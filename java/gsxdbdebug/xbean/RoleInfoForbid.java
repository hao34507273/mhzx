package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleInfoForbid
  extends Bean
{
  public abstract RoleInfoForbid copy();
  
  public abstract RoleInfoForbid toData();
  
  public abstract RoleInfoForbid toBean();
  
  public abstract RoleInfoForbid toDataIf();
  
  public abstract RoleInfoForbid toBeanIf();
  
  public abstract Map<Integer, IdipForbidInfo> getForbids();
  
  public abstract Map<Integer, IdipForbidInfo> getForbidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleInfoForbid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */