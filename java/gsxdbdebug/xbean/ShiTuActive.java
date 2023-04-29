package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ShiTuActive
  extends Bean
{
  public abstract ShiTuActive copy();
  
  public abstract ShiTuActive toData();
  
  public abstract ShiTuActive toBean();
  
  public abstract ShiTuActive toDataIf();
  
  public abstract ShiTuActive toBeanIf();
  
  public abstract long getReset_time();
  
  public abstract Map<Long, AwardIndexIds> getAward_map();
  
  public abstract Map<Long, AwardIndexIds> getAward_mapAsData();
  
  public abstract void setReset_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ShiTuActive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */