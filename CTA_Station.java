package lab6;

public class CTA_Station{

	private String name;
	private String location;
	private int[] line=new int[8];
	private boolean wheelchair;
	private double result;
	private String[] nameofstation= {"Red","Green","Blue","Brown","Purple","Pink","Orange","Yellow"};
	protected double latitude;
	protected double longitude;
	private String name1;

	public CTA_Station() {
		name="name";
	}
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
		this.location=l;
		this.name=n;
		this.setLine(0,rl); this.setLine(1,gl); this.setLine(2,blue); this.setLine(3,br); this.setLine(4,pur); this.setLine(5,pink);
		this.setLine(6,or); this.setLine(7,yel);
		this.wheelchair=w;
		latitude=la;
		longitude=lo;
		this.result=0;
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

	public boolean equalsTo(CTA_Station g1) {
		if(this.name==g1.name)
			return true;
		return false;
	}

	public String toString() {
		return name;
	}

}
