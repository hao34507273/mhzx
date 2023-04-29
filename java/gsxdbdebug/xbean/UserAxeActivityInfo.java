package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface UserAxeActivityInfo
  extends Bean
{
  public abstract UserAxeActivityInfo copy();
  
  public abstract UserAxeActivityInfo toData();
  
  public abstract UserAxeActivityInfo toBean();
  
  public abstract UserAxeActivityInfo toDataIf();
  
  public abstract UserAxeActivityInfo toBeanIf();
  
  public abstract Map<Integer, AxeActivityInfo> getAxe_activity_infos();
  
  public abstract Map<Integer, AxeActivityInfo> getAxe_activity_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\UserAxeActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */