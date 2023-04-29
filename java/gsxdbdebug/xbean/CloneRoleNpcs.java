package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CloneRoleNpcs
  extends Bean
{
  public abstract CloneRoleNpcs copy();
  
  public abstract CloneRoleNpcs toData();
  
  public abstract CloneRoleNpcs toBean();
  
  public abstract CloneRoleNpcs toDataIf();
  
  public abstract CloneRoleNpcs toBeanIf();
  
  public abstract Map<Integer, Long> getNpc_map();
  
  public abstract Map<Integer, Long> getNpc_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CloneRoleNpcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */