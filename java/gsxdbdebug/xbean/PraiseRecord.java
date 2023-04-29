package xbean;

import xdb.Bean;

public abstract interface PraiseRecord
  extends Bean
{
  public abstract PraiseRecord copy();
  
  public abstract PraiseRecord toData();
  
  public abstract PraiseRecord toBean();
  
  public abstract PraiseRecord toDataIf();
  
  public abstract PraiseRecord toBeanIf();
  
  public abstract int getNum();
  
  public abstract void setNum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PraiseRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */