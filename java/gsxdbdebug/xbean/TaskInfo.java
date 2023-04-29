package xbean;

import xdb.Bean;

public abstract interface TaskInfo
  extends Bean
{
  public static final int NOT_FINISHED = 0;
  public static final int YES_FINISHED = 1;
  public static final int QUESTION_TASK = 0;
  public static final int PIN_TU_TASK = 1;
  public static final int FIGHT_TASK = 2;
  
  public abstract TaskInfo copy();
  
  public abstract TaskInfo toData();
  
  public abstract TaskInfo toBean();
  
  public abstract TaskInfo toDataIf();
  
  public abstract TaskInfo toBeanIf();
  
  public abstract int getCfg_id();
  
  public abstract int getIs_finish();
  
  public abstract void setCfg_id(int paramInt);
  
  public abstract void setIs_finish(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */