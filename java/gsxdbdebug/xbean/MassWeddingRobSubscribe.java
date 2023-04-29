package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MassWeddingRobSubscribe
  extends Bean
{
  public abstract MassWeddingRobSubscribe copy();
  
  public abstract MassWeddingRobSubscribe toData();
  
  public abstract MassWeddingRobSubscribe toBean();
  
  public abstract MassWeddingRobSubscribe toDataIf();
  
  public abstract MassWeddingRobSubscribe toBeanIf();
  
  public abstract Map<Long, MassWeddingRobSubscribeRoles> getRobsubscribemap();
  
  public abstract Map<Long, MassWeddingRobSubscribeRoles> getRobsubscribemapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassWeddingRobSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */