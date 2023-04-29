package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface DiyAppIds
  extends Bean
{
  public abstract DiyAppIds copy();
  
  public abstract DiyAppIds toData();
  
  public abstract DiyAppIds toBean();
  
  public abstract DiyAppIds toDataIf();
  
  public abstract DiyAppIds toBeanIf();
  
  public abstract List<Integer> getApplist();
  
  public abstract List<Integer> getApplistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DiyAppIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */