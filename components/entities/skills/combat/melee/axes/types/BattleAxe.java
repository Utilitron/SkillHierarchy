package components.entities.skills.combat.melee.axes.types;

import components.entities.skills.SkillObject;
import components.entities.skills.SubSkill;
import components.entities.skills.combat.weapontypes.Axe;
import components.entities.skills.combat.weapontypes.OneHanded;

public class BattleAxe implements SkillObject, Axe, OneHanded, SubSkill {
	
	private SkillObject parentSkill;
	public SkillObject getParentSkill() { return this.parentSkill; }
	public void setParentSkill(SkillObject parentSkill) { this.parentSkill = parentSkill; }
	
	private double baseSkill = 0;
	public double getBaseSkill(){
		return this.baseSkill;
	}
	
	public double calculatedSkill(){
		if ((parentSkill.calculatedSkill() + baseSkill) > 100)
			return 100;
		
		return (parentSkill.calculatedSkill() + baseSkill);
	}

	public BattleAxe(SkillObject parentSkill) {
		this.parentSkill = parentSkill;
	}

	
	public String toString() {
		return "Battle Axe [Base Skill=" + getBaseSkill() + ", Calculated Skill=" + calculatedSkill() + "]";
	}
	
}
