package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface MassWeddingRobSubscribeRoles
  extends Bean
{
  public abstract MassWeddingRobSubscribeRoles copy();
  
  public abstract MassWeddingRobSubscribeRoles toData();
  
  public abstract MassWeddingRobSubscribeRoles toBean();
  
  public abstract MassWeddingRobSubscribeRoles toDataIf();
  
  public abstract MassWeddingRobSubscribeRoles toBeanIf();
  
  public abstract Set<Long> getRoleids();
  
  public abstract Set<Long> getRoleidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassWeddingRobSubscribeRoles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */