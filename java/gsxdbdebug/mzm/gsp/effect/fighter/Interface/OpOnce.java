package mzm.gsp.effect.fighter.Interface;

import mzm.gsp.effect.main.FighterEffectGroup;
import mzm.gsp.fight.main.Fighter;
import mzm.gsp.skill.main.Skill;

public abstract interface OpOnce
{
  public abstract boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Interface\OpOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */