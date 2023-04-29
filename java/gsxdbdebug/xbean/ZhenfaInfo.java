package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ZhenfaInfo
  extends Bean
{
  public abstract ZhenfaInfo copy();
  
  public abstract ZhenfaInfo toData();
  
  public abstract ZhenfaInfo toBean();
  
  public abstract ZhenfaInfo toDataIf();
  
  public abstract ZhenfaInfo toBeanIf();
  
  public abstract List<ZhenfaBean> getZhenfas();
  
  public abstract List<ZhenfaBean> getZhenfasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ZhenfaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */