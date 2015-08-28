# CryptoWeight

CryptoWeight allows the user to compare the Weighted Prices of Bitcoin in a 24 different currencies over three time periods, 24 hours, 7 days, and 30 days. 
It is written in Java and features a GUI that is created with JavaFX and CSS for styling. 


The data is retrieved through a Json object, supplied by [Bitcoinchart's public API](http://bitcoincharts.com/about/markets-api/). The Json is deserialized
through [Google's gson API](https://github.com/google/gson). 

To reduce the number of API calls to Bitcoinchart, CryptoWeight serializes the price data and stores it in a local directory. This allows the last loaded data to persist between application uses. 


#Basic Overview 

CryptoWeight is loaded with the prices that were last loaded during the previous use. The price data may be updated with the "Update Weighted Prices" button. It will launch a confirm box, as seen below. 

![alt text](https://github.com/evanllewellyn/CryptoWeight/blob/master/CryptoWeightpics/updatePic.png "update pic")

Once data has been loaded, the user can select one of the 24 different currencies from the selection menu and push the "Display Weighted Price" button to view the desired prices, as seen below. 

![alt text](https://github.com/evanllewellyn/CryptoWeight/blob/master/CryptoWeightpics/currencydisplay.png "currencydisplay")

Once the "Display Weighted Price" button has been pushed, the selected currencies data is loaded in the text box, below is an example of British Pound's data loaded. 

![alt text](https://github.com/evanllewellyn/CryptoWeight/blob/master/CryptoWeightpics/infodisplay.png "info display")

If a user is confused about the definition of weighted prices, the "What are Weighted Prices?" button can be selected to load an info box containing information, as seen below. 

![alt text](https://github.com/evanllewellyn/CryptoWeight/blob/master/CryptoWeightpics/infobox.png "info box")

Written by Evan Llewellyn, August 2015.
