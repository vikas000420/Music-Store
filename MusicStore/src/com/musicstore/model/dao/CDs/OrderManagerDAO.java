package com.musicstore.model.dao.CDs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.musicstore.model.CreditCardDetails;
import com.musicstore.model.Po;
import com.musicstore.model.Poitem;

/**
 * @author sowjanya
 *
 */
public class OrderManagerDAO {

	private DBAgent agent = null;

	public OrderManagerDAO() {
		agent = new DBAgent();
		agent.initialize();
	}

	/* 
	 * The ordered items saves with last name and first name
	 */
	public boolean saveOrder(Po order) {
		List<String> parameters = new ArrayList<String>();
		parameters.add(order.getLname());
		parameters.add(order.getFname());
		parameters.add("PROCESSED");
		parameters.add("1");
		int poid = agent.executeUpdateSQL(DBQueryList.create_Po, DBQueryList.POType, parameters);
		parameters = new ArrayList<String>();
		List<Poitem> poitems = order.getPoitems();
		for (int i = 0; i < poitems.size(); i++) {
			parameters = new ArrayList<String>();
			parameters.add(Integer.toString(poid));
			parameters.add(poitems.get(i).getCd().getCdid());
			parameters.add(Integer.toString(poitems.get(i).getCd().getPrice()));
			agent.executeSQL(DBQueryList.create_PoItems, DBQueryList.POItemType, parameters);
		}

		return true;
	}

	/* 
	 * Gets the information about order
	 * if success it shows ordered, failed it shows denied
	 */
	public Po postOrder(Po order, CreditCardDetails ccInfo) {
		List<String> parameters = new ArrayList<String>();
		parameters.add(order.getLname());
		parameters.add(order.getFname());
		boolean isCCValid = verifyCC(ccInfo);
		if (isCCValid) {
			order.setStatus("ORDERED");
			parameters.add("ORDERED");
		} else {
			order.setStatus("DENIED");
			parameters.add("DENIED");
		}
		parameters.add(Integer.toString(order.getAddressBean().getId()));
		agent.startTransaction();
		int poid = agent.executeUpdateSQL(DBQueryList.create_Po, DBQueryList.POType, parameters);
		parameters = new ArrayList<String>();
		order.setId(poid);

		List<Poitem> poitems = order.getPoitems();
		for (int i = 0; i < poitems.size(); i++) {
			parameters = new ArrayList<String>();
			parameters.add(Integer.toString(poid));
			parameters.add(poitems.get(i).getCd().getCdid());
			parameters.add(Integer.toString(poitems.get(i).getCd().getPrice()));
			agent.executeSQL(DBQueryList.create_PoItems, DBQueryList.POItemType, parameters);
		}
		agent.endTransaction();
		return order;

	}

	/**
	 * @param ccInfo
	 * @return
	 */
	private boolean verifyCC(CreditCardDetails ccInfo) {
		//// Send CC info to Credit card authentication process, and verify the
		//// process response.
		List<Map<String, Object>> qr = agent.getQueryResult(DBQueryList.poCount, DBQueryList.POType,
				new ArrayList<String>());
		Object obj = qr.get(0).get("count");
		Long cnt = Long.parseLong(obj.toString());
		return cnt % 5 != 0;
	}

}
