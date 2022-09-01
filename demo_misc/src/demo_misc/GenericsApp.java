package demo_misc;

public class GenericsApp<T> {

	T x,y;
	
	public void setData(T x, T y) {
		this.x=x;
		this.y=y;
	}
	
	public String displayData() {
		return x.toString()+y.toString();
	}
}
