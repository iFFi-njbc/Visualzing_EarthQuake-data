package demos;

public class SelecctionSort {
	public static void main(String[] args)
	{
		int[] array = {56, 25, 85, 45, 66, 21, 01, 84, 100};
		
		int position = 0;
		int i, j, store;
		for(i=0; i<(array.length); i++)
		{
			position = array[i];
			for(j = i; j<array.length; j++)
			{
				if(position > array[j])
				{
					store = array[j];
					array[j] = position;
					position = store;
				}
			}
			array[i] = position;
		}
		
		for(int k = 0; k<array.length; k++)
		{
			System.out.println(array[k]);
		} 
		
		
		/* insertionsort(array);
		for(int k = 0; k<array.length; k++)
		{
			System.out.println(array[k]);
		} */
		
	}
	
	public static void insertionsort(int[] vals)
	{
		int currentid, dum;
		for(int pos = 1; pos < vals.length; pos++)
		{
			currentid = pos;
			while(currentid > 0 && vals[currentid] < vals[currentid -1])
			{
				dum = vals[currentid - 1];
				vals[currentid - 1] = pos;
				pos = dum;
				
				currentid = currentid - 1;
			}
		}
	}

}
