package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RolePrivilegeInfo
  extends Bean
{
  public abstract RolePrivilegeInfo copy();
  
  public abstract RolePrivilegeInfo toData();
  
  public abstract RolePrivilegeInfo toBean();
  
  public abstract RolePrivilegeInfo toDataIf();
  
  public abstract RolePrivilegeInfo toBeanIf();
  
  public abstract Map<Integer, PrivilegeAwardInfo> getFreshman_award_infos();
  
  public abstract Map<Integer, PrivilegeAwardInfo> getFreshman_award_infosAsData();
  
  public abstract Map<Integer, PrivilegeAwardInfo> getLogin_award_infos();
  
  public abstract Map<Integer, PrivilegeAwardInfo> getLogin_award_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolePrivilegeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */