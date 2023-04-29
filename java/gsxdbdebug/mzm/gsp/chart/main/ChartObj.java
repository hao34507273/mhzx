package mzm.gsp.chart.main;

public abstract class ChartObj<TKey, TChartObj extends ChartObj<TKey, TChartObj>>
  implements ObjWithKey<TKey>
{
  public abstract boolean isAvailable();
  
  public abstract boolean isTopThan(TChartObj paramTChartObj);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\ChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */