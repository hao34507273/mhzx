package xbean;

import xdb.Bean;

public abstract interface NoneRealRoleLevelBean
  extends Bean
{
  public abstract NoneRealRoleLevelBean copy();
  
  public abstract NoneRealRoleLevelBean toData();
  
  public abstract NoneRealRoleLevelBean toBean();
  
  public abstract NoneRealRoleLevelBean toDataIf();
  
  public abstract NoneRealRoleLevelBean toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract int getLevel();
  
  public abstract long getLvuptime();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setLvuptime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealRoleLevelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */