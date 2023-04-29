package mzm.gsp.map.main.scene.zone.type.event;

import mzm.gsp.map.main.scene.zone.ZoneForm;

public abstract interface IZoneListener
{
  public abstract void onEnterRole(long paramLong, ZoneForm paramZoneForm);
  
  public abstract void onLeaveRole(long paramLong, ZoneForm paramZoneForm);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\type\event\IZoneListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */