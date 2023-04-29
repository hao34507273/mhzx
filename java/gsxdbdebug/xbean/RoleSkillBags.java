package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleSkillBags
  extends Bean
{
  public abstract RoleSkillBags copy();
  
  public abstract RoleSkillBags toData();
  
  public abstract RoleSkillBags toBean();
  
  public abstract RoleSkillBags toDataIf();
  
  public abstract RoleSkillBags toBeanIf();
  
  public abstract Map<Integer, Integer> getMenpai();
  
  public abstract Map<Integer, Integer> getMenpaiAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleSkillBags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */