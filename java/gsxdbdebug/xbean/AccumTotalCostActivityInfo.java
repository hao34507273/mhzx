package xbean;

import xdb.Bean;

public abstract interface AccumTotalCostActivityInfo
  extends Bean
{
  public abstract AccumTotalCostActivityInfo copy();
  
  public abstract AccumTotalCostActivityInfo toData();
  
  public abstract AccumTotalCostActivityInfo toBean();
  
  public abstract AccumTotalCostActivityInfo toDataIf();
  
  public abstract AccumTotalCostActivityInfo toBeanIf();
  
  public abstract long getAccum_total_cost();
  
  public abstract int getSortid();
  
  public abstract void setAccum_total_cost(long paramLong);
  
  public abstract void setSortid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AccumTotalCostActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */