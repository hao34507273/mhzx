package xbean;

import xdb.Bean;

public abstract interface Campaign
  extends Bean
{
  public abstract Campaign copy();
  
  public abstract Campaign toData();
  
  public abstract Campaign toBean();
  
  public abstract Campaign toDataIf();
  
  public abstract Campaign toBeanIf();
  
  public abstract int getCampaign();
  
  public abstract VoteAwardInfo getVote_award_info();
  
  public abstract int getPoint();
  
  public abstract long getUpdate_point_time();
  
  public abstract void setCampaign(int paramInt);
  
  public abstract void setPoint(int paramInt);
  
  public abstract void setUpdate_point_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Campaign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */