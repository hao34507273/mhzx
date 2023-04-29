package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface QMHWActivity
  extends Bean
{
  public static final int HADDLE_RESULT_DEFAULT = 0;
  public static final int HADDLE_RESULT_END_NOT_HANDLE = 1;
  public static final int HADDLE_RESULT_END_HANDLE = 2;
  
  public abstract QMHWActivity copy();
  
  public abstract QMHWActivity toData();
  
  public abstract QMHWActivity toBean();
  
  public abstract QMHWActivity toDataIf();
  
  public abstract QMHWActivity toBeanIf();
  
  public abstract long getWorldid();
  
  public abstract Set<Long> getFightids();
  
  public abstract Set<Long> getFightidsAsData();
  
  public abstract int getHandleresult();
  
  public abstract void setWorldid(long paramLong);
  
  public abstract void setHandleresult(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QMHWActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */