package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleCounterInfo
  extends Bean
{
  public abstract RoleCounterInfo copy();
  
  public abstract RoleCounterInfo toData();
  
  public abstract RoleCounterInfo toBean();
  
  public abstract RoleCounterInfo toDataIf();
  
  public abstract RoleCounterInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getCounter_info();
  
  public abstract Map<Integer, Integer> getCounter_infoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleCounterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */