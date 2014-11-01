package components.entities.skills.combat.melee.daggers;

import java.util.ArrayList;
import java.util.List;

import components.entities.skills.ParentSkill;
import components.entities.skills.SkillObject;
import components.entities.skills.SubSkill;
import components.entities.skills.combat.melee.daggers.types.Dirk;

public class Daggers implements SkillObject, ParentSkill, SubSkill {

	private List<SkillObject> subSkills;
	public List<SkillObject> getSubSkill() { return this.subSkills; }
	
	private SkillObject parentSkill;
	public SkillObject getParentSkill() { return this.parentSkill; }
	public void setParentSkill(SkillObject parentSkill) { this.parentSkill = parentSkill; }

	private double baseSkill(){
		double skillTotal = 0;
		
		for (SkillObject skill: subSkills){
			skillTotal += skill.getBaseSkill();
		}
		
		return skillTotal*.25;
	}
	public double getBaseSkill(){
		return this.baseSkill();
	}
	
	public double calculatedSkill(){
		if ((parentSkill.calculatedSkill() + baseSkill()) > 100)
			return 100;
		
		return (parentSkill.calculatedSkill() + baseSkill());
	}
	
	public Daggers(SkillObject parentSkill) {
		super();
		this.parentSkill = parentSkill;
		
		this.subSkills = new ArrayList<SkillObject>();
		this.subSkills.add(new Dirk(this));
	}
	

	public String toString() {
		return "Daggers [Base Skill=" + getBaseSkill() + ", Calculated Skill=" + calculatedSkill() + "]";
	}
	
}
