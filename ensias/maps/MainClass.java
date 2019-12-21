

package ensias.maps;

/**
 * @author MHAMED BOUKBAB 
 */
import javax.swing.*;
import Draw.plot;
import ensias.maps.connection;
public class MainClass extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args)
    {	connection main = new connection();
        Position2d result;
        signal sign;
		int yheight =1000;
        int xwidth = 1600;
        JFrame f = new JFrame("2dMapping");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        plot _cd= new plot(yheight,xwidth);
        f.add(_cd);
        f.setSize(xwidth,yheight);
        f.setVisible(true);
        while(true){ 
        	 sign=main.ReadSensordata();
        	result=main.ReadObjectPosition();
        	_cd.CoordinateObject(result.x, result.y,sign);
        	
        	_cd.repaint();  
        	try  
            {  
                Thread.sleep(10); 
            }catch(InterruptedException e){System.out.println(e);}  
        	
        	
                           
                     }
    }
}
            
