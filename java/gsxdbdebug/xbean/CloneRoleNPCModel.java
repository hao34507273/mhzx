package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CloneRoleNPCModel
  extends Bean
{
  public abstract CloneRoleNPCModel copy();
  
  public abstract CloneRoleNPCModel toData();
  
  public abstract CloneRoleNPCModel toBean();
  
  public abstract CloneRoleNPCModel toDataIf();
  
  public abstract CloneRoleNPCModel toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract Map<Integer, String> getString_prop_map();
  
  public abstract Map<Integer, String> getString_prop_mapAsData();
  
  public abstract Map<Integer, Integer> getInt_prop_map();
  
  public abstract Map<Integer, Integer> getInt_prop_mapAsData();
  
  public abstract int getModelid();
  
  public abstract int getColorid();
  
  public abstract Map<Integer, Integer> getModel_info();
  
  public abstract Map<Integer, Integer> getModel_infoAsData();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setModelid(int paramInt);
  
  public abstract void setColorid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CloneRoleNPCModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */