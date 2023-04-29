package xbean;

import xdb.Bean;

public abstract interface PassiveSkillInfo
  extends Bean
{
  public abstract PassiveSkillInfo copy();
  
  public abstract PassiveSkillInfo toData();
  
  public abstract PassiveSkillInfo toBean();
  
  public abstract PassiveSkillInfo toDataIf();
  
  public abstract PassiveSkillInfo toBeanIf();
  
  public abstract int getPassive_skill_cfg_id();
  
  public abstract int getRefresh_passive_skill_cfg_id();
  
  public abstract void setPassive_skill_cfg_id(int paramInt);
  
  public abstract void setRefresh_passive_skill_cfg_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PassiveSkillInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */