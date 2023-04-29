package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleLevelGuidesInfo
  extends Bean
{
  public abstract RoleLevelGuidesInfo copy();
  
  public abstract RoleLevelGuidesInfo toData();
  
  public abstract RoleLevelGuidesInfo toBean();
  
  public abstract RoleLevelGuidesInfo toDataIf();
  
  public abstract RoleLevelGuidesInfo toBeanIf();
  
  public abstract Map<Integer, LevelGuideInfo> getTargets();
  
  public abstract Map<Integer, LevelGuideInfo> getTargetsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleLevelGuidesInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */