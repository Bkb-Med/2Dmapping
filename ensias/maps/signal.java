package ensias.maps;
/**
*
* @author MHAMED BOUKBAB
*/

public class signal
{
	float[] s ;
	
	
	public signal (float[] s) {
		
		this.s=s;
	}
	public int getlenght() {
		return s.length;
	}
	public float[] getArray() {
		return s;
	}
}
