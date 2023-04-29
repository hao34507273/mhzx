package xbean;

import xdb.Bean;

public abstract interface LonngBoatRaceAwardRecord
  extends Bean
{
  public abstract LonngBoatRaceAwardRecord copy();
  
  public abstract LonngBoatRaceAwardRecord toData();
  
  public abstract LonngBoatRaceAwardRecord toBean();
  
  public abstract LonngBoatRaceAwardRecord toDataIf();
  
  public abstract LonngBoatRaceAwardRecord toBeanIf();
  
  public abstract int getAwardcount();
  
  public abstract long getTimestamp();
  
  public abstract void setAwardcount(int paramInt);
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LonngBoatRaceAwardRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */