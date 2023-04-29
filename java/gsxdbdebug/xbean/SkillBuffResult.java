package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface SkillBuffResult
  extends Bean
{
  public abstract SkillBuffResult copy();
  
  public abstract SkillBuffResult toData();
  
  public abstract SkillBuffResult toBean();
  
  public abstract SkillBuffResult toDataIf();
  
  public abstract SkillBuffResult toBeanIf();
  
  public abstract List<SkillBuffResultInfo> getRoundinfo();
  
  public abstract List<SkillBuffResultInfo> getRoundinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillBuffResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */