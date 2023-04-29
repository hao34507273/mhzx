package xbean;

import xdb.Bean;

public abstract interface ChatBubbleInfo
  extends Bean
{
  public abstract ChatBubbleInfo copy();
  
  public abstract ChatBubbleInfo toData();
  
  public abstract ChatBubbleInfo toBean();
  
  public abstract ChatBubbleInfo toDataIf();
  
  public abstract ChatBubbleInfo toBeanIf();
  
  public abstract long getExpiretimestamp();
  
  public abstract long getSessionid();
  
  public abstract void setExpiretimestamp(long paramLong);
  
  public abstract void setSessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChatBubbleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */