package xbean;

import xdb.Bean;

public abstract interface GlobalSingleFloorInfo
  extends Bean
{
  public abstract GlobalSingleFloorInfo copy();
  
  public abstract GlobalSingleFloorInfo toData();
  
  public abstract GlobalSingleFloorInfo toBean();
  
  public abstract GlobalSingleFloorInfo toDataIf();
  
  public abstract GlobalSingleFloorInfo toBeanIf();
  
  public abstract FloorFightRes getFirstblood();
  
  public abstract FloorFightRes getFastkill();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GlobalSingleFloorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */