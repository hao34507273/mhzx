package xbean;

import xdb.Bean;

public abstract interface SkillMirrorFighterInfo
  extends Bean
{
  public abstract SkillMirrorFighterInfo copy();
  
  public abstract SkillMirrorFighterInfo toData();
  
  public abstract SkillMirrorFighterInfo toBean();
  
  public abstract SkillMirrorFighterInfo toDataIf();
  
  public abstract SkillMirrorFighterInfo toBeanIf();
  
  public abstract int getFighterid();
  
  public abstract int getOcp();
  
  public abstract void setFighterid(int paramInt);
  
  public abstract void setOcp(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillMirrorFighterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */