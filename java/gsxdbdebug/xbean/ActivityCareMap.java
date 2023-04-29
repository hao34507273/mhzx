package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ActivityCareMap
  extends Bean
{
  public abstract ActivityCareMap copy();
  
  public abstract ActivityCareMap toData();
  
  public abstract ActivityCareMap toBean();
  
  public abstract ActivityCareMap toDataIf();
  
  public abstract ActivityCareMap toBeanIf();
  
  public abstract Map<Integer, Integer> getActivitycaremap();
  
  public abstract Map<Integer, Integer> getActivitycaremapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityCareMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */