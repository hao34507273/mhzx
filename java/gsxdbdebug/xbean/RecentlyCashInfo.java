package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RecentlyCashInfo
  extends Bean
{
  public abstract RecentlyCashInfo copy();
  
  public abstract RecentlyCashInfo toData();
  
  public abstract RecentlyCashInfo toBean();
  
  public abstract RecentlyCashInfo toDataIf();
  
  public abstract RecentlyCashInfo toBeanIf();
  
  public abstract List<DaySaveAmtInfo> getDay_save_amt_list();
  
  public abstract List<DaySaveAmtInfo> getDay_save_amt_listAsData();
  
  public abstract long getLast_week_cash_amt();
  
  public abstract long getLast_two_week_cash_amt();
  
  public abstract long getLast_month_cash_amt();
  
  public abstract long getLast_cash_amt_refresh_time();
  
  public abstract void setLast_week_cash_amt(long paramLong);
  
  public abstract void setLast_two_week_cash_amt(long paramLong);
  
  public abstract void setLast_month_cash_amt(long paramLong);
  
  public abstract void setLast_cash_amt_refresh_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RecentlyCashInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */