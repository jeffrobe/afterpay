package com.afterpay;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.afterpay.model.CreditCardTransaction;
import com.afterpay.service.ParseTransactionsService;
import com.afterpay.service.TransactionFraudService;

public class AfterPayTest {
	public static String str = "";
	DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-ddTkk:mm:ss");

	private static final String dateStr = "11/03/2019";

	private static final Double threshold = 20.00;

	private static ArrayList<String> transactions = new ArrayList<>(
			Arrays.asList("11d7ce2f43e35fa57d1bbf8b1e2, 2019-03-11T13:15:54, 10.00",
					"11d7ce2f43e234a57d1bbf8b1e2, 2019-03-11T13:15:54, 30.00",
					"10d7ce2f43e35fa57d1bbf8b1e2, 2019-03-11T13:15:54, 10.00",
					"10d7ce2f43e35fa57d1bbf8b1e2, 2019-03-11T14:15:54, 12.00",
					"10d7ce2f43e35fa57d1bbf8b1e2, 2019-03-11T15:15:54, 13.00"));

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// @Test
	public void testParseData() throws ParseException {
		Date checkDate = sdf.parse(dateStr);

		System.out.printf("running agains date: %s thresh hols: %f\n", checkDate, threshold);
		System.out.printf("transactions: %s\n", transactions.toString());

		ParseTransactionsService svc = new ParseTransactionsService();
		ArrayList<CreditCardTransaction> parsedTransactions = svc.parseTransactionList(transactions);

		TransactionFraudService svcFraud = new TransactionFraudService();
		List<?> fraudTransList = svcFraud.detectFraud(parsedTransactions, checkDate, threshold);

		System.out.printf("fraudulent credit cards: %s\n", fraudTransList);

		// assertEquals(4, fraudTransList.size());

	}

}
