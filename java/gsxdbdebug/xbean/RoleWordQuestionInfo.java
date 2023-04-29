package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RoleWordQuestionInfo
  extends Bean
{
  public abstract RoleWordQuestionInfo copy();
  
  public abstract RoleWordQuestionInfo toData();
  
  public abstract RoleWordQuestionInfo toBean();
  
  public abstract RoleWordQuestionInfo toDataIf();
  
  public abstract RoleWordQuestionInfo toBeanIf();
  
  public abstract List<Integer> getQuestionidlist();
  
  public abstract List<Integer> getQuestionidlistAsData();
  
  public abstract int getRightnum();
  
  public abstract int getCuridx();
  
  public abstract long getSessionid();
  
  public abstract void setRightnum(int paramInt);
  
  public abstract void setCuridx(int paramInt);
  
  public abstract void setSessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleWordQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */