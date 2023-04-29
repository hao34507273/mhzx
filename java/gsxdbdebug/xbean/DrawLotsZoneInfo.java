package xbean;

import xdb.Bean;

public abstract interface DrawLotsZoneInfo
  extends Bean
{
  public abstract DrawLotsZoneInfo copy();
  
  public abstract DrawLotsZoneInfo toData();
  
  public abstract DrawLotsZoneInfo toBean();
  
  public abstract DrawLotsZoneInfo toDataIf();
  
  public abstract DrawLotsZoneInfo toBeanIf();
  
  public abstract int getZone();
  
  public abstract int getActive();
  
  public abstract int getMailed();
  
  public abstract void setZone(int paramInt);
  
  public abstract void setActive(int paramInt);
  
  public abstract void setMailed(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DrawLotsZoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */