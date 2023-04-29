package xbean;

import mzm.gsp.timer.main.Observer;
import xdb.Bean;

public abstract interface CourseObserver
  extends Bean
{
  public abstract CourseObserver copy();
  
  public abstract CourseObserver toData();
  
  public abstract CourseObserver toBean();
  
  public abstract CourseObserver toDataIf();
  
  public abstract CourseObserver toBeanIf();
  
  public abstract Observer getObserver();
  
  public abstract void setObserver(Observer paramObserver);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CourseObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */