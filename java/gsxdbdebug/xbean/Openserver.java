package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Openserver
  extends Bean
{
  public abstract Openserver copy();
  
  public abstract Openserver toData();
  
  public abstract Openserver toBean();
  
  public abstract Openserver toDataIf();
  
  public abstract Openserver toBeanIf();
  
  public abstract List<Integer> getAwardeddays();
  
  public abstract List<Integer> getAwardeddaysAsData();
  
  public abstract long getSigntime();
  
  public abstract void setSigntime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Openserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */