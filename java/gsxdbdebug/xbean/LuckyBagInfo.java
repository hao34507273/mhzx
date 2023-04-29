package xbean;

import xdb.Bean;

public abstract interface LuckyBagInfo
  extends Bean
{
  public abstract LuckyBagInfo copy();
  
  public abstract LuckyBagInfo toData();
  
  public abstract LuckyBagInfo toBean();
  
  public abstract LuckyBagInfo toDataIf();
  
  public abstract LuckyBagInfo toBeanIf();
  
  public abstract int getScore();
  
  public abstract void setScore(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LuckyBagInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */