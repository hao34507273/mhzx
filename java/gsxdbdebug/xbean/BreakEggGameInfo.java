package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface BreakEggGameInfo
  extends Bean
{
  public abstract BreakEggGameInfo copy();
  
  public abstract BreakEggGameInfo toData();
  
  public abstract BreakEggGameInfo toBean();
  
  public abstract BreakEggGameInfo toDataIf();
  
  public abstract BreakEggGameInfo toBeanIf();
  
  public abstract long getSession_id();
  
  public abstract int getActivity_id();
  
  public abstract long getInviter_id();
  
  public abstract List<Long> getRoleid_list();
  
  public abstract List<Long> getRoleid_listAsData();
  
  public abstract List<Integer> getReward_info_id();
  
  public abstract List<Integer> getReward_info_idAsData();
  
  public abstract Map<Integer, BreakEggInfo> getIndex2break_egg_info();
  
  public abstract Map<Integer, BreakEggInfo> getIndex2break_egg_infoAsData();
  
  public abstract Map<Long, Integer> getRole_id2break_num();
  
  public abstract Map<Long, Integer> getRole_id2break_numAsData();
  
  public abstract void setSession_id(long paramLong);
  
  public abstract void setActivity_id(int paramInt);
  
  public abstract void setInviter_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BreakEggGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */