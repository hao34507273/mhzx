package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ChineseValentineGame
  extends Bean
{
  public abstract ChineseValentineGame copy();
  
  public abstract ChineseValentineGame toData();
  
  public abstract ChineseValentineGame toBean();
  
  public abstract ChineseValentineGame toDataIf();
  
  public abstract ChineseValentineGame toBeanIf();
  
  public abstract long getStarttime();
  
  public abstract List<Long> getRoleidlist();
  
  public abstract List<Long> getRoleidlistAsData();
  
  public abstract ChineseValentineRound getRoundinfo();
  
  public abstract int getRightcount();
  
  public abstract int getWrongcount();
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setRightcount(int paramInt);
  
  public abstract void setWrongcount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChineseValentineGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */