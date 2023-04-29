package xbean;

import java.util.List;
import java.util.Set;
import xdb.Bean;

public abstract interface LadderRankBackUp
  extends Bean
{
  public abstract LadderRankBackUp copy();
  
  public abstract LadderRankBackUp toData();
  
  public abstract LadderRankBackUp toBean();
  
  public abstract LadderRankBackUp toDataIf();
  
  public abstract LadderRankBackUp toBeanIf();
  
  public abstract List<LadderRankRole> getRanklist();
  
  public abstract List<LadderRankRole> getRanklistAsData();
  
  public abstract long getBackuptime();
  
  public abstract Set<Long> getRemoteawardroles();
  
  public abstract Set<Long> getRemoteawardrolesAsData();
  
  public abstract void setBackuptime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LadderRankBackUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */