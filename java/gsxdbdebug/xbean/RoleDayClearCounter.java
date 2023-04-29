package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleDayClearCounter
  extends Bean
{
  public static final int USE_VIGOR_ITEM = 0;
  
  public abstract RoleDayClearCounter copy();
  
  public abstract RoleDayClearCounter toData();
  
  public abstract RoleDayClearCounter toBean();
  
  public abstract RoleDayClearCounter toDataIf();
  
  public abstract RoleDayClearCounter toBeanIf();
  
  public abstract Map<Integer, Integer> getDatamap();
  
  public abstract Map<Integer, Integer> getDatamapAsData();
  
  public abstract long getTimestamp();
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleDayClearCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */