package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleAvatarFrameSessionInfo
  extends Bean
{
  public abstract RoleAvatarFrameSessionInfo copy();
  
  public abstract RoleAvatarFrameSessionInfo toData();
  
  public abstract RoleAvatarFrameSessionInfo toBean();
  
  public abstract RoleAvatarFrameSessionInfo toDataIf();
  
  public abstract RoleAvatarFrameSessionInfo toBeanIf();
  
  public abstract Map<Integer, Long> getSessions();
  
  public abstract Map<Integer, Long> getSessionsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleAvatarFrameSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */