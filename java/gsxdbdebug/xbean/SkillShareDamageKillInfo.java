package xbean;

import xdb.Bean;

public abstract interface SkillShareDamageKillInfo
  extends Bean
{
  public abstract SkillShareDamageKillInfo copy();
  
  public abstract SkillShareDamageKillInfo toData();
  
  public abstract SkillShareDamageKillInfo toBean();
  
  public abstract SkillShareDamageKillInfo toDataIf();
  
  public abstract SkillShareDamageKillInfo toBeanIf();
  
  public abstract int getSharedamagetype();
  
  public abstract int getSharedamagefighterid();
  
  public abstract int getSkillid();
  
  public abstract int getFighterid();
  
  public abstract long getRoleid();
  
  public abstract void setSharedamagetype(int paramInt);
  
  public abstract void setSharedamagefighterid(int paramInt);
  
  public abstract void setSkillid(int paramInt);
  
  public abstract void setFighterid(int paramInt);
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillShareDamageKillInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */