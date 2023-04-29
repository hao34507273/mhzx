package mzm.gsp.map.main;

import java.util.Set;
import xdb.Lockey;

public abstract interface MapItemGatherHandler
{
  public abstract Set<Lockey> collectLocks(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, MapItemGatherContext paramMapItemGatherContext);
  
  public abstract boolean gatherCheck(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, MapItemGatherContext paramMapItemGatherContext);
  
  public abstract boolean onGather(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, MapItemGatherContext paramMapItemGatherContext);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapItemGatherHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */