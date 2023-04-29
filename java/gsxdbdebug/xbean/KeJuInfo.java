package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface KeJuInfo
  extends Bean
{
  public static final int STATE_XIANGSHI = 1;
  public static final int STATE_HUISHI = 2;
  public static final int STATE_DIANSHI = 3;
  
  public abstract KeJuInfo copy();
  
  public abstract KeJuInfo toData();
  
  public abstract KeJuInfo toBean();
  
  public abstract KeJuInfo toDataIf();
  
  public abstract KeJuInfo toBeanIf();
  
  public abstract List<Integer> getQuestionlist();
  
  public abstract List<Integer> getQuestionlistAsData();
  
  public abstract int getState();
  
  public abstract int getRightnum();
  
  public abstract int getAnswernum();
  
  public abstract boolean getIspasshuishi();
  
  public abstract long getStarttime();
  
  public abstract long getFinishtime();
  
  public abstract int getPunishtime();
  
  public abstract void setState(int paramInt);
  
  public abstract void setRightnum(int paramInt);
  
  public abstract void setAnswernum(int paramInt);
  
  public abstract void setIspasshuishi(boolean paramBoolean);
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setFinishtime(long paramLong);
  
  public abstract void setPunishtime(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\KeJuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */