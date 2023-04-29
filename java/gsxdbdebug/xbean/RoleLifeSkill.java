package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleLifeSkill
  extends Bean
{
  public abstract RoleLifeSkill copy();
  
  public abstract RoleLifeSkill toData();
  
  public abstract RoleLifeSkill toBean();
  
  public abstract RoleLifeSkill toDataIf();
  
  public abstract RoleLifeSkill toBeanIf();
  
  public abstract Map<Integer, Integer> getLifeskillbagmap();
  
  public abstract Map<Integer, Integer> getLifeskillbagmapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleLifeSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */