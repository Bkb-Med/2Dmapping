


package Draw;
/**
*
* @author MHAMED BOUKBAB
*/
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;


import Draw.Params;
import ensias.maps.signal;

  
public class plot extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _yh;
    private int _xw;
    private int hlines;
    private int vlines;
    dataList dotMaps = new dataList()  ;
    int[] data;
    public int xobjectposition=0;
    public int yobjectposition=0;
    
    public plot(int yh, int xw){
		    this._xw = xw;
		    this._yh = yh;
		    this.hlines=_yh/30;
		    this.vlines=_xw/40;
    }   

    
    private void plotlines(Graphics2D gr) {
    	 gr.setFont(Params.pfont);  
	     gr.setColor(Color.GRAY);
    	 gr.setPaint(Params.gridColor);
	     gr.setStroke(new BasicStroke(1));
    	 for(int i=0 ; i<=vlines;i++)  {
	        	gr.draw(new Line2D.Float(i*vlines, 0,i*vlines,_yh));}
	     for(int i=0 ; i<=hlines;i++)  {
	        	gr.draw(new Line2D.Float(0, i*hlines,_xw,i*hlines));}
	    
    }
    public void mapsPlot(Graphics2D gr) {
    	 
	    gr.setPaint(Params.mapsdotcolor);
	    gr.translate(xobjectposition,yobjectposition);  
		   if(data.length>=2) {
		    	try {
				    for(int i=0 ; i<data.length ; i+=2) {
				    	
				    	gr.fillOval((int)data[i],(int)-data[i+1],Params.mapsdotsize,Params.mapsdotsize);
				    	
				    	}
				   } catch (Exception e) {
				       e.printStackTrace();
	    }}}
	  
    
    
    private void mainObjectTrack(Graphics2D gr) {
    	gr.setPaint(Params.trackColor);
        gr.translate(0, _yh);
        gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gr.fillOval(xobjectposition-Params.xdotmargin,yobjectposition-Params.ydotmargin,Params.tracksize,Params.tracksize);
        gr.setPaint(Params.trackColormax);
        gr.drawOval(xobjectposition-Params.xdotmargin,yobjectposition-Params.ydotmargin,Params.tracksize,Params.tracksize);
        gr.setColor(Params.dotcolor);
        gr.fillOval(xobjectposition,yobjectposition,Params.dotsize,Params.dotsize);
    
    	
    }
	public void CoordinateObject(int x,int y,signal maps) {
	    	 xobjectposition=x; 
	 	     yobjectposition=-y;
	 	     if(maps.getlenght()%2 ==0) {
		 	     float[] ret=new float[maps.getlenght()];
		 	     ret=maps.getArray();
		 	     for(int i=0; i<ret.length;i++) {
		 	    	     dotMaps.setDatapoint((int)ret[i]);
				        }
		 	    data = new int[dotMaps.getlenght()];
			    data = dotMaps.filterAndget();
			    //System.out.println(Arrays.toString(dotMaps.filterAndget()));
	 	     }
	 	     }
	public void paintComponent(Graphics g){
		
	        super.paintComponent(g);
	        this.setBackground(Color.BLACK);
	        Graphics2D mainGr =(Graphics2D)g;
	        mainGr.translate(0,0);
	        plotlines(mainGr); 
	        mainObjectTrack(mainGr);   
	        mapsPlot(mainGr);
	        
	       
	} }


