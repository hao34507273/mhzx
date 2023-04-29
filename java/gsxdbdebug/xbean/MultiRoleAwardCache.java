package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import mzm.gsp.tlog.TLogArg;
import xdb.Bean;

public abstract interface MultiRoleAwardCache
  extends Bean
{
  public abstract MultiRoleAwardCache copy();
  
  public abstract MultiRoleAwardCache toData();
  
  public abstract MultiRoleAwardCache toBean();
  
  public abstract MultiRoleAwardCache toDataIf();
  
  public abstract MultiRoleAwardCache toBeanIf();
  
  public abstract List<Long> getRoles();
  
  public abstract List<Long> getRolesAsData();
  
  public abstract List<Item2CountBean> getAwarditemids();
  
  public abstract List<Item2CountBean> getAwarditemidsAsData();
  
  public abstract Map<Integer, Long> getIndexmap();
  
  public abstract Map<Integer, Long> getIndexmapAsData();
  
  public abstract Set<Long> getOperroleids();
  
  public abstract Set<Long> getOperroleidsAsData();
  
  public abstract TLogArg getTlogarg();
  
  public abstract void setTlogarg(TLogArg paramTLogArg);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MultiRoleAwardCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */