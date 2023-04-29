package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleFireData
  extends Bean
{
  public abstract RoleFireData copy();
  
  public abstract RoleFireData toData();
  
  public abstract RoleFireData toBean();
  
  public abstract RoleFireData toDataIf();
  
  public abstract RoleFireData toBeanIf();
  
  public abstract Map<Integer, ActivityFireData> getActivitydata();
  
  public abstract Map<Integer, ActivityFireData> getActivitydataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFireData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */