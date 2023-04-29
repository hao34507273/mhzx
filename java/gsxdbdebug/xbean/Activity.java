package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Activity
  extends Bean
{
  public abstract Activity copy();
  
  public abstract Activity toData();
  
  public abstract Activity toBean();
  
  public abstract Activity toDataIf();
  
  public abstract Activity toBeanIf();
  
  public abstract Map<Integer, ActivityBean> getActivitymap();
  
  public abstract Map<Integer, ActivityBean> getActivitymapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */