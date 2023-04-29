package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface Active
  extends Bean
{
  public abstract Active copy();
  
  public abstract Active toData();
  
  public abstract Active toBean();
  
  public abstract Active toDataIf();
  
  public abstract Active toBeanIf();
  
  public abstract Map<Integer, Integer> getActivitymap();
  
  public abstract Map<Integer, Integer> getActivitymapAsData();
  
  public abstract Set<Integer> getAwardcfgids();
  
  public abstract Set<Integer> getAwardcfgidsAsData();
  
  public abstract long getResettime();
  
  public abstract Set<Integer> getAward_index_id_set();
  
  public abstract Set<Integer> getAward_index_id_setAsData();
  
  public abstract void setResettime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Active.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */