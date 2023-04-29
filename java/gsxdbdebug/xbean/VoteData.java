package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface VoteData
  extends Bean
{
  public abstract VoteData copy();
  
  public abstract VoteData toData();
  
  public abstract VoteData toBean();
  
  public abstract VoteData toDataIf();
  
  public abstract VoteData toBeanIf();
  
  public abstract Set<Integer> getVotedids();
  
  public abstract Set<Integer> getVotedidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\VoteData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */