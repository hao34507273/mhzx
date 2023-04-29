package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RolekejuRank
  extends Bean
{
  public abstract RolekejuRank copy();
  
  public abstract RolekejuRank toData();
  
  public abstract RolekejuRank toBean();
  
  public abstract RolekejuRank toDataIf();
  
  public abstract RolekejuRank toBeanIf();
  
  public abstract List<Long> getRankdatas();
  
  public abstract List<Long> getRankdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolekejuRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */