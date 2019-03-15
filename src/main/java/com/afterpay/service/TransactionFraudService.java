package com.afterpay.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.afterpay.model.CreditCardTransaction;

public class TransactionFraudService {

	@SuppressWarnings("deprecation")
	private static boolean equalDate(Date d1, Date d2) {
		if (d1.getYear() != d2.getYear())
			return false;
		if (d1.getMonth() != d2.getMonth())
			return false;
		if (d1.getDate() != d2.getDate())
			return false;
		return true;
	}

	public Map<String, Double> sumtransactionAmounts(ArrayList<CreditCardTransaction> transactions, Date date) {
		Map<String, Double> creditCardAmounts = new HashMap<String, Double>();
		for (CreditCardTransaction transaction : transactions) {
			if (equalDate(transaction.getEntered(), date)) {
				Object obj = creditCardAmounts.get(transaction.getHsh());
				Double amt = transaction.getAmount();
				if (obj != null) {
					amt = amt + (Double) obj;
				}
				creditCardAmounts.put(transaction.getHsh(), amt);
			}
		}

		return creditCardAmounts;
	}

	public ArrayList<String> getCardsOverAmount(Map<String, Double> transactions, Double threshold) {
		ArrayList<String> lst = new ArrayList<String>();

		Set<String> keys = transactions.keySet();
		for (Iterator<String> i = keys.iterator(); i.hasNext();) {
			String key = i.next();
			Double value = transactions.get(key);
			if (value > threshold) {
				lst.add(key);
			}
		}

		return lst;
	}

	public List<?> detectFraud(ArrayList<CreditCardTransaction> transactions, Date date, Double threshold)
			throws ParseException {

		Map<String, Double> transactionMap = sumtransactionAmounts(transactions, date);
		List<?> fraud = getCardsOverAmount(transactionMap, threshold);

		return fraud;
	}

}
