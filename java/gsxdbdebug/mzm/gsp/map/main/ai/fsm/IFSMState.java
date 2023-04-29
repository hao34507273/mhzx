package mzm.gsp.map.main.ai.fsm;

public abstract interface IFSMState
{
  public abstract void onBegin();
  
  public abstract void onEnd();
  
  public abstract void update(long paramLong);
  
  public abstract IFSMState nextState();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\fsm\IFSMState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */