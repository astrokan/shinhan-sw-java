package prac01.ps01;

class Cylinder {

	int radius;
	int height;

	double getVolume() {
		return Math.PI * radius * radius * height;
	}

	double getArea() {
		double circleArea = Math.PI * radius * radius;
		double rectArea = (2 * Math.PI * radius) * height;

		return circleArea * 2 + rectArea;
	}
}
