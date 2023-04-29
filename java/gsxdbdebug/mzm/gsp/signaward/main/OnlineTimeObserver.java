/*     */ package mzm.gsp.signaward.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.OnlineAward;
/*     */ import xdb.Executor;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2onlineaward;
/*     */ import xtable.User;
/*     */ 
/*     */ class OnlineTimeObserver extends Observer
/*     */ {
/*  22 */   private static volatile long lastupdatetime = 0L;
/*     */   
/*     */   OnlineTimeObserver(long intervalSeconds)
/*     */   {
/*  26 */     super(intervalSeconds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  33 */     long lastUpdateTime = lastupdatetime;
/*  34 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  36 */     lastupdatetime = now;
/*  37 */     Xdb.executor().execute(new OnlinetimeOutRunnable(now, lastUpdateTime));
/*     */     
/*  39 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class OnlinetimeOutRunnable
/*     */     extends LogicRunnable
/*     */   {
/*     */     private final long now;
/*     */     private final long lastUpdateTime;
/*     */     
/*     */     OnlinetimeOutRunnable(long now, long lastUpdateTime)
/*     */     {
/*  51 */       this.now = now;
/*  52 */       this.lastUpdateTime = lastUpdateTime;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/*  58 */       List<Long> roleList = OnlineManager.getInstance().getAllRolesInWorld();
/*  59 */       Iterator<Long> iterator = roleList.iterator();
/*  60 */       while (iterator.hasNext())
/*     */       {
/*  62 */         long roleid = ((Long)iterator.next()).longValue();
/*  63 */         new OnlineTimeObserver.OnlinetimeOutPro(roleid, this.lastUpdateTime, this.now).call();
/*  64 */         iterator.remove();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getLastupdatetime()
/*     */   {
/*  78 */     return lastupdatetime;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class OnlinetimeOutPro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     private final long lastUpdateTime;
/*     */     private final long now;
/*     */     
/*     */     public OnlinetimeOutPro(long roleid, long lastUpdateTime, long now)
/*     */     {
/*  92 */       this.roleid = roleid;
/*     */       
/*  94 */       this.lastUpdateTime = lastUpdateTime;
/*     */       
/*  96 */       this.now = now;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 103 */       String userId = RoleInterface.getUserId(this.roleid);
/* 104 */       if (null != userId)
/*     */       {
/* 106 */         Lockeys.lock(Lockeys.get(User.getTable(), userId));
/*     */       }
/*     */       
/* 109 */       long interval = TimeUnit.MILLISECONDS.toSeconds(this.now - this.lastUpdateTime);
/* 110 */       OnlineAward xOnlineAward = Role2onlineaward.get(Long.valueOf(this.roleid));
/* 111 */       if (xOnlineAward == null)
/*     */       {
/*     */ 
/* 114 */         String logstr = String.format("[onlineaward]OnlinetimeOutPro.processImp@xOnlineAward null,should not run to here|roleid=%d|now=%s", new Object[] { Long.valueOf(this.roleid), DateTimeUtils.formatTimestamp(this.now) });
/*     */         
/*     */ 
/* 117 */         SignAwardManager.logger.error(logstr);
/* 118 */         return false;
/*     */       }
/*     */       
/* 121 */       if ((!DateTimeUtils.isInSameDay(xOnlineAward.getLogintime(), this.now)) && (this.now > xOnlineAward.getLogintime()))
/*     */       {
/* 123 */         SignAwardManager.resetOnlineAward(xOnlineAward, this.now);
/*     */       }
/* 125 */       long logintime = xOnlineAward.getLogintime();
/* 126 */       if (logintime + TimeUnit.SECONDS.toMillis(interval) < this.now)
/*     */       {
/* 128 */         xOnlineAward.setOnlinetime(interval + xOnlineAward.getOnlinetime());
/*     */         
/* 130 */         String logstr = String.format("[onlineaward]OnlinetimeOutPro.processImp@add role online time|roleid=%d|logintime=%s|addtime=%d|totaltime=%d", new Object[] { Long.valueOf(this.roleid), DateTimeUtils.formatTimestamp(logintime), Long.valueOf(interval), Long.valueOf(xOnlineAward.getOnlinetime()) });
/*     */         
/*     */ 
/* 133 */         SignAwardManager.logger.info(logstr);
/*     */       }
/*     */       else
/*     */       {
/* 137 */         long addnum = TimeUnit.MILLISECONDS.toSeconds(this.now - logintime);
/*     */         
/* 139 */         xOnlineAward.setOnlinetime(addnum + xOnlineAward.getOnlinetime());
/* 140 */         String logstr = String.format("[onlineaward]OnlinetimeOutPro.processImp@add role online time|roleid=%d|logintime=%s|addtime=%d|totaltime=%d", new Object[] { Long.valueOf(this.roleid), DateTimeUtils.formatTimestamp(logintime), Long.valueOf(addnum), Long.valueOf(xOnlineAward.getOnlinetime()) });
/*     */         
/*     */ 
/* 143 */         SignAwardManager.logger.info(logstr);
/*     */       }
/*     */       
/* 146 */       if (SignAwardManager.hasOnlineTimeAward(xOnlineAward))
/*     */       {
/* 148 */         int onlinetime = (int)xOnlineAward.getOnlinetime();
/* 149 */         SignAwardManager.sendSSynOnlineTimeRes(this.roleid, onlinetime);
/* 150 */         SignAwardManager.sendSSynAwardedRes(this.roleid, xOnlineAward, null);
/*     */       }
/*     */       
/*     */ 
/* 154 */       Role role = RoleInterface.getRole(this.roleid, true);
/* 155 */       long onlineMilliSec = this.now - role.getLastLoginTime();
/* 156 */       if (onlineMilliSec % 3600000L <= TimeUnit.SECONDS.toMillis(interval))
/*     */       {
/* 158 */         long OnlineHour = onlineMilliSec / 3600000L;
/* 159 */         mzm.gsp.achievement.main.AchievementInterface.updateGoalTypeState(this.roleid, 3306, Integer.valueOf((int)OnlineHour), "OnlinetimeOutPro.processImp@handle ONLINE_TIME success");
/*     */       }
/*     */       
/*     */ 
/* 163 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\OnlineTimeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */