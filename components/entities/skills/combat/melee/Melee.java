package components.entities.skills.combat.melee;

import java.util.ArrayList;
import java.util.List;

import components.entities.skills.ParentSkill;
import components.entities.skills.SkillObject;
import components.entities.skills.SubSkill;
import components.entities.skills.combat.melee.axes.Axes;
import components.entities.skills.combat.melee.bashing.Bashing;
import components.entities.skills.combat.melee.daggers.Daggers;
import components.entities.skills.combat.melee.polearms.Polearms;
import components.entities.skills.combat.melee.swords.Swords;

public class Melee implements SkillObject, ParentSkill, SubSkill {

	private List<SkillObject> subSkills;
	public List<SkillObject> getSubSkill() { return this.subSkills; }
	
	private SkillObject parentSkill;
	public SkillObject getParentSkill() { return this.parentSkill; }
	public void setParentSkill(SkillObject parentSkill) { this.parentSkill = parentSkill; }

	private double baseSkill(){
		double skillAverage = 0;
		
		for (SkillObject skill: subSkills){
			skillAverage += skill.getBaseSkill();
		}
		
		return skillAverage/subSkills.size();
	}
	public double getBaseSkill(){
		return this.baseSkill();
	}
	
	public double calculatedSkill(){
		if ((parentSkill.calculatedSkill() + baseSkill()) > 100)
			return 100;
		
		return (parentSkill.calculatedSkill() + baseSkill());
	}
	
	public Melee(SkillObject parentSkill) {
		super();
		this.parentSkill = parentSkill;
	
		this.subSkills = new ArrayList<SkillObject>();
		this.subSkills.add(new Axes(this));
		this.subSkills.add(new Bashing(this));
		this.subSkills.add(new Daggers(this));
		this.subSkills.add(new Polearms(this));
		this.subSkills.add(new Swords(this));
	}
	
	public String toString() {
		return  "Melee [Base Skill=" + getBaseSkill() + ", Calculated Skill=" + calculatedSkill() + "]";
	}
	
}
