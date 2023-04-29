package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleBaseProBean
  extends Bean
{
  public abstract RoleBaseProBean copy();
  
  public abstract RoleBaseProBean toData();
  
  public abstract RoleBaseProBean toBean();
  
  public abstract RoleBaseProBean toDataIf();
  
  public abstract RoleBaseProBean toBeanIf();
  
  public abstract Map<Integer, Float> getBase_props();
  
  public abstract Map<Integer, Float> getBase_propsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleBaseProBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */