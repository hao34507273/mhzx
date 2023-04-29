package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface WantedInfo
  extends Bean
{
  public abstract WantedInfo copy();
  
  public abstract WantedInfo toData();
  
  public abstract WantedInfo toBean();
  
  public abstract WantedInfo toDataIf();
  
  public abstract WantedInfo toBeanIf();
  
  public abstract Map<Long, Integer> getRoleid2count();
  
  public abstract Map<Long, Integer> getRoleid2countAsData();
  
  public abstract int getNpcfightcount();
  
  public abstract long getStarttimestamp();
  
  public abstract long getSessionid();
  
  public abstract void setNpcfightcount(int paramInt);
  
  public abstract void setStarttimestamp(long paramLong);
  
  public abstract void setSessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WantedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */