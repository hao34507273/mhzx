package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface InteractivetaskMap
  extends Bean
{
  public abstract InteractivetaskMap copy();
  
  public abstract InteractivetaskMap toData();
  
  public abstract InteractivetaskMap toBean();
  
  public abstract InteractivetaskMap toDataIf();
  
  public abstract InteractivetaskMap toBeanIf();
  
  public abstract Map<Integer, InteractivetaskInfo> getTypeid2task();
  
  public abstract Map<Integer, InteractivetaskInfo> getTypeid2taskAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\InteractivetaskMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */