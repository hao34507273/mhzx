package xbean;

import xdb.Bean;

public abstract interface MarketItem
  extends Bean
{
  public abstract MarketItem copy();
  
  public abstract MarketItem toData();
  
  public abstract MarketItem toBean();
  
  public abstract MarketItem toDataIf();
  
  public abstract MarketItem toBeanIf();
  
  public abstract int getRest_num();
  
  public abstract Item getItem();
  
  public abstract long getRoleid();
  
  public abstract int getPrice();
  
  public abstract int getState();
  
  public abstract long getOnshelf_time();
  
  public abstract int getConcern_role_num();
  
  public abstract long getChannel_id();
  
  public abstract void setRest_num(int paramInt);
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setPrice(int paramInt);
  
  public abstract void setState(int paramInt);
  
  public abstract void setOnshelf_time(long paramLong);
  
  public abstract void setConcern_role_num(int paramInt);
  
  public abstract void setChannel_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarketItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */