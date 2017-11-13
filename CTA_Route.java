package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CTA_Route extends CTA_Station{
	private static String name1;
	public static CTA_Station c1[]=new CTA_Station[138];
	public static ArrayList<CTA_Station> stops = new ArrayList<CTA_Station>();
	
	public static void displayStationNames() {
		for(CTA_Station e:stops)
		{
			System.out.println(e.getName());
		}
	}

	public static void readfile() throws FileNotFoundException {
		File f1=new File("CTAFinal.csv");
		String line;
		Scanner input1=new Scanner(System.in);
		int i=0;
		int choice=1;
		Scanner input=new Scanner(f1);
		input.nextLine();
		input.nextLine();
		while(input.hasNext()) {
			line=input.nextLine();
			String[] n1= line.split(",");
			c1[i]=new CTA_Station(n1[0],Double.parseDouble(n1[1]),Double.parseDouble(n1[2]),n1[3],Boolean.parseBoolean(n1[4]),Integer.parseInt(n1[5]),Integer.parseInt(n1[6]),Integer.parseInt(n1[7]),Integer.parseInt(n1[8]),Integer.parseInt(n1[9]),Integer.parseInt(n1[10]),Integer.parseInt(n1[11]),Integer.parseInt(n1[12]));
			stops.add(new CTA_Station(n1[0],Double.parseDouble(n1[1]),Double.parseDouble(n1[2]),n1[3],Boolean.parseBoolean(n1[4]),Integer.parseInt(n1[5]),Integer.parseInt(n1[6]),Integer.parseInt(n1[7]),Integer.parseInt(n1[8]),Integer.parseInt(n1[9]),Integer.parseInt(n1[10]),Integer.parseInt(n1[11]),Integer.parseInt(n1[12])));
			i++;
		}
	}
	public static void displayNearest() {
		double lat;
		double lon;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the latitude of the location you want to find the nearest station to: ");
		lat=input.nextDouble();
		System.out.println("Enter the latitude of the location you want to find the nearest station to: ");
		lon=input.nextDouble();
		CTA_Station c2=new CTA_Station();
		c2=nearestStation(lat,lon);
		System.out.print("Nearest station to " + lat + " , " + lon + " is " + c2.getName() + " on ");
		for(int i=0;i<8;i++) {
		if(c2.getLine(i)!=-1)
			System.out.print(c2.getNameofstation(i) + " Line ; ");
			}
		System.out.println("\n");
	}
	
	public static void  displayInfo() {
		String name;
		String name1;
		Scanner input=new Scanner(System.in);
		Scanner input1=new Scanner(System.in);
		System.out.println("Enter the station name you want to find the info about: ");
		name=input.nextLine();
		CTA_Station c1=new CTA_Station();
		System.out.println("Enter the line color: ");
		name1=input.nextLine();
		c1=lookupstation(name,name1);
		if(c1!=null) {
		System.out.print("Name: " + c1.getName() + "\nLocation: " + c1.getLocation() + "\nLatitude: " + c1.getlatitude() + "\nLongitude: " 
		+ c1.getlongitude() + "\nWheelchair: ");
		if(c1.isWheelchair()==true)
			System.out.print("Yes");
		else
			System.out.print("No");
		System.out.print("\nRoute: ");
		for(int i=0;i<8;i++) {
			if(c1.getLine(i)!=-1)
				System.out.print(c1.getNameofstation(i) + " Line ; ");
			}
		System.out.println("\n");
		}
		else 
			System.out.println("The station entered does not exist!");
	}
	
	public static void displayAllInfo() {
		for(CTA_Station c1:stops) {
		System.out.print("\nName: " + c1.getName() + "\nLocation: " + c1.getLocation() + "\nLatitude: " + c1.getlatitude() + "\nLongitude: " 
		+ c1.getlongitude() + "\nWheelchair: ");
		if(c1.isWheelchair()==true)
			System.out.print("Yes");
		else
			System.out.print("No");
		System.out.print("\nRoute: ");
		for(int i=0;i<8;i++) {
			if(c1.getLine(i)!=-1)
				System.out.print(c1.getNameofstation(i) + " Line ; ");
			}
		System.out.println("\n");
		}
	}
	
	public static void addNew() {
		CTA_Station c1=new CTA_Station();
		String ans;
		int i=0;
		String new1;
		int c=0;
		String wc;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the station you want this station to be after: ");
		ans=input.nextLine();
		System.out.print("Enter the route that station is on: ");
		String name2=input.nextLine();
		CTA_Station c2=new CTA_Station();
		c2=lookupstation(ans,name2);
		if (c2!=null) {
		System.out.println("Enter Name of the station: ");
		String name1=input.next();
		c1.setName(name1);
		for(CTA_Station e:stops) {
			if(c1.getName().equalsIgnoreCase(e.getName()))
				c++;
		}
		if(c==0) {
		System.out.println("Enter Longitude of the station: ");
		c1.setlongitude(input.nextDouble());
		System.out.println("Enter Latitude of the station: ");
		c1.setlatitude(input.nextDouble());
		System.out.println("Enter Location of the station(eg: elevated, subway, etc.): ");
		wc=input.next();
		c1.setLocation(wc);
		System.out.println("Enter Wheelchair accessibilty of the station (Enter true for yes and false for no):  ");
		c1.setWheelchair(Boolean.parseBoolean(input.next()));
		System.out.println("Enter Route of the station: ");
		new1=input.next();
		for(int k=0;i<8;i++) {
			if(c1.getNameofstation(k).equalsIgnoreCase(new1)) {
				c1.setLine(k,c2.getLine(k)+1);
				for(int h=0;h<stops.size();h++) {
					if(h!=k)
						c1.setLine(h, -1);
					}
				}
			}
		insertStation((stops.indexOf(c2)+1),c1);
		displayAllInfo();
		}
		else
			System.out.println("A Station of this name already exists!");
		}
		else
			System.out.println("That station does not exist!");
		System.out.println("\n");
	}
	
	public static void deleteOne() {
		Scanner input= new Scanner(System.in);
		System.out.println("Enter the name of the station you want to delete: ");
		String name=input.nextLine();
		System.out.println("Enter the route it appears on: ");
		String route=input.nextLine();
		CTA_Station c1=new CTA_Station();
		c1=lookupstation(name,route);
		if(c1!=null)
			removeStation(c1);
		else
			System.out.println("The station entered does not exist!");
	}
	
	public static void addStation(CTA_Station c1) {
		stops.add(c1);
	}
	
	public static void removeStation(CTA_Station c1) {
		stops.remove(c1);
	}
	
	public static void insertStation(int index,CTA_Station c1) {
		stops.add(index, c1);
	}
	
	public static CTA_Station lookupstation(String name1, String name2) {
		for(CTA_Station e:stops) {
			for(int i=0;i<8;i++) {
				if((e.getName()).equalsIgnoreCase(name1) && e.getNameofstation(i).equalsIgnoreCase(name2))
					if(e.getLine(i)!=-1)
					return e;
			}
		}
		return null;
	}
	
	public static CTA_Station nearestStation(double lat1,double lon1) {
		double[] result=new double[138];
		int i=0;
		int j=0;
		double lat;
		double lon;
		for(CTA_Station e:stops) {
			lat=(e.getlatitude()-lat1);
			lon=(e.getlongitude()-lon1);
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
	
	public String toString(CTA_Station c1) {
		return c1.getName() + Double.toString(c1.getlatitude());
	}
	
	public boolean equalsTo(CTA_Station c1) {
		if(this.getName()==c1.getName())
			return true;
		return false;
	}
	
}
