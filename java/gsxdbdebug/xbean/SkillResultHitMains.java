package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface SkillResultHitMains
  extends Bean
{
  public abstract SkillResultHitMains copy();
  
  public abstract SkillResultHitMains toData();
  
  public abstract SkillResultHitMains toBean();
  
  public abstract SkillResultHitMains toDataIf();
  
  public abstract SkillResultHitMains toBeanIf();
  
  public abstract List<SkillResultHitMain> getRoundinfo();
  
  public abstract List<SkillResultHitMain> getRoundinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillResultHitMains.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */