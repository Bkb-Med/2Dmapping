package Draw;
/**
*
* @author MHAMED BOUKBAB
*/

import java.util.ArrayList;
import java.util.List;

public class dataList {
	List<Integer> arrlist = new ArrayList<Integer>();
	
	public dataList()
    {
		arrlist   = new ArrayList<Integer>();
    }
	public void setDatapoint(int arr) {
		arrlist.add(arr);	
	}
	public int[] getDatapoint() {
		
		int[] ret = new int[arrlist.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = arrlist.get(i);
		  return ret;
	}
	public int getlenght() {
		return arrlist.size();
	}
	public int[] filterAndget() {
	
		    Integer a ;
			Integer b ;
			for(int j=0 ; j<arrlist.size()/2;j+=2) {
					a=arrlist.get(j);
					b=arrlist.get(j+1);
				    int k=0;
					for(int i=0 ; i<arrlist.size()/2;i+=2) {
						
						               if(arrlist.get(i).equals(a) && arrlist.get(i+1).equals(b)){
												if (k==0) {k++;continue;}
												else
											    	arrlist.remove(i);
												    arrlist.remove(i);
											      }
									k++;
					              }
			}
			
			int[] ret = new int[arrlist.size()];
			  for(int i = 0;i < ret.length;i++)
			    ret[i] = arrlist.get(i);
			  return ret;

	    }
	
}
