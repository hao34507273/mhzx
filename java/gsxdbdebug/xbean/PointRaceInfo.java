package xbean;

import xdb.Bean;

public abstract interface PointRaceInfo
  extends Bean
{
  public abstract PointRaceInfo copy();
  
  public abstract PointRaceInfo toData();
  
  public abstract PointRaceInfo toBean();
  
  public abstract PointRaceInfo toDataIf();
  
  public abstract PointRaceInfo toBeanIf();
  
  public abstract int getWin();
  
  public abstract int getLose();
  
  public abstract int getPoint();
  
  public abstract long getUpdate_time();
  
  public abstract boolean getReported();
  
  public abstract void setWin(int paramInt);
  
  public abstract void setLose(int paramInt);
  
  public abstract void setPoint(int paramInt);
  
  public abstract void setUpdate_time(long paramLong);
  
  public abstract void setReported(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PointRaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */