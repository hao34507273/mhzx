package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GeniusInfo
  extends Bean
{
  public abstract GeniusInfo copy();
  
  public abstract GeniusInfo toData();
  
  public abstract GeniusInfo toBean();
  
  public abstract GeniusInfo toDataIf();
  
  public abstract GeniusInfo toBeanIf();
  
  public abstract Map<Integer, GeniusSeries> getGenius_series();
  
  public abstract Map<Integer, GeniusSeries> getGenius_seriesAsData();
  
  public abstract int getExtra_point();
  
  public abstract void setExtra_point(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GeniusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */