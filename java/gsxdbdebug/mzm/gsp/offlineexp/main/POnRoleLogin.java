/*     */ package mzm.gsp.offlineexp.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.SSyncOfflineExpReward;
/*     */ import mzm.gsp.award.confbean.OfflineExpAward;
/*     */ import mzm.gsp.award.confbean.OfflineExpRewardConsts;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.OfflineExpReward;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2offlineexpreward;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   @Deprecated
/*     */   protected boolean processImpOld() throws Exception
/*     */   {
/*  31 */     String userid = getUserLock(((Long)this.arg).longValue());
/*     */     
/*  33 */     int level = RoleInterface.getLevel(((Long)this.arg).longValue());
/*  34 */     if (level < OfflineExpRewardConsts.getInstance().OPEN_LEVEL)
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     OfflineExpReward xOfflineTime = getXOffExpData();
/*  39 */     long logoffTime = RoleInterface.getLastLogoffTime(((Long)this.arg).longValue());
/*  40 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  41 */     Calendar logoffCal = Calendar.getInstance();
/*  42 */     Calendar nowCal = Calendar.getInstance();
/*  43 */     logoffCal.setTimeInMillis(logoffTime);
/*  44 */     nowCal.setTimeInMillis(now);
/*  45 */     if ((logoffCal.get(6) != nowCal.get(6)) || (logoffCal.get(1) != nowCal.get(1)))
/*     */     {
/*     */ 
/*  48 */       long dayBegin = getDayBeginMills(nowCal);
/*  49 */       long dif = now - dayBegin;
/*  50 */       long avaliableTime = dif - TimeUnit.MINUTES.toMillis(OfflineExpRewardConsts.getInstance().OFFLINE_AND_START_DURATION);
/*     */       
/*  52 */       if (avaliableTime <= 0L)
/*  53 */         return false;
/*  54 */       avaliableTime = Math.min(dif, TimeUnit.MINUTES.toMillis(OfflineExpRewardConsts.getInstance().ONCE_MAX_OFFLINE_TIME));
/*  55 */       xOfflineTime.setDayofflinetime(avaliableTime);
/*  56 */       awardExp(userid, avaliableTime, level);
/*  57 */       return true;
/*     */     }
/*  59 */     long dif = now - logoffTime;
/*  60 */     long avaliableTime = dif - TimeUnit.MINUTES.toMillis(OfflineExpRewardConsts.getInstance().OFFLINE_AND_START_DURATION);
/*  61 */     if (avaliableTime <= 0L)
/*  62 */       return false;
/*  63 */     avaliableTime = Math.min(dif, TimeUnit.MINUTES.toMillis(OfflineExpRewardConsts.getInstance().ONCE_MAX_OFFLINE_TIME));
/*  64 */     long alreadyOfflineTime = xOfflineTime.getDayofflinetime();
/*  65 */     long totalMinute = avaliableTime + xOfflineTime.getDayofflinetime();
/*  66 */     totalMinute = Math.min(totalMinute, TimeUnit.MINUTES.toMillis(OfflineExpRewardConsts.getInstance().DAY_MAX_OFFLINE_TIME));
/*     */     
/*  68 */     avaliableTime = totalMinute - alreadyOfflineTime;
/*  69 */     xOfflineTime.setDayofflinetime(avaliableTime);
/*  70 */     awardExp(userid, avaliableTime, level);
/*  71 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  80 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  82 */       GameServer.logger().info(String.format("[offlineexp]POnRoleLogin.processImp@ isRoamServer, can not add offline exp!|roleId=%d", new Object[] { this.arg }));
/*     */       
/*  84 */       return false;
/*     */     }
/*  86 */     int level = RoleInterface.getLevel(((Long)this.arg).longValue());
/*  87 */     if (level < OfflineExpRewardConsts.getInstance().OPEN_LEVEL)
/*     */     {
/*  89 */       return false;
/*     */     }
/*  91 */     String userid = getUserLock(((Long)this.arg).longValue());
/*  92 */     OfflineExpReward xOfflineTime = getXOffExpData();
/*     */     
/*  94 */     long avaliableMills = getAwardMills(xOfflineTime, DateTimeUtils.getCurrTimeInMillis(), lastZeroTime());
/*  95 */     if (avaliableMills <= 0L)
/*     */     {
/*  97 */       return false;
/*     */     }
/*  99 */     xOfflineTime.setDayofflinetime(avaliableMills + xOfflineTime.getDayofflinetime());
/* 100 */     awardExp(userid, avaliableMills, level);
/* 101 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String getUserLock(long roleId)
/*     */   {
/* 111 */     String userid = RoleInterface.getUserId(roleId);
/* 112 */     lock(Lockeys.get(User.getTable(), userid));
/* 113 */     return userid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private long getAwardMills(OfflineExpReward xOfflineTime, long now, long lastZeroTime)
/*     */   {
/* 128 */     if (isZero(now, lastZeroTime))
/*     */     {
/* 130 */       String info = String.format("[offlineexp]POnRoleLogin.getAwardMills@ in zero income state!|roleId=%d", new Object[] { this.arg });
/* 131 */       GameServer.logger().info(info);
/* 132 */       return 0L;
/*     */     }
/* 134 */     long logOffMills = Math.max(lastZeroTime, logOffTimeThisDay(RoleInterface.getLastLogoffTime(((Long)this.arg).longValue()), now, xOfflineTime));
/* 135 */     return getAwardDuration(now, logOffMills, xOfflineTime.getDayofflinetime());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private OfflineExpReward getXOffExpData()
/*     */   {
/* 147 */     OfflineExpReward xOfflineTime = Role2offlineexpreward.get((Long)this.arg);
/* 148 */     if (xOfflineTime == null)
/*     */     {
/* 150 */       xOfflineTime = xbean.Pod.newOfflineExpReward();
/* 151 */       Role2offlineexpreward.add((Long)this.arg, xOfflineTime);
/*     */     }
/* 153 */     return xOfflineTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getAwardDuration(long now, long logOffMills, long alAwardMills)
/*     */   {
/* 169 */     long difMills = now - logOffMills;
/* 170 */     if (difMills < getMinAwardMills())
/*     */     {
/* 172 */       return 0L;
/*     */     }
/* 174 */     return getTotalMinute(alAwardMills, difMills) - alAwardMills;
/*     */   }
/*     */   
/*     */   private long getTotalMinute(long alAwardMills, long difMills)
/*     */   {
/* 179 */     long totalMinute = Math.min(difMills, getOneMaxAwardMills()) + alAwardMills;
/* 180 */     return Math.min(totalMinute, getDayMaxAwardMills());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long logOffTimeThisDay(long logoffTime, long now, OfflineExpReward xOfflineTime)
/*     */   {
/* 195 */     if (isSameDay(logoffTime, now))
/*     */     {
/* 197 */       return logoffTime;
/*     */     }
/* 199 */     xOfflineTime.setDayofflinetime(0L);
/* 200 */     return DateTimeUtils.getBeginTimeOfCurrDay(now);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long lastZeroTime()
/*     */   {
/* 210 */     return mzm.gsp.idip.main.IdipManager.zeroProfitExpireTime(((Long)this.arg).longValue());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isZero(long now, long zeroExpireTime)
/*     */   {
/* 222 */     return zeroExpireTime > now;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isSameDay(long t1, long t2)
/*     */   {
/* 234 */     return DateTimeUtils.isInSameDay(t1, t2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isSameDay_del(long t1, long t2)
/*     */   {
/* 248 */     Calendar c1 = Calendar.getInstance();
/* 249 */     Calendar c2 = Calendar.getInstance();
/* 250 */     c1.setTimeInMillis(t1);
/* 251 */     c2.setTimeInMillis(t2);
/* 252 */     return isSameDay(c1, c2);
/*     */   }
/*     */   
/*     */   private boolean isSameDay(Calendar c1, Calendar c2)
/*     */   {
/* 257 */     if (c1.get(6) != c2.get(6))
/*     */     {
/* 259 */       return false;
/*     */     }
/* 261 */     if (c1.get(1) != c2.get(1))
/*     */     {
/* 263 */       return false;
/*     */     }
/* 265 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private long getDayBeginMills(Calendar nowCal)
/*     */   {
/* 276 */     nowCal.set(11, 0);
/* 277 */     nowCal.set(12, 0);
/* 278 */     nowCal.set(13, 0);
/* 279 */     nowCal.set(14, 0);
/* 280 */     return nowCal.getTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void awardExp(String userid, long avaliableTime, int level)
/*     */   {
/* 292 */     OfflineExpAward awardCfg = findMatchLevel(level);
/* 293 */     if (awardCfg == null)
/*     */     {
/* 295 */       return;
/*     */     }
/* 297 */     int offlineMinute = (int)TimeUnit.MILLISECONDS.toMinutes(avaliableTime);
/* 298 */     if (offlineMinute <= 0)
/*     */     {
/* 300 */       return;
/*     */     }
/* 302 */     int rewardExp = awardCfg.expPerMinute * offlineMinute;
/* 303 */     RoleInterface.addExp(userid, ((Long)this.arg).longValue(), rewardExp, new TLogArg(LogReason.ROLE_OFFLINE_EXP_ADD));
/*     */     
/* 305 */     noticeClient(offlineMinute, rewardExp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void noticeClient(int offlineMinute, int rewardExp)
/*     */   {
/* 316 */     sendOLAwardPro(offlineMinute, rewardExp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void sendOLAwardPro(int offlineMinute, int rewardExp)
/*     */   {
/* 330 */     SSyncOfflineExpReward sSyncOfflineExpReward = new SSyncOfflineExpReward();
/* 331 */     sSyncOfflineExpReward.offlineminute = offlineMinute;
/* 332 */     sSyncOfflineExpReward.rewardexp = rewardExp;
/* 333 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncOfflineExpReward);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private OfflineExpAward findMatchLevel(int level)
/*     */   {
/* 344 */     for (OfflineExpAward offlineExpAward : OfflineExpAward.getAll().values())
/*     */     {
/* 346 */       if ((offlineExpAward.levelMax >= level) && (offlineExpAward.levelMin <= level))
/*     */       {
/* 348 */         return offlineExpAward;
/*     */       }
/*     */     }
/* 351 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void sendAddOfflineExpTipMail(long roleId, int offMin, int rewardExp)
/*     */   {
/* 363 */     List<String> contentArgs = new ArrayList();
/* 364 */     contentArgs.add(String.valueOf(offMin));
/* 365 */     contentArgs.add(String.valueOf(rewardExp));
/* 366 */     TLogArg logArg = new TLogArg(LogReason.AWARD_OFFLINE_EXP_TIP_MAIL);
/* 367 */     MailInterface.synBuildAndSendMail(roleId, getOfflineExpTipMailId(), new ArrayList(), contentArgs, logArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getOfflineExpTipMailId()
/*     */   {
/* 377 */     return OfflineExpRewardConsts.getInstance().OFFLINE_EXP_TIP_MAILID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getDayMaxAwardMills()
/*     */   {
/* 387 */     return TimeUnit.MINUTES.toMillis(OfflineExpRewardConsts.getInstance().DAY_MAX_OFFLINE_TIME);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getOneMaxAwardMills()
/*     */   {
/* 397 */     return TimeUnit.MINUTES.toMillis(OfflineExpRewardConsts.getInstance().ONCE_MAX_OFFLINE_TIME);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getMinAwardMills()
/*     */   {
/* 407 */     return TimeUnit.MINUTES.toMillis(OfflineExpRewardConsts.getInstance().OFFLINE_AND_START_DURATION);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\offlineexp\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */