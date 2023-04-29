package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface RoleApplyGang
  extends Bean
{
  public abstract RoleApplyGang copy();
  
  public abstract RoleApplyGang toData();
  
  public abstract RoleApplyGang toBean();
  
  public abstract RoleApplyGang toDataIf();
  
  public abstract RoleApplyGang toBeanIf();
  
  public abstract Set<Long> getGangs();
  
  public abstract Set<Long> getGangsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleApplyGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */