package xbean;

import xdb.Bean;

public abstract interface CountInfo
  extends Bean
{
  public abstract CountInfo copy();
  
  public abstract CountInfo toData();
  
  public abstract CountInfo toBean();
  
  public abstract CountInfo toDataIf();
  
  public abstract CountInfo toBeanIf();
  
  public abstract int getCount();
  
  public abstract boolean getIsawarded();
  
  public abstract int getAwardnum();
  
  public abstract long getStarttime();
  
  public abstract int getCurcircle();
  
  public abstract void setCount(int paramInt);
  
  public abstract void setIsawarded(boolean paramBoolean);
  
  public abstract void setAwardnum(int paramInt);
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setCurcircle(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */