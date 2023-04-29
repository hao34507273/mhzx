package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleGangSkill
  extends Bean
{
  public abstract RoleGangSkill copy();
  
  public abstract RoleGangSkill toData();
  
  public abstract RoleGangSkill toBean();
  
  public abstract RoleGangSkill toDataIf();
  
  public abstract RoleGangSkill toBeanIf();
  
  public abstract Map<Integer, Integer> getGangskillbagmap();
  
  public abstract Map<Integer, Integer> getGangskillbagmapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGangSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */