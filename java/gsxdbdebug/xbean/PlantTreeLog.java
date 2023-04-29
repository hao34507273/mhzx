package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface PlantTreeLog
  extends Bean
{
  public abstract PlantTreeLog copy();
  
  public abstract PlantTreeLog toData();
  
  public abstract PlantTreeLog toBean();
  
  public abstract PlantTreeLog toDataIf();
  
  public abstract PlantTreeLog toBeanIf();
  
  public abstract int getLog_type();
  
  public abstract int getTimestamp();
  
  public abstract List<String> getExtradatas();
  
  public abstract List<String> getExtradatasAsData();
  
  public abstract void setLog_type(int paramInt);
  
  public abstract void setTimestamp(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PlantTreeLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */