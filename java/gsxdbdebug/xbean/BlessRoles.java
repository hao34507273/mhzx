package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface BlessRoles
  extends Bean
{
  public abstract BlessRoles copy();
  
  public abstract BlessRoles toData();
  
  public abstract BlessRoles toBean();
  
  public abstract BlessRoles toDataIf();
  
  public abstract BlessRoles toBeanIf();
  
  public abstract Set<Long> getBlessroles();
  
  public abstract Set<Long> getBlessrolesAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BlessRoles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */