package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MarketLog
  extends Bean
{
  public abstract MarketLog copy();
  
  public abstract MarketLog toData();
  
  public abstract MarketLog toBean();
  
  public abstract MarketLog toDataIf();
  
  public abstract MarketLog toBeanIf();
  
  public abstract List<SaleLog> getSelllog();
  
  public abstract List<SaleLog> getSelllogAsData();
  
  public abstract List<SaleLog> getBuylog();
  
  public abstract List<SaleLog> getBuylogAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarketLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */