package xbean;

import xdb.Bean;

public abstract interface ReportRecord
  extends Bean
{
  public abstract ReportRecord copy();
  
  public abstract ReportRecord toData();
  
  public abstract ReportRecord toBean();
  
  public abstract ReportRecord toDataIf();
  
  public abstract ReportRecord toBeanIf();
  
  public abstract int getNum();
  
  public abstract void setNum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ReportRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */