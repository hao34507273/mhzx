package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleCountDownInfo
  extends Bean
{
  public abstract RoleCountDownInfo copy();
  
  public abstract RoleCountDownInfo toData();
  
  public abstract RoleCountDownInfo toBean();
  
  public abstract RoleCountDownInfo toDataIf();
  
  public abstract RoleCountDownInfo toBeanIf();
  
  public abstract Map<Integer, CountDownInfo> getCount_down_infos();
  
  public abstract Map<Integer, CountDownInfo> getCount_down_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleCountDownInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */