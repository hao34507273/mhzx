package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface StoryInfo
  extends Bean
{
  public abstract StoryInfo copy();
  
  public abstract StoryInfo toData();
  
  public abstract StoryInfo toBean();
  
  public abstract StoryInfo toDataIf();
  
  public abstract StoryInfo toBeanIf();
  
  public abstract List<Integer> getStoryids();
  
  public abstract List<Integer> getStoryidsAsData();
  
  public abstract long getReadtime();
  
  public abstract long getAwardtime();
  
  public abstract long getStorytime();
  
  public abstract void setReadtime(long paramLong);
  
  public abstract void setAwardtime(long paramLong);
  
  public abstract void setStorytime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\StoryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */