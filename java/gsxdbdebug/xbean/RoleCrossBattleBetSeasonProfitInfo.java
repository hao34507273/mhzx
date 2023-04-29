package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleCrossBattleBetSeasonProfitInfo
  extends Bean
{
  public abstract RoleCrossBattleBetSeasonProfitInfo copy();
  
  public abstract RoleCrossBattleBetSeasonProfitInfo toData();
  
  public abstract RoleCrossBattleBetSeasonProfitInfo toBean();
  
  public abstract RoleCrossBattleBetSeasonProfitInfo toDataIf();
  
  public abstract RoleCrossBattleBetSeasonProfitInfo toBeanIf();
  
  public abstract Map<Integer, RoleCrossBattleBetProfitInfo> getProfit_infos();
  
  public abstract Map<Integer, RoleCrossBattleBetProfitInfo> getProfit_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleCrossBattleBetSeasonProfitInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */