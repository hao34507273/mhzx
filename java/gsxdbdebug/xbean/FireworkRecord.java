package xbean;

import xdb.Bean;

public abstract interface FireworkRecord
  extends Bean
{
  public abstract FireworkRecord copy();
  
  public abstract FireworkRecord toData();
  
  public abstract FireworkRecord toBean();
  
  public abstract FireworkRecord toDataIf();
  
  public abstract FireworkRecord toBeanIf();
  
  public abstract long getCleansessionid();
  
  public abstract int getAlreadygetnum();
  
  public abstract long getFireworkstarttime();
  
  public abstract long getFireworkcountdowntime();
  
  public abstract long getFindfireworkstarttime();
  
  public abstract void setCleansessionid(long paramLong);
  
  public abstract void setAlreadygetnum(int paramInt);
  
  public abstract void setFireworkstarttime(long paramLong);
  
  public abstract void setFireworkcountdowntime(long paramLong);
  
  public abstract void setFindfireworkstarttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FireworkRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */