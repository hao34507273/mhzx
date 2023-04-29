package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Blacklist
  extends Bean
{
  public abstract Blacklist copy();
  
  public abstract Blacklist toData();
  
  public abstract Blacklist toBean();
  
  public abstract Blacklist toDataIf();
  
  public abstract Blacklist toBeanIf();
  
  public abstract List<Long> getList();
  
  public abstract List<Long> getListAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Blacklist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */