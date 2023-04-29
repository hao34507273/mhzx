package mzm.gsp.map.main.ai;

import mzm.gsp.map.main.scene.Position;

public abstract interface IMapAIObject
{
  public abstract void stay(long paramLong);
  
  public abstract long getStayTime();
  
  public abstract int tryStartFight();
  
  public abstract boolean isStartFightSuccess();
  
  public abstract void onMove();
  
  public abstract int getVelocity();
  
  public abstract Position getPosition();
  
  public abstract Position getTargetPos();
  
  public abstract void setXYZ(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void setTargetPos(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\IMapAIObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */