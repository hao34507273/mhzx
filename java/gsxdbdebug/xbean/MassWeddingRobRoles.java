package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface MassWeddingRobRoles
  extends Bean
{
  public abstract MassWeddingRobRoles copy();
  
  public abstract MassWeddingRobRoles toData();
  
  public abstract MassWeddingRobRoles toBean();
  
  public abstract MassWeddingRobRoles toDataIf();
  
  public abstract MassWeddingRobRoles toBeanIf();
  
  public abstract Set<Long> getGrooms();
  
  public abstract Set<Long> getGroomsAsData();
  
  public abstract Set<Long> getBrides();
  
  public abstract Set<Long> getBridesAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassWeddingRobRoles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */