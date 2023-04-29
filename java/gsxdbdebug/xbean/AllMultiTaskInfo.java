package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface AllMultiTaskInfo
  extends Bean
{
  public abstract AllMultiTaskInfo copy();
  
  public abstract AllMultiTaskInfo toData();
  
  public abstract AllMultiTaskInfo toBean();
  
  public abstract AllMultiTaskInfo toDataIf();
  
  public abstract AllMultiTaskInfo toBeanIf();
  
  public abstract Map<Integer, CommonMultiTaskInfo> getActivity2info();
  
  public abstract Map<Integer, CommonMultiTaskInfo> getActivity2infoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AllMultiTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */