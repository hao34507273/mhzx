package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ChatGiftRoleGetInfo
  extends Bean
{
  public abstract ChatGiftRoleGetInfo copy();
  
  public abstract ChatGiftRoleGetInfo toData();
  
  public abstract ChatGiftRoleGetInfo toBean();
  
  public abstract ChatGiftRoleGetInfo toDataIf();
  
  public abstract ChatGiftRoleGetInfo toBeanIf();
  
  public abstract Map<Integer, ChatGiftTimeList> getChatgiftrolegetinfo();
  
  public abstract Map<Integer, ChatGiftTimeList> getChatgiftrolegetinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChatGiftRoleGetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */