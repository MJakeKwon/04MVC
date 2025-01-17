package com.model2.mvc.service.purchase.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDao;
import com.model2.mvc.service.domain.Purchase;

@Service("PurchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	@Qualifier("PurchaseDaoImpl")
	private PurchaseDao purchaseDao;
	
	public PurchaseServiceImpl() {
		System.out.println("::" + getClass() + ".default Constructor Call....");
	}
	
	public void insertPurchase(Purchase purchase) throws Exception{
		purchaseDao.insertPurchase(purchase);
	}
	
	public Purchase getPurchase(int tranNo) throws Exception{
		return purchaseDao.findPurchase(tranNo);
	}

	public Map<String, Object> getPurchaseList(Search search, String buyerId) throws Exception{
		return purchaseDao.getPurchaseList(search, buyerId);
	}
	
	public Map<String, Object> getSaleList(Search search) throws Exception{
		return purchaseDao.getSaleList(search);
	}

	public void updatePurchase(Purchase purchase) throws Exception {
		purchaseDao.updatePurchase(purchase);
	}

	public void updateTranCode(Purchase purchase) throws Exception {
		purchaseDao.updateTranCode(purchase);
	}

}
