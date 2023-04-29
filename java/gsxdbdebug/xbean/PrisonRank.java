package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface PrisonRank
  extends Bean
{
  public abstract PrisonRank copy();
  
  public abstract PrisonRank toData();
  
  public abstract PrisonRank toBean();
  
  public abstract PrisonRank toDataIf();
  
  public abstract PrisonRank toBeanIf();
  
  public abstract List<Long> getRoleids();
  
  public abstract List<Long> getRoleidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PrisonRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */