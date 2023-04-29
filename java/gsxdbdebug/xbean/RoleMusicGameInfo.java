package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleMusicGameInfo
  extends Bean
{
  public abstract RoleMusicGameInfo copy();
  
  public abstract RoleMusicGameInfo toData();
  
  public abstract RoleMusicGameInfo toBean();
  
  public abstract RoleMusicGameInfo toDataIf();
  
  public abstract RoleMusicGameInfo toBeanIf();
  
  public abstract Map<Integer, MusicGameInfo> getMusic_game_infos();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleMusicGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */