package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Role2MiBaoInfo
  extends Bean
{
  public abstract Role2MiBaoInfo copy();
  
  public abstract Role2MiBaoInfo toData();
  
  public abstract Role2MiBaoInfo toBean();
  
  public abstract Role2MiBaoInfo toDataIf();
  
  public abstract Role2MiBaoInfo toBeanIf();
  
  public abstract int getBuy_times_today();
  
  public abstract int getCurrent_score();
  
  public abstract int getCurrent_lucky_value();
  
  public abstract int getCurrent_index_id();
  
  public abstract long getShould_exchange_score_limit_end_time();
  
  public abstract long getShould_exchange_score_limit_begin_time();
  
  public abstract boolean getIs_exchange_score();
  
  public abstract Map<Integer, Integer> getLimit_item_draw_times_map();
  
  public abstract Map<Integer, Integer> getLimit_item_draw_times_mapAsData();
  
  public abstract void setBuy_times_today(int paramInt);
  
  public abstract void setCurrent_score(int paramInt);
  
  public abstract void setCurrent_lucky_value(int paramInt);
  
  public abstract void setCurrent_index_id(int paramInt);
  
  public abstract void setShould_exchange_score_limit_end_time(long paramLong);
  
  public abstract void setShould_exchange_score_limit_begin_time(long paramLong);
  
  public abstract void setIs_exchange_score(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2MiBaoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */