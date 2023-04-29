package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ChildGrowthDiaryInfo
  extends Bean
{
  public abstract ChildGrowthDiaryInfo copy();
  
  public abstract ChildGrowthDiaryInfo toData();
  
  public abstract ChildGrowthDiaryInfo toBean();
  
  public abstract ChildGrowthDiaryInfo toDataIf();
  
  public abstract ChildGrowthDiaryInfo toBeanIf();
  
  public abstract long getGive_birth_time();
  
  public abstract long getChildhood_begin_time();
  
  public abstract long getAdult_begin_time();
  
  public abstract List<ChildGrowthInfo> getGrowth_info_list();
  
  public abstract List<ChildGrowthInfo> getGrowth_info_listAsData();
  
  public abstract long getAnother_give_birth_parent_role_id();
  
  public abstract void setGive_birth_time(long paramLong);
  
  public abstract void setChildhood_begin_time(long paramLong);
  
  public abstract void setAdult_begin_time(long paramLong);
  
  public abstract void setAnother_give_birth_parent_role_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChildGrowthDiaryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */