/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.personal.ConditionInfo;
/*     */ import mzm.gsp.personal.confbean.SNSConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.AdvertInfo;
/*     */ import xbean.AdvertObserver;
/*     */ import xbean.NoneRealTimeSnsRoles;
/*     */ import xbean.PersonalInfo;
/*     */ import xtable.Advert;
/*     */ import xtable.Nonerealtimesnsroles;
/*     */ import xtable.Role2personal;
/*     */ 
/*     */ public class SNSManager
/*     */ {
/*     */   static final String ENCODING = "UTF-8";
/*     */   private static final int SAVE_DB_INTERVAL_SEC = 300;
/*     */   static final String TLOG_RELEASE_ADVERT = "ReleaseAdvert";
/*     */   static final String TLOG_DELETE_ADVERT = "DeleteAdvert";
/*     */   
/*     */   static void init()
/*     */   {
/*  38 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  40 */       return;
/*     */     }
/*     */     
/*  43 */     new ActiveRoleIdSaveDBObserver(300L);
/*  44 */     new SNSInit(null).call();
/*     */   }
/*     */   
/*     */   private static class SNSInit
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  53 */       NoneRealTimeSnsRoles xNoneRealTimeSnsRoles = Nonerealtimesnsroles.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  54 */       if (xNoneRealTimeSnsRoles == null)
/*     */       {
/*  56 */         return true;
/*     */       }
/*     */       
/*  59 */       long now = System.currentTimeMillis();
/*  60 */       long validMilliSecs = TimeUnit.MINUTES.toMillis(SNSConsts.getInstance().VALID_MAX_TIME);
/*  61 */       List<Long> roleIds = xNoneRealTimeSnsRoles.getRoleids();
/*  62 */       for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/*  64 */         PersonalInfo xPersonalInfo = Role2personal.select(Long.valueOf(roleId));
/*  65 */         if (xPersonalInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  70 */           int realGender = xPersonalInfo.getGender();
/*  71 */           int province = PersonalManager.getProvince(xPersonalInfo.getLocation());
/*  72 */           int level = RoleInterface.getLevel(roleId);
/*  73 */           int integrity = PersonalManager.calculateIntegrity(xPersonalInfo);
/*     */           
/*  75 */           boolean first = true;
/*  76 */           for (Map.Entry<Integer, Long> entry : xPersonalInfo.getAdverts().entrySet())
/*     */           {
/*  78 */             long advertId = ((Long)entry.getValue()).longValue();
/*  79 */             int advertType = ((Integer)entry.getKey()).intValue();
/*  80 */             AdvertInfo xAdvertInfo = Advert.select(Long.valueOf(advertId));
/*  81 */             long releaseTimestamp = xAdvertInfo.getRelease_timestamp();
/*     */             
/*  83 */             long intervalSeconds = TimeUnit.MILLISECONDS.toSeconds(releaseTimestamp + validMilliSecs - now);
/*  84 */             if (intervalSeconds <= 0L)
/*     */             {
/*  86 */               new SNSManager.PForceDeleteAdvert(advertType, roleId, advertId).execute();
/*     */             }
/*     */             else
/*     */             {
/*  90 */               if (first)
/*     */               {
/*  92 */                 int headImage = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(roleId, false);
/*  93 */                 int avatarFrameId = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/*  94 */                 String name = RoleInterface.getName(roleId);
/*  95 */                 int gender = RoleInterface.getGender(roleId);
/*  96 */                 int occupationId = RoleInterface.getOccupationId(roleId);
/*  97 */                 RoleData roleData = new RoleData(roleId, headImage, realGender, level, name, gender, occupationId, avatarFrameId);
/*     */                 
/*  99 */                 AdvertDataCache.getInstance().put(roleData);
/* 100 */                 first = false;
/*     */               }
/*     */               
/*     */ 
/* 104 */               AdvertData advertData = new AdvertData(advertId, advertType, xAdvertInfo.getContent(), releaseTimestamp);
/*     */               
/* 106 */               AdvertDataCache.getInstance().put(advertData);
/*     */               
/*     */ 
/* 109 */               AdvertChart advertChart = new AdvertChart(roleId, advertId, integrity, releaseTimestamp);
/* 110 */               AdvertChartCache.getInstance().put(advertId, advertChart);
/*     */               
/*     */ 
/* 113 */               FilterInfo filterInfo = new FilterInfo(advertType, level, realGender, province);
/* 114 */               SNSIndexManager.getInstance().addAdvert(advertId, filterInfo);
/*     */               
/*     */ 
/* 117 */               new SNSManager.PAddDeleteAdvertObserver(advertType, roleId, advertId, intervalSeconds).execute();
/*     */             }
/*     */           }
/*     */           
/* 121 */           ActiveRoleIdLRU.getInstance().add(roleId);
/*     */         }
/*     */       }
/* 124 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PAddDeleteAdvertObserver extends LogicProcedure
/*     */   {
/*     */     private final int advertType;
/*     */     private final long roleId;
/*     */     private final long advertId;
/*     */     private final long intervalSeconds;
/*     */     
/*     */     public PAddDeleteAdvertObserver(int advertType, long roleId, long advertId, long intervalSeconds)
/*     */     {
/* 137 */       this.advertType = advertType;
/* 138 */       this.roleId = roleId;
/* 139 */       this.advertId = advertId;
/* 140 */       this.intervalSeconds = intervalSeconds;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 146 */       AdvertObserver advertObserver = xbean.Pod.newAdvertObserver();
/* 147 */       xtable.Advertobservers.insert(Long.valueOf(this.advertId), advertObserver);
/* 148 */       advertObserver.setObserver(new DeleteAdvertObserver(this.advertType, this.roleId, this.advertId, this.intervalSeconds));
/* 149 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PForceDeleteAdvert
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int advertType;
/*     */     private final long roleId;
/*     */     private final long advertId;
/*     */     
/*     */     public PForceDeleteAdvert(int advertType, long roleId, long advertId)
/*     */     {
/* 162 */       this.advertType = advertType;
/* 163 */       this.roleId = roleId;
/* 164 */       this.advertId = advertId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 171 */       PersonalInfo xPersonalInfo = Role2personal.get(Long.valueOf(this.roleId));
/* 172 */       xPersonalInfo.getAdverts().remove(Integer.valueOf(this.advertType));
/*     */       
/* 174 */       Advert.remove(Long.valueOf(this.advertId));
/* 175 */       SNSManager.tlogDeleteAdvert(this.roleId, this.advertId, this.advertType, 2);
/* 176 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFunOpen(long roleId)
/*     */   {
/* 186 */     if (!OpenInterface.getOpenStatus(140))
/*     */     {
/* 188 */       return false;
/*     */     }
/* 190 */     if (OpenInterface.isBanPlay(roleId, 140))
/*     */     {
/* 192 */       OpenInterface.sendBanPlayMsg(roleId, 140);
/* 193 */       return false;
/*     */     }
/* 195 */     return true;
/*     */   }
/*     */   
/*     */   static boolean checkRoleStatus(long roleid)
/*     */   {
/* 200 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, 73, true))
/*     */     {
/* 202 */       mzm.gsp.GameServer.logger().error(String.format("[personal]SNSManager.checkRoleStatus@status check failed|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/* 204 */       return false;
/*     */     }
/* 206 */     return true;
/*     */   }
/*     */   
/*     */   static void tlogDeleteAdvert(long roleId, long advertId, int advertType, int delType)
/*     */   {
/* 211 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 212 */     String userId = RoleInterface.getUserId(roleId);
/* 213 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 215 */     TLogManager.getInstance().addLog(userId, "DeleteAdvert", new Object[] { vGameIp, userId, Long.valueOf(roleId), Integer.valueOf(roleLevel), Long.valueOf(advertId), Integer.valueOf(advertType), Integer.valueOf(delType) });
/*     */   }
/*     */   
/*     */ 
/*     */   static Set<Long> getDesireMasters()
/*     */   {
/* 221 */     int limitLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel() + RoleCommonConstants.getInstance().ROLE_LEVEL_MORE_THAN_SERVER_LEVEL;
/*     */     
/* 223 */     ConditionInfo queryConditionInfo = new ConditionInfo();
/* 224 */     queryConditionInfo.gender = -1;
/* 225 */     queryConditionInfo.location = -1;
/* 226 */     queryConditionInfo.minlevel = 1;
/* 227 */     queryConditionInfo.maxlevel = limitLevel;
/*     */     
/* 229 */     SearchInfo searchInfo = new SearchInfo(SNSConsts.getInstance().DESIRE_MASTER_SUB_TYPE_ID, queryConditionInfo);
/* 230 */     AdvertRank advertRank = new AdvertRank(0, SNSConsts.getInstance().PAGE_SIZE);
/*     */     
/* 232 */     Collection<Long> advertIds = SNSIndexManager.getInstance().searchAdvertIds(searchInfo);
/* 233 */     if ((advertIds == null) || (advertIds.isEmpty()))
/*     */     {
/* 235 */       return Collections.emptySet();
/*     */     }
/*     */     
/* 238 */     AdvertChartCache.getInstance().buildRank(advertIds, advertRank);
/* 239 */     Set<Long> result = new java.util.HashSet();
/* 240 */     for (AdvertChart chartObj : advertRank.getAllChartObjs())
/*     */     {
/* 242 */       result.add(Long.valueOf(chartObj.getRoleId()));
/*     */     }
/* 244 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\SNSManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */