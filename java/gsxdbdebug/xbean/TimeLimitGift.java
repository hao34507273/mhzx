package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface TimeLimitGift
  extends Bean
{
  public abstract TimeLimitGift copy();
  
  public abstract TimeLimitGift toData();
  
  public abstract TimeLimitGift toBean();
  
  public abstract TimeLimitGift toDataIf();
  
  public abstract TimeLimitGift toBeanIf();
  
  public abstract Map<Integer, Giftid2count> getActivityid2giftids();
  
  public abstract Map<Integer, Giftid2count> getActivityid2giftidsAsData();
  
  public abstract boolean getIssendmail();
  
  public abstract void setIssendmail(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TimeLimitGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */