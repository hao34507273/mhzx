package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MultiGender
  extends Bean
{
  public abstract MultiGender copy();
  
  public abstract MultiGender toData();
  
  public abstract MultiGender toBean();
  
  public abstract MultiGender toDataIf();
  
  public abstract MultiGender toBeanIf();
  
  public abstract List<Integer> getGenders();
  
  public abstract List<Integer> getGendersAsData();
  
  public abstract long getSwitch_time();
  
  public abstract void setSwitch_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MultiGender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */