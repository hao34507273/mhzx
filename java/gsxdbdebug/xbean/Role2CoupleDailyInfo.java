package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Role2CoupleDailyInfo
  extends Bean
{
  public static final int NOT_AWARDED = 0;
  public static final int YES_AWARDED = 1;
  
  public abstract Role2CoupleDailyInfo copy();
  
  public abstract Role2CoupleDailyInfo toData();
  
  public abstract Role2CoupleDailyInfo toBean();
  
  public abstract Role2CoupleDailyInfo toDataIf();
  
  public abstract Role2CoupleDailyInfo toBeanIf();
  
  public abstract List<TaskInfo> getTasklist();
  
  public abstract List<TaskInfo> getTasklistAsData();
  
  public abstract int getIsawarded();
  
  public abstract long getPartnerroleid();
  
  public abstract CoupleQuestionInfo getCouplequestioninfo();
  
  public abstract void setIsawarded(int paramInt);
  
  public abstract void setPartnerroleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2CoupleDailyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */