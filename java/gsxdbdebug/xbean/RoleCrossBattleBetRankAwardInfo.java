package xbean;

import xdb.Bean;

public abstract interface RoleCrossBattleBetRankAwardInfo
  extends Bean
{
  public abstract RoleCrossBattleBetRankAwardInfo copy();
  
  public abstract RoleCrossBattleBetRankAwardInfo toData();
  
  public abstract RoleCrossBattleBetRankAwardInfo toBean();
  
  public abstract RoleCrossBattleBetRankAwardInfo toDataIf();
  
  public abstract RoleCrossBattleBetRankAwardInfo toBeanIf();
  
  public abstract int getRank();
  
  public abstract boolean getAwarded();
  
  public abstract void setRank(int paramInt);
  
  public abstract void setAwarded(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleCrossBattleBetRankAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */