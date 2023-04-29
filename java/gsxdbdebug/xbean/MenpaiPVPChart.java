package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MenpaiPVPChart
  extends Bean
{
  public abstract MenpaiPVPChart copy();
  
  public abstract MenpaiPVPChart toData();
  
  public abstract MenpaiPVPChart toBean();
  
  public abstract MenpaiPVPChart toDataIf();
  
  public abstract MenpaiPVPChart toBeanIf();
  
  public abstract List<Long> getRanklist();
  
  public abstract List<Long> getRanklistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MenpaiPVPChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */