package components.entities.skills.combat.melee.daggers.types;

import components.entities.skills.SkillObject;
import components.entities.skills.SubSkill;
import components.entities.skills.combat.weapontypes.Bladed;
import components.entities.skills.combat.weapontypes.OneHanded;

public class Dirk implements SkillObject, OneHanded, Bladed, SubSkill {

	private SkillObject parentSkill;
	public SkillObject getParentSkill() { return this.parentSkill; }
	public void setParentSkill(SkillObject parentSkill) { this.parentSkill = parentSkill; }

	private double baseSkill = 100;
	public double getBaseSkill(){
		return this.baseSkill;
	}
	
	public double calculatedSkill(){
		if ((parentSkill.calculatedSkill() + baseSkill) > 100)
			return 100;
		
		return (parentSkill.calculatedSkill() + baseSkill);
	}
	
	public Dirk(SkillObject parentSkill) {
		this.parentSkill = parentSkill;
	}
	
	
	public String toString() {
		return "Dirk [Base Skill=" + getBaseSkill() + ", Calculated Skill=" + calculatedSkill() + "]";
	}
	
}
