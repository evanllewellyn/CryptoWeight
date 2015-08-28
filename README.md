# CryptoWeight

CryptoWeight allows the user to compare the Weighted Prices of Bitcoin in a 24 different currencies over three time periods, 24 hours, 7 days, and 30 days. 
It is written in Java and features a GUI that is created with JavaFX and CSS for styling. 


The data is retrieved through a Json object, supplied by [Bitcoinchart's public API](http://bitcoincharts.com/about/markets-api/). The Json is deserialized
through [Google's gson API](https://github.com/google/gson). 

To reduce the number of API calls to Bitcoinchart CryptoWeight serializes the price data and stores it in a local directory. This allows the last loaded data
to persist between application uses. 


#Basic Overview 



