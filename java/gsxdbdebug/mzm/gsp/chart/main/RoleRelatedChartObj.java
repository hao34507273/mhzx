package mzm.gsp.chart.main;

public abstract class RoleRelatedChartObj<TKey, TChartObj extends RoleRelatedChartObj<TKey, TChartObj>>
  extends ChartObj<TKey, TChartObj>
  implements ObjWithKey<TKey>
{
  public abstract long getRoleid();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\RoleRelatedChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */