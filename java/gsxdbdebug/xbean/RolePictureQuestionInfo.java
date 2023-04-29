package xbean;

import xdb.Bean;

public abstract interface RolePictureQuestionInfo
  extends Bean
{
  public abstract RolePictureQuestionInfo copy();
  
  public abstract RolePictureQuestionInfo toData();
  
  public abstract RolePictureQuestionInfo toBean();
  
  public abstract RolePictureQuestionInfo toDataIf();
  
  public abstract RolePictureQuestionInfo toBeanIf();
  
  public abstract long getPicinfoid();
  
  public abstract int getRightnum();
  
  public abstract int getTotalnum();
  
  public abstract int getUsehelpnum();
  
  public abstract void setPicinfoid(long paramLong);
  
  public abstract void setRightnum(int paramInt);
  
  public abstract void setTotalnum(int paramInt);
  
  public abstract void setUsehelpnum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolePictureQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */