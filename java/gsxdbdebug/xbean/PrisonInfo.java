package xbean;

import xdb.Bean;

public abstract interface PrisonInfo
  extends Bean
{
  public abstract PrisonInfo copy();
  
  public abstract PrisonInfo toData();
  
  public abstract PrisonInfo toBean();
  
  public abstract PrisonInfo toDataIf();
  
  public abstract PrisonInfo toBeanIf();
  
  public abstract long getEnterjailtimestamp();
  
  public abstract long getSessionid();
  
  public abstract int getJailaction();
  
  public abstract long getInjailonlinetime();
  
  public abstract void setEnterjailtimestamp(long paramLong);
  
  public abstract void setSessionid(long paramLong);
  
  public abstract void setJailaction(int paramInt);
  
  public abstract void setInjailonlinetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PrisonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */