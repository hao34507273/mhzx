package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface TimeLimitGiftInfo
  extends Bean
{
  public abstract TimeLimitGiftInfo copy();
  
  public abstract TimeLimitGiftInfo toData();
  
  public abstract TimeLimitGiftInfo toBean();
  
  public abstract TimeLimitGiftInfo toDataIf();
  
  public abstract TimeLimitGiftInfo toBeanIf();
  
  public abstract int getReceive_count();
  
  public abstract int getSend_count();
  
  public abstract Map<Long, TimeLimitGiftP2PInfo> getReceiver_info();
  
  public abstract Map<Long, TimeLimitGiftP2PInfo> getReceiver_infoAsData();
  
  public abstract void setReceive_count(int paramInt);
  
  public abstract void setSend_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TimeLimitGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */