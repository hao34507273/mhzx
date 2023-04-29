package xbean;

import java.util.List;
import java.util.Set;
import xdb.Bean;

public abstract interface InteractivetaskInfo
  extends Bean
{
  public abstract InteractivetaskInfo copy();
  
  public abstract InteractivetaskInfo toData();
  
  public abstract InteractivetaskInfo toBean();
  
  public abstract InteractivetaskInfo toDataIf();
  
  public abstract InteractivetaskInfo toBeanIf();
  
  public abstract long getWorldid();
  
  public abstract List<Integer> getFinished_graphids();
  
  public abstract List<Integer> getFinished_graphidsAsData();
  
  public abstract int getCurrent_graphid();
  
  public abstract Set<Long> getRoleids();
  
  public abstract Set<Long> getRoleidsAsData();
  
  public abstract long getCommander_roleid();
  
  public abstract long getSessionid();
  
  public abstract void setWorldid(long paramLong);
  
  public abstract void setCurrent_graphid(int paramInt);
  
  public abstract void setCommander_roleid(long paramLong);
  
  public abstract void setSessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\InteractivetaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */