package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface SchoolChallenge
  extends Bean
{
  public abstract SchoolChallenge copy();
  
  public abstract SchoolChallenge toData();
  
  public abstract SchoolChallenge toBean();
  
  public abstract SchoolChallenge toDataIf();
  
  public abstract SchoolChallenge toBeanIf();
  
  public abstract int getCurrentring();
  
  public abstract int getAwardcirclecount();
  
  public abstract List<Integer> getTaskids();
  
  public abstract List<Integer> getTaskidsAsData();
  
  public abstract void setCurrentring(int paramInt);
  
  public abstract void setAwardcirclecount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SchoolChallenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */