package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleCrossBattleFinalAwardInfo
  extends Bean
{
  public abstract RoleCrossBattleFinalAwardInfo copy();
  
  public abstract RoleCrossBattleFinalAwardInfo toData();
  
  public abstract RoleCrossBattleFinalAwardInfo toBean();
  
  public abstract RoleCrossBattleFinalAwardInfo toDataIf();
  
  public abstract RoleCrossBattleFinalAwardInfo toBeanIf();
  
  public abstract Map<Integer, CrossBattleFinalAwardInfo> getActivity_award_map();
  
  public abstract Map<Integer, CrossBattleFinalAwardInfo> getActivity_award_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleCrossBattleFinalAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */