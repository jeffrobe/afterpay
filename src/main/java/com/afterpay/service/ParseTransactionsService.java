package com.afterpay.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Logger;

import com.afterpay.model.CreditCardTransaction;

public class ParseTransactionsService {
	public static DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	private static final Logger logger = Logger.getLogger(ParseTransactionsService.class.getName());

	private CreditCardTransaction parseTarnsacrions(String str) throws ParseException {
		logger.info("trans: " + str);
		String parts[] = str.split(",");

		String hsh = parts[0];
		String dtStr = parts[1];
		Date dt = df.parse(dtStr.replace("T", " "));
		Double amt = new Double(parts[2]);

		CreditCardTransaction trans = new CreditCardTransaction(hsh, dt, amt);

		return trans;
	}

	public ArrayList<CreditCardTransaction> parseTransactionList(ArrayList<String> transactions) throws ParseException {
		ArrayList<CreditCardTransaction> lst = new ArrayList<CreditCardTransaction>();

		Iterator<String> iter = transactions.iterator();
		while (iter.hasNext()) {
			CreditCardTransaction trans = parseTarnsacrions(iter.next());
			lst.add(trans);
		}

		return lst;
	}

}
