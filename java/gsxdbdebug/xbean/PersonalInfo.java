package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface PersonalInfo
  extends Bean
{
  public abstract PersonalInfo copy();
  
  public abstract PersonalInfo toData();
  
  public abstract PersonalInfo toBean();
  
  public abstract PersonalInfo toDataIf();
  
  public abstract PersonalInfo toBeanIf();
  
  public abstract String getSign();
  
  public abstract Octets getSignOctets();
  
  public abstract int getGender();
  
  public abstract int getAge();
  
  public abstract long getBirthday();
  
  public abstract int getAnimalsign();
  
  public abstract int getConstellation();
  
  public abstract int getBloodtype();
  
  public abstract int getOccupation();
  
  public abstract String getSchool();
  
  public abstract Octets getSchoolOctets();
  
  public abstract long getLocation();
  
  public abstract List<Integer> getHobbies();
  
  public abstract List<Integer> getHobbiesAsData();
  
  public abstract String getHeadimage();
  
  public abstract Octets getHeadimageOctets();
  
  public abstract List<String> getPhotos();
  
  public abstract List<String> getPhotosAsData();
  
  public abstract PraiseInfo getPraise();
  
  public abstract Map<Integer, Long> getRefreshadvert();
  
  public abstract Map<Integer, Long> getRefreshadvertAsData();
  
  public abstract Map<Integer, Long> getAdverts();
  
  public abstract Map<Integer, Long> getAdvertsAsData();
  
  public abstract Map<Integer, Long> getDeletetimestamps();
  
  public abstract Map<Integer, Long> getDeletetimestampsAsData();
  
  public abstract void setSign(String paramString);
  
  public abstract void setSignOctets(Octets paramOctets);
  
  public abstract void setGender(int paramInt);
  
  public abstract void setAge(int paramInt);
  
  public abstract void setBirthday(long paramLong);
  
  public abstract void setAnimalsign(int paramInt);
  
  public abstract void setConstellation(int paramInt);
  
  public abstract void setBloodtype(int paramInt);
  
  public abstract void setOccupation(int paramInt);
  
  public abstract void setSchool(String paramString);
  
  public abstract void setSchoolOctets(Octets paramOctets);
  
  public abstract void setLocation(long paramLong);
  
  public abstract void setHeadimage(String paramString);
  
  public abstract void setHeadimageOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PersonalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */