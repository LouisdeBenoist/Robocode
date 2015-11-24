package debenoist.com;
import robocode.*;



public class Terminator extends AdvancedRobot
{
	double previousEnergy = 100;
  double movementDirection = 20;
  double direction = 40;



public void run() {
	setAdjustRadarForRobotTurn(true);
	setAdjustGunForRobotTurn(true);

	while (true) {
			setTurnRadarRight(360);
			setTurnRight(direction);
			setAhead(movementDirection);
			setFire(3);
			setAhead(movementDirection);
			setFire(3);
			execute();
	}
}  

public void onScannedRobot(ScannedRobotEvent e) {

	direction = e.getBearing();
	movementDirection = e.getDistance();
   	double changeInEnergy = previousEnergy-e.getEnergy();
	
   		 if (changeInEnergy>0 && changeInEnergy<=3) {
				setTurnRight(e.getBearing() + 90 - 30 * movementDirection);
         movementDirection = -movementDirection;
		 setAhead((e.getDistance() / 4 + 25) * movementDirection);
		 }
		 
	previousEnergy = e.getEnergy();
 

 	double absoluteBearing = getHeadingRadians() + e.getBearingRadians();
	setTurnGunRightRadians(robocode.util.Utils.normalRelativeAngle(absoluteBearing - getGunHeadingRadians() + (e.getVelocity() * Math.sin(e.getHeadingRadians() - absoluteBearing) / 13.0)));
if (getGunTurnRemaining() <=40){
	setFire(3.0);
}



}
 


	public void onHitByBullet(HitByBulletEvent e) {
	}
	
	

	public void onHitWall(HitWallEvent e) {
	}
	}	
	


	
