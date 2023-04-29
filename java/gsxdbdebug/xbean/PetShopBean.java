package xbean;

import xdb.Bean;

public abstract interface PetShopBean
  extends Bean
{
  public abstract PetShopBean copy();
  
  public abstract PetShopBean toData();
  
  public abstract PetShopBean toBean();
  
  public abstract PetShopBean toDataIf();
  
  public abstract PetShopBean toBeanIf();
  
  public abstract int getSellcount();
  
  public abstract long getTimestamp();
  
  public abstract void setSellcount(int paramInt);
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetShopBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */