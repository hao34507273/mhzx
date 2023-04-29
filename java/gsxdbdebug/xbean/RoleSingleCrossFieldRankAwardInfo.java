package xbean;

import xdb.Bean;

public abstract interface RoleSingleCrossFieldRankAwardInfo
  extends Bean
{
  public abstract RoleSingleCrossFieldRankAwardInfo copy();
  
  public abstract RoleSingleCrossFieldRankAwardInfo toData();
  
  public abstract RoleSingleCrossFieldRankAwardInfo toBean();
  
  public abstract RoleSingleCrossFieldRankAwardInfo toDataIf();
  
  public abstract RoleSingleCrossFieldRankAwardInfo toBeanIf();
  
  public abstract int getRank();
  
  public abstract boolean getAwarded();
  
  public abstract void setRank(int paramInt);
  
  public abstract void setAwarded(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleSingleCrossFieldRankAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */