package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface SkillResultKillMonsterInfo
  extends Bean
{
  public abstract SkillResultKillMonsterInfo copy();
  
  public abstract SkillResultKillMonsterInfo toData();
  
  public abstract SkillResultKillMonsterInfo toBean();
  
  public abstract SkillResultKillMonsterInfo toDataIf();
  
  public abstract SkillResultKillMonsterInfo toBeanIf();
  
  public abstract List<Integer> getRoundnumber();
  
  public abstract List<Integer> getRoundnumberAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillResultKillMonsterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */