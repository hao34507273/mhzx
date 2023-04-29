package xbean;

import xdb.Bean;

public abstract interface RoleSingleCrossFieldSeasonInfo
  extends Bean
{
  public abstract RoleSingleCrossFieldSeasonInfo copy();
  
  public abstract RoleSingleCrossFieldSeasonInfo toData();
  
  public abstract RoleSingleCrossFieldSeasonInfo toBean();
  
  public abstract RoleSingleCrossFieldSeasonInfo toDataIf();
  
  public abstract RoleSingleCrossFieldSeasonInfo toBeanIf();
  
  public abstract int getStar_num();
  
  public abstract int getWin_point();
  
  public abstract int getStraight_win_num();
  
  public abstract long getStar_num_timestamp();
  
  public abstract boolean getAwarded();
  
  public abstract void setStar_num(int paramInt);
  
  public abstract void setWin_point(int paramInt);
  
  public abstract void setStraight_win_num(int paramInt);
  
  public abstract void setStar_num_timestamp(long paramLong);
  
  public abstract void setAwarded(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleSingleCrossFieldSeasonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */