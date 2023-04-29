package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ChineseValentineRound
  extends Bean
{
  public static final int STATE_PREPARE = 0;
  public static final int STATE_COMMAND = 1;
  public static final int STATE_SETTLEMENT = 2;
  
  public abstract ChineseValentineRound copy();
  
  public abstract ChineseValentineRound toData();
  
  public abstract ChineseValentineRound toBean();
  
  public abstract ChineseValentineRound toDataIf();
  
  public abstract ChineseValentineRound toBeanIf();
  
  public abstract long getSessionid();
  
  public abstract int getRoundnumber();
  
  public abstract long getRoundstarttime();
  
  public abstract List<ChineseValentineCage> getCageinfolist();
  
  public abstract List<ChineseValentineCage> getCageinfolistAsData();
  
  public abstract int getState();
  
  public abstract void setSessionid(long paramLong);
  
  public abstract void setRoundnumber(int paramInt);
  
  public abstract void setRoundstarttime(long paramLong);
  
  public abstract void setState(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChineseValentineRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */