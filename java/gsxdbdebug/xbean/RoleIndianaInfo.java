package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleIndianaInfo
  extends Bean
{
  public abstract RoleIndianaInfo copy();
  
  public abstract RoleIndianaInfo toData();
  
  public abstract RoleIndianaInfo toBean();
  
  public abstract RoleIndianaInfo toDataIf();
  
  public abstract RoleIndianaInfo toBeanIf();
  
  public abstract Map<Integer, RoleIndianaActivityInfo> getActivity_infos();
  
  public abstract Map<Integer, RoleIndianaActivityInfo> getActivity_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleIndianaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */