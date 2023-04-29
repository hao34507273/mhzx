package xbean;

import xdb.Bean;

public abstract interface SkillResultHitMain
  extends Bean
{
  public abstract SkillResultHitMain copy();
  
  public abstract SkillResultHitMain toData();
  
  public abstract SkillResultHitMain toBean();
  
  public abstract SkillResultHitMain toDataIf();
  
  public abstract SkillResultHitMain toBeanIf();
  
  public abstract int getRoundnumber();
  
  public abstract boolean getIsok();
  
  public abstract void setRoundnumber(int paramInt);
  
  public abstract void setIsok(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillResultHitMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */