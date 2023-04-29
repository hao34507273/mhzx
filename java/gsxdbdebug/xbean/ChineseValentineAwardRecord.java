package xbean;

import xdb.Bean;

public abstract interface ChineseValentineAwardRecord
  extends Bean
{
  public abstract ChineseValentineAwardRecord copy();
  
  public abstract ChineseValentineAwardRecord toData();
  
  public abstract ChineseValentineAwardRecord toBean();
  
  public abstract ChineseValentineAwardRecord toDataIf();
  
  public abstract ChineseValentineAwardRecord toBeanIf();
  
  public abstract int getAwardcount();
  
  public abstract long getTimestamp();
  
  public abstract void setAwardcount(int paramInt);
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChineseValentineAwardRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */