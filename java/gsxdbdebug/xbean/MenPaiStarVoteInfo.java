package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MenPaiStarVoteInfo
  extends Bean
{
  public abstract MenPaiStarVoteInfo copy();
  
  public abstract MenPaiStarVoteInfo toData();
  
  public abstract MenPaiStarVoteInfo toBean();
  
  public abstract MenPaiStarVoteInfo toDataIf();
  
  public abstract MenPaiStarVoteInfo toBeanIf();
  
  public abstract int getVote();
  
  public abstract int getToday_vote_num();
  
  public abstract long getLast_vote_time();
  
  public abstract int getVote_num();
  
  public abstract Map<Long, Long> getWorld_canvass();
  
  public abstract Map<Long, Long> getWorld_canvassAsData();
  
  public abstract Map<Long, Long> getGang_canvass();
  
  public abstract Map<Long, Long> getGang_canvassAsData();
  
  public abstract void setVote(int paramInt);
  
  public abstract void setToday_vote_num(int paramInt);
  
  public abstract void setLast_vote_time(long paramLong);
  
  public abstract void setVote_num(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MenPaiStarVoteInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */