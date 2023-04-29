package xbean;

import java.util.List;
import mzm.gsp.confirm.main.TeamConfirmContext;
import xdb.Bean;

public abstract interface TeamConfirmBean
  extends Bean
{
  public abstract TeamConfirmBean copy();
  
  public abstract TeamConfirmBean toData();
  
  public abstract TeamConfirmBean toBean();
  
  public abstract TeamConfirmBean toDataIf();
  
  public abstract TeamConfirmBean toBeanIf();
  
  public abstract List<Long> getAllroles();
  
  public abstract List<Long> getAllrolesAsData();
  
  public abstract List<Long> getAcceptroles();
  
  public abstract List<Long> getAcceptrolesAsData();
  
  public abstract long getSessionid();
  
  public abstract TeamConfirmContext getContext();
  
  public abstract long getEndtime();
  
  public abstract int getConfirmtype();
  
  public abstract void setSessionid(long paramLong);
  
  public abstract void setContext(TeamConfirmContext paramTeamConfirmContext);
  
  public abstract void setEndtime(long paramLong);
  
  public abstract void setConfirmtype(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TeamConfirmBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */