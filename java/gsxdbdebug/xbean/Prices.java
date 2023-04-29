package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Prices
  extends Bean
{
  public abstract Prices copy();
  
  public abstract Prices toData();
  
  public abstract Prices toBean();
  
  public abstract Prices toDataIf();
  
  public abstract Prices toBeanIf();
  
  public abstract Map<Integer, Channels> getPrice2channels();
  
  public abstract Map<Integer, Channels> getPrice2channelsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Prices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */