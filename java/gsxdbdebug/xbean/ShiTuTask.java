package xbean;

import xdb.Bean;

public abstract interface ShiTuTask
  extends Bean
{
  public static final int UN_ACCEPTED = 0;
  public static final int ALREADY_ACCEPTED = 1;
  public static final int FINISHED = 2;
  public static final int GIVE_UP = 3;
  public static final int MASTER_REWARDED = 4;
  
  public abstract ShiTuTask copy();
  
  public abstract ShiTuTask toData();
  
  public abstract ShiTuTask toBean();
  
  public abstract ShiTuTask toDataIf();
  
  public abstract ShiTuTask toBeanIf();
  
  public abstract int getTask_id();
  
  public abstract int getTask_state();
  
  public abstract void setTask_id(int paramInt);
  
  public abstract void setTask_state(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ShiTuTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */