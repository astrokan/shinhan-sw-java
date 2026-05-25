package ch06.sec14;

public class Car {
	private int speed;
	private boolean stop;
	
	
	//getter setter 단축키 -> alt(cmd) shift s
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if (speed < 0) this.speed = 0;
		this.speed = speed;
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
}
