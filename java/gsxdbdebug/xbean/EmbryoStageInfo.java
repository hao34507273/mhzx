package xbean;

import xdb.Bean;

public abstract interface EmbryoStageInfo
  extends Bean
{
  public abstract EmbryoStageInfo copy();
  
  public abstract EmbryoStageInfo toData();
  
  public abstract EmbryoStageInfo toBean();
  
  public abstract EmbryoStageInfo toDataIf();
  
  public abstract EmbryoStageInfo toBeanIf();
  
  public abstract int getEmbryo_cfgid();
  
  public abstract int getHatch_days();
  
  public abstract long getLast_hatch_time();
  
  public abstract void setEmbryo_cfgid(int paramInt);
  
  public abstract void setHatch_days(int paramInt);
  
  public abstract void setLast_hatch_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\EmbryoStageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */