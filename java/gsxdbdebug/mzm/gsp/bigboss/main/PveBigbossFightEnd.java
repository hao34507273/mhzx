/*     */ package mzm.gsp.bigboss.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.bigboss.confbean.SBigbossCfgConsts;
/*     */ import mzm.gsp.fight.event.PVIMonsterFightEndArg;
/*     */ import mzm.gsp.fight.main.FightContext;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BigBoss;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PveBigbossFightEnd extends mzm.gsp.fight.event.PVIMonsterFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  22 */     FightContext fightContext = ((PVIMonsterFightEndArg)this.arg).context;
/*  23 */     if ((fightContext == null) || (!(fightContext instanceof PVEBossFightContex)))
/*     */     {
/*  25 */       return false;
/*     */     }
/*  27 */     PVEBossFightContex pveBossFightContex = (PVEBossFightContex)fightContext;
/*  28 */     if (pveBossFightContex.getFightReson().value != FightReason.BIG_BOSS_ACTIVITY_FIGHT.value)
/*     */     {
/*  30 */       return false;
/*     */     }
/*  32 */     BigBossFightManager.getInstance().onFightEnd(((PVIMonsterFightEndArg)this.arg).fightid);
/*  33 */     if ((((PVIMonsterFightEndArg)this.arg).roleList == null) || (((PVIMonsterFightEndArg)this.arg).roleList.size() == 0))
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     long roleid = ((Long)((PVIMonsterFightEndArg)this.arg).roleList.get(0)).longValue();
/*     */     
/*  40 */     String userid = RoleInterface.getUserId(roleid);
/*  41 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/*  42 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*     */     
/*  44 */     BigBoss xBigBoss = BigbossManager.getBigboss(roleid, true);
/*  45 */     if (xBigBoss == null)
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     boolean ret = BigbossManager.decChallenagecount(xBigBoss, 1);
/*  50 */     if (!ret)
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.award(SBigbossCfgConsts.getInstance().FIGHT_END_REWARDID, userid, roleid, false, true, new mzm.gsp.award.main.AwardReason(mzm.gsp.tlog.LogReason.BIGBOSS_ACTIVITY_FIGHT_ADD, SBigbossCfgConsts.getInstance().FIGHT_END_REWARDID));
/*     */     
/*  56 */     if (awardModel == null)
/*     */     {
/*  58 */       String logstr = String.format("[bigboss]PveBigbossFightEnd.processImp@Bigboss fight end offer award error|roleid=%d|rewardid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(SBigbossCfgConsts.getInstance().FIGHT_END_REWARDID) });
/*     */       
/*     */ 
/*  61 */       BigbossManager.logger.error(logstr);
/*  62 */       return false;
/*     */     }
/*  64 */     int ocp = RoleInterface.getOccupationId(roleid);
/*  65 */     Integer oldDamagePoint = (Integer)xBigBoss.getOcp2damagepoint().get(Integer.valueOf(ocp));
/*  66 */     if (oldDamagePoint == null)
/*     */     {
/*  68 */       oldDamagePoint = Integer.valueOf(0);
/*     */     }
/*  70 */     long startTimestamp = BigbossManager.getActivityStarttime();
/*  71 */     Integer damage = (Integer)((PVIMonsterFightEndArg)this.arg).roleDamageMap.get(Long.valueOf(roleid));
/*  72 */     if (damage == null)
/*     */     {
/*  74 */       damage = Integer.valueOf(0);
/*     */     }
/*  76 */     int damagepoint = (int)(damage.intValue() * SBigbossCfgConsts.getInstance().DAMAGE_PARAM);
/*  77 */     if ((!xBigBoss.getOcp2damagepoint().containsKey(Integer.valueOf(ocp))) && (!xBigBoss.getOcp2damagepoint().isEmpty()))
/*     */     {
/*  79 */       BigbossManager.clearRoleOtherOcpPoint(roleid, xBigBoss, ocp, startTimestamp);
/*     */     }
/*  81 */     int newDamagePoint = Math.max(damagepoint, oldDamagePoint.intValue());
/*  82 */     if (!BigbossManager.isBanRank(roleid))
/*     */     {
/*  84 */       xBigBoss.getOcp2damagepoint().put(Integer.valueOf(ocp), Integer.valueOf(newDamagePoint));
/*  85 */       BigbossChartManager.getInstance().rank(ocp, roleid, newDamagePoint);
/*  86 */       BigbossManager.reportRoleBigBossRankInfo(CommonUtils.getLong(ocp, (int)(startTimestamp / 1000L)), roleid, RoleInterface.getName(roleid), ocp, newDamagePoint, 1);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  91 */       String logstr = String.format("[bigboss]PveBigbossFightEnd.processImp@role is is ban rank state|roleid=%d|old_damage_point=%d|new_damage_point=%d", new Object[] { Long.valueOf(roleid), oldDamagePoint, Integer.valueOf(newDamagePoint) });
/*     */       
/*     */ 
/*  94 */       BigbossManager.logger.info(logstr);
/*     */     }
/*  96 */     int roleRank = BigbossChartManager.getInstance().getRank(ocp, roleid);
/*  97 */     Integer newPoint = (Integer)xBigBoss.getOcp2damagepoint().get(Integer.valueOf(ocp));
/*  98 */     if (newPoint == null)
/*     */     {
/* 100 */       newPoint = Integer.valueOf(0);
/*     */     }
/* 102 */     BigbossManager.synBigbossActivityDataChanged(roleid, newPoint.intValue() - oldDamagePoint.intValue(), ocp, xBigBoss, roleRank);
/*     */     
/* 104 */     ActivityInterface.addActivityCount(userid, roleid, SBigbossCfgConsts.getInstance().ACTIVITYID);
/* 105 */     ActivityInterface.logActivity(roleid, SBigbossCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/* 106 */     ActivityInterface.tlogActivity(roleid, SBigbossCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\PveBigbossFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */