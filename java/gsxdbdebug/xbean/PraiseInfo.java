package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface PraiseInfo
  extends Bean
{
  public abstract PraiseInfo copy();
  
  public abstract PraiseInfo toData();
  
  public abstract PraiseInfo toBean();
  
  public abstract PraiseInfo toDataIf();
  
  public abstract PraiseInfo toBeanIf();
  
  public abstract int getBe_praised_num();
  
  public abstract Map<Long, PraiseRecord> getPraise_records();
  
  public abstract Map<Long, PraiseRecord> getPraise_recordsAsData();
  
  public abstract long getPraise_timestamp();
  
  public abstract int getPraised_num();
  
  public abstract void setBe_praised_num(int paramInt);
  
  public abstract void setPraise_timestamp(long paramLong);
  
  public abstract void setPraised_num(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PraiseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */