/*     */ package mzm.gsp.jingji.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
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
/*     */   private long opponentRoleid;
/*     */   
/*     */   public PStartFight(long roleid, long opponentRoleid)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.opponentRoleid = opponentRoleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (this.opponentRoleid == this.roleid)
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     if (!JingjiManager.isJingjiSwitchOpenForRole(this.roleid))
/*     */     {
/*  47 */       String logstr = String.format("[jingji]PStartFight.processImp@Jingji switch is closed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  48 */       JingjiManager.logger.info(logstr);
/*  49 */       return false;
/*     */     }
/*  51 */     if (!JingjiManager.isRoleStateCanJoinJIngjiActivity(this.roleid))
/*     */     {
/*  53 */       String logStr = String.format("[jingji]PStartFight.processImp@role state can not join jingji activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  55 */       JingjiManager.logger.info(logStr);
/*  56 */       return false;
/*     */     }
/*  58 */     String userId = RoleInterface.getUserId(this.roleid);
/*  59 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*  60 */     Lockeys.lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  61 */     if ((TeamInterface.isTeamMemberNormal(this.roleid)) && (TeamInterface.getNormalRoleList(this.roleid).size() > 1))
/*     */     {
/*  63 */       JingjiManager.sendErrorInfo(this.roleid, 7);
/*  64 */       return false;
/*     */     }
/*  66 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleid, JingjiActivityCfgConsts.getInstance().ACTIVITYID);
/*     */     
/*  68 */     if ((!res.isCanJoin()) && (!res.isSingleRoleTeam()))
/*     */     {
/*  70 */       String logstr = String.format("[jingji]PStartFight.processImp@canjoin error|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  71 */       JingjiManager.logger.error(logstr);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     if (!JingjiManager.isOpponentRight(this.roleid, this.opponentRoleid))
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (JingjiManager.getTotalChallengeCount(this.roleid) <= 0)
/*     */     {
/*  82 */       JingjiManager.sendErrorInfo(this.roleid, 1);
/*  83 */       return false;
/*     */     }
/*  85 */     List<Long> passiveRoleids = new ArrayList();
/*  86 */     PVPFightContex fightContex = new PVPFightContex();
/*  87 */     fightContex.setRoleid(this.roleid);
/*  88 */     fightContex.setOpponentRoleid(this.opponentRoleid);
/*  89 */     if (this.opponentRoleid == 0L)
/*     */     {
/*  91 */       fightContex.setFightReson(FightReason.JINGJI_ROBOT_FIGHT);
/*  92 */       FightInterface.startPVCFightWithRobot(this.roleid, passiveRoleids, fightContex, 7, FightReason.JINGJI_ROBOT_FIGHT, JingjiActivityCfgConsts.getInstance().PVP_FIGHT_TYPE_ID);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  97 */       fightContex.setFightReson(FightReason.JINGJI_ROLE_FIGHT);
/*  98 */       passiveRoleids.add(Long.valueOf(this.opponentRoleid));
/*  99 */       FightInterface.startPVCFight(this.roleid, passiveRoleids, fightContex, 7, FightReason.JINGJI_ROLE_FIGHT, JingjiActivityCfgConsts.getInstance().PROPERTY_SCALE_ID);
/*     */     }
/*     */     
/* 102 */     ActivityInterface.logActivity(this.roleid, JingjiActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/* 103 */     ActivityInterface.tlogActivity(this.roleid, JingjiActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */     
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\PStartFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */