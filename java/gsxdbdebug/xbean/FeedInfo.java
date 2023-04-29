package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FeedInfo
  extends Bean
{
  public abstract FeedInfo copy();
  
  public abstract FeedInfo toData();
  
  public abstract FeedInfo toBean();
  
  public abstract FeedInfo toDataIf();
  
  public abstract FeedInfo toBeanIf();
  
  public abstract Map<Long, Integer> getFeed_cat_records();
  
  public abstract Map<Long, Integer> getFeed_cat_recordsAsData();
  
  public abstract long getFeed_timestamp();
  
  public abstract Map<Long, FeedCatInfo> getFeed_records();
  
  public abstract Map<Long, FeedCatInfo> getFeed_recordsAsData();
  
  public abstract void setFeed_timestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FeedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */