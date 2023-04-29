package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MassWeddingRob
  extends Bean
{
  public abstract MassWeddingRob copy();
  
  public abstract MassWeddingRob toData();
  
  public abstract MassWeddingRob toBean();
  
  public abstract MassWeddingRob toDataIf();
  
  public abstract MassWeddingRob toBeanIf();
  
  public abstract Map<Long, MassWeddingRobRoles> getRobmap();
  
  public abstract Map<Long, MassWeddingRobRoles> getRobmapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassWeddingRob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */