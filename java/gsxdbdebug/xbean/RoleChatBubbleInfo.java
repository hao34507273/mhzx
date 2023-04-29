package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleChatBubbleInfo
  extends Bean
{
  public abstract RoleChatBubbleInfo copy();
  
  public abstract RoleChatBubbleInfo toData();
  
  public abstract RoleChatBubbleInfo toBean();
  
  public abstract RoleChatBubbleInfo toDataIf();
  
  public abstract RoleChatBubbleInfo toBeanIf();
  
  public abstract int getCurchatbubblecfgid();
  
  public abstract Map<Integer, ChatBubbleInfo> getCfgid2info();
  
  public abstract Map<Integer, ChatBubbleInfo> getCfgid2infoAsData();
  
  public abstract void setCurchatbubblecfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleChatBubbleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */