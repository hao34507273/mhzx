package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface RoleGrcFriendInfo
  extends Bean
{
  public abstract RoleGrcFriendInfo copy();
  
  public abstract RoleGrcFriendInfo toData();
  
  public abstract RoleGrcFriendInfo toBean();
  
  public abstract RoleGrcFriendInfo toDataIf();
  
  public abstract RoleGrcFriendInfo toBeanIf();
  
  public abstract Set<Long> getIds();
  
  public abstract Set<Long> getIdsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGrcFriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */