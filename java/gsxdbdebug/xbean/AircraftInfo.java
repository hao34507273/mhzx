package xbean;

import xdb.Bean;

public abstract interface AircraftInfo
  extends Bean
{
  public abstract AircraftInfo copy();
  
  public abstract AircraftInfo toData();
  
  public abstract AircraftInfo toBean();
  
  public abstract AircraftInfo toDataIf();
  
  public abstract AircraftInfo toBeanIf();
  
  public abstract int getDye_color_id();
  
  public abstract void setDye_color_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AircraftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */