package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleBigBossRemoteChartInfo
  extends Bean
{
  public abstract RoleBigBossRemoteChartInfo copy();
  
  public abstract RoleBigBossRemoteChartInfo toData();
  
  public abstract RoleBigBossRemoteChartInfo toBean();
  
  public abstract RoleBigBossRemoteChartInfo toDataIf();
  
  public abstract RoleBigBossRemoteChartInfo toBeanIf();
  
  public abstract Map<Integer, RoleBigBossRemoteChartAwardInfo> getAward_infos();
  
  public abstract Map<Integer, RoleBigBossRemoteChartAwardInfo> getAward_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleBigBossRemoteChartInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */