package xbean;

import xdb.Bean;

public abstract interface RoleAllLottoTurnInfo
  extends Bean
{
  public abstract RoleAllLottoTurnInfo copy();
  
  public abstract RoleAllLottoTurnInfo toData();
  
  public abstract RoleAllLottoTurnInfo toBean();
  
  public abstract RoleAllLottoTurnInfo toDataIf();
  
  public abstract RoleAllLottoTurnInfo toBeanIf();
  
  public abstract int getAward_state();
  
  public abstract void setAward_state(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleAllLottoTurnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */