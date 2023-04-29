package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface WingRandomSkill
  extends Bean
{
  public abstract WingRandomSkill copy();
  
  public abstract WingRandomSkill toData();
  
  public abstract WingRandomSkill toBean();
  
  public abstract WingRandomSkill toDataIf();
  
  public abstract WingRandomSkill toBeanIf();
  
  public abstract Map<Integer, RandomSkillInfo> getIndex2wingskill();
  
  public abstract Map<Integer, RandomSkillInfo> getIndex2wingskillAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WingRandomSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */