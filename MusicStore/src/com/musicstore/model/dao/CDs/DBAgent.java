package com.musicstore.model.dao.CDs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DBAgent {
	private static Logger logger = Logger.getLogger(DBAgent.class.getName());
	private Connection conn = null;

	{
		loadDBQueries();
	}

	private static Map<String, Map<String, String>> queryList = new HashMap<String, Map<String, String>>();

	/**
	 * queries are loaded 
	 */
	private static void loadDBQueries() {
		ClassLoader loader = DBAgent.class.getClassLoader();
		if (null == loader)
			loader = ClassLoader.getSystemClassLoader();

		String xmlFile = "dbqueries.xml";
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		java.net.URL url = loader.getResource(xmlFile);
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
			e1.printStackTrace();
		}
		try {
			Document doc = dBuilder.parse(url.getPath());
			NodeList catNodes = doc.getElementsByTagName(DBQueryList.CategoryType);

			queryList.put(DBQueryList.CategoryType, getNodes(catNodes));

			catNodes = doc.getElementsByTagName(DBQueryList.AccountType);
			queryList.put(DBQueryList.AccountType, getNodes(catNodes));

			catNodes = doc.getElementsByTagName(DBQueryList.POType);
			queryList.put(DBQueryList.POType, getNodes(catNodes));

			catNodes = doc.getElementsByTagName(DBQueryList.VisitEventType);
			queryList.put(DBQueryList.VisitEventType, getNodes(catNodes));

			catNodes = doc.getElementsByTagName(DBQueryList.POItemType);
			queryList.put(DBQueryList.POItemType, getNodes(catNodes));

			catNodes = doc.getElementsByTagName(DBQueryList.AddressType);
			queryList.put(DBQueryList.AddressType, getNodes(catNodes));

		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
			e1.printStackTrace();
		}
	}

	/**
	 * @param queryList
	 * @param catNodes
	 * 
	 */
	private static Map<String, String> getNodes(NodeList catNodes) {
		Map<String, String> queryList = new HashMap<String, String>();
		for (int temp = 0; temp < catNodes.getLength(); temp++) {
			Node nNode = catNodes.item(temp);
			Element eElement = (Element) nNode;
			if (!queryList.containsKey(eElement.getElementsByTagName("id").item(0).getTextContent())) {
				queryList.put(eElement.getElementsByTagName("id").item(0).getTextContent(),
						eElement.getElementsByTagName("query").item(0).getTextContent().trim());

			}
		}

		return queryList;
	}

	/**
	 * Initializes the connection with database
	 */
	public void initialize() {
		Connection connection = null;
		try {

			Context context = new InitialContext();
			Context envContext = (Context) context.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("musicstore");
			connection = ds.getConnection();
			if (connection == null) {
				// throw error;
			}
			conn = connection;

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();

		} catch (NamingException e) {
			logger.error(e.getMessage());
			e.printStackTrace();

		}

	}

	public void finalize() {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
	}

	/**
	 * Starts the transaction
	 */
	public void startTransaction() {

		try {
			conn.setAutoCommit(false);

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * Ends the transaction
	 */
	public void endTransaction() {

		try {
			conn.commit();
		} catch (SQLException e) {
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException e1) {
				logger.error(e.getMessage());
				e1.printStackTrace();
			}
		} finally {
			if (conn != null)
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
		}

	}

	/** values are inserted
	 * @param id
	 * @param qtype
	 * @param parameters
	 * @return
	 */
	public int executeUpdateSQL(String id, String qtype, List<String> parameters) {
		PreparedStatement sqlStmt = null;

		int autoId = 0;
		int n = 1;
		Iterator<String> iter = parameters.iterator();
		try {

			String query = queryList.get(qtype).get(id);

			sqlStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			while (iter.hasNext()) {
				sqlStmt.setString(n, (String) iter.next());
				n++;
			}

			sqlStmt.executeUpdate();
			ResultSet rs = sqlStmt.getGeneratedKeys();
			rs.next();
			autoId = rs.getInt(1);
		} catch (SQLException sqlexception) {
			logger.error(sqlexception.getMessage());
			sqlexception.printStackTrace();
		} finally {

			if (sqlStmt != null) {
				try {
					sqlStmt.close();
				} catch (SQLException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
			}

		}
		return autoId;

	}

	/** retrieves values
	 * @param id
	 * @param qtype
	 * @param parameters
	 * @return
	 */
	public int executeSQL(String id, String qtype, List<String> parameters) {
		PreparedStatement sqlStmt = null;

		int NumberORowsAffected = 0;
		int n = 1;
		Iterator<String> iter = parameters.iterator();
		try {

			String query = queryList.get(qtype).get(id);
			sqlStmt = conn.prepareStatement(query);

			while (iter.hasNext()) {
				sqlStmt.setString(n, (String) iter.next());
				n++;
			}

			NumberORowsAffected = sqlStmt.executeUpdate();
		} catch (SQLException sqlexception) {
			logger.error(sqlexception.getMessage());
			sqlexception.printStackTrace();
		} finally {

			if (sqlStmt != null) {
				try {
					sqlStmt.close();
				} catch (SQLException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
			}

		}
		return NumberORowsAffected;

	}
	//getting result from the database by preparing and executing queries 
	public List<Map<String, Object>> getQueryResult(String id, String qtype, List<String> parameterList)

	{
		PreparedStatement sqlStmt = null;
		ResultSet rs = null;
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Iterator<String> iter = parameterList.iterator();
		int n = 1;

		try {
			String query = queryList.get(qtype).get(id);

			if(conn == null){
				initialize();
			}
			
			sqlStmt = conn.prepareStatement(query);

			while (iter.hasNext()) {
				sqlStmt.setString(n, (String) iter.next());
				n++;
			}

			rs = sqlStmt.executeQuery();
			if (rs != null) {
				ResultSetMetaData md = rs.getMetaData();
				int columnCount = md.getColumnCount();

				while (rs.next()) {
					Map<String, Object> columns = new LinkedHashMap<String, Object>();

					for (int i = 1; i <= columnCount; i++) {
						columns.put(md.getColumnLabel(i), rs.getObject(i));
					}
					result.add(columns);
				}
			}
		} catch (SQLException sqlexcep) {
			logger.error(sqlexcep.getMessage());
			sqlexcep.printStackTrace();
		} finally {

			try {
				if (sqlStmt != null)
					sqlStmt.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return result;

	}

}
