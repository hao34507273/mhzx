package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ArenaChart
  extends Bean
{
  public abstract ArenaChart copy();
  
  public abstract ArenaChart toData();
  
  public abstract ArenaChart toBean();
  
  public abstract ArenaChart toDataIf();
  
  public abstract ArenaChart toBeanIf();
  
  public abstract List<Long> getRanklist();
  
  public abstract List<Long> getRanklistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ArenaChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */