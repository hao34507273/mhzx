package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleAllLottoActivityInfo
  extends Bean
{
  public abstract RoleAllLottoActivityInfo copy();
  
  public abstract RoleAllLottoActivityInfo toData();
  
  public abstract RoleAllLottoActivityInfo toBean();
  
  public abstract RoleAllLottoActivityInfo toDataIf();
  
  public abstract RoleAllLottoActivityInfo toBeanIf();
  
  public abstract Map<Integer, RoleAllLottoWarmUpInfo> getWarm_up_infos();
  
  public abstract Map<Integer, RoleAllLottoWarmUpInfo> getWarm_up_infosAsData();
  
  public abstract Map<Integer, RoleAllLottoTurnInfo> getTurn_infos();
  
  public abstract Map<Integer, RoleAllLottoTurnInfo> getTurn_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleAllLottoActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */