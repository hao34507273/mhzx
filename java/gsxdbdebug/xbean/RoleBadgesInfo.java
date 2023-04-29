package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleBadgesInfo
  extends Bean
{
  public abstract RoleBadgesInfo copy();
  
  public abstract RoleBadgesInfo toData();
  
  public abstract RoleBadgesInfo toBean();
  
  public abstract RoleBadgesInfo toDataIf();
  
  public abstract RoleBadgesInfo toBeanIf();
  
  public abstract Map<Integer, BadgeInfo> getBadgesinfo();
  
  public abstract Map<Integer, BadgeInfo> getBadgesinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleBadgesInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */