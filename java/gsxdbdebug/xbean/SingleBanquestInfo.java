package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SingleBanquestInfo
  extends Bean
{
  public abstract SingleBanquestInfo copy();
  
  public abstract SingleBanquestInfo toData();
  
  public abstract SingleBanquestInfo toBean();
  
  public abstract SingleBanquestInfo toDataIf();
  
  public abstract SingleBanquestInfo toBeanIf();
  
  public abstract Map<Integer, DishInfo> getOwnmapitems();
  
  public abstract Map<Integer, DishInfo> getOwnmapitemsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleBanquestInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */