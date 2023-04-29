package xbean;

import xdb.Bean;

public abstract interface SkillBuffResultInfo
  extends Bean
{
  public abstract SkillBuffResultInfo copy();
  
  public abstract SkillBuffResultInfo toData();
  
  public abstract SkillBuffResultInfo toBean();
  
  public abstract SkillBuffResultInfo toDataIf();
  
  public abstract SkillBuffResultInfo toBeanIf();
  
  public abstract int getRoundnumber();
  
  public abstract boolean getIsok();
  
  public abstract int getBuff();
  
  public abstract void setRoundnumber(int paramInt);
  
  public abstract void setIsok(boolean paramBoolean);
  
  public abstract void setBuff(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillBuffResultInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */