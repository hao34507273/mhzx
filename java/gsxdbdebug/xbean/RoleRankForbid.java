package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleRankForbid
  extends Bean
{
  public abstract RoleRankForbid copy();
  
  public abstract RoleRankForbid toData();
  
  public abstract RoleRankForbid toBean();
  
  public abstract RoleRankForbid toDataIf();
  
  public abstract RoleRankForbid toBeanIf();
  
  public abstract Map<Integer, IdipForbidInfo> getForbids();
  
  public abstract Map<Integer, IdipForbidInfo> getForbidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleRankForbid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */