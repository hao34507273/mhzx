package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface CommonMultiTaskInfo
  extends Bean
{
  public abstract CommonMultiTaskInfo copy();
  
  public abstract CommonMultiTaskInfo toData();
  
  public abstract CommonMultiTaskInfo toBean();
  
  public abstract CommonMultiTaskInfo toDataIf();
  
  public abstract CommonMultiTaskInfo toBeanIf();
  
  public abstract int getTurn();
  
  public abstract Set<Integer> getFinishsteps();
  
  public abstract Set<Integer> getFinishstepsAsData();
  
  public abstract void setTurn(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CommonMultiTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */