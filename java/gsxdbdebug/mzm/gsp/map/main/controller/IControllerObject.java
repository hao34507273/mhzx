package mzm.gsp.map.main.controller;

import java.util.List;
import mzm.gsp.map.main.scene.object.SceneObject;

public abstract interface IControllerObject
{
  public abstract List<? extends SceneObject> refresh(long paramLong, int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\controller\IControllerObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */