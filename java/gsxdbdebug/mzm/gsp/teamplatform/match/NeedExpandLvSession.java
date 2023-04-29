/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.MatchActivityCfg;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class NeedExpandLvSession extends Session
/*     */ {
/*     */   private final int level_low;
/*     */   private final int level_high;
/*     */   private final long roleId;
/*     */   private final long interval;
/*     */   private final int matchType;
/*     */   
/*     */   public NeedExpandLvSession(long interval, long roleId, int level_low, int level_high, int matchType)
/*     */   {
/*  19 */     super(interval, roleId);
/*  20 */     this.level_high = level_high;
/*  21 */     this.level_low = level_low;
/*  22 */     this.roleId = roleId;
/*  23 */     this.interval = interval;
/*  24 */     this.matchType = matchType;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  30 */     MatchNRTimeTaskManager.getInstance().addTask(new NeedExpandLv());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long beginTeamExpandLvSession(long roleId, long interval, int level_low, int level_high, int matchType)
/*     */   {
/*  42 */     NeedExpandLvSession needExpandLvSession = new NeedExpandLvSession(interval, roleId, level_low, level_high, matchType);
/*  43 */     return needExpandLvSession.getSessionId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   class NeedExpandLv
/*     */     extends LogicProcedure
/*     */   {
/*     */     NeedExpandLv() {}
/*     */     
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  59 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(NeedExpandLvSession.this.roleId) }));
/*     */       
/*     */ 
/*  62 */       MatchActivityCfg roleMatchInfo = TeamMatchMananger.getRoleActivity(NeedExpandLvSession.this.roleId, true);
/*  63 */       if (roleMatchInfo == null)
/*     */       {
/*  65 */         return false;
/*     */       }
/*  67 */       if (!checkAndSetNextSession(roleMatchInfo))
/*     */       {
/*     */ 
/*  70 */         return false;
/*     */       }
/*     */       
/*  73 */       switch (NeedExpandLvSession.this.matchType)
/*     */       {
/*     */       case 0: 
/*  76 */         return RoleQueueManager.onRoleNeedLevelChange(NeedExpandLvSession.this.roleId, NeedExpandLvSession.this.level_low, NeedExpandLvSession.this.level_high);
/*     */       case 1: 
/*  78 */         return TeamQueueManager.onLeaderNeedLevelChange(NeedExpandLvSession.this.roleId, NeedExpandLvSession.this.level_low, NeedExpandLvSession.this.level_high);
/*     */       }
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     boolean checkAndSetNextSession(MatchActivityCfg roleMatchInfo)
/*     */     {
/*  91 */       if (NeedExpandLvSession.this.level_high >= 150)
/*     */       {
/*  93 */         return true;
/*     */       }
/*  95 */       int levelLow_now = 1;
/*  96 */       int levelHigh_now = 150;
/*  97 */       NeedExpandLvSession needExpandLvSession = new NeedExpandLvSession(NeedExpandLvSession.this.interval, NeedExpandLvSession.this.roleId, levelLow_now, levelHigh_now, NeedExpandLvSession.this.matchType);
/*     */       
/*  99 */       if (needExpandLvSession.getSessionId() <= 0L)
/*     */       {
/* 101 */         return false;
/*     */       }
/* 103 */       roleMatchInfo.setExpandlvsessionid(needExpandLvSession.getSessionId());
/*     */       
/* 105 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\NeedExpandLvSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */