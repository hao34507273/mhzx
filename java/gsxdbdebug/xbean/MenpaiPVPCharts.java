package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MenpaiPVPCharts
  extends Bean
{
  public abstract MenpaiPVPCharts copy();
  
  public abstract MenpaiPVPCharts toData();
  
  public abstract MenpaiPVPCharts toBean();
  
  public abstract MenpaiPVPCharts toDataIf();
  
  public abstract MenpaiPVPCharts toBeanIf();
  
  public abstract Map<Integer, MenpaiPVPChart> getCharts();
  
  public abstract Map<Integer, MenpaiPVPChart> getChartsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MenpaiPVPCharts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */