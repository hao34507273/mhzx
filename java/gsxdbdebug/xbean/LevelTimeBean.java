package xbean;

import xdb.Bean;

public abstract interface LevelTimeBean
  extends Bean
{
  public abstract LevelTimeBean copy();
  
  public abstract LevelTimeBean toData();
  
  public abstract LevelTimeBean toBean();
  
  public abstract LevelTimeBean toDataIf();
  
  public abstract LevelTimeBean toBeanIf();
  
  public abstract int getServerlevel();
  
  public abstract long getStarttime();
  
  public abstract long getUpgradetime();
  
  public abstract void setServerlevel(int paramInt);
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setUpgradetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LevelTimeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */