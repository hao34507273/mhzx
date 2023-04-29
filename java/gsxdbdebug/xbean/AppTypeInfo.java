package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface AppTypeInfo
  extends Bean
{
  public abstract AppTypeInfo copy();
  
  public abstract AppTypeInfo toData();
  
  public abstract AppTypeInfo toBean();
  
  public abstract AppTypeInfo toDataIf();
  
  public abstract AppTypeInfo toBeanIf();
  
  public abstract Map<Integer, DiyAppIds> getApptypemap();
  
  public abstract Map<Integer, DiyAppIds> getApptypemapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AppTypeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */