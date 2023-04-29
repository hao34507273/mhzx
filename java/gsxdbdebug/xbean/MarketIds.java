package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MarketIds
  extends Bean
{
  public abstract MarketIds copy();
  
  public abstract MarketIds toData();
  
  public abstract MarketIds toBean();
  
  public abstract MarketIds toDataIf();
  
  public abstract MarketIds toBeanIf();
  
  public abstract List<Long> getMarket_ids();
  
  public abstract List<Long> getMarket_idsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarketIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */