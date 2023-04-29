package xbean;

import xdb.Bean;

public abstract interface CrossBattleOwnActivityInfo
  extends Bean
{
  public abstract CrossBattleOwnActivityInfo copy();
  
  public abstract CrossBattleOwnActivityInfo toData();
  
  public abstract CrossBattleOwnActivityInfo toBean();
  
  public abstract CrossBattleOwnActivityInfo toDataIf();
  
  public abstract CrossBattleOwnActivityInfo toBeanIf();
  
  public abstract int getVote_times();
  
  public abstract long getVote_timestamp();
  
  public abstract long getCanvass_timestamp();
  
  public abstract void setVote_times(int paramInt);
  
  public abstract void setVote_timestamp(long paramLong);
  
  public abstract void setCanvass_timestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleOwnActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */