/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SJingjiPhaseCfg;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGetSeasonReward extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PGetSeasonReward(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!JingjiManager.isJingjiSwitchOpenForRole(this.roleid))
/*    */     {
/* 28 */       String logstr = String.format("[jingji]PGetSeasonReward.processImp@Jingji switch is closed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 30 */       JingjiManager.logger.info(logstr);
/*    */       
/* 32 */       return false;
/*    */     }
/* 34 */     if (!JingjiManager.isRoleStateCanJoinJIngjiActivity(this.roleid))
/*    */     {
/* 36 */       String logStr = String.format("[jingji]PGetSeasonReward.processImp@role state can not join jingji activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 38 */       JingjiManager.logger.info(logStr);
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     String userid = RoleInterface.getUserId(this.roleid);
/* 43 */     lock(Lockeys.get(User.getTable(), userid));
/* 44 */     int phase = JingjiManager.getLastseasonphase(this.roleid);
/* 45 */     if (phase == 0)
/*    */     {
/* 47 */       JingjiManager.sendErrorInfo(this.roleid, 5);
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     SJingjiPhaseCfg jingjiPhaseCfg = JingjiManager.getJingjiPhaseCfgByPhase(phase);
/* 52 */     if (jingjiPhaseCfg == null)
/*    */     {
/* 54 */       String logstr = String.format("[jingji]PGetSeasonReward.processImp@SJingjiPhaseCfg null|roleid=%d|cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(phase) });
/*    */       
/* 56 */       JingjiManager.logger.error(logstr);
/* 57 */       return false;
/*    */     }
/* 59 */     AwardModel awardModel = AwardInterface.awardFixAward(jingjiPhaseCfg.seasonRewardId, userid, this.roleid, true, true, new AwardReason(LogReason.JINGJI_ACTIVITY_SEASON_REWARD_ADD, jingjiPhaseCfg.seasonRewardId));
/*    */     
/* 61 */     if (awardModel == null)
/*    */     {
/* 63 */       String logstr = String.format("[jingji]PGetSeasonReward.processImp@Get five fight reward error|roleid=%d|rewarid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(jingjiPhaseCfg.seasonRewardId) });
/*    */       
/*    */ 
/* 66 */       JingjiManager.logger.error(logstr);
/* 67 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 71 */     JingjiManager.setLastseasonphase(this.roleid, 0);
/* 72 */     JingjiManager.synRewardChanged(this.roleid);
/*    */     
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\PGetSeasonReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */