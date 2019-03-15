# AfterPay Skills Assessment Test

Given credit card transaction data parse data into java object. Filter data by date, group by credit card number and sum transaction amount.

To run fraud test loop over parsed transactions if the total transaction amount is aboe thresh hols add the credit card hash to fraud card list. List is outputed after running.

## Assumptions
Data will be coming in small batches over time. Results will be stored in memory on system. Most likely this would be run as a server. Web services would be used to input transaction data. At the time data is added the fraud test would be run.

If this was a run as one time job against a large transaction data file a more efficient process could be used. The data file could be parsed with a simple regex parser.

## Getting Started

Run the main method in AfterPay class. This will read the transaction date and set a threshold and date.

### Prerequisites

Everything needed to run is contained in source.

```
Give examples
```



## Running the tests

running against date: Mon Mar 11 00:00:00 PDT 2019 thresh hold: 20.000000
transactions: 

[11d7ce2f43e35fa57d1bbf8b1e2, 2019-03-11T13:15:54, 10.00, 11d7ce2f43e234a57d1bbf8b1e2, 2019-03-11T13:15:54, 30.00, 10d7ce2f43e35fa57d1bbf8b1e2, 2019-03-11T13:15:54, 10.00, 10d7ce2f43e35fa57d1bbf8b1e2, 2019-03-11T14:15:54, 12.00, 10d7ce2f43e35fa57d1bbf8b1e2, 2019-03-11T15:15:54, 13.00]

fraudulent credit cards: 

[11d7ce2f43e234a57d1bbf8b1e2, 10d7ce2f43e35fa57d1bbf8b1e2]



## Deployment


## Built With


