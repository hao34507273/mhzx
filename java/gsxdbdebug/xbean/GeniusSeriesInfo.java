package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GeniusSeriesInfo
  extends Bean
{
  public abstract GeniusSeriesInfo copy();
  
  public abstract GeniusSeriesInfo toData();
  
  public abstract GeniusSeriesInfo toBean();
  
  public abstract GeniusSeriesInfo toDataIf();
  
  public abstract GeniusSeriesInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getGenius_skills();
  
  public abstract Map<Integer, Integer> getGenius_skillsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GeniusSeriesInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */