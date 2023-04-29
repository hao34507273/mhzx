package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleXiuLian
  extends Bean
{
  public abstract RoleXiuLian copy();
  
  public abstract RoleXiuLian toData();
  
  public abstract RoleXiuLian toBean();
  
  public abstract RoleXiuLian toDataIf();
  
  public abstract RoleXiuLian toBeanIf();
  
  public abstract Map<Integer, XiuLianSkill> getSkillmap();
  
  public abstract Map<Integer, XiuLianSkill> getSkillmapAsData();
  
  public abstract int getDefaultskillid();
  
  public abstract void setDefaultskillid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleXiuLian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */