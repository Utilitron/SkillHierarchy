package components.entities.skills.combat;

import java.util.ArrayList;
import java.util.List;

import components.entities.skills.ParentSkill;
import components.entities.skills.SkillObject;
import components.entities.skills.combat.melee.Melee;

public class Combat implements SkillObject, ParentSkill {

	private List<SkillObject> subSkills;
	public List<SkillObject> getSubSkill() { return this.subSkills; }

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
		if ((2 * baseSkill()) > 100)
			return 100;
		
		return (2 * baseSkill());
	}

	public Combat() {
		super();
		
		this.subSkills = new ArrayList<SkillObject>();
		this.subSkills.add(new Melee(this));
	}
	
	
	public String toString() {
		return "Combat [Base Skill=" + getBaseSkill() + ", Calculated Skill=" + calculatedSkill() + "]";

	}
	
}
