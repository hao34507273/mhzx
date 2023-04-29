package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface HomelandRankList
  extends Bean
{
  public abstract HomelandRankList copy();
  
  public abstract HomelandRankList toData();
  
  public abstract HomelandRankList toBean();
  
  public abstract HomelandRankList toDataIf();
  
  public abstract HomelandRankList toBeanIf();
  
  public abstract List<Long> getRanklist();
  
  public abstract List<Long> getRanklistAsData();
  
  public abstract long getAwardtime();
  
  public abstract void setAwardtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HomelandRankList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */