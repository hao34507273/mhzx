package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ResourcePoint
  extends Bean
{
  public abstract ResourcePoint copy();
  
  public abstract ResourcePoint toData();
  
  public abstract ResourcePoint toBean();
  
  public abstract ResourcePoint toDataIf();
  
  public abstract ResourcePoint toBeanIf();
  
  public abstract Map<Long, RoleResourcePointInfo> getRole_resource_point_infos();
  
  public abstract Map<Long, RoleResourcePointInfo> getRole_resource_point_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ResourcePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */