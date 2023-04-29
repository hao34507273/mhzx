package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SingleRecord
  extends Bean
{
  public abstract SingleRecord copy();
  
  public abstract SingleRecord toData();
  
  public abstract SingleRecord toBean();
  
  public abstract SingleRecord toDataIf();
  
  public abstract SingleRecord toBeanIf();
  
  public abstract Map<Long, Integer> getDead2count();
  
  public abstract Map<Long, Integer> getDead2countAsData();
  
  public abstract Map<Long, Integer> getKiller2count();
  
  public abstract Map<Long, Integer> getKiller2countAsData();
  
  public abstract long getRevivetime();
  
  public abstract void setRevivetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */