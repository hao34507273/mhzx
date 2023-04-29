/*     */ package mzm.gsp.msdkprofile.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MSDKProfileManager
/*     */ {
/*     */   public static final String TLOG_WECHAT_LEVEL_RANK_FLOW = "LevelRankFlow";
/*     */   public static final String TLOG_WECHAT_FLOWER_RANK_FLOW = "FlowerRankFlow";
/*     */   public static final String TLOG_WECHAT_FIGHT_VALUE_RANK_FLOW = "FightValueRankFlow";
/*     */   private static final int MIN_MINUTE = 5;
/*     */   private static final int MAX_MINUTE = 15;
/*  23 */   static final Map<String, Reporter> reporters = new HashMap();
/*     */   
/*     */   static
/*     */   {
/*  27 */     if (!GameServerInfoManager.isRoamServer())
/*     */     {
/*  29 */       reporters.put("wechat", new mzm.gsp.msdkprofile.main.wechat.ReporterImp());
/*  30 */       reporters.put("qq", new mzm.gsp.msdkprofile.main.qq.ReporterImp());
/*     */     }
/*     */   }
/*     */   
/*     */   static void init()
/*     */   {
/*  36 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  38 */       return;
/*     */     }
/*     */     
/*     */ 
/*  42 */     Random random = Xdb.random();
/*  43 */     int num = 5 + random.nextInt(11);
/*  44 */     new OnlineTimeObserver(TimeUnit.MINUTES.toSeconds(num));
/*     */   }
/*     */   
/*     */   private static Reporter getReporter(String userid)
/*     */   {
/*  49 */     String platName = CommonUtils.getPlatName(userid);
/*  50 */     if (platName == null)
/*     */     {
/*  52 */       return null;
/*     */     }
/*  54 */     return (Reporter)reporters.get(platName);
/*     */   }
/*     */   
/*     */   static boolean reportRoleLevel(String userid, long roleid, int level)
/*     */   {
/*  59 */     String platName = CommonUtils.getPlatName(userid);
/*  60 */     if (platName == null)
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     Reporter reporter = (Reporter)reporters.get(platName);
/*  66 */     if (reporter == null)
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     return reporter.reportRoleLevel(userid, roleid, level);
/*     */   }
/*     */   
/*     */   static boolean reportRoleCash(String userid, long roleid, long cash)
/*     */   {
/*  76 */     Reporter reporter = getReporter(userid);
/*  77 */     if (reporter == null)
/*     */     {
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     return reporter.reportRoleCash(userid, roleid, cash);
/*     */   }
/*     */   
/*     */   static boolean reportRoleRankScore(String userid, long roleid, int rankScore, long expire)
/*     */   {
/*  87 */     Reporter reporter = getReporter(userid);
/*  88 */     if (reporter == null)
/*     */     {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     return reporter.reportRoleRankScore(userid, roleid, rankScore, expire);
/*     */   }
/*     */   
/*     */   static boolean reportRoleLogin(String userid, long roleid)
/*     */   {
/*  98 */     Reporter reporter = getReporter(userid);
/*  99 */     if (reporter == null)
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     return reporter.reportRoleLogin(userid, roleid);
/*     */   }
/*     */   
/*     */   static boolean reportRoleFightValue(String userid, long roleid, int fightValue)
/*     */   {
/* 109 */     Reporter reporter = getReporter(userid);
/* 110 */     if (reporter == null)
/*     */     {
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     return reporter.reportRoleFightValue(userid, roleid, fightValue);
/*     */   }
/*     */   
/*     */   static boolean reportRoleCreate(String userid, long roleid)
/*     */   {
/* 120 */     Reporter reporter = getReporter(userid);
/* 121 */     if (reporter == null)
/*     */     {
/* 123 */       return false;
/*     */     }
/* 125 */     return reporter.reportRoleCreate(userid, roleid);
/*     */   }
/*     */   
/*     */   static boolean reportRoleName(String userid, long roleid)
/*     */   {
/* 130 */     Reporter reporter = getReporter(userid);
/* 131 */     if (reporter == null)
/*     */     {
/* 133 */       return false;
/*     */     }
/* 135 */     return reporter.reportRoleName(userid, roleid);
/*     */   }
/*     */   
/*     */   static boolean reportRoleRecharge(String userid, long roleid, long oldSaveAmt, long currSaveAmt)
/*     */   {
/* 140 */     Reporter reporter = getReporter(userid);
/* 141 */     if (reporter == null)
/*     */     {
/* 143 */       return false;
/*     */     }
/* 145 */     return reporter.reportRoleRecharge(userid, roleid, oldSaveAmt, currSaveAmt);
/*     */   }
/*     */   
/*     */   static boolean reportGangName(String userid, long roleid, long gangId, String gangName)
/*     */   {
/* 150 */     Reporter reporter = getReporter(userid);
/* 151 */     if (reporter == null)
/*     */     {
/* 153 */       return false;
/*     */     }
/* 155 */     return reporter.reportGangName(userid, roleid, gangId, gangName);
/*     */   }
/*     */   
/*     */   static boolean reportGangLevel(String userid, long roleid, long gangId, int gangLevel)
/*     */   {
/* 160 */     Reporter reporter = getReporter(userid);
/* 161 */     if (reporter == null)
/*     */     {
/* 163 */       return false;
/*     */     }
/* 165 */     return reporter.reportGangLevel(userid, roleid, gangId, gangLevel);
/*     */   }
/*     */   
/*     */   static boolean reportGangCreate(String userid, long bangZhuRoleId, long gangId)
/*     */   {
/* 170 */     Reporter reporter = getReporter(userid);
/* 171 */     if (reporter == null)
/*     */     {
/* 173 */       return false;
/*     */     }
/* 175 */     return reporter.reportGangCreate(userid, bangZhuRoleId, gangId);
/*     */   }
/*     */   
/*     */   static boolean reportGangDestory(String userid, long bangZhuRoleId, long gangId)
/*     */   {
/* 180 */     Reporter reporter = getReporter(userid);
/* 181 */     if (reporter == null)
/*     */     {
/* 183 */       return false;
/*     */     }
/* 185 */     return reporter.reportGangDestory(userid, bangZhuRoleId, gangId);
/*     */   }
/*     */   
/*     */   static boolean reportGangMemberJoin(String userid, long roleid, long gangId)
/*     */   {
/* 190 */     Reporter reporter = getReporter(userid);
/* 191 */     if (reporter == null)
/*     */     {
/* 193 */       return false;
/*     */     }
/*     */     
/* 196 */     return reporter.reportGangMemberJoin(userid, roleid, gangId);
/*     */   }
/*     */   
/*     */   static boolean reportGangMemberExit(String userid, long roleid, long gangId)
/*     */   {
/* 201 */     Reporter reporter = getReporter(userid);
/* 202 */     if (reporter == null)
/*     */     {
/* 204 */       return false;
/*     */     }
/*     */     
/* 207 */     return reporter.reportGangMemberExit(userid, roleid, gangId);
/*     */   }
/*     */   
/*     */   static boolean reportGangPositionChange(String userid, long roleid, long gangId, int duty)
/*     */   {
/* 212 */     Reporter reporter = getReporter(userid);
/* 213 */     if (reporter == null)
/*     */     {
/* 215 */       return false;
/*     */     }
/* 217 */     return reporter.reportGangPositionChange(userid, roleid, gangId, duty);
/*     */   }
/*     */   
/*     */   static boolean reportGangBindQQ(String userid, long roleid, long gangId, String qq)
/*     */   {
/* 222 */     Reporter reporter = getReporter(userid);
/* 223 */     if (reporter == null)
/*     */     {
/* 225 */       return false;
/*     */     }
/* 227 */     return reporter.reportGangBindQQ(userid, roleid, gangId, qq);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean reportGangMemberAbility(String userid, long roleid, long gangId, int value)
/*     */   {
/* 233 */     Reporter reporter = getReporter(userid);
/* 234 */     if (reporter == null)
/*     */     {
/* 236 */       return false;
/*     */     }
/* 238 */     return reporter.reportGangMemberAbility(userid, roleid, gangId, value);
/*     */   }
/*     */   
/*     */   static void reportRoleOnlineSecondsAsync(long roleid, int seconds)
/*     */   {
/* 243 */     new PReportOnlineTime(roleid, seconds).execute();
/*     */   }
/*     */   
/*     */   private static class PReportOnlineTime
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int onlineSeconds;
/*     */     
/*     */     public PReportOnlineTime(long roleid, int onlineSeconds)
/*     */     {
/* 254 */       this.roleid = roleid;
/* 255 */       this.onlineSeconds = onlineSeconds;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 261 */       String userid = RoleInterface.getUserId(this.roleid);
/* 262 */       return MSDKProfileManager.reportRoleOnlineSeconds(userid, this.roleid, this.onlineSeconds);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean reportRoleOnlineSeconds(String userid, long roleid, int seconds)
/*     */   {
/* 269 */     Reporter reporter = getReporter(userid);
/* 270 */     if (reporter == null)
/*     */     {
/* 272 */       return false;
/*     */     }
/* 274 */     return reporter.reportRoleOnlineSeconds(userid, roleid, seconds);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\MSDKProfileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */