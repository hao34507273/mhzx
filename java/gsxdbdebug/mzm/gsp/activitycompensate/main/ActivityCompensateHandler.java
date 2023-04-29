package mzm.gsp.activitycompensate.main;

import java.util.List;

public abstract interface ActivityCompensateHandler
{
  public abstract List<Integer> getActivitySwitchList(int paramInt);
  
  public abstract int getCompensateAwardTimes(long paramLong, int paramInt1, int paramInt2);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\ActivityCompensateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */