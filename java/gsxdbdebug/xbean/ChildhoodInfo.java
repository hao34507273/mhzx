package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ChildhoodInfo
  extends Bean
{
  public abstract ChildhoodInfo copy();
  
  public abstract ChildhoodInfo toData();
  
  public abstract ChildhoodInfo toBean();
  
  public abstract ChildhoodInfo toDataIf();
  
  public abstract ChildhoodInfo toBeanIf();
  
  public abstract int getInterest();
  
  public abstract Map<Integer, CourseInfo> getCourses();
  
  public abstract Map<Integer, CourseInfo> getCoursesAsData();
  
  public abstract CourseStudyInfo getCur_course();
  
  public abstract DailyCourseInfo getDaily_curse();
  
  public abstract int getTotal_num();
  
  public abstract int getTotal_crit_num();
  
  public abstract int getChild_hood_model_cfg_id();
  
  public abstract void setInterest(int paramInt);
  
  public abstract void setTotal_num(int paramInt);
  
  public abstract void setTotal_crit_num(int paramInt);
  
  public abstract void setChild_hood_model_cfg_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChildhoodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */