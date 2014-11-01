package components;

import components.entities.player.Player;


// Run the game logic in its own thread.
public class GameThread extends Thread {

	public GraphicsFrame graphicsFrame;
	
	public GameThread(GraphicsFrame graphicsFrame) {
		this.graphicsFrame = graphicsFrame;
	}

	/** Start */
	public void gameStart() {
		this.start(); // Invoke GaemThread.run()
	}

	public void run() {
		while (true) {
			long beginTimeMillis, timeTakenMillis, timeLeftMillis;
			beginTimeMillis = System.currentTimeMillis();
	
			// Execute one game step
			gameUpdate();
			
			// Refresh the display
			graphicsFrame.repaint();
	
	
			// Provide the necessary delay to meet the target rate
			timeTakenMillis = System.currentTimeMillis() - beginTimeMillis;
			timeLeftMillis = 1000L / GraphicsFrame.UPDATE_RATE - timeTakenMillis;
			if (timeLeftMillis < 5)
				timeLeftMillis = 5; // Set a minimum
	
			// Delay and give other thread a chance
			try {
				Thread.sleep(timeLeftMillis);
			} catch (InterruptedException ex) {
			}
		}
	}
	
	/**
	 * Set up the game
	 */
	public void gameSetup() {
		Player player = new Player();
		
		graphicsFrame.setPlayerObject(player);
	}
	
	/**
	 * One game time-step. Update the game objects, with proper collision
	 * detection and response.
	 */
	public void gameUpdate() {

	}
}
