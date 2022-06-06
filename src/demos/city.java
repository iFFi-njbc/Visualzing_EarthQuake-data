package demos;

public class city {
	
	public static void main(String[] args)
	{
	String[] cities = {"Ankara", "Beijing", "Cairo", "Dublin", "Sialkot"};
	int low = 0;
	int high = cities.length;

	
	String find = "Beijing";
	
	while(low<=high)
	{
		int mid = (low+high)/2;
		int compare = find.compareTo(cities[mid]);
		if(compare == 0)
		{
			System.out.println("City is in the mid 1st");
		}
	/*	else if(compare < 0)
		{
			high = mid - 1;
			break;
		}
		else if(compare > 0)
		{
			low = mid + 1;
			break;
		}
			
	} */
	}
	}
	

}
