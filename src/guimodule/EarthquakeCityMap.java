package guimodule;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;


public class EarthquakeCityMap extends PApplet{

	private UnfoldingMap map;
	public void setup()
	{
		size(950,600, OPENGL);
		map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		Location valloc = new Location(-38.14f, -73.03f);
		Feature valeq = new PointFeature(valloc);
		valeq.addProperty("title", "chile");
		valeq.addProperty("year", "1960");
		Location japan = new Location(40.14f, 3.03f);
		Feature japaneq = new PointFeature(japan);
		valeq.addProperty("title", "japan");
		valeq.addProperty("year", "2001");
		List<PointFeature> bigEqs = new ArrayList<PointFeature>();
		bigEqs.add((PointFeature) valeq); 
		bigEqs.add((PointFeature) japaneq);
		List<Marker> markers = new ArrayList<Marker>();
		for(PointFeature eq: bigEqs)
		{
			markers.add(new SimplePointMarker(eq.getLocation(), eq.getProperties()));
		}
		for(Marker mk : markers)
		{
			mk.setColor(0xffffff00);
			map.addMarker(mk);
			/*if(mk.getStringProperty("title") == "japan");
			{
				mk.setColor(0xffffff00);
				map.addMarker(mk); 
			}
			else
			{
				mk.setColor(85);
				map.addMarker(mk); 
			} */
		}

		//map.addMarkers(markers);

	}
	public void draw()
	{
		background(10);
		map.draw();
		addkey();
	}
	private void addkey() {
		// TODO Auto-generated method stub
		
	}

}
