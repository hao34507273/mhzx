package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossCompeteTmp
  extends Bean
{
  public abstract CrossCompeteTmp copy();
  
  public abstract CrossCompeteTmp toData();
  
  public abstract CrossCompeteTmp toBean();
  
  public abstract CrossCompeteTmp toDataIf();
  
  public abstract CrossCompeteTmp toBeanIf();
  
  public abstract Map<CrossCompeteMatch, CrossCompeteAgainstTmp> getAgainsts();
  
  public abstract Map<CrossCompeteMatch, CrossCompeteAgainstTmp> getAgainstsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossCompeteTmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */