package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface HulaRank
  extends Bean
{
  public abstract HulaRank copy();
  
  public abstract HulaRank toData();
  
  public abstract HulaRank toBean();
  
  public abstract HulaRank toDataIf();
  
  public abstract HulaRank toBeanIf();
  
  public abstract List<Long> getRanklist();
  
  public abstract List<Long> getRanklistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HulaRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */