package lab6;

public class GeoLocation {

	protected double latitude;
	protected double longitude;

	public GeoLocation() {
		this.latitude=10.0;
		this.longitude=20.0;
	}
	
	public GeoLocation(double la,double lo) {
		this.latitude=la;
		this.longitude=lo;
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
	public double calcDistance(GeoLocation g1) {
		double lat=(this.getlatitude()-g1.getlatitude());
		double lon=(this.getlongitude()-g1.getlongitude());
		double result=Math.sqrt((lat*lat)+(lon*lon));
		return result*69;
	}
	
	public double calcDistance (double g1,double g2) {
		double lat=(this.getlatitude()-g1);
		double lon=(this.getlongitude()-g2);
		double result=Math.sqrt((lat*lat)+(lon*lon));
		return result*69;
	}
	
}
