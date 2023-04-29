package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MarriageSkill
  extends Bean
{
  public abstract MarriageSkill copy();
  
  public abstract MarriageSkill toData();
  
  public abstract MarriageSkill toBean();
  
  public abstract MarriageSkill toDataIf();
  
  public abstract MarriageSkill toBeanIf();
  
  public abstract Map<Integer, Integer> getSkills();
  
  public abstract Map<Integer, Integer> getSkillsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarriageSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */