package xbean;

import xdb.Bean;

public abstract interface BuyGiftInfo
  extends Bean
{
  public abstract BuyGiftInfo copy();
  
  public abstract BuyGiftInfo toData();
  
  public abstract BuyGiftInfo toBean();
  
  public abstract BuyGiftInfo toDataIf();
  
  public abstract BuyGiftInfo toBeanIf();
  
  public abstract int getGift_cfg_id();
  
  public abstract int getAleardy_buy_times();
  
  public abstract void setGift_cfg_id(int paramInt);
  
  public abstract void setAleardy_buy_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BuyGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */