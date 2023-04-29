package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface SeasonMultiTaskInfo
  extends Bean
{
  public abstract SeasonMultiTaskInfo copy();
  
  public abstract SeasonMultiTaskInfo toData();
  
  public abstract SeasonMultiTaskInfo toBean();
  
  public abstract SeasonMultiTaskInfo toDataIf();
  
  public abstract SeasonMultiTaskInfo toBeanIf();
  
  public abstract int getStep();
  
  public abstract List<Integer> getFinishsteps();
  
  public abstract List<Integer> getFinishstepsAsData();
  
  public abstract void setStep(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SeasonMultiTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */