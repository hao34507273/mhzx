package xbean;

import xdb.Bean;

public abstract interface XiuLianSkill
  extends Bean
{
  public abstract XiuLianSkill copy();
  
  public abstract XiuLianSkill toData();
  
  public abstract XiuLianSkill toBean();
  
  public abstract XiuLianSkill toDataIf();
  
  public abstract XiuLianSkill toBeanIf();
  
  public abstract int getLevel();
  
  public abstract int getExp();
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setExp(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XiuLianSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */