package guimodule;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancy extends PApplet{
	UnfoldingMap map;
	Map<String, Float> lifeExpbyCountry;
	List<Feature> countries;
	List<Marker> countryMarkers;
	public void setup()
	{
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		lifeExpbyCountry = LoadLifeExpectancyFromCSV("LifeExpectancyWorldBankModule3.csv");
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries); 
		map.addMarkers(countryMarkers);
		shadeCountries();
	}
	
	public void draw()
	{
		map.draw();
	}
	
	private Map<String, Float> LoadLifeExpectancyFromCSV(String filename)
	{
		Map<String, Float> LifeExpMap = new HashMap<String, Float>();
		String[] rows = loadStrings(filename);
		for(String row : rows)
		{
			String[] columns = row.split(",");
			if(columns[5].equals(".."))
			{
				columns[5]="54.78";
			}
				
				float value = Float.parseFloat(columns[5]);
				LifeExpMap.put(columns[4],value);
			
			
		}
		
		
		return LifeExpMap;
	}
	private void shadeCountries()
	{
		for(Marker marker : countryMarkers)
		{
			String countryId = marker.getId();
			if(lifeExpbyCountry.containsKey(countryId))
			{
				float lifexp = lifeExpbyCountry.get(countryId);
				int colorLevel = (int) map(lifexp, 40, 90, 10, 255);
				marker.setColor(color(255-colorLevel, 100, colorLevel));
			}
			else
			{
				marker.setColor(color(150,150,150));
			}
		}
	}

}
