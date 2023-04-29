package mzm.gsp.map.main.worldai.script;

public abstract interface IAIContext
{
  public static final int SCOPE_MAP = 0;
  public static final int SCOPE_WORLD = 1;
  public static final int SCOPE_ALL = 2;
  public static final int CONTROLLER_STATE_ACTIVE = 1;
  public static final int CONTROLLER_STATE_STOP = 0;
  public static final int CONTROLLER_STATE_NOEXIST = -1;
  
  public abstract int getMapParam(int paramInt);
  
  public abstract int getWorldParam(int paramInt);
  
  public abstract int getGlobalParam(int paramInt);
  
  public abstract int getControllerState(int paramInt);
  
  public abstract boolean isNpcExist(int paramInt);
  
  public abstract boolean isMonsterExist(int paramInt);
  
  public abstract int getMonsterNumber(int paramInt);
  
  public abstract void addMapParam(int paramInt1, int paramInt2);
  
  public abstract void addWorldParam(int paramInt1, int paramInt2);
  
  public abstract void addGlobalParam(int paramInt1, int paramInt2);
  
  public abstract void setMapParam(int paramInt1, int paramInt2);
  
  public abstract void setWorldParam(int paramInt1, int paramInt2);
  
  public abstract void setGlobalParam(int paramInt1, int paramInt2);
  
  public abstract void speek(String paramString, int paramInt);
  
  public abstract void setControllerState(int paramInt, boolean paramBoolean);
  
  public abstract boolean createTimer(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean isTimerTrigger(int paramInt);
  
  public abstract void finishScript();
  
  public abstract boolean hasTimer(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\worldai\script\IAIContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */