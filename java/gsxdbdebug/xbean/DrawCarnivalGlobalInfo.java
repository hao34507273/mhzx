package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface DrawCarnivalGlobalInfo
  extends Bean
{
  public abstract DrawCarnivalGlobalInfo copy();
  
  public abstract DrawCarnivalGlobalInfo toData();
  
  public abstract DrawCarnivalGlobalInfo toBean();
  
  public abstract DrawCarnivalGlobalInfo toDataIf();
  
  public abstract DrawCarnivalGlobalInfo toBeanIf();
  
  public abstract long getAward_pool_yuan_bao_count();
  
  public abstract Map<Integer, DrawCarnivalActivityInfo> getActivity_id2info();
  
  public abstract Map<Integer, DrawCarnivalActivityInfo> getActivity_id2infoAsData();
  
  public abstract void setAward_pool_yuan_bao_count(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DrawCarnivalGlobalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */