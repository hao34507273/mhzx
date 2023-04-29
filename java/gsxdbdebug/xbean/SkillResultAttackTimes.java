package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface SkillResultAttackTimes
  extends Bean
{
  public abstract SkillResultAttackTimes copy();
  
  public abstract SkillResultAttackTimes toData();
  
  public abstract SkillResultAttackTimes toBean();
  
  public abstract SkillResultAttackTimes toDataIf();
  
  public abstract SkillResultAttackTimes toBeanIf();
  
  public abstract List<SkillResultAttackTimesRoundInfo> getRoundinfo();
  
  public abstract List<SkillResultAttackTimesRoundInfo> getRoundinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillResultAttackTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */