/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.personal.Birthday;
/*     */ import mzm.gsp.personal.EditPersonalInfo;
/*     */ import mzm.gsp.personal.Location;
/*     */ import mzm.gsp.personal.SEditPersonalInfoFailed;
/*     */ import mzm.gsp.personal.SEditPersonalInfoSuccess;
/*     */ import mzm.gsp.personal.confbean.LinkLocationsCfg;
/*     */ import mzm.gsp.personal.confbean.PersonalConsts;
/*     */ import mzm.gsp.personal.confbean.PersonalOptionCfg;
/*     */ import mzm.gsp.personal.confbean.SPersonalCfg;
/*     */ import mzm.gsp.personal.confbean.SPersonalOptionCfg;
/*     */ import mzm.gsp.personal.event.GenderArg;
/*     */ import mzm.gsp.personal.event.GenderChange;
/*     */ import mzm.gsp.personal.event.IntegrityArg;
/*     */ import mzm.gsp.personal.event.IntegrityChange;
/*     */ import mzm.gsp.personal.event.LocationArg;
/*     */ import mzm.gsp.personal.event.LocationChange;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2personal;
/*     */ 
/*     */ public class PCEditPersonalInfo
/*     */   extends LogicProcedure
/*     */ {
/*     */   private static final String ENCODING = "UTF-8";
/*     */   private final long roleId;
/*     */   private final EditPersonalInfo personalInfo;
/*     */   
/*     */   public PCEditPersonalInfo(long roleId, EditPersonalInfo personalInfo)
/*     */   {
/*  42 */     this.roleId = roleId;
/*  43 */     this.personalInfo = personalInfo;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (!PersonalManager.isFunOpen(this.roleId))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     if (!PersonalManager.checkRoleStatus(this.roleId))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     String userid = RoleInterface.getUserId(this.roleId);
/*  62 */     xbean.User xUser = xtable.User.get(userid);
/*  63 */     if (xUser == null)
/*     */     {
/*  65 */       onFailed(5);
/*  66 */       return false;
/*     */     }
/*  68 */     xbean.PersonalInfo xPersonalInfo = Role2personal.get(Long.valueOf(this.roleId));
/*  69 */     if (xPersonalInfo == null)
/*     */     {
/*  71 */       onFailed(5);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     String sign = this.personalInfo.sign.getString("UTF-8");
/*  76 */     if (!checkSign(sign))
/*     */     {
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     int gender = this.personalInfo.gender;
/*  82 */     if (!checkGender(gender))
/*     */     {
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     int age = this.personalInfo.age;
/*  88 */     if (!checkAge(age))
/*     */     {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     Birthday birthday = this.personalInfo.birthday;
/*  94 */     if (!checkBitrhday(birthday))
/*     */     {
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     int animalSign = this.personalInfo.animalsign;
/* 100 */     if (!checkAnimalSign(animalSign))
/*     */     {
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     int constellation = this.personalInfo.constellation;
/* 106 */     if (!checkConstellation(constellation))
/*     */     {
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     int bloodType = this.personalInfo.bloodtype;
/* 112 */     if (!checkBloodType(bloodType))
/*     */     {
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     int occupation = this.personalInfo.occupation;
/* 118 */     if (!checkOccupation(occupation))
/*     */     {
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     String school = this.personalInfo.school.getString("UTF-8");
/* 124 */     if (!checkSchool(school))
/*     */     {
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     Location location = this.personalInfo.location;
/* 130 */     if (!checkLocation(location))
/*     */     {
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     ArrayList<Integer> hobbies = this.personalInfo.hobbies;
/* 136 */     if (!checkHobbies(hobbies))
/*     */     {
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     ArrayList<Integer> photos = this.personalInfo.photos;
/* 142 */     if (!checkPhotos(photos))
/*     */     {
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     int oldIntegrity = PersonalManager.calculateIntegrity(xPersonalInfo);
/*     */     
/* 149 */     String oldSign = xPersonalInfo.getSign();
/* 150 */     if (!sign.equals(oldSign))
/*     */     {
/* 152 */       xPersonalInfo.setSign(sign);
/* 153 */       IdipManager.chatTLog(this.roleId, 0L, 0L, 0L, 102, null, this.personalInfo.sign);
/*     */     }
/*     */     
/* 156 */     if (xPersonalInfo.getGender() != gender)
/*     */     {
/*     */ 
/* 159 */       GenderChange genderChangeEvent = new GenderChange();
/* 160 */       genderChangeEvent.setSequential(true);
/* 161 */       TriggerEventsManger.getInstance().triggerEvent(genderChangeEvent, new GenderArg(this.roleId, xPersonalInfo.getGender(), gender), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*     */ 
/* 165 */     xPersonalInfo.setGender(gender);
/* 166 */     xPersonalInfo.setAge(age);
/* 167 */     xPersonalInfo.setBirthday(getBirthday(birthday));
/* 168 */     xPersonalInfo.setAnimalsign(animalSign);
/* 169 */     xPersonalInfo.setConstellation(constellation);
/* 170 */     xPersonalInfo.setBloodtype(bloodType);
/* 171 */     xPersonalInfo.setOccupation(occupation);
/* 172 */     xPersonalInfo.setSchool(school);
/*     */     
/* 174 */     long oldLocation = xPersonalInfo.getLocation();
/* 175 */     long newLocation = getLocation(location);
/* 176 */     if (oldLocation != newLocation)
/*     */     {
/*     */ 
/* 179 */       LocationChange locationChangeEvent = new LocationChange();
/* 180 */       locationChangeEvent.setSequential(true);
/* 181 */       TriggerEventsManger.getInstance().triggerEvent(locationChangeEvent, new LocationArg(this.roleId, PersonalManager.getLocation(oldLocation), location), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*     */ 
/* 185 */     xPersonalInfo.setLocation(newLocation);
/* 186 */     xPersonalInfo.getHobbies().clear();
/* 187 */     xPersonalInfo.getHobbies().addAll(hobbies);
/*     */     
/*     */ 
/* 190 */     int newIntegrity = PersonalManager.calculateIntegrity(xPersonalInfo);
/* 191 */     if (oldIntegrity != newIntegrity)
/*     */     {
/*     */ 
/* 194 */       IntegrityChange integrityChangeEvent = new IntegrityChange();
/* 195 */       integrityChangeEvent.setSequential(true);
/* 196 */       TriggerEventsManger.getInstance().triggerEvent(integrityChangeEvent, new IntegrityArg(this.roleId, oldIntegrity, newIntegrity), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 201 */     mzm.gsp.personal.PersonalInfo personalInfo = PersonalManager.transInfo(this.roleId, xPersonalInfo);
/*     */     
/* 203 */     personalInfo.figure_url.setString(xUser.getFigure_url(), "UTF-8");
/*     */     
/*     */ 
/* 206 */     SEditPersonalInfoSuccess resp = new SEditPersonalInfoSuccess();
/* 207 */     resp.roleid = this.roleId;
/* 208 */     resp.personalinfo = personalInfo;
/* 209 */     OnlineManager.getInstance().send(this.roleId, resp);
/*     */     
/* 211 */     GameServer.logger().info(String.format("[personal]PCEditPersonalInfo.processImp@edit success|roleid=%d|sign=%s|gender=%d|age=%d|birthday=%d|animalSign=%d|constellation=%d|bloodType=%d|occupation=%d|school=%s|location=%d|hobby_list=%s", new Object[] { Long.valueOf(this.roleId), xPersonalInfo.getSign(), Integer.valueOf(gender), Integer.valueOf(age), Long.valueOf(getBirthday(birthday)), Integer.valueOf(animalSign), Integer.valueOf(constellation), Integer.valueOf(bloodType), Integer.valueOf(occupation), xPersonalInfo.getSchool(), Long.valueOf(getLocation(location)), hobbies.toString() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 216 */     return true;
/*     */   }
/*     */   
/*     */   private long getBirthday(Birthday birthday)
/*     */   {
/* 221 */     long result = birthday.month;
/* 222 */     result <<= 32;
/* 223 */     result += birthday.day;
/* 224 */     return result;
/*     */   }
/*     */   
/*     */   private long getLocation(Location location)
/*     */   {
/* 229 */     long result = location.province;
/* 230 */     result <<= 32;
/* 231 */     result += location.city;
/* 232 */     return result;
/*     */   }
/*     */   
/*     */   private void onFailed(int retCode)
/*     */   {
/* 237 */     SEditPersonalInfoFailed resp = new SEditPersonalInfoFailed();
/* 238 */     resp.roleid = this.roleId;
/* 239 */     resp.retcode = retCode;
/* 240 */     OnlineManager.getInstance().sendAtOnce(this.roleId, resp);
/*     */     
/* 242 */     GameServer.logger().info(String.format("[personal]PCEditPersonalInfo.onFailed@edit failed|roleid=%d|ret=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(retCode) }));
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean checkSign(String sign)
/*     */   {
/* 248 */     if (sign.isEmpty())
/*     */     {
/* 250 */       return true;
/*     */     }
/*     */     
/* 253 */     if (sign.length() > SPersonalCfg.get(2).textMaxLen)
/*     */     {
/* 255 */       onFailed(2);
/* 256 */       return false;
/*     */     }
/*     */     
/* 259 */     if (SensitiveInterface.isContentSensitive(sign))
/*     */     {
/* 261 */       onFailed(1);
/* 262 */       return false;
/*     */     }
/*     */     
/* 265 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkGender(int gender)
/*     */   {
/* 270 */     if (gender == 0)
/*     */     {
/* 272 */       return true;
/*     */     }
/*     */     
/* 275 */     int optionId = SPersonalCfg.get(4).optionId;
/* 276 */     if (!PersonalOptionCfg.get(optionId).optionCfgIds.contains(Integer.valueOf(gender)))
/*     */     {
/* 278 */       onFailed(11);
/* 279 */       return false;
/*     */     }
/*     */     
/* 282 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkAge(int age)
/*     */   {
/* 287 */     if (age == 0)
/*     */     {
/* 289 */       return true;
/*     */     }
/*     */     
/* 292 */     if (age < 0)
/*     */     {
/* 294 */       onFailed(12);
/* 295 */       return false;
/*     */     }
/* 297 */     if (age > PersonalConsts.getInstance().MAX_AGE)
/*     */     {
/* 299 */       onFailed(12);
/* 300 */       return false;
/*     */     }
/*     */     
/* 303 */     return true;
/*     */   }
/*     */   
/* 306 */   private static final int[] monthDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
/*     */   
/*     */   private boolean checkBitrhday(Birthday birthday)
/*     */   {
/* 310 */     if ((birthday.month == 0) && (birthday.day == 0))
/*     */     {
/* 312 */       return true;
/*     */     }
/*     */     
/* 315 */     int month = birthday.month;
/* 316 */     if ((month <= 0) || (month > 12))
/*     */     {
/* 318 */       onFailed(13);
/* 319 */       return false;
/*     */     }
/*     */     
/* 322 */     int day = birthday.day;
/* 323 */     if ((day <= 0) || (day > monthDays[(birthday.month - 1)]))
/*     */     {
/* 325 */       onFailed(13);
/* 326 */       return false;
/*     */     }
/*     */     
/* 329 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkAnimalSign(int animalSign)
/*     */   {
/* 334 */     if (animalSign == 0)
/*     */     {
/* 336 */       return true;
/*     */     }
/*     */     
/* 339 */     int optionId = SPersonalCfg.get(8).optionId;
/* 340 */     if (!PersonalOptionCfg.get(optionId).optionCfgIds.contains(Integer.valueOf(animalSign)))
/*     */     {
/* 342 */       onFailed(14);
/* 343 */       return false;
/*     */     }
/* 345 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkConstellation(int constellation)
/*     */   {
/* 350 */     if (constellation == 0)
/*     */     {
/* 352 */       return true;
/*     */     }
/*     */     
/* 355 */     int optionId = SPersonalCfg.get(9).optionId;
/* 356 */     if (!PersonalOptionCfg.get(optionId).optionCfgIds.contains(Integer.valueOf(constellation)))
/*     */     {
/* 358 */       onFailed(15);
/* 359 */       return false;
/*     */     }
/* 361 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkBloodType(int bloodType)
/*     */   {
/* 366 */     if (bloodType == 0)
/*     */     {
/* 368 */       return true;
/*     */     }
/*     */     
/* 371 */     int optionId = SPersonalCfg.get(10).optionId;
/* 372 */     if (!PersonalOptionCfg.get(optionId).optionCfgIds.contains(Integer.valueOf(bloodType)))
/*     */     {
/* 374 */       onFailed(16);
/* 375 */       return false;
/*     */     }
/*     */     
/* 378 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkOccupation(int occupation)
/*     */   {
/* 383 */     if (occupation == 0)
/*     */     {
/* 385 */       return true;
/*     */     }
/*     */     
/* 388 */     int optionId = SPersonalCfg.get(11).optionId;
/* 389 */     if (!PersonalOptionCfg.get(optionId).optionCfgIds.contains(Integer.valueOf(occupation)))
/*     */     {
/* 391 */       onFailed(17);
/* 392 */       return false;
/*     */     }
/*     */     
/* 395 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkSchool(String school)
/*     */   {
/* 400 */     if (school.isEmpty())
/*     */     {
/* 402 */       return true;
/*     */     }
/*     */     
/* 405 */     if (school.length() > SPersonalCfg.get(12).textMaxLen)
/*     */     {
/* 407 */       onFailed(4);
/* 408 */       return false;
/*     */     }
/*     */     
/* 411 */     if (SensitiveInterface.isContentSensitive(school))
/*     */     {
/* 413 */       onFailed(3);
/* 414 */       return false;
/*     */     }
/*     */     
/* 417 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkLocation(Location location)
/*     */   {
/* 422 */     if ((location.province == 0) && (location.city == 0))
/*     */     {
/* 424 */       return true;
/*     */     }
/*     */     
/* 427 */     int province = location.province;
/* 428 */     int optionId = SPersonalCfg.get(14).optionId;
/* 429 */     if (!PersonalOptionCfg.get(optionId).optionCfgIds.contains(Integer.valueOf(province)))
/*     */     {
/* 431 */       onFailed(18);
/* 432 */       return false;
/*     */     }
/*     */     
/* 435 */     int city = location.city;
/* 436 */     int linkLocationId = SPersonalOptionCfg.get(province).linkOptionId;
/* 437 */     if (!LinkLocationsCfg.get(linkLocationId).locationCfgIds.contains(Integer.valueOf(city)))
/*     */     {
/* 439 */       onFailed(19);
/* 440 */       return false;
/*     */     }
/*     */     
/* 443 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkHobbies(ArrayList<Integer> hobbies)
/*     */   {
/* 448 */     if (hobbies.size() == 0)
/*     */     {
/* 450 */       return true;
/*     */     }
/*     */     
/* 453 */     if (hobbies.size() > PersonalConsts.getInstance().MAX_HOBBY)
/*     */     {
/* 455 */       onFailed(21);
/* 456 */       return false;
/*     */     }
/*     */     
/* 459 */     int optionId = SPersonalCfg.get(16).optionId;
/* 460 */     if (!PersonalOptionCfg.get(optionId).optionCfgIds.containsAll(hobbies))
/*     */     {
/* 462 */       onFailed(20);
/* 463 */       return false;
/*     */     }
/*     */     
/* 466 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean checkPhotos(ArrayList<Integer> photos)
/*     */   {
/* 472 */     if (!photos.isEmpty())
/*     */     {
/* 474 */       onFailed(22);
/* 475 */       return false;
/*     */     }
/* 477 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PCEditPersonalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */