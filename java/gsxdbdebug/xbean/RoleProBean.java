package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleProBean
  extends Bean
{
  public abstract RoleProBean copy();
  
  public abstract RoleProBean toData();
  
  public abstract RoleProBean toBean();
  
  public abstract RoleProBean toDataIf();
  
  public abstract RoleProBean toBeanIf();
  
  public abstract Map<Integer, Integer> getPropmap();
  
  public abstract Map<Integer, Integer> getPropmapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleProBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */