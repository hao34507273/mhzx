package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface CrossLadderRankList
  extends Bean
{
  public abstract CrossLadderRankList copy();
  
  public abstract CrossLadderRankList toData();
  
  public abstract CrossLadderRankList toBean();
  
  public abstract CrossLadderRankList toDataIf();
  
  public abstract CrossLadderRankList toBeanIf();
  
  public abstract List<Long> getRank_list();
  
  public abstract List<Long> getRank_listAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossLadderRankList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */