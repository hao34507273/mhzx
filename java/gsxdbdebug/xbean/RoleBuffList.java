package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleBuffList
  extends Bean
{
  public abstract RoleBuffList copy();
  
  public abstract RoleBuffList toData();
  
  public abstract RoleBuffList toBean();
  
  public abstract RoleBuffList toDataIf();
  
  public abstract RoleBuffList toBeanIf();
  
  public abstract Map<Integer, RoleBuff> getBuffmap();
  
  public abstract Map<Integer, RoleBuff> getBuffmapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleBuffList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */