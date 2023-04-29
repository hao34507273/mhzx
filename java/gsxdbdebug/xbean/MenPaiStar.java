package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MenPaiStar
  extends Bean
{
  public abstract MenPaiStar copy();
  
  public abstract MenPaiStar toData();
  
  public abstract MenPaiStar toBean();
  
  public abstract MenPaiStar toDataIf();
  
  public abstract MenPaiStar toBeanIf();
  
  public abstract Map<Integer, MenPaiStarInfo> getCharts();
  
  public abstract Map<Integer, MenPaiStarInfo> getChartsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MenPaiStar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */