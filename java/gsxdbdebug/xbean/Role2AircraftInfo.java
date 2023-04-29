package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Role2AircraftInfo
  extends Bean
{
  public abstract Role2AircraftInfo copy();
  
  public abstract Role2AircraftInfo toData();
  
  public abstract Role2AircraftInfo toBean();
  
  public abstract Role2AircraftInfo toDataIf();
  
  public abstract Role2AircraftInfo toBeanIf();
  
  public abstract Map<Integer, AircraftInfo> getOwn_aircraft_map();
  
  public abstract Map<Integer, AircraftInfo> getOwn_aircraft_mapAsData();
  
  public abstract int getCurrent_aircraft_cfg_id();
  
  public abstract void setCurrent_aircraft_cfg_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2AircraftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */