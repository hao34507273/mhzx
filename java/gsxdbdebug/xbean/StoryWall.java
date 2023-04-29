package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface StoryWall
  extends Bean
{
  public abstract StoryWall copy();
  
  public abstract StoryWall toData();
  
  public abstract StoryWall toBean();
  
  public abstract StoryWall toDataIf();
  
  public abstract StoryWall toBeanIf();
  
  public abstract long getStoryrefreshtime();
  
  public abstract List<Integer> getStoryids();
  
  public abstract List<Integer> getStoryidsAsData();
  
  public abstract int getMaxindex();
  
  public abstract void setStoryrefreshtime(long paramLong);
  
  public abstract void setMaxindex(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\StoryWall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */