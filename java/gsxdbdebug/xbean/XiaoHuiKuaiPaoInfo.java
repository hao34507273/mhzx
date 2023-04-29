package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface XiaoHuiKuaiPaoInfo
  extends Bean
{
  public static final int NOT_CONVERTED = 0;
  public static final int CONVERTED = 1;
  
  public abstract XiaoHuiKuaiPaoInfo copy();
  
  public abstract XiaoHuiKuaiPaoInfo toData();
  
  public abstract XiaoHuiKuaiPaoInfo toBean();
  
  public abstract XiaoHuiKuaiPaoInfo toDataIf();
  
  public abstract XiaoHuiKuaiPaoInfo toBeanIf();
  
  public abstract int getIndex();
  
  public abstract int getAccumulateturncount();
  
  public abstract int getTicketcount();
  
  public abstract Set<Integer> getHitindexes();
  
  public abstract Set<Integer> getHitindexesAsData();
  
  public abstract Set<Integer> getHitrandomtexttabletypeids();
  
  public abstract Set<Integer> getHitrandomtexttabletypeidsAsData();
  
  public abstract long getEndtimestamp();
  
  public abstract int getIsouterturnconverttopoint();
  
  public abstract void setIndex(int paramInt);
  
  public abstract void setAccumulateturncount(int paramInt);
  
  public abstract void setTicketcount(int paramInt);
  
  public abstract void setEndtimestamp(long paramLong);
  
  public abstract void setIsouterturnconverttopoint(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XiaoHuiKuaiPaoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */