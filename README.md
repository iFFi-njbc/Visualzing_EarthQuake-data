Earthquake-Data
==================================================================


A GUI created by using Processing and Unfolding Maps library functions in Eclipse IDE to display and print out the earthquakes which have occured all over the world.

This is a project that I have created with the help of the Object Oriented Programming in Java course offered by 
UC San Diego through Coursera. The project was half created and the other half was asked to implement throughout the course. However, in the course the project has further features but to not make it more complex I haven't added all of them.

### Processing and Unfolding map libraries;

**Processing library:** an open-source graphical library and integrated development environment (IDE) built for the electronic arts, new media art, and visual design communities with the purpose of teaching non-programmers the fundamentals of computer programming in a visual context.
Processing uses the Java language, with additional simplifications such as additional classes and aliased mathematical functions and operations. It also provides a graphical user interface for simplifying the compilation and execution stage. 

**Unfolding maps library:** Enables you to quickly create interactive maps. Simply create geo-positioned markers to display data on a map. The library supports loading and displaying user-defined shapes, such as points, lines, or polygons.

## Description Of The Project

### Displayed And Printed Results;
<img src="Screenshot 2022-06-06 145601.jpg" width="600">

`Map can be zoomed as shown below. The image next to it is the printed results appearing on the console.`

<img src="Screenshot 2022-06-06 152932.jpg" width="600">  

Using OpenGLMapDisplay with processing.opengl.PGraphics3D
- Afghanistan: 13
- Argentina: 8
- Bolivia: 2
- Canada: 44
- Chile: 10
- China: 16
- Democratic Republic of the Congo: 2
- Colombia: 4
- Cyprus: 1
- Dominican Republic: 6
- Algeria: 1
- Greece: 3
- Guatemala: 4
- Indonesia: 7
- India: 2
- Iran: 2
- Israel: 1
- Italy: 2
- Japan: 8
- Mexico: 17
- Myanmar: 2
- Malaysia: 1
- Nicaragua: 1
- Nepal: 3
- Pakistan: 5
- Peru: 5
- Philippines: 5
- Papua New Guinea: 5
- Puerto Rico: 16
- Portugal: 2
- Solomon Islands: 1
- El Salvador: 1
- Sweden: 2
- Tajikistan: 2
- Turkey: 2
- Taiwan: 1
- Ukraine: 1
- United States of America: 6583
- Uzbekistan: 2
- Venezuela: 2
- OCEAN QUAKES: 2258

### Extended Functionality
==========================

When clicking on a city, A textbox and the console will display a count for the number of nearby earthquakes (within threatCircle) the average magnitude. It will also show the complete information of earth quakes occured.

The extension  is in the EarthquakeCitymap class and CityMarker class in module 7.

Method checkCitiesForClick() in EarthquakeCityMap class, if the user clicked on a city, all the earthquakes' threat circle that include the city will be recorded and their location information will be added to a array list. Then, I called the getProperties()  method of city marker and returned a HashMap called prop. Then, I will put the earthquake information threat circle and averagemag into the prop which is be used in the cityMarker class.  then information will be displayed in the console.

Mathod drawMarker() in cityMarker class, if the getClicked() is true, I will get the properties of this city marker using getProperties method.  


<img src="Screenshot 2022-06-06 145625.jpg" width="600">  



### Detailed Explanation Of The Code;

The project has an interactive map which displays where the earthquakes have occured with the help of markers. Optionally you can work online or offline with it. If you work online **GoogleMapProvider()** will display a map otherwise, an offline map is displayed. 

The data of earthquakes are taken from this live RSS feed https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom and parsed by the course in order to read the data inside it. In addition, there are two more files: cityFile and countryFile. countryFile includes features of the countries such as: name, location, type. Also, if an earthquake occurs in a particular country it is added as a marker to the map. cityFile on the other hand, includes cities and their properties. 

A RuntimeException is checked while reading and adding the cityFile to the map as shown below;

### UML Class/Data Diagrams 

<img src="https://user-images.githubusercontent.com/64264345/81473170-8c600a80-921e-11ea-9533-7f2078ac851e.png" width="500"> <img src="https://user-images.githubusercontent.com/64264345/81471618-325a4780-9214-11ea-8e99-df2282f58376.png" width="200"> 

> As shown above, the project contains 5 classes: EarthquakeCityMap, CityMarker, EarthqukeMarker, LandQuakeMarker and OceanQuakeMarker. Let's further investigate them;
### Five Classes

**EarthquakeCityMarker Class;**

- It is the main class which extends PApplet in order to create a GUI. This class includes some methods and helper methods. **addKey()** is a helper method which draws key in GUI and **isInCountry()** is another helper method which is used to test whether a given earthquake is in a given country or not. It also adds the country property to the properties of the earthquake feature if it's in one of the countries. Moreover, there is a method called **printQuakes()** which prints out countries with number of earthquakes. 

**CityMarker Class;**
 
- This class extends SimplePointMarker to mark the cities on the map. SimplePointMarker is a class of UnfoldingMaps library which   represents marker on a single location. 

**EarthquakeMarker Class;**

- An abstract class which implements a visual marker for earthquakes on an earthquake map. It has two subclasses: LandQuakeMarker and OceanQuakeMarker. EarthquakeMarker class allows these two classes to implement abstract method **drawEarthquake()** differently. Moreover, class includes method **colorDetermine()** which allows the derived classes to determine color of marker from depth of the earthquake.

**LandQuakeMarker and OceanQuakeMarker Classes;**

- The main difference between these two child classes is that they both implement markers on different places. LandQuakeMarker implements quakes markers on the land; however, OceanQuakeMarker implements them on the ocean.
