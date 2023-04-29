package xbean;

import xdb.Bean;

public abstract interface TimeLimitGiftP2PInfo
  extends Bean
{
  public abstract TimeLimitGiftP2PInfo copy();
  
  public abstract TimeLimitGiftP2PInfo toData();
  
  public abstract TimeLimitGiftP2PInfo toBean();
  
  public abstract TimeLimitGiftP2PInfo toDataIf();
  
  public abstract TimeLimitGiftP2PInfo toBeanIf();
  
  public abstract int getGift_count();
  
  public abstract void setGift_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TimeLimitGiftP2PInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */