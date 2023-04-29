package xbean;

import xdb.Bean;

public abstract interface FumoInfo
  extends Bean
{
  public abstract FumoInfo copy();
  
  public abstract FumoInfo toData();
  
  public abstract FumoInfo toBean();
  
  public abstract FumoInfo toDataIf();
  
  public abstract FumoInfo toBeanIf();
  
  public abstract int getProtype();
  
  public abstract int getAddvalue();
  
  public abstract long getTimeout();
  
  public abstract void setProtype(int paramInt);
  
  public abstract void setAddvalue(int paramInt);
  
  public abstract void setTimeout(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FumoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */