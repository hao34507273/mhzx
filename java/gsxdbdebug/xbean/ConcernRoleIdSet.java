package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ConcernRoleIdSet
  extends Bean
{
  public abstract ConcernRoleIdSet copy();
  
  public abstract ConcernRoleIdSet toData();
  
  public abstract ConcernRoleIdSet toBean();
  
  public abstract ConcernRoleIdSet toDataIf();
  
  public abstract ConcernRoleIdSet toBeanIf();
  
  public abstract List<Long> getRoleids();
  
  public abstract List<Long> getRoleidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ConcernRoleIdSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */