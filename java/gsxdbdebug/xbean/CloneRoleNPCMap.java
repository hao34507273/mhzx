package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CloneRoleNPCMap
  extends Bean
{
  public abstract CloneRoleNPCMap copy();
  
  public abstract CloneRoleNPCMap toData();
  
  public abstract CloneRoleNPCMap toBean();
  
  public abstract CloneRoleNPCMap toDataIf();
  
  public abstract CloneRoleNPCMap toBeanIf();
  
  public abstract Map<Integer, CloneRoleNPCModel> getNpc_map();
  
  public abstract Map<Integer, CloneRoleNPCModel> getNpc_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CloneRoleNPCMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */