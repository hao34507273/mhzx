package xbean;

import xdb.Bean;

public abstract interface EachMoneyDayCostData
  extends Bean
{
  public abstract EachMoneyDayCostData copy();
  
  public abstract EachMoneyDayCostData toData();
  
  public abstract EachMoneyDayCostData toBean();
  
  public abstract EachMoneyDayCostData toDataIf();
  
  public abstract EachMoneyDayCostData toBeanIf();
  
  public abstract long getTotalcost();
  
  public abstract void setTotalcost(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\EachMoneyDayCostData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */