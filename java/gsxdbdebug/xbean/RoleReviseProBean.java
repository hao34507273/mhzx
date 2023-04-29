package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleReviseProBean
  extends Bean
{
  public abstract RoleReviseProBean copy();
  
  public abstract RoleReviseProBean toData();
  
  public abstract RoleReviseProBean toBean();
  
  public abstract RoleReviseProBean toDataIf();
  
  public abstract RoleReviseProBean toBeanIf();
  
  public abstract Map<Integer, RoleBaseProBean> getProps();
  
  public abstract Map<Integer, RoleBaseProBean> getPropsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleReviseProBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */