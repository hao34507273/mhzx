package xbean;

import java.util.List;
import java.util.Map;
import mzm.gsp.drawandguess.main.IDrawAndGuessContext;
import xdb.Bean;

public abstract interface DrawAndGuessInfo
  extends Bean
{
  public abstract DrawAndGuessInfo copy();
  
  public abstract DrawAndGuessInfo toData();
  
  public abstract DrawAndGuessInfo toBean();
  
  public abstract DrawAndGuessInfo toDataIf();
  
  public abstract DrawAndGuessInfo toBeanIf();
  
  public abstract IDrawAndGuessContext getContext();
  
  public abstract long getSession_id();
  
  public abstract long getStart_time();
  
  public abstract int getCfg_id();
  
  public abstract long getDrawer_id();
  
  public abstract List<Long> getAll_roleids();
  
  public abstract List<Long> getAll_roleidsAsData();
  
  public abstract List<Long> getSuc_roleids();
  
  public abstract List<Long> getSuc_roleidsAsData();
  
  public abstract Map<Long, Long> getRoleids2answer_time();
  
  public abstract Map<Long, Long> getRoleids2answer_timeAsData();
  
  public abstract void setContext(IDrawAndGuessContext paramIDrawAndGuessContext);
  
  public abstract void setSession_id(long paramLong);
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setCfg_id(int paramInt);
  
  public abstract void setDrawer_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DrawAndGuessInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */