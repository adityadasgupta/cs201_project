package lab6;

import java.util.ArrayList;

public class CTA_Station{

	private static String name1;
	public static CTA_Station c1[]=new CTA_Station[138];
	public static ArrayList<CTA_Station> stops = new ArrayList<CTA_Station>();
	
		private double latitude;
		private double longitude;

		public double getlatitude() {
			return latitude;
		}
		
		public double getlongitude() {
			return longitude;
		}
		
		public void setlatitude(double la) {
			this.latitude=la;
		}
		
		public void setlongitude(double lo) {
			this.longitude=lo;
		}
		
	

	private String name;
	private String location;
	private int[] line=new int[8];
	private boolean wheelchair;
	private double result;
	private String[] nameofstation= {"Red","Green","Blue","Brown","Purple","Pink","Orange","Yellow"};

	public CTA_Station() {
		name="name";
	}
	
	public int getLine(int i) {
		return line[i];
	}

	public void setLine(int index, int line1) {
		line[index] = line1;
	}

	public String getName1() {
		return name1;
	}
	public String getNameofstation(int i) {
		return nameofstation[i];
	}

	public void setNameofstation(int i, String name) {
		nameofstation[i] = name;
		name1=name;
	}

	public CTA_Station(String n,double la,double lo,String l,boolean w,int rl, int gl,int blue, int br, int pur, int pink, int or, int yel) {
		location=l;
		name=n;
		setLine(0,rl); setLine(1,gl); setLine(2,blue); setLine(3,br); setLine(4,pur); setLine(5,pink);
		setLine(6,or); setLine(7,yel);
		wheelchair=w;
		latitude=la;
		longitude=lo;
		result=0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getResult() {
		return result;
	}

	public void setResult(double result1) {
		this.result = result1;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public boolean isWheelchair() {
		return wheelchair;
	}

	public void setWheelchair(boolean wheelchair) {
		this.wheelchair = wheelchair;
	}
	
	public boolean equalsto(CTA_Station g1) {
		if(this.name==g1.name)
			return true;
		return false;
	}
	
	public String toString() {
		return name;
	}
	
	public static CTA_Station nearestStation(CTA_Station c2) {
		double[] result=new double[138];
		int i=0;
		int j=0;
		double lat;
		double lon;
		for(CTA_Station e:stops) {
			lat=(e.getlatitude()-c2.getlatitude());
			lon=(e.getlongitude()-c2.getlongitude());
			result[i]=Math.sqrt((lat*lat)+(lon*lon));
			i++;
		}
		for(CTA_Station e:stops) {
			e.setResult(result[j]);
			j++;
		}
		double min=result[0];
		for(CTA_Station e:stops) {
			if(e.getResult()<=min&&e.getResult()!=0)
				min=e.getResult();
		}
		for(CTA_Station e:stops) {
			if(e.getResult()==min)
				return e;
		}
		return null;
	}
	
}
