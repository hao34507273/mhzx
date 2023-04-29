package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleAvatarSessionInfo
  extends Bean
{
  public abstract RoleAvatarSessionInfo copy();
  
  public abstract RoleAvatarSessionInfo toData();
  
  public abstract RoleAvatarSessionInfo toBean();
  
  public abstract RoleAvatarSessionInfo toDataIf();
  
  public abstract RoleAvatarSessionInfo toBeanIf();
  
  public abstract Map<Integer, Long> get_expire_sessions();
  
  public abstract Map<Integer, Long> get_expire_sessionsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleAvatarSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */