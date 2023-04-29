package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface SkillReleaseRoundInfos
  extends Bean
{
  public abstract SkillReleaseRoundInfos copy();
  
  public abstract SkillReleaseRoundInfos toData();
  
  public abstract SkillReleaseRoundInfos toBean();
  
  public abstract SkillReleaseRoundInfos toDataIf();
  
  public abstract SkillReleaseRoundInfos toBeanIf();
  
  public abstract List<SkillReleaseRoundInfo> getRoundinfo();
  
  public abstract List<SkillReleaseRoundInfo> getRoundinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillReleaseRoundInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */