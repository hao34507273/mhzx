package xbean;

import xdb.Bean;

public abstract interface ActivityTeamBean
  extends Bean
{
  public abstract ActivityTeamBean copy();
  
  public abstract ActivityTeamBean toData();
  
  public abstract ActivityTeamBean toBean();
  
  public abstract ActivityTeamBean toDataIf();
  
  public abstract ActivityTeamBean toBeanIf();
  
  public abstract long getSessionid();
  
  public abstract void setSessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityTeamBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */