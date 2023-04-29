package xbean;

import xdb.Bean;

public abstract interface ActivityCompensateGlobal
  extends Bean
{
  public abstract ActivityCompensateGlobal copy();
  
  public abstract ActivityCompensateGlobal toData();
  
  public abstract ActivityCompensateGlobal toBean();
  
  public abstract ActivityCompensateGlobal toDataIf();
  
  public abstract ActivityCompensateGlobal toBeanIf();
  
  public abstract long getOpen_time();
  
  public abstract void setOpen_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityCompensateGlobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */