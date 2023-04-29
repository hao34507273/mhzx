package xbean;

import xdb.Bean;

public abstract interface SkillReleaseRoundInfo
  extends Bean
{
  public abstract SkillReleaseRoundInfo copy();
  
  public abstract SkillReleaseRoundInfo toData();
  
  public abstract SkillReleaseRoundInfo toBean();
  
  public abstract SkillReleaseRoundInfo toDataIf();
  
  public abstract SkillReleaseRoundInfo toBeanIf();
  
  public abstract int getRoundnumber();
  
  public abstract boolean getIsok();
  
  public abstract void setRoundnumber(int paramInt);
  
  public abstract void setIsok(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillReleaseRoundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */