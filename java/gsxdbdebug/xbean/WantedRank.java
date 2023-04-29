package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface WantedRank
  extends Bean
{
  public abstract WantedRank copy();
  
  public abstract WantedRank toData();
  
  public abstract WantedRank toBean();
  
  public abstract WantedRank toDataIf();
  
  public abstract WantedRank toBeanIf();
  
  public abstract List<Long> getRoleids();
  
  public abstract List<Long> getRoleidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WantedRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */