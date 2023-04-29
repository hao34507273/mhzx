package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface VoteDatas
  extends Bean
{
  public abstract VoteDatas copy();
  
  public abstract VoteDatas toData();
  
  public abstract VoteDatas toBean();
  
  public abstract VoteDatas toDataIf();
  
  public abstract VoteDatas toBeanIf();
  
  public abstract List<VoteData> getVotedinfos();
  
  public abstract List<VoteData> getVotedinfosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\VoteDatas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */