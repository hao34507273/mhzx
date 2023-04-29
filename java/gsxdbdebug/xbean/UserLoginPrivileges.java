package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface UserLoginPrivileges
  extends Bean
{
  public abstract UserLoginPrivileges copy();
  
  public abstract UserLoginPrivileges toData();
  
  public abstract UserLoginPrivileges toBean();
  
  public abstract UserLoginPrivileges toDataIf();
  
  public abstract UserLoginPrivileges toBeanIf();
  
  public abstract Map<Integer, UserLoginPrivilegeInfo> getPrivileges();
  
  public abstract Map<Integer, UserLoginPrivilegeInfo> getPrivilegesAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\UserLoginPrivileges.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */