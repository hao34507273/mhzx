package mzm.gsp.effect.formula.fighter;

import mzm.gsp.fight.main.Fighter;
import mzm.gsp.skill.main.Skill;

public abstract interface EffectFormula
{
  public abstract int calc(Skill paramSkill, Fighter paramFighter1, Fighter paramFighter2);
  
  public abstract int getParamConst();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\formula\fighter\EffectFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */