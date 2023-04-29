package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface SkillMirrorInfo
  extends Bean
{
  public abstract SkillMirrorInfo copy();
  
  public abstract SkillMirrorInfo toData();
  
  public abstract SkillMirrorInfo toBean();
  
  public abstract SkillMirrorInfo toDataIf();
  
  public abstract SkillMirrorInfo toBeanIf();
  
  public abstract Set<SkillMirrorFighterInfo> getTargets();
  
  public abstract Set<SkillMirrorFighterInfo> getTargetsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillMirrorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */