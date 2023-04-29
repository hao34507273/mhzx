package mzm.gsp.map.main.controller;

public abstract interface ControllerListener
{
  public abstract boolean isCallInProcedure();
  
  public abstract void onSpawn(ControllerContext paramControllerContext);
  
  public abstract void onDestroy(ControllerContext paramControllerContext);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\controller\ControllerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */