package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface FoolsDayInfo
  extends Bean
{
  public abstract FoolsDayInfo copy();
  
  public abstract FoolsDayInfo toData();
  
  public abstract FoolsDayInfo toBean();
  
  public abstract FoolsDayInfo toDataIf();
  
  public abstract FoolsDayInfo toBeanIf();
  
  public abstract int getMake_chest_num();
  
  public abstract List<Integer> getAlternative_buff_cfg_ids();
  
  public abstract List<Integer> getAlternative_buff_cfg_idsAsData();
  
  public abstract int getRefresh_time();
  
  public abstract int getPoint();
  
  public abstract List<Long> getOpen_chest_maker_ids();
  
  public abstract List<Long> getOpen_chest_maker_idsAsData();
  
  public abstract long getOpen_chest_maker_ids_timestamp();
  
  public abstract boolean getHas_get_title_award();
  
  public abstract void setMake_chest_num(int paramInt);
  
  public abstract void setRefresh_time(int paramInt);
  
  public abstract void setPoint(int paramInt);
  
  public abstract void setOpen_chest_maker_ids_timestamp(long paramLong);
  
  public abstract void setHas_get_title_award(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FoolsDayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */