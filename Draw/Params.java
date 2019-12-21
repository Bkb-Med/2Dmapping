package Draw;
/**
*
* @author MHAMED BOUKBAB
*/

import java.awt.Color;
import java.awt.Font;

public class Params {
	
	public static final float alpha           = (float)0.2;
	public static final float alphamax        = (float)0.6;
	public static final int xdotmargin        = 90;
	public static final int ydotmargin        = 85;
	public static final int dotsize           = 20;
	public static final int tracksize         = 200;
	public static final Color gridColor       = new Color(0, 1, 0, Params.alpha);
	public static final Color trackColor      = new Color(0, (float)191/255, 1, Params.alpha);
	public static final Color trackColormax   = new Color(0, (float)191/255, 1, Params.alphamax);
	public static final Font pfont            = new Font("Ubuntu", Font.PLAIN, 20);
	public static final Color dotcolor        = new Color(30,144,255);
	public static final Color mapsdotcolor        = new Color(1, 0, 0, (float)1);
	public static final int mapsdotsize           = 9;
}
