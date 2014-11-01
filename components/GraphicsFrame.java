package components;
import java.awt.*;

import javax.swing.JPanel;

import components.entities.player.PlayerObject;
import components.entities.skills.ParentSkill;
import components.entities.skills.SkillObject;

/**
 * The control logic and main display panel for game.
 */
public class GraphicsFrame extends JPanel {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	public final static int UPDATE_RATE = 30; // Frames per second (fps)

	private GameThread gameThread; // The thread that rns the game logic
	private ContainerBox[] box = new ContainerBox[2]; // The container rectangular box
	private int canvasWidth;
	private int canvasHeight;

	private PlayerObject playerObject;
	public PlayerObject getPlayerObject() { return playerObject; }
	public void setPlayerObject(PlayerObject playerObject) { this.playerObject = playerObject; }

	/**
	 * Constructor to create the UI components and init the game objects. Set
	 * the drawing canvas to fill the screen (given its width and height).
	 * 
	 * @param width
	 *            : screen width
	 * @param height
	 *            : screen height
	 */
	public GraphicsFrame(int width, int height) {
		canvasWidth = width;
		canvasHeight = height;


		// Init the Container Box to fill the screen
		box[0] = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.WHITE);

		// Init the custom drawing panel for drawing the game
		DrawCanvas drawCanvas = new DrawCanvas();

		// Layout the drawing panel and control panel
		this.setLayout(new BorderLayout());
		this.add(drawCanvas, BorderLayout.CENTER);
		
		// Setup and Start
		gameThread = new GameThread(this);
		gameThread.gameSetup();
		gameThread.gameStart();
	}

	/** The custom drawing panel for the game (inner class). */
	class DrawCanvas extends JPanel {

		/**
		 * Serial Version UID
		 */
		private static final long serialVersionUID = 1L;

		/** Custom drawing codes */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Paint background
			// Draw the box
			box[0].draw(g);
			
			int lineNumber = 15;
			
			g.drawString(playerObject.toString(), 10, lineNumber);
			for (SkillObject skill : playerObject.getSkills()) {
				lineNumber += 15;
				g.drawString(skill.toString(), 10, lineNumber);
				
				if (skill instanceof ParentSkill){
					ParentSkill parentskill = (ParentSkill) skill;
					for (SkillObject skill1 : parentskill.getSubSkill()) {
						lineNumber += 15;
						g.drawString("  " + skill1.toString(), 20, lineNumber);
						if (skill1 instanceof ParentSkill){
							ParentSkill parentskill1 = (ParentSkill) skill1;
							for (SkillObject skill2 : parentskill1.getSubSkill()) {
								lineNumber += 15;
								g.drawString(skill2.toString(), 30, lineNumber);
								if (skill1 instanceof ParentSkill){
									ParentSkill parentskill2 = (ParentSkill) skill2;
									for (SkillObject skill3 : parentskill2.getSubSkill()) {
										lineNumber += 15;
										g.drawString(skill3.toString(), 40, lineNumber);
									}
								}

							}
						}
					}
				}
			}
		}

		/** Called back to get the preferred size of the component. */
		@Override
		public Dimension getPreferredSize() {
			return (new Dimension(canvasWidth, canvasHeight));
		}
	}
	
}
