package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface RolePetFightSkill
  extends Bean
{
  public abstract RolePetFightSkill copy();
  
  public abstract RolePetFightSkill toData();
  
  public abstract RolePetFightSkill toBean();
  
  public abstract RolePetFightSkill toDataIf();
  
  public abstract RolePetFightSkill toBeanIf();
  
  public abstract Set<Integer> getSkills();
  
  public abstract Set<Integer> getSkillsAsData();
  
  public abstract Map<Long, Integer> getPet2skill();
  
  public abstract Map<Long, Integer> getPet2skillAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolePetFightSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */