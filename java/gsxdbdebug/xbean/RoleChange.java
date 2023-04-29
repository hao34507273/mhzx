package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RoleChange
  extends Bean
{
  public abstract RoleChange copy();
  
  public abstract RoleChange toData();
  
  public abstract RoleChange toBean();
  
  public abstract RoleChange toDataIf();
  
  public abstract RoleChange toBeanIf();
  
  public abstract List<Integer> getChangeids();
  
  public abstract List<Integer> getChangeidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */