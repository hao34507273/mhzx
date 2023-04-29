/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.personal.AdvertInfo;
/*     */ 
/*     */ public class AdvertDataCache
/*     */ {
/*  15 */   private static final AdvertDataCache instance = new AdvertDataCache();
/*     */   
/*     */   public static AdvertDataCache getInstance()
/*     */   {
/*  19 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  26 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*  28 */   private final Map<Long, AdvertData> advertDatas = new HashMap();
/*  29 */   private final Map<Long, RoleData> roleDatas = new HashMap();
/*     */   
/*     */   public void remove(long advertId)
/*     */   {
/*  33 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  36 */       this.advertDatas.remove(Long.valueOf(advertId));
/*     */     }
/*     */     finally
/*     */     {
/*  40 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void remove(long advertId, long roleId)
/*     */   {
/*  46 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  49 */       this.advertDatas.remove(Long.valueOf(advertId));
/*  50 */       this.roleDatas.remove(Long.valueOf(roleId));
/*     */     }
/*     */     finally
/*     */     {
/*  54 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void put(AdvertData advertData)
/*     */   {
/*  60 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  63 */       this.advertDatas.put(Long.valueOf(advertData.advertId), advertData);
/*     */     }
/*     */     finally
/*     */     {
/*  67 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void put(RoleData roleData)
/*     */   {
/*  73 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  76 */       this.roleDatas.put(Long.valueOf(roleData.roleId), roleData);
/*     */     }
/*     */     finally
/*     */     {
/*  80 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void put(AdvertData advertData, RoleData roleData)
/*     */   {
/*  86 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  89 */       this.advertDatas.put(Long.valueOf(advertData.advertId), advertData);
/*  90 */       this.roleDatas.put(Long.valueOf(roleData.roleId), roleData);
/*     */     }
/*     */     finally
/*     */     {
/*  94 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void roleLevelChange(long roleId, int newLevel)
/*     */   {
/* 100 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 103 */       RoleData oldRoleData = (RoleData)this.roleDatas.get(Long.valueOf(roleId));
/* 104 */       if (oldRoleData == null) {
/*     */         return;
/*     */       }
/*     */       
/* 108 */       RoleData newRoleData = new RoleData(oldRoleData.roleId, oldRoleData.headImage, oldRoleData.realGender, newLevel, oldRoleData.name, oldRoleData.gender, oldRoleData.occupationId, oldRoleData.avatarFrameId);
/*     */       
/*     */ 
/* 111 */       this.roleDatas.put(Long.valueOf(roleId), newRoleData);
/*     */     }
/*     */     finally
/*     */     {
/* 115 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void roleNameChange(long roleId, String newName)
/*     */   {
/* 121 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 124 */       RoleData oldRoleData = (RoleData)this.roleDatas.get(Long.valueOf(roleId));
/* 125 */       if (oldRoleData == null) {
/*     */         return;
/*     */       }
/*     */       
/* 129 */       RoleData newRoleData = new RoleData(oldRoleData.roleId, oldRoleData.headImage, oldRoleData.realGender, oldRoleData.level, newName, oldRoleData.gender, oldRoleData.occupationId, oldRoleData.avatarFrameId);
/*     */       
/*     */ 
/* 132 */       this.roleDatas.put(Long.valueOf(roleId), newRoleData);
/*     */     }
/*     */     finally
/*     */     {
/* 136 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void roleHeadImageChange(long roleId, int newHeadImage)
/*     */   {
/* 142 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 145 */       RoleData oldRoleData = (RoleData)this.roleDatas.get(Long.valueOf(roleId));
/* 146 */       if (oldRoleData == null) {
/*     */         return;
/*     */       }
/*     */       
/* 150 */       RoleData newRoleData = new RoleData(oldRoleData.roleId, newHeadImage, oldRoleData.realGender, oldRoleData.level, oldRoleData.name, oldRoleData.gender, oldRoleData.occupationId, oldRoleData.avatarFrameId);
/*     */       
/*     */ 
/* 153 */       this.roleDatas.put(Long.valueOf(roleId), newRoleData);
/*     */     }
/*     */     finally
/*     */     {
/* 157 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void roleAvatarFrameChange(long roleId, int avatarFrameId)
/*     */   {
/* 163 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 166 */       RoleData oldRoleData = (RoleData)this.roleDatas.get(Long.valueOf(roleId));
/* 167 */       if (oldRoleData == null) {
/*     */         return;
/*     */       }
/*     */       
/* 171 */       RoleData newRoleData = new RoleData(oldRoleData.roleId, oldRoleData.headImage, oldRoleData.realGender, oldRoleData.level, oldRoleData.name, oldRoleData.gender, oldRoleData.occupationId, avatarFrameId);
/*     */       
/*     */ 
/* 174 */       this.roleDatas.put(Long.valueOf(roleId), newRoleData);
/*     */     }
/*     */     finally
/*     */     {
/* 178 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void roleRealGenderChange(long roleId, int newRealGender)
/*     */   {
/* 184 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 187 */       RoleData oldRoleData = (RoleData)this.roleDatas.get(Long.valueOf(roleId));
/* 188 */       if (oldRoleData == null) {
/*     */         return;
/*     */       }
/*     */       
/* 192 */       RoleData newRoleData = new RoleData(oldRoleData.roleId, oldRoleData.headImage, newRealGender, oldRoleData.level, oldRoleData.name, oldRoleData.gender, oldRoleData.occupationId, oldRoleData.avatarFrameId);
/*     */       
/*     */ 
/* 195 */       this.roleDatas.put(Long.valueOf(roleId), newRoleData);
/*     */     }
/*     */     finally
/*     */     {
/* 199 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public ArrayList<AdvertInfo> buildResp(List<AdvertChart> advertCharts)
/*     */   {
/* 205 */     if (advertCharts.isEmpty())
/*     */     {
/* 207 */       return new ArrayList(0);
/*     */     }
/*     */     
/* 210 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/* 213 */       ArrayList<AdvertInfo> result = new ArrayList(advertCharts.size());
/* 214 */       for (AdvertChart advertChart : advertCharts)
/*     */       {
/* 216 */         AdvertInfo advertInfo = fillAdvertInfo(advertChart);
/* 217 */         if (advertInfo != null)
/*     */         {
/* 219 */           result.add(advertInfo);
/*     */         }
/*     */       }
/* 222 */       return result;
/*     */     }
/*     */     finally
/*     */     {
/* 226 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private AdvertInfo fillAdvertInfo(AdvertChart advertChart)
/*     */   {
/* 232 */     AdvertData advertData = (AdvertData)this.advertDatas.get(Long.valueOf(advertChart.getAdvertId()));
/* 233 */     if (advertData == null)
/*     */     {
/* 235 */       return null;
/*     */     }
/* 237 */     RoleData roleData = (RoleData)this.roleDatas.get(Long.valueOf(advertChart.getRoleId()));
/* 238 */     if (roleData == null)
/*     */     {
/* 240 */       return null;
/*     */     }
/*     */     
/* 243 */     AdvertInfo advertInfo = new AdvertInfo();
/* 244 */     advertInfo.roleid = roleData.roleId;
/* 245 */     advertInfo.headimage = roleData.headImage;
/* 246 */     advertInfo.realgender = roleData.realGender;
/* 247 */     advertInfo.gender = roleData.gender;
/* 248 */     advertInfo.occupationid = roleData.occupationId;
/* 249 */     advertInfo.level = roleData.level;
/*     */     
/* 251 */     advertInfo.advertid = advertData.advertId;
/* 252 */     advertInfo.adverttype = advertData.advertType;
/*     */     try
/*     */     {
/* 255 */       advertInfo.name.setString(roleData.name, "UTF-8");
/* 256 */       advertInfo.content.setString(advertData.content, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 263 */     advertInfo.avatar_frameid = roleData.avatarFrameId;
/* 264 */     return advertInfo;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\AdvertDataCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */