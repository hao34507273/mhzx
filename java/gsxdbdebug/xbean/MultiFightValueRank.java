package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MultiFightValueRank
  extends Bean
{
  public abstract MultiFightValueRank copy();
  
  public abstract MultiFightValueRank toData();
  
  public abstract MultiFightValueRank toBean();
  
  public abstract MultiFightValueRank toDataIf();
  
  public abstract MultiFightValueRank toBeanIf();
  
  public abstract List<RoleMultiFightValueBean> getRolerankdatas();
  
  public abstract List<RoleMultiFightValueBean> getRolerankdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MultiFightValueRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */