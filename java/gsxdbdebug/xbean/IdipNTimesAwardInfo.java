package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface IdipNTimesAwardInfo
  extends Bean
{
  public abstract IdipNTimesAwardInfo copy();
  
  public abstract IdipNTimesAwardInfo toData();
  
  public abstract IdipNTimesAwardInfo toBean();
  
  public abstract IdipNTimesAwardInfo toDataIf();
  
  public abstract IdipNTimesAwardInfo toBeanIf();
  
  public abstract long getStart_time();
  
  public abstract long getExpire_time();
  
  public abstract int getN_times();
  
  public abstract Set<Integer> getValid_zone_id_set();
  
  public abstract Set<Integer> getValid_zone_id_setAsData();
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setExpire_time(long paramLong);
  
  public abstract void setN_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IdipNTimesAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */