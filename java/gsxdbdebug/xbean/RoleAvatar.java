package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleAvatar
  extends Bean
{
  public static final int UNLOCKED = 0;
  public static final int EXPIRED = 1;
  
  public abstract RoleAvatar copy();
  
  public abstract RoleAvatar toData();
  
  public abstract RoleAvatar toBean();
  
  public abstract RoleAvatar toDataIf();
  
  public abstract RoleAvatar toBeanIf();
  
  public abstract int get_current_avatar();
  
  public abstract int get_active_avatar();
  
  public abstract Map<Integer, Integer> get_avatars();
  
  public abstract Map<Integer, Integer> get_avatarsAsData();
  
  public abstract void set_current_avatar(int paramInt);
  
  public abstract void set_active_avatar(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */