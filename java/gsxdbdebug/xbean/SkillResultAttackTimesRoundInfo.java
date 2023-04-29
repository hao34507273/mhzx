package xbean;

import xdb.Bean;

public abstract interface SkillResultAttackTimesRoundInfo
  extends Bean
{
  public abstract SkillResultAttackTimesRoundInfo copy();
  
  public abstract SkillResultAttackTimesRoundInfo toData();
  
  public abstract SkillResultAttackTimesRoundInfo toBean();
  
  public abstract SkillResultAttackTimesRoundInfo toDataIf();
  
  public abstract SkillResultAttackTimesRoundInfo toBeanIf();
  
  public abstract int getRoundnumber();
  
  public abstract int getTimes();
  
  public abstract void setRoundnumber(int paramInt);
  
  public abstract void setTimes(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillResultAttackTimesRoundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */