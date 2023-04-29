package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface AdultStageInfo
  extends Bean
{
  public abstract AdultStageInfo copy();
  
  public abstract AdultStageInfo toData();
  
  public abstract AdultStageInfo toBean();
  
  public abstract AdultStageInfo toDataIf();
  
  public abstract AdultStageInfo toBeanIf();
  
  public abstract int getAnimal_cfgid();
  
  public abstract long getLast_mate_time();
  
  public abstract int getAward_cfgid();
  
  public abstract long getBirth_time();
  
  public abstract int getMate_times();
  
  public abstract List<MateInfo> getMate_infos();
  
  public abstract List<MateInfo> getMate_infosAsData();
  
  public abstract void setAnimal_cfgid(int paramInt);
  
  public abstract void setLast_mate_time(long paramLong);
  
  public abstract void setAward_cfgid(int paramInt);
  
  public abstract void setBirth_time(long paramLong);
  
  public abstract void setMate_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AdultStageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */