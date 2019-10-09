
public class StatFormulas {
	public static double mean(double values[]) {
		double result = 0.0;
		double ans = 0.0;
		for(int i = 0; i < values.length; i++) {
			result += values[i]; //sums up the values
		}
		ans = result/values.length; //get the mean
		return ans;
	}
	
	public static double median(double values[]) {
		int mid = values.length/2; //get the mid point value
		double ans = 0.0;
		if (values.length%2 == 1) { //checks if it's odd or even length
			return values[mid]; //return mid point if odd
		}else {
			ans = values[mid] + values[mid - 1]; //adds the mid point and 1 - mid point
			return ans/2;
		}
	}
	
	public static double std(double values[]) {
		double m = 0.0;
		m = mean(values); //Gets the mean of values
		double result = 0.0;
		double ans = 0.0;
		for (int i = 0; i < values.length; i++) {
			result += Math.pow((values[i] - m), 2); //for every value subtract by the mean and square it
		}
		ans = result/values.length; //get the new mean
		return Math.sqrt(ans); //square root the mean
	}
}
