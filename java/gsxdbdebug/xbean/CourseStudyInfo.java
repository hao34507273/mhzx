package xbean;

import xdb.Bean;

public abstract interface CourseStudyInfo
  extends Bean
{
  public abstract CourseStudyInfo copy();
  
  public abstract CourseStudyInfo toData();
  
  public abstract CourseStudyInfo toBean();
  
  public abstract CourseStudyInfo toDataIf();
  
  public abstract CourseStudyInfo toBeanIf();
  
  public abstract int getCourse_type();
  
  public abstract long getTime();
  
  public abstract void setCourse_type(int paramInt);
  
  public abstract void setTime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CourseStudyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */