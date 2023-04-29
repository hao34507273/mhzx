package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SysSellItem
  extends Bean
{
  public abstract SysSellItem copy();
  
  public abstract SysSellItem toData();
  
  public abstract SysSellItem toBean();
  
  public abstract SysSellItem toDataIf();
  
  public abstract SysSellItem toBeanIf();
  
  public abstract Map<Integer, Integer> getPrice2num();
  
  public abstract Map<Integer, Integer> getPrice2numAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SysSellItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */