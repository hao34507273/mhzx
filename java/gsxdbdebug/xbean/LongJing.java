package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LongJing
  extends Bean
{
  public abstract LongJing copy();
  
  public abstract LongJing toData();
  
  public abstract LongJing toBean();
  
  public abstract LongJing toDataIf();
  
  public abstract LongJing toBeanIf();
  
  public abstract Map<Integer, Item> getLongjingitems();
  
  public abstract Map<Integer, Item> getLongjingitemsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LongJing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */