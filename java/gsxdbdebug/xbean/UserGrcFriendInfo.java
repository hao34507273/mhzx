package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface UserGrcFriendInfo
  extends Bean
{
  public abstract UserGrcFriendInfo copy();
  
  public abstract UserGrcFriendInfo toData();
  
  public abstract UserGrcFriendInfo toBean();
  
  public abstract UserGrcFriendInfo toDataIf();
  
  public abstract UserGrcFriendInfo toBeanIf();
  
  public abstract Map<Integer, RoleGrcFriendInfo> getZone2ids();
  
  public abstract Map<Integer, RoleGrcFriendInfo> getZone2idsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\UserGrcFriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */