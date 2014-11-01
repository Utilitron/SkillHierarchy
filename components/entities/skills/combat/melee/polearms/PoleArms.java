package components.entities.skills.combat.melee.polearms;

import java.util.ArrayList;
import java.util.List;

import components.entities.skills.ParentSkill;
import components.entities.skills.SkillObject;
import components.entities.skills.SubSkill;
import components.entities.skills.combat.melee.polearms.types.Bardiche;
import components.entities.skills.combat.melee.polearms.types.Halberd;
import components.entities.skills.combat.melee.polearms.types.Pike;

public class Polearms implements SkillObject, ParentSkill, SubSkill {

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
	
	public Polearms(SkillObject parentSkill) {
		super();
		this.parentSkill = parentSkill;
		
		this.subSkills = new ArrayList<SkillObject>();
		this.subSkills.add(new Bardiche(this));
		this.subSkills.add(new Halberd(this));
		this.subSkills.add(new Pike(this));
	}
	
	
	public String toString() {
		return "PoleArms [Base Skill=" + getBaseSkill() + ", Calculated Skill=" + calculatedSkill() + "]";
	}
	
}
