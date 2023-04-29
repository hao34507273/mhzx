package xbean;

import xdb.Bean;

public abstract interface SingleChildRatingRankInfo
  extends Bean
{
  public abstract SingleChildRatingRankInfo copy();
  
  public abstract SingleChildRatingRankInfo toData();
  
  public abstract SingleChildRatingRankInfo toBean();
  
  public abstract SingleChildRatingRankInfo toDataIf();
  
  public abstract SingleChildRatingRankInfo toBeanIf();
  
  public abstract long getChildid();
  
  public abstract void setChildid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleChildRatingRankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */