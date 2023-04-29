package mzm.gsp.map.main.scene.zone;

import mzm.gsp.map.main.scene.object.MapEntity;
import mzm.gsp.map.main.scene.object.MapMonster;
import mzm.gsp.map.main.scene.object.MapNPC;
import mzm.gsp.map.main.scene.object.MapRole;
import mzm.gsp.map.main.scene.object.SceneObject;

public abstract interface IZone
{
  public abstract void onEnterEntity(MapEntity paramMapEntity);
  
  public abstract void onLeaveEntity(MapEntity paramMapEntity);
  
  public abstract void onEnterMonster(MapMonster paramMapMonster);
  
  public abstract void onLeaveMonster(MapMonster paramMapMonster);
  
  public abstract void onEnterNPC(MapNPC paramMapNPC);
  
  public abstract void onLeaveNPC(MapNPC paramMapNPC);
  
  public abstract void onEnterRole(MapRole paramMapRole);
  
  public abstract void onLeaveRole(MapRole paramMapRole);
  
  public abstract void onMove(SceneObject paramSceneObject);
  
  public abstract boolean enterEntity(MapEntity paramMapEntity);
  
  public abstract boolean leaveEntity(MapEntity paramMapEntity);
  
  public abstract boolean enterRole(MapRole paramMapRole);
  
  public abstract boolean leaveRole(MapRole paramMapRole);
  
  public abstract boolean isEffectOn(SceneObject paramSceneObject);
  
  public abstract boolean intersectsRectangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean containPoint(int paramInt1, int paramInt2);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\IZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */