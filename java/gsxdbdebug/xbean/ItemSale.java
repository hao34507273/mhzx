package xbean;

import xdb.Bean;

public abstract interface ItemSale
  extends Bean
{
  public abstract ItemSale copy();
  
  public abstract ItemSale toData();
  
  public abstract ItemSale toBean();
  
  public abstract ItemSale toDataIf();
  
  public abstract ItemSale toBeanIf();
  
  public abstract long getTotalsellnum();
  
  public abstract long getTotalsellmoney();
  
  public abstract int getRecommendprice();
  
  public abstract int getTotalgridnum();
  
  public abstract void setTotalsellnum(long paramLong);
  
  public abstract void setTotalsellmoney(long paramLong);
  
  public abstract void setRecommendprice(int paramInt);
  
  public abstract void setTotalgridnum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ItemSale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */