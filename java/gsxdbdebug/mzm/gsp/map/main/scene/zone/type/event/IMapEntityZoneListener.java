package mzm.gsp.map.main.scene.zone.type.event;

import mzm.gsp.map.main.scene.object.MapEntityType;
import mzm.gsp.map.main.scene.zone.ZoneForm;

public abstract interface IMapEntityZoneListener
{
  public abstract void onEnterMapEntity(MapEntityType paramMapEntityType, long paramLong, ZoneForm paramZoneForm);
  
  public abstract void onLeaveMapEntity(MapEntityType paramMapEntityType, long paramLong, ZoneForm paramZoneForm);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\type\event\IMapEntityZoneListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */