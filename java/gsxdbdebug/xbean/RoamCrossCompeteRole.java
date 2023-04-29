package xbean;

import xdb.Bean;

public abstract interface RoamCrossCompeteRole
  extends Bean
{
  public abstract RoamCrossCompeteRole copy();
  
  public abstract RoamCrossCompeteRole toData();
  
  public abstract RoamCrossCompeteRole toBean();
  
  public abstract RoamCrossCompeteRole toDataIf();
  
  public abstract RoamCrossCompeteRole toBeanIf();
  
  public abstract long getFactionid();
  
  public abstract int getDuty();
  
  public abstract int getAction_point();
  
  public abstract int getWin_times();
  
  public abstract int getLose_times();
  
  public abstract int getWin_streak();
  
  public abstract int getWin_streak_awards();
  
  public abstract int getFinal_award();
  
  public abstract int getEscape_times();
  
  public abstract void setFactionid(long paramLong);
  
  public abstract void setDuty(int paramInt);
  
  public abstract void setAction_point(int paramInt);
  
  public abstract void setWin_times(int paramInt);
  
  public abstract void setLose_times(int paramInt);
  
  public abstract void setWin_streak(int paramInt);
  
  public abstract void setWin_streak_awards(int paramInt);
  
  public abstract void setFinal_award(int paramInt);
  
  public abstract void setEscape_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoamCrossCompeteRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */