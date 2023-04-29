/*     */ package mzm.gsp.bigboss.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.bigboss.confbean.SBigbossCfgConsts;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BigBoss;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PStartFight
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   
/*     */   public PStartFight(long roleid)
/*     */   {
/*  32 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!BigbossManager.isRoleStateCanJoinBigbossActivity(this.roleid))
/*     */     {
/*  40 */       String logStr = String.format("[bigboss]PStartFight.processImp@role state can not join bigboss activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  42 */       BigbossManager.logger.info(logStr);
/*  43 */       return false;
/*     */     }
/*  45 */     if (!BigbossManager.isBigBossSwitchOpenForRole(this.roleid))
/*     */     {
/*  47 */       String logstr = String.format("[bigboss]PStartFight.processImp@Bigboss switch isclosed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  48 */       BigbossManager.logger.info(logstr);
/*     */       
/*  50 */       return false;
/*     */     }
/*  52 */     int sortid = BigbossManager.getBigbossActivityMonsterSordId();
/*  53 */     if (sortid == -1)
/*     */     {
/*  55 */       BigbossManager.sendErrorInfo(this.roleid, 5);
/*  56 */       return false;
/*     */     }
/*  58 */     int fightid = BigbossManager.getFightId(sortid);
/*  59 */     if (fightid == -1)
/*     */     {
/*  61 */       BigbossManager.sendErrorInfo(this.roleid, 5);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     String userId = RoleInterface.getUserId(this.roleid);
/*  66 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*  67 */     Lockeys.lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  69 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleid, SBigbossCfgConsts.getInstance().ACTIVITYID);
/*     */     
/*  71 */     if (!joinResult.isCanJoin())
/*     */     {
/*  73 */       if (joinResult.isActivityNotOpen())
/*     */       {
/*  75 */         BigbossManager.sendErrorInfo(this.roleid, 5);
/*     */       }
/*  77 */       if (joinResult.isSingleRoleTeam())
/*     */       {
/*  79 */         BigbossManager.sendErrorInfo(this.roleid, 4);
/*     */       }
/*  81 */       String logstr = String.format("[bigboss]PStartFight.processImp@canjoin bigboss error|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  82 */       BigbossManager.logger.error(logstr);
/*     */       
/*  84 */       return false;
/*     */     }
/*  86 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 26, true))
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     BigBoss xBigBoss = BigbossManager.getBigboss(this.roleid, true);
/*     */     
/*  92 */     if (BigbossManager.getTotalChallengecount(xBigBoss) <= 0)
/*     */     {
/*  94 */       BigbossManager.sendErrorInfo(this.roleid, 1);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     PVEBossFightContex fightContex = new PVEBossFightContex();
/*  99 */     fightContex.setRoleid(this.roleid);
/* 100 */     fightContex.setFightReson(FightReason.BIG_BOSS_ACTIVITY_FIGHT);
/* 101 */     fightContex.setMonsterid(sortid);
/*     */     
/* 103 */     FightInterface.startPVIMonsterFight(this.roleid, fightid, fightContex, 8, FightReason.BIG_BOSS_ACTIVITY_FIGHT, 10000);
/*     */     
/* 105 */     ActivityInterface.logActivity(this.roleid, SBigbossCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/* 106 */     ActivityInterface.tlogActivity(this.roleid, SBigbossCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */     
/* 108 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\PStartFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */