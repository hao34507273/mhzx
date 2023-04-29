package xbean;

import xdb.Bean;

public abstract interface RoleAllLottoWarmUpInfo
  extends Bean
{
  public abstract RoleAllLottoWarmUpInfo copy();
  
  public abstract RoleAllLottoWarmUpInfo toData();
  
  public abstract RoleAllLottoWarmUpInfo toBean();
  
  public abstract RoleAllLottoWarmUpInfo toDataIf();
  
  public abstract RoleAllLottoWarmUpInfo toBeanIf();
  
  public abstract boolean getAwarded();
  
  public abstract void setAwarded(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleAllLottoWarmUpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */