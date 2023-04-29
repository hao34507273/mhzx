package xbean;

import xdb.Bean;

public abstract interface ShuYuan
  extends Bean
{
  public abstract ShuYuan copy();
  
  public abstract ShuYuan toData();
  
  public abstract ShuYuan toBean();
  
  public abstract ShuYuan toDataIf();
  
  public abstract ShuYuan toBeanIf();
  
  public abstract int getLevel();
  
  public abstract long getLevelupendtime();
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setLevelupendtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ShuYuan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */