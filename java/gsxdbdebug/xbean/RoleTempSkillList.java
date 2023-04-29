package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleTempSkillList
  extends Bean
{
  public abstract RoleTempSkillList copy();
  
  public abstract RoleTempSkillList toData();
  
  public abstract RoleTempSkillList toBean();
  
  public abstract RoleTempSkillList toDataIf();
  
  public abstract RoleTempSkillList toBeanIf();
  
  public abstract Map<Integer, Integer> getSkilllist();
  
  public abstract Map<Integer, Integer> getSkilllistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleTempSkillList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */