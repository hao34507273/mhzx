package mzm.gsp.visiblemonsterfight.main;

import mzm.gsp.activity.main.ActivityHandler;

public abstract interface IMonsterDeadHandle
  extends ActivityHandler
{
  public abstract void init();
  
  public abstract boolean handleMonsterDead(VisibleMonsterFightContext paramVisibleMonsterFightContext);
  
  public abstract boolean handleMonsterWin(VisibleMonsterFightContext paramVisibleMonsterFightContext);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\IMonsterDeadHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */