package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleAvatarFrame
  extends Bean
{
  public abstract RoleAvatarFrame copy();
  
  public abstract RoleAvatarFrame toData();
  
  public abstract RoleAvatarFrame toBean();
  
  public abstract RoleAvatarFrame toDataIf();
  
  public abstract RoleAvatarFrame toBeanIf();
  
  public abstract int getCurrent_avatar_frame();
  
  public abstract Map<Integer, Integer> getAvatar_frames();
  
  public abstract Map<Integer, Integer> getAvatar_framesAsData();
  
  public abstract void setCurrent_avatar_frame(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleAvatarFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */