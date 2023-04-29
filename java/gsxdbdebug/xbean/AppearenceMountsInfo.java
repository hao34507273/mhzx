package xbean;

import xdb.Bean;

public abstract interface AppearenceMountsInfo
  extends Bean
{
  public abstract AppearenceMountsInfo copy();
  
  public abstract AppearenceMountsInfo toData();
  
  public abstract AppearenceMountsInfo toBean();
  
  public abstract AppearenceMountsInfo toDataIf();
  
  public abstract AppearenceMountsInfo toBeanIf();
  
  public abstract long getMounts_id();
  
  public abstract long getStart_time();
  
  public abstract long getEffect_time();
  
  public abstract void setMounts_id(long paramLong);
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setEffect_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AppearenceMountsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */