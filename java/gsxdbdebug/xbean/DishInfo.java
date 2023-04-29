package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface DishInfo
  extends Bean
{
  public abstract DishInfo copy();
  
  public abstract DishInfo toData();
  
  public abstract DishInfo toBean();
  
  public abstract DishInfo toDataIf();
  
  public abstract DishInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getOnedishown();
  
  public abstract Map<Integer, Integer> getOnedishownAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DishInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */