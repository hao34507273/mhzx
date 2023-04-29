package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RandomSkillInfo
  extends Bean
{
  public abstract RandomSkillInfo copy();
  
  public abstract RandomSkillInfo toData();
  
  public abstract RandomSkillInfo toBean();
  
  public abstract RandomSkillInfo toDataIf();
  
  public abstract RandomSkillInfo toBeanIf();
  
  public abstract WingSkill getPhase_up_reset_skill();
  
  public abstract Map<Integer, MainSubSkill> getIndex_reset_skill();
  
  public abstract Map<Integer, MainSubSkill> getIndex_reset_skillAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RandomSkillInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */