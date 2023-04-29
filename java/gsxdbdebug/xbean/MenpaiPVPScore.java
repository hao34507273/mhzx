package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MenpaiPVPScore
  extends Bean
{
  public abstract MenpaiPVPScore copy();
  
  public abstract MenpaiPVPScore toData();
  
  public abstract MenpaiPVPScore toBean();
  
  public abstract MenpaiPVPScore toDataIf();
  
  public abstract MenpaiPVPScore toBeanIf();
  
  public abstract int getScore();
  
  public abstract int getWin_times();
  
  public abstract int getLose_times();
  
  public abstract Map<Long, Integer> getMatchroles();
  
  public abstract Map<Long, Integer> getMatchrolesAsData();
  
  public abstract boolean getParticipated();
  
  public abstract void setScore(int paramInt);
  
  public abstract void setWin_times(int paramInt);
  
  public abstract void setLose_times(int paramInt);
  
  public abstract void setParticipated(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MenpaiPVPScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */