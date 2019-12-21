

/**
 * x, y and z of the closest detected point
 */

//simRemoteApi.start(19999)
package ensias.maps;
/**
*
* @author MHAMED BOUKBAB
*/

import coppelia.CharWA;
import coppelia.FloatWA;
import coppelia.IntW;
import coppelia.remoteApi;

	
public class connection {
        int clientID = -1;
        protected remoteApi vrep = new remoteApi();
        protected IntW leftMotor = new IntW(0);
        protected IntW rightMotor = new IntW(0);
        protected IntW LidarSensor = new IntW(0);
        public FloatWA dataSignal = new FloatWA(1);
        FloatWA RlinearVelo = new FloatWA(0);
        FloatWA RangularVelo = new FloatWA(0);
        FloatWA LlinearVelo = new FloatWA(0);
        FloatWA LangularVelo = new FloatWA(0); 
      
    public connection(){
        vrep.simxFinish(-1);
        clientID = vrep.simxStart("127.0.0.1", 19999, true, true, 5000, 5);
        if (clientID == -1) {
        	throw new RuntimeException("impossible to connect to V-REP server");
        } else {
        	System.out.println("connected to the server....");
        }
        vrep.simxGetObjectHandle(clientID, "LidarSensor", LidarSensor, remoteApi.simx_opmode_blocking);   
       
        System.out.println("ready to go ! ");
        }
    
    public void ReadRobotMotorvelocity(){
        vrep.simxGetObjectVelocity (clientID, leftMotor.getValue(), LlinearVelo,LangularVelo, remoteApi.simx_opmode_streaming);
        vrep.simxGetObjectVelocity (clientID, rightMotor.getValue(), RlinearVelo,RangularVelo, remoteApi.simx_opmode_streaming);
    
    }
    public signal ReadSensordata() {
    	CharWA signal = new CharWA(1);
    	float[] Pointsignal;
    	vrep.simxGetAndClearStringSignal(clientID, "measuredData", signal, remoteApi.simx_opmode_streaming);
    	dataSignal.initArrayFromCharArray(signal.getArray());
    	Pointsignal = new float[dataSignal.getLength()];
    	for (int i = 0; i < dataSignal.getLength(); i++) {
    		if (Math.abs(dataSignal.getArray()[i])<0.000001  || Math.abs(dataSignal.getArray()[i])>50) {Pointsignal[i]=0;}
    		else {Pointsignal[i]=(float)(dataSignal.getArray()[i]+0.00000f);}
    		
    	}
    	signal ret = new signal(new float[Pointsignal.length]);
    	for (int i = 0; i < Pointsignal.length; i++) {
    		ret.s[i] =(float)Math.round((Pointsignal[i])*100) ;
    	     
    	} 
    	return ret;
    }
    public Position2d ReadObjectPosition() {
    	FloatWA GSposition = new FloatWA(1);
    	vrep.simxGetObjectPosition(clientID, LidarSensor.getValue(), -1, GSposition, remoteApi.simx_opmode_streaming);
    	float x = GSposition.getArray()[0] + 0.00000f;
		float y = GSposition.getArray()[1] + 0.00000f;
		Position2d res = new Position2d(0, 0);
		res.y = (int) Math.round((y+12)*40) ;
		res.x = (int) Math.round((x+12)*60);
		return res;
    	
    }
}




