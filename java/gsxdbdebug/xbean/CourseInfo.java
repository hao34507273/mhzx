package xbean;

import xdb.Bean;

public abstract interface CourseInfo
  extends Bean
{
  public abstract CourseInfo copy();
  
  public abstract CourseInfo toData();
  
  public abstract CourseInfo toBean();
  
  public abstract CourseInfo toDataIf();
  
  public abstract CourseInfo toBeanIf();
  
  public abstract int getNum();
  
  public abstract int getCrit_num();
  
  public abstract void setNum(int paramInt);
  
  public abstract void setCrit_num(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CourseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */