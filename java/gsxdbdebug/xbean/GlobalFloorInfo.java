package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GlobalFloorInfo
  extends Bean
{
  public abstract GlobalFloorInfo copy();
  
  public abstract GlobalFloorInfo toData();
  
  public abstract GlobalFloorInfo toBean();
  
  public abstract GlobalFloorInfo toDataIf();
  
  public abstract GlobalFloorInfo toBeanIf();
  
  public abstract Map<Integer, GlobalSingleFloorInfo> getFloor2info();
  
  public abstract Map<Integer, GlobalSingleFloorInfo> getFloor2infoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GlobalFloorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */