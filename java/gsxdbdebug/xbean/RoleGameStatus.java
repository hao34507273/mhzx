package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface RoleGameStatus
  extends Bean
{
  public abstract RoleGameStatus copy();
  
  public abstract RoleGameStatus toData();
  
  public abstract RoleGameStatus toBean();
  
  public abstract RoleGameStatus toDataIf();
  
  public abstract RoleGameStatus toBeanIf();
  
  public abstract Set<Integer> getGamestatus();
  
  public abstract Set<Integer> getGamestatusAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGameStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */