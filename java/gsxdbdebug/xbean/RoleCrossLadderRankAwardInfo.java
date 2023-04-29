package xbean;

import xdb.Bean;

public abstract interface RoleCrossLadderRankAwardInfo
  extends Bean
{
  public abstract RoleCrossLadderRankAwardInfo copy();
  
  public abstract RoleCrossLadderRankAwardInfo toData();
  
  public abstract RoleCrossLadderRankAwardInfo toBean();
  
  public abstract RoleCrossLadderRankAwardInfo toDataIf();
  
  public abstract RoleCrossLadderRankAwardInfo toBeanIf();
  
  public abstract int getRank();
  
  public abstract boolean getAwarded();
  
  public abstract void setRank(int paramInt);
  
  public abstract void setAwarded(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleCrossLadderRankAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */