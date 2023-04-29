package mzm.gsp;

import java.util.List;
import xdb.Table;

public abstract interface MergeModule
{
  public abstract List<Table> getHandleTables();
  
  public abstract boolean handleMerge();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\MergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */