package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MenPaiStarChart
  extends Bean
{
  public abstract MenPaiStarChart copy();
  
  public abstract MenPaiStarChart toData();
  
  public abstract MenPaiStarChart toBean();
  
  public abstract MenPaiStarChart toDataIf();
  
  public abstract MenPaiStarChart toBeanIf();
  
  public abstract Map<Integer, MenPaiStarChartInfo> getCharts();
  
  public abstract Map<Integer, MenPaiStarChartInfo> getChartsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MenPaiStarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */