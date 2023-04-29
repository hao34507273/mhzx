package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface IdipNoticeInfo
  extends Bean
{
  public abstract IdipNoticeInfo copy();
  
  public abstract IdipNoticeInfo toData();
  
  public abstract IdipNoticeInfo toBean();
  
  public abstract IdipNoticeInfo toDataIf();
  
  public abstract IdipNoticeInfo toBeanIf();
  
  public abstract int getNoticetype();
  
  public abstract int getDisplaytype();
  
  public abstract int getHreftype();
  
  public abstract String getHreftext();
  
  public abstract Octets getHreftextOctets();
  
  public abstract String getHrefurl();
  
  public abstract Octets getHrefurlOctets();
  
  public abstract int getSendtype();
  
  public abstract String getNoticetitle();
  
  public abstract Octets getNoticetitleOctets();
  
  public abstract String getNoticecontent();
  
  public abstract Octets getNoticecontentOctets();
  
  public abstract String getPictureurl();
  
  public abstract Octets getPictureurlOctets();
  
  public abstract long getStarttime();
  
  public abstract long getEndtime();
  
  public abstract int getMinopenserverdays();
  
  public abstract int getMaxopenserverdays();
  
  public abstract int getMincreatroledays();
  
  public abstract int getMaxcreatroledays();
  
  public abstract int getMinrolelevel();
  
  public abstract int getMaxrolelevel();
  
  public abstract long getMinsaveamt();
  
  public abstract long getMaxsaveamt();
  
  public abstract int getNoticetag();
  
  public abstract boolean getBadge();
  
  public abstract int getNoticesortid();
  
  public abstract void setNoticetype(int paramInt);
  
  public abstract void setDisplaytype(int paramInt);
  
  public abstract void setHreftype(int paramInt);
  
  public abstract void setHreftext(String paramString);
  
  public abstract void setHreftextOctets(Octets paramOctets);
  
  public abstract void setHrefurl(String paramString);
  
  public abstract void setHrefurlOctets(Octets paramOctets);
  
  public abstract void setSendtype(int paramInt);
  
  public abstract void setNoticetitle(String paramString);
  
  public abstract void setNoticetitleOctets(Octets paramOctets);
  
  public abstract void setNoticecontent(String paramString);
  
  public abstract void setNoticecontentOctets(Octets paramOctets);
  
  public abstract void setPictureurl(String paramString);
  
  public abstract void setPictureurlOctets(Octets paramOctets);
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setEndtime(long paramLong);
  
  public abstract void setMinopenserverdays(int paramInt);
  
  public abstract void setMaxopenserverdays(int paramInt);
  
  public abstract void setMincreatroledays(int paramInt);
  
  public abstract void setMaxcreatroledays(int paramInt);
  
  public abstract void setMinrolelevel(int paramInt);
  
  public abstract void setMaxrolelevel(int paramInt);
  
  public abstract void setMinsaveamt(long paramLong);
  
  public abstract void setMaxsaveamt(long paramLong);
  
  public abstract void setNoticetag(int paramInt);
  
  public abstract void setBadge(boolean paramBoolean);
  
  public abstract void setNoticesortid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IdipNoticeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */