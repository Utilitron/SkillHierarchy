package components.entities.skills.combat.melee.swords.types;

import java.util.ArrayList;
import java.util.List;

import components.entities.skills.ParentSkill;
import components.entities.skills.SiblingSkill;
import components.entities.skills.SkillObject;
import components.entities.skills.SubSkill;
import components.entities.skills.combat.weapontypes.Bladed;
import components.entities.skills.combat.weapontypes.TwoHanded;

public class Claymore implements SkillObject, Bladed, TwoHanded, SubSkill, SiblingSkill {

	private SkillObject parentSkill;
	public SkillObject getParentSkill() { return this.parentSkill; }
	public void setParentSkill(SkillObject parentSkill) { this.parentSkill = parentSkill; }

	private List<SkillObject> siblingSkills;
	public List<SkillObject> getSiblingSkills() {
		if (siblingSkills == null){
			siblingSkills = new ArrayList<SkillObject>();
			if (this.parentSkill instanceof ParentSkill){
				ParentSkill parentSkill = (ParentSkill) this.parentSkill;
				
				siblingSkills.addAll(parentSkill.getSubSkill());
			}
		} else
			this.siblingSkills = new ArrayList<SkillObject>();
		
		return this.siblingSkills;
	}
	
	private double baseSkill = 0;
	public double getBaseSkill(){
		return this.baseSkill;
	}
	
	public double calculatedSkill(){
		if ((parentSkill.calculatedSkill() + baseSkill) > 100)
			return 100;
		
		return (parentSkill.calculatedSkill() + baseSkill);
	}
	
	public Claymore(SkillObject parentSkill) {
		this.parentSkill = parentSkill;
	}

	
	public String toString() {
		return "Claymore [Base Skill=" + getBaseSkill() + ", Calculated Skill=" + calculatedSkill() + "]";
	}
	
}
