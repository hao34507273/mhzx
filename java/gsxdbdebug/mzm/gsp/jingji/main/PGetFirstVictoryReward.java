/*    */ package mzm.gsp.jingji.main;
/*    */ 
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
/*    */ public class PGetFirstVictoryReward extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PGetFirstVictoryReward(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!JingjiManager.isJingjiSwitchOpenForRole(this.roleid))
/*    */     {
/* 27 */       String logstr = String.format("[jingji]PGetFirstVictoryReward.processImp@Jingji switch is closed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 29 */       JingjiManager.logger.info(logstr);
/*    */       
/* 31 */       return false;
/*    */     }
/* 33 */     if (!JingjiManager.isRoleStateCanJoinJIngjiActivity(this.roleid))
/*    */     {
/* 35 */       String logStr = String.format("[jingji]PGetFirstVictoryReward.processImp@role state can not join jingji activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 37 */       JingjiManager.logger.info(logStr);
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     String userid = RoleInterface.getUserId(this.roleid);
/* 42 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 44 */     int rewardid = JingjiManager.getFirstvictoryrewardid(this.roleid);
/* 45 */     if ((rewardid == -1) || (rewardid == 0))
/*    */     {
/* 47 */       JingjiManager.sendErrorInfo(this.roleid, 3);
/* 48 */       return false;
/*    */     }
/* 50 */     AwardModel awardModel = AwardInterface.awardFixAward(rewardid, userid, this.roleid, true, true, new AwardReason(LogReason.JINGJI_ACTIVITY_FIRST_VICTORY_ADD, rewardid));
/*    */     
/* 52 */     if (awardModel == null)
/*    */     {
/* 54 */       String logstr = String.format("[jingji]PGetFirstVictoryReward.processImp@Get first victory reward error|roleid=%d|rewarid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(rewardid) });
/*    */       
/*    */ 
/* 57 */       JingjiManager.logger.error(logstr);
/* 58 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 62 */     JingjiManager.setFirstvictoryrewardid(this.roleid, 0);
/* 63 */     JingjiManager.synRewardChanged(this.roleid);
/*    */     
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\PGetFirstVictoryReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */