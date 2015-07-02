import java.io.*;

public class NextInlexicalOrder{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		String answer_save[] = new String[test];
		
		for(int t = 0 ; t<test ; t++ ){
		String input = new String(br.readLine());
		char input_char[] = input.toCharArray();
	
		
		boolean answer = false;
		for( int i = input_char.length-2 ; i >= 0 ; i--  ){
			if(answer == true){break;}
			String input_for_sort1 = new String(input_char);
			String input_for_sort = input_for_sort1.substring(i+1, input_char.length);
			//System.out.println(input_for_sort);
			char sorter[] = input_for_sort.toCharArray();
			sort(sorter);
			for(int c = i+1 ; c<input_char.length ; c++){
				input_char[c] = sorter[c-(i+1)];
			}
			
			for(int j = i+1 ; j < input_char.length ; j++){
				if( input_char[j] > input_char[i] ){
					char temp = input_char[j];
					input_char[j]=input_char[i];
					input_char[i]=temp;
					answer = true;
					String answer_string = new String(input_char);
					answer_save[t]=answer_string;
					break;}	}	}//outermost i loop
		}//test
		for(int t = 0 ; t< test ; t++){
			if(answer_save[t]==null)
			System.out.println("no answer");
			else
			System.out.println(answer_save[t]);
		}
	}
    public static void sort(char[] arr)
    	{quickSort(arr, 0, arr.length - 1); }
    public static void quickSort(char arr[], int low, int high) 
  {
        int i = low, j = high;
        char temp;
        int pivot = (int)(arr[(low + high) / 2]);
        while (i <= j) 
        {
            while ((int)arr[i] < pivot)
                i++;
            while ((int)arr[j] > pivot)
                j--;
            if (i <= j) 
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(arr, low, j);
        if (i < high)
            quickSort(arr, i, high);
    }//function ends
	
}
