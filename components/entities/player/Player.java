package components.entities.player;

import java.util.ArrayList;
import java.util.List;

import components.entities.skills.SkillObject;
import components.entities.skills.combat.Combat;

public class Player implements PlayerObject {

	private List<SkillObject> skills;
	public List<SkillObject> getSkills() {
		
		return this.skills;
	}

	public Player() {
		super();
		
		this.skills = new ArrayList<SkillObject>();
		this.skills.add(new Combat());
	}
	
	
	public String toString() {
		return "Skills:";
	}
	
}
