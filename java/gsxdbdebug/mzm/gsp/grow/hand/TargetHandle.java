package mzm.gsp.grow.hand;

public abstract interface TargetHandle
{
  public abstract boolean isGoalValid(long paramLong, int paramInt);
  
  public abstract void setParam(long paramLong, int paramInt1, int paramInt2);
  
  public abstract int getParam(long paramLong, int paramInt);
  
  public abstract boolean onCanFinishTarget(long paramLong, int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\hand\TargetHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */