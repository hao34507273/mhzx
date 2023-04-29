package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FeedCatInfo
  extends Bean
{
  public abstract FeedCatInfo copy();
  
  public abstract FeedCatInfo toData();
  
  public abstract FeedCatInfo toBean();
  
  public abstract FeedCatInfo toDataIf();
  
  public abstract FeedCatInfo toBeanIf();
  
  public abstract Map<Long, Integer> getFeed_cats();
  
  public abstract Map<Long, Integer> getFeed_catsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FeedCatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */