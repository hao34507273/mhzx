/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.link.Onlines;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.personal.Birthday;
/*     */ import mzm.gsp.personal.Location;
/*     */ import mzm.gsp.personal.confbean.PersonalConsts;
/*     */ import mzm.gsp.personal.confbean.SPersonalFieldPrecentCfg;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PraiseInfo;
/*     */ import xtable.Role2personal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PersonalManager
/*     */ {
/*     */   static final String ENCODING = "UTF-8";
/*     */   
/*     */   static mzm.gsp.personal.PersonalInfo transInfo(long roleId, xbean.PersonalInfo xPersonalInfo)
/*     */   {
/*  35 */     mzm.gsp.personal.PersonalInfo result = new mzm.gsp.personal.PersonalInfo();
/*     */     
/*  37 */     String userId = RoleInterface.getUserId(roleId);
/*  38 */     String openId = Onlines.getInstance().findOpenid(userId);
/*     */     
/*     */     try
/*     */     {
/*  42 */       result.rolename.setString(RoleInterface.getName(roleId), "UTF-8");
/*  43 */       result.openid.setString(openId, "UTF-8");
/*  44 */       result.sign.setString(xPersonalInfo.getSign(), "UTF-8");
/*  45 */       result.school.setString(xPersonalInfo.getSchool(), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  52 */     result.gender = xPersonalInfo.getGender();
/*  53 */     result.age = xPersonalInfo.getAge();
/*  54 */     result.birthday = getBirthday(xPersonalInfo.getBirthday());
/*  55 */     result.animalsign = xPersonalInfo.getAnimalsign();
/*  56 */     result.constellation = xPersonalInfo.getConstellation();
/*  57 */     result.bloodtype = xPersonalInfo.getBloodtype();
/*  58 */     result.occupation = xPersonalInfo.getOccupation();
/*  59 */     result.location = getLocation(xPersonalInfo.getLocation());
/*  60 */     result.hobbies = new ArrayList(xPersonalInfo.getHobbies());
/*  61 */     result.headimage = PersonalConsts.getInstance().DEFAULT_HEAD_IMAGE_ID;
/*     */     
/*     */ 
/*  64 */     result.photos = new ArrayList(0);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  73 */     result.praisenum = xPersonalInfo.getPraise().getBe_praised_num();
/*  74 */     Role role = RoleInterface.getRole(roleId, true);
/*  75 */     result.onlineseconds = role.getOnlineSeconds();
/*     */     
/*  77 */     result.avatar_frame = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, true);
/*  78 */     return result;
/*     */   }
/*     */   
/*     */   static void initXPersonalInfo(long roleId, xbean.PersonalInfo xPersonalInfo)
/*     */   {
/*  83 */     xPersonalInfo.setHeadimage(String.valueOf(PersonalConsts.getInstance().DEFAULT_HEAD_IMAGE_ID));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int calculateIntegrity(xbean.PersonalInfo xPersonalInfo)
/*     */   {
/*  94 */     int integrity = 0;
/*  95 */     integrity += SPersonalFieldPrecentCfg.get(1).precent;
/*  96 */     if (!xPersonalInfo.getSign().isEmpty())
/*     */     {
/*  98 */       integrity += SPersonalFieldPrecentCfg.get(2).precent;
/*     */     }
/* 100 */     integrity += SPersonalFieldPrecentCfg.get(3).precent;
/* 101 */     if (xPersonalInfo.getGender() != 0)
/*     */     {
/* 103 */       integrity += SPersonalFieldPrecentCfg.get(4).precent;
/*     */     }
/* 105 */     if (xPersonalInfo.getAge() != 0)
/*     */     {
/* 107 */       integrity += SPersonalFieldPrecentCfg.get(5).precent;
/*     */     }
/* 109 */     if (xPersonalInfo.getBirthday() != 0L)
/*     */     {
/* 111 */       integrity += SPersonalFieldPrecentCfg.get(6).precent;
/* 112 */       integrity += SPersonalFieldPrecentCfg.get(7).precent;
/*     */     }
/* 114 */     if (xPersonalInfo.getAnimalsign() != 0)
/*     */     {
/* 116 */       integrity += SPersonalFieldPrecentCfg.get(8).precent;
/*     */     }
/* 118 */     if (xPersonalInfo.getConstellation() != 0)
/*     */     {
/* 120 */       integrity += SPersonalFieldPrecentCfg.get(9).precent;
/*     */     }
/* 122 */     if (xPersonalInfo.getBloodtype() != 0)
/*     */     {
/* 124 */       integrity += SPersonalFieldPrecentCfg.get(10).precent;
/*     */     }
/* 126 */     if (xPersonalInfo.getOccupation() != 0)
/*     */     {
/* 128 */       integrity += SPersonalFieldPrecentCfg.get(11).precent;
/*     */     }
/* 130 */     if (!xPersonalInfo.getSchool().isEmpty())
/*     */     {
/* 132 */       integrity += SPersonalFieldPrecentCfg.get(12).precent;
/*     */     }
/* 134 */     if (xPersonalInfo.getLocation() != 0L)
/*     */     {
/* 136 */       integrity += SPersonalFieldPrecentCfg.get(13).precent;
/* 137 */       integrity += SPersonalFieldPrecentCfg.get(14).precent;
/* 138 */       integrity += SPersonalFieldPrecentCfg.get(15).precent;
/*     */     }
/* 140 */     if (!xPersonalInfo.getHobbies().isEmpty())
/*     */     {
/* 142 */       integrity += SPersonalFieldPrecentCfg.get(16).precent;
/*     */     }
/* 144 */     integrity += SPersonalFieldPrecentCfg.get(17).precent;
/* 145 */     integrity += SPersonalFieldPrecentCfg.get(18).precent;
/* 146 */     return integrity;
/*     */   }
/*     */   
/*     */   private static Birthday getBirthday(long data)
/*     */   {
/* 151 */     Birthday birthday = new Birthday();
/* 152 */     birthday.month = ((int)(data >> 32));
/* 153 */     birthday.day = ((int)data);
/* 154 */     return birthday;
/*     */   }
/*     */   
/*     */   static Location getLocation(long data)
/*     */   {
/* 159 */     Location location = new Location();
/* 160 */     location.province = ((int)(data >> 32));
/* 161 */     location.city = ((int)data);
/* 162 */     return location;
/*     */   }
/*     */   
/*     */   static int getProvince(long data)
/*     */   {
/* 167 */     return (int)(data >> 32);
/*     */   }
/*     */   
/*     */   static int getCity(long data)
/*     */   {
/* 172 */     return (int)data;
/*     */   }
/*     */   
/*     */   static boolean isFunOpen(long roleId)
/*     */   {
/* 177 */     if (!OpenInterface.getOpenStatus(120))
/*     */     {
/* 179 */       return false;
/*     */     }
/* 181 */     if (OpenInterface.isBanPlay(roleId, 120))
/*     */     {
/* 183 */       OpenInterface.sendBanPlayMsg(roleId, 120);
/* 184 */       return false;
/*     */     }
/* 186 */     return true;
/*     */   }
/*     */   
/*     */   static boolean checkRoleStatus(long roleid)
/*     */   {
/* 191 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, 72, true))
/*     */     {
/* 193 */       GameServer.logger().error(String.format("[personal]PersonalManager.checkRoleStatus@status check failed|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/* 195 */       return false;
/*     */     }
/* 197 */     return true;
/*     */   }
/*     */   
/*     */   static String getHeadImageURL(long roleId, boolean remainLock)
/*     */   {
/* 202 */     if (remainLock)
/*     */     {
/* 204 */       xbean.PersonalInfo xPersonalInfo = Role2personal.get(Long.valueOf(roleId));
/* 205 */       if (xPersonalInfo != null)
/*     */       {
/* 207 */         return xPersonalInfo.getHeadimage();
/*     */       }
/* 209 */       return "";
/*     */     }
/*     */     
/*     */ 
/* 213 */     String headImage = Role2personal.selectHeadimage(Long.valueOf(roleId));
/* 214 */     if (headImage == null)
/*     */     {
/* 216 */       return "";
/*     */     }
/* 218 */     return headImage;
/*     */   }
/*     */   
/*     */ 
/*     */   static String getSign(long roleId, boolean remainLock)
/*     */   {
/* 224 */     if (remainLock)
/*     */     {
/* 226 */       xbean.PersonalInfo xPersonalInfo = Role2personal.get(Long.valueOf(roleId));
/* 227 */       if (xPersonalInfo != null)
/*     */       {
/* 229 */         return xPersonalInfo.getSign();
/*     */       }
/* 231 */       return "";
/*     */     }
/*     */     
/*     */ 
/* 235 */     String sign = Role2personal.selectSign(Long.valueOf(roleId));
/* 236 */     if (sign == null)
/*     */     {
/* 238 */       return "";
/*     */     }
/* 240 */     return sign;
/*     */   }
/*     */   
/*     */ 
/*     */   static int getProvince(long roleId, boolean remainLock)
/*     */   {
/* 246 */     if (remainLock)
/*     */     {
/* 248 */       xbean.PersonalInfo xPersonalInfo = Role2personal.get(Long.valueOf(roleId));
/* 249 */       if (xPersonalInfo == null)
/*     */       {
/* 251 */         return -1;
/*     */       }
/*     */       
/* 254 */       long data = xPersonalInfo.getLocation();
/* 255 */       return data == 0L ? -1 : getProvince(data);
/*     */     }
/*     */     
/*     */ 
/* 259 */     Long data = Role2personal.selectLocation(Long.valueOf(roleId));
/* 260 */     if (data == null)
/*     */     {
/* 262 */       return -1;
/*     */     }
/*     */     
/* 265 */     return data.longValue() == 0L ? -1 : getProvince(data.longValue());
/*     */   }
/*     */   
/*     */ 
/*     */   static int getCity(long roleId, boolean remainLock)
/*     */   {
/* 271 */     if (remainLock)
/*     */     {
/* 273 */       xbean.PersonalInfo xPersonalInfo = Role2personal.get(Long.valueOf(roleId));
/* 274 */       if (xPersonalInfo == null)
/*     */       {
/* 276 */         return -1;
/*     */       }
/*     */       
/* 279 */       long data = xPersonalInfo.getLocation();
/* 280 */       return data == 0L ? -1 : getCity(data);
/*     */     }
/*     */     
/*     */ 
/* 284 */     Long data = Role2personal.selectLocation(Long.valueOf(roleId));
/* 285 */     if (data == null)
/*     */     {
/* 287 */       return -1;
/*     */     }
/*     */     
/* 290 */     return data.longValue() == 0L ? -1 : getCity(data.longValue());
/*     */   }
/*     */   
/*     */ 
/*     */   static int getPraisedNum(long roleid, boolean remainLock)
/*     */   {
/* 296 */     xbean.PersonalInfo xPersonalInfo = null;
/* 297 */     if (remainLock)
/*     */     {
/* 299 */       xPersonalInfo = Role2personal.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 303 */       xPersonalInfo = Role2personal.select(Long.valueOf(roleid));
/*     */     }
/*     */     
/* 306 */     if (xPersonalInfo == null)
/*     */     {
/* 308 */       return 0;
/*     */     }
/* 310 */     return xPersonalInfo.getPraise().getPraised_num();
/*     */   }
/*     */   
/*     */   static int getBePraisedNum(long roleid, boolean remainLock)
/*     */   {
/* 315 */     xbean.PersonalInfo xPersonalInfo = null;
/* 316 */     if (remainLock)
/*     */     {
/* 318 */       xPersonalInfo = Role2personal.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 322 */       xPersonalInfo = Role2personal.select(Long.valueOf(roleid));
/*     */     }
/*     */     
/* 325 */     if (xPersonalInfo == null)
/*     */     {
/* 327 */       return 0;
/*     */     }
/* 329 */     return xPersonalInfo.getPraise().getBe_praised_num();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PersonalManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */