package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GeniusSeries
  extends Bean
{
  public abstract GeniusSeries copy();
  
  public abstract GeniusSeries toData();
  
  public abstract GeniusSeries toBean();
  
  public abstract GeniusSeries toDataIf();
  
  public abstract GeniusSeries toBeanIf();
  
  public abstract Map<Integer, GeniusSeriesInfo> getSeries();
  
  public abstract Map<Integer, GeniusSeriesInfo> getSeriesAsData();
  
  public abstract int getCur_series();
  
  public abstract void setCur_series(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GeniusSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */