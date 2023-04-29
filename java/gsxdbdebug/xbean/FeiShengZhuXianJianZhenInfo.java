package xbean;

import xdb.Bean;

public abstract interface FeiShengZhuXianJianZhenInfo
  extends Bean
{
  public abstract FeiShengZhuXianJianZhenInfo copy();
  
  public abstract FeiShengZhuXianJianZhenInfo toData();
  
  public abstract FeiShengZhuXianJianZhenInfo toBean();
  
  public abstract FeiShengZhuXianJianZhenInfo toDataIf();
  
  public abstract FeiShengZhuXianJianZhenInfo toBeanIf();
  
  public abstract int getStage();
  
  public abstract long getWorld_id();
  
  public abstract int getCommit_item_num();
  
  public abstract int getKill_monster_num();
  
  public abstract long getSession_id();
  
  public abstract long getStage_collect_item_start_timestamp();
  
  public abstract long getStage_kill_monster_start_timestamp();
  
  public abstract boolean getHave_get_activity_award();
  
  public abstract int getDaily_try_times();
  
  public abstract long getDaily_try_times_timestamp();
  
  public abstract void setStage(int paramInt);
  
  public abstract void setWorld_id(long paramLong);
  
  public abstract void setCommit_item_num(int paramInt);
  
  public abstract void setKill_monster_num(int paramInt);
  
  public abstract void setSession_id(long paramLong);
  
  public abstract void setStage_collect_item_start_timestamp(long paramLong);
  
  public abstract void setStage_kill_monster_start_timestamp(long paramLong);
  
  public abstract void setHave_get_activity_award(boolean paramBoolean);
  
  public abstract void setDaily_try_times(int paramInt);
  
  public abstract void setDaily_try_times_timestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FeiShengZhuXianJianZhenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */