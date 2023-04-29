package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleBubbleGameInfo
  extends Bean
{
  public abstract RoleBubbleGameInfo copy();
  
  public abstract RoleBubbleGameInfo toData();
  
  public abstract RoleBubbleGameInfo toBean();
  
  public abstract RoleBubbleGameInfo toDataIf();
  
  public abstract RoleBubbleGameInfo toBeanIf();
  
  public abstract Map<Integer, BubbleGameInfo> getBubble_game_infos();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleBubbleGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */