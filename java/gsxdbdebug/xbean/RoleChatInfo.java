package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleChatInfo
  extends Bean
{
  public abstract RoleChatInfo copy();
  
  public abstract RoleChatInfo toData();
  
  public abstract RoleChatInfo toBean();
  
  public abstract RoleChatInfo toDataIf();
  
  public abstract RoleChatInfo toBeanIf();
  
  public abstract Map<Integer, Long> getChannels();
  
  public abstract Map<Integer, Long> getChannelsAsData();
  
  public abstract Map<Long, ChatDataListBean> getChatinfo();
  
  public abstract Map<Long, ChatDataListBean> getChatinfoAsData();
  
  public abstract Map<Integer, Integer> getChatcfg();
  
  public abstract Map<Integer, Integer> getChatcfgAsData();
  
  public abstract int getChat_room_type();
  
  public abstract int getChat_roomid();
  
  public abstract Map<Integer, Long> getSecretchannels();
  
  public abstract Map<Integer, Long> getSecretchannelsAsData();
  
  public abstract void setChat_room_type(int paramInt);
  
  public abstract void setChat_roomid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleChatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */