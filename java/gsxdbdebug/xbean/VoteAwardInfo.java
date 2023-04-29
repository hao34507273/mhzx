package xbean;

import xdb.Bean;

public abstract interface VoteAwardInfo
  extends Bean
{
  public abstract VoteAwardInfo copy();
  
  public abstract VoteAwardInfo toData();
  
  public abstract VoteAwardInfo toBean();
  
  public abstract VoteAwardInfo toDataIf();
  
  public abstract VoteAwardInfo toBeanIf();
  
  public abstract int getAward();
  
  public abstract int getNum();
  
  public abstract long getLast_time();
  
  public abstract void setAward(int paramInt);
  
  public abstract void setNum(int paramInt);
  
  public abstract void setLast_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\VoteAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */