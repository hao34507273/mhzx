package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Role2ChildrenInfo
  extends Bean
{
  public static final int NO_CHILD_SHOW = -1;
  
  public abstract Role2ChildrenInfo copy();
  
  public abstract Role2ChildrenInfo toData();
  
  public abstract Role2ChildrenInfo toBean();
  
  public abstract Role2ChildrenInfo toDataIf();
  
  public abstract Role2ChildrenInfo toBeanIf();
  
  public abstract List<Long> getChild_id_list();
  
  public abstract List<Long> getChild_id_listAsData();
  
  public abstract List<Long> getChild_bag_id_list();
  
  public abstract List<Long> getChild_bag_id_listAsData();
  
  public abstract long getShow_child_id();
  
  public abstract int getSignal_way_child_score();
  
  public abstract int getShow_child_period();
  
  public abstract ChildFashionInfo getFashion_info();
  
  public abstract int getTotal_rating();
  
  public abstract int getTotal_discard_child_num();
  
  public abstract int getPeriod_recall_times();
  
  public abstract long getRecall_period_refresh_time();
  
  public abstract void setShow_child_id(long paramLong);
  
  public abstract void setSignal_way_child_score(int paramInt);
  
  public abstract void setShow_child_period(int paramInt);
  
  public abstract void setTotal_rating(int paramInt);
  
  public abstract void setTotal_discard_child_num(int paramInt);
  
  public abstract void setPeriod_recall_times(int paramInt);
  
  public abstract void setRecall_period_refresh_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2ChildrenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */