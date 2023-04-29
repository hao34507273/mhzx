package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface VoteInfo
  extends Bean
{
  public abstract VoteInfo copy();
  
  public abstract VoteInfo toData();
  
  public abstract VoteInfo toBean();
  
  public abstract VoteInfo toDataIf();
  
  public abstract VoteInfo toBeanIf();
  
  public abstract Map<Integer, VoteDatas> getActivityid2votedata();
  
  public abstract Map<Integer, VoteDatas> getActivityid2votedataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\VoteInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */