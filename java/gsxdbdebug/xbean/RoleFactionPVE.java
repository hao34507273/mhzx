package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleFactionPVE
  extends Bean
{
  public abstract RoleFactionPVE copy();
  
  public abstract RoleFactionPVE toData();
  
  public abstract RoleFactionPVE toBean();
  
  public abstract RoleFactionPVE toDataIf();
  
  public abstract RoleFactionPVE toBeanIf();
  
  public abstract long getParticipate_millis();
  
  public abstract int getParticipate_times();
  
  public abstract Map<Integer, Integer> getGoal();
  
  public abstract Map<Integer, Integer> getGoalAsData();
  
  public abstract int getGoal_times();
  
  public abstract long getParticipate_faction();
  
  public abstract void setParticipate_millis(long paramLong);
  
  public abstract void setParticipate_times(int paramInt);
  
  public abstract void setGoal_times(int paramInt);
  
  public abstract void setParticipate_faction(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFactionPVE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */