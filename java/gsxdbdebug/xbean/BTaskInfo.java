package xbean;

import xdb.Bean;

public abstract interface BTaskInfo
  extends Bean
{
  public static final int UN_ACCEPTED = 0;
  public static final int ALREADY_ACCEPTED = 1;
  public static final int FINISHED = 2;
  public static final int GIVE_UP = 3;
  
  public abstract BTaskInfo copy();
  
  public abstract BTaskInfo toData();
  
  public abstract BTaskInfo toBean();
  
  public abstract BTaskInfo toDataIf();
  
  public abstract BTaskInfo toBeanIf();
  
  public abstract int getTaskid();
  
  public abstract int getTaskstate();
  
  public abstract void setTaskid(int paramInt);
  
  public abstract void setTaskstate(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */