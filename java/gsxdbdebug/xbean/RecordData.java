package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RecordData
  extends Bean
{
  public abstract RecordData copy();
  
  public abstract RecordData toData();
  
  public abstract RecordData toBean();
  
  public abstract RecordData toDataIf();
  
  public abstract RecordData toBeanIf();
  
  public abstract Map<Long, RoleRankData> getRankdatas();
  
  public abstract Map<Long, RoleRankData> getRankdatasAsData();
  
  public abstract long getLastlogtime();
  
  public abstract void setLastlogtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RecordData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */