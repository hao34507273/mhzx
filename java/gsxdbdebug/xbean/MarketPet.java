package xbean;

import xdb.Bean;

public abstract interface MarketPet
  extends Bean
{
  public abstract MarketPet copy();
  
  public abstract MarketPet toData();
  
  public abstract MarketPet toBean();
  
  public abstract MarketPet toDataIf();
  
  public abstract MarketPet toBeanIf();
  
  public abstract Pet getPet();
  
  public abstract long getRoleid();
  
  public abstract int getPrice();
  
  public abstract int getState();
  
  public abstract long getOnshelf_time();
  
  public abstract int getConcern_role_num();
  
  public abstract long getChannel_id();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setPrice(int paramInt);
  
  public abstract void setState(int paramInt);
  
  public abstract void setOnshelf_time(long paramLong);
  
  public abstract void setConcern_role_num(int paramInt);
  
  public abstract void setChannel_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarketPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */