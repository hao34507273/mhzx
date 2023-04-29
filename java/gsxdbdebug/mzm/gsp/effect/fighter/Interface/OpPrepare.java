package mzm.gsp.effect.fighter.Interface;

import mzm.gsp.effect.main.FighterEffectGroup;
import mzm.gsp.fight.main.Fighter;
import mzm.gsp.skill.main.Skill;

public abstract interface OpPrepare
{
  public abstract boolean prepare(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2, Fighter paramFighter3);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Interface\OpPrepare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */