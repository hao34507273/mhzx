package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface AwardIndexIds
  extends Bean
{
  public abstract AwardIndexIds copy();
  
  public abstract AwardIndexIds toData();
  
  public abstract AwardIndexIds toBean();
  
  public abstract AwardIndexIds toDataIf();
  
  public abstract AwardIndexIds toBeanIf();
  
  public abstract Set<Integer> getAward_index_id_set();
  
  public abstract Set<Integer> getAward_index_id_setAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AwardIndexIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */