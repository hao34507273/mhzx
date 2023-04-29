package xbean;

import xdb.Bean;

public abstract interface RoleBigBossRemoteChartAwardInfo
  extends Bean
{
  public abstract RoleBigBossRemoteChartAwardInfo copy();
  
  public abstract RoleBigBossRemoteChartAwardInfo toData();
  
  public abstract RoleBigBossRemoteChartAwardInfo toBean();
  
  public abstract RoleBigBossRemoteChartAwardInfo toDataIf();
  
  public abstract RoleBigBossRemoteChartAwardInfo toBeanIf();
  
  public abstract int getOccupation();
  
  public abstract int getRank();
  
  public abstract void setOccupation(int paramInt);
  
  public abstract void setRank(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleBigBossRemoteChartAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */