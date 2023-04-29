package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LevelTaskInfo
  extends Bean
{
  public abstract LevelTaskInfo copy();
  
  public abstract LevelTaskInfo toData();
  
  public abstract LevelTaskInfo toBean();
  
  public abstract LevelTaskInfo toDataIf();
  
  public abstract LevelTaskInfo toBeanIf();
  
  public abstract Map<Integer, OwnTaskData> getLevel2graphids();
  
  public abstract Map<Integer, OwnTaskData> getLevel2graphidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LevelTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */