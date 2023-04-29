package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface RedgiftRoleidSet
  extends Bean
{
  public abstract RedgiftRoleidSet copy();
  
  public abstract RedgiftRoleidSet toData();
  
  public abstract RedgiftRoleidSet toBean();
  
  public abstract RedgiftRoleidSet toDataIf();
  
  public abstract RedgiftRoleidSet toBeanIf();
  
  public abstract Set<Long> getRoleidset();
  
  public abstract Set<Long> getRoleidsetAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RedgiftRoleidSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */