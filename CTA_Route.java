package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CTA_Route extends CTA_Station{
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
	public static void route() {
		Scanner input=new Scanner(System.in);
		double lat;
		double lon;
		String station;
		String l;
		System.out.print("Enter the latitude of your current location: ");
		lat=input.nextDouble();
		System.out.print("Enter the longitude of your current location: ");
		lon=input.nextDouble();
		CTA_Station d=new CTA_Station();
		d=nearestStation(lat,lon);
		System.out.println("The nearest station to your location is: " + d.getName());
		System.out.println("Which line? ");
		l=input.next();
		CTA_Station g=new CTA_Station();
		g=lookupstation(d.getName(),l);
		System.out.println("Which station do you want to go to? ");
		station=input.next();
		System.out.println("Which line is it on? ");
		String line1=input.next();
		CTA_Station e=new CTA_Station();
		e=lookupstation(station,line1);
		CTA_Station r=new CTA_Station();
		int i=0;
		int j=0;
		for(int u=0;u<8;u++) 
			if(g.getNameofstation(u).equalsIgnoreCase(l)) 
				i=u;
		for(int u=0;u<8;u++) 
			if(e.getNameofstation(u).equalsIgnoreCase(line1))
				j=u;
		r=route1(i,j);
		System.out.print("Intersecting station: " + r.getName());
		
		
	}
	
	public static CTA_Station route1(int i,int j) {
		int c=0;
		for(CTA_Station f:stops) {
			if(f.getLine(i)!=-1 && f.getLine(j)!=-1) { 
				return f;	
				}
			}
		return null;
	}
	
	public static void write() throws IOException{
		File f = new File("output.csv");
		
		FileWriter file = new FileWriter("output.csv");
			for (int i=0;i<138;i++) {
			file.append(c1[i].getName());
			file.append(",");
			file.append(Double.toString(c1[i].getlatitude()));
			file.append(",");
			file.append(Double.toString(c1[i].getlongitude()));
			file.append(",");
			file.append(c1[i].getLocation());
			file.append(",");
			file.append(Boolean.toString(c1[i].isWheelchair()));
			file.append(",");
			file.append(Integer.toString(c1[i].getLine(0)));
			file.append(",");
			file.append(Integer.toString(c1[i].getLine(1)));
			file.append(",");
			file.append(Integer.toString(c1[i].getLine(2)));
			file.append(",");
			file.append(Integer.toString(c1[i].getLine(3)));
			file.append(",");
			file.append(Integer.toString(c1[i].getLine(4)));
			file.append(",");
			file.append(Integer.toString(c1[i].getLine(5)));
			file.append(",");
			file.append(Integer.toString(c1[i].getLine(6)));
			file.append(",");
			file.append(Integer.toString(c1[i].getLine(7)));
			file.append("\n");
		} 
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		f.delete();
		
	}
}
