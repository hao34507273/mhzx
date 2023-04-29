package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RolePlayForbid
  extends Bean
{
  public abstract RolePlayForbid copy();
  
  public abstract RolePlayForbid toData();
  
  public abstract RolePlayForbid toBean();
  
  public abstract RolePlayForbid toDataIf();
  
  public abstract RolePlayForbid toBeanIf();
  
  public abstract Map<Integer, IdipForbidInfo> getForbids();
  
  public abstract Map<Integer, IdipForbidInfo> getForbidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolePlayForbid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */