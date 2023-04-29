package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GlobalFloorActivityInfo
  extends Bean
{
  public abstract GlobalFloorActivityInfo copy();
  
  public abstract GlobalFloorActivityInfo toData();
  
  public abstract GlobalFloorActivityInfo toBean();
  
  public abstract GlobalFloorActivityInfo toDataIf();
  
  public abstract GlobalFloorActivityInfo toBeanIf();
  
  public abstract Map<Integer, GlobalFloorInfo> getActivityinfo();
  
  public abstract Map<Integer, GlobalFloorInfo> getActivityinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GlobalFloorActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */