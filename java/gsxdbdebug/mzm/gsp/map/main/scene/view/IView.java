package mzm.gsp.map.main.scene.view;

import java.util.Collection;
import java.util.Set;
import mzm.gsp.map.main.scene.object.MapRole;
import mzm.gsp.map.main.scene.object.SceneObject;

public abstract interface IView
{
  public abstract int test(SceneObject paramSceneObject);
  
  public abstract SceneObject getOwner();
  
  public abstract int getRadius();
  
  public abstract boolean validateView();
  
  public abstract void setDelegate(IView paramIView);
  
  public abstract void deleteDelegate(boolean paramBoolean);
  
  public abstract boolean isBeDelegated();
  
  public abstract boolean isBeDelegated(IView paramIView);
  
  public abstract Collection<MapRole> getPlayers();
  
  public abstract Collection<SceneObject> getSceneObjects();
  
  public abstract int onEnter(SceneObject paramSceneObject, boolean paramBoolean);
  
  public abstract int onMove(SceneObject paramSceneObject, boolean paramBoolean);
  
  public abstract int onLeave(SceneObject paramSceneObject, boolean paramBoolean);
  
  public abstract void clearView();
  
  public abstract int inActiveEnter(SceneObject paramSceneObject, boolean paramBoolean);
  
  public abstract int inActiveLeave(SceneObject paramSceneObject, boolean paramBoolean);
  
  public abstract void addDelgateObject(SceneObject paramSceneObject);
  
  public abstract Set<SceneObject> getDelegateObjects();
  
  public abstract void removeDelegateObject(SceneObject paramSceneObject);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\view\IView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */