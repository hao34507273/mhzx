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
/*    */ public class PGetFiveFightReward extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PGetFiveFightReward(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!JingjiManager.isJingjiSwitchOpenForRole(this.roleid))
/*    */     {
/* 27 */       String logstr = String.format("[jingji]PGetFiveFightReward.processImp@Jingji switch is closed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 29 */       JingjiManager.logger.info(logstr);
/*    */       
/* 31 */       return false;
/*    */     }
/* 33 */     if (!JingjiManager.isRoleStateCanJoinJIngjiActivity(this.roleid))
/*    */     {
/* 35 */       String logStr = String.format("[jingji]PGetFiveFightReward.processImp@role state can not join jingji activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 37 */       JingjiManager.logger.info(logStr);
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     String userid = RoleInterface.getUserId(this.roleid);
/* 42 */     lock(Lockeys.get(User.getTable(), userid));
/* 43 */     int rewardid = JingjiManager.getFivefightrewardid(this.roleid);
/* 44 */     if ((rewardid == -1) || (rewardid == 0))
/*    */     {
/* 46 */       JingjiManager.sendErrorInfo(this.roleid, 4);
/* 47 */       return false;
/*    */     }
/* 49 */     AwardModel awardModel = AwardInterface.awardFixAward(rewardid, userid, this.roleid, true, true, new AwardReason(LogReason.JINGJI_ACTIVITY_FIVE_FIGHT_ADD, rewardid));
/*    */     
/* 51 */     if (awardModel == null)
/*    */     {
/* 53 */       String logstr = String.format("[jingji]PGetFiveFightReward.processImp@Get five fight reward error|roleid=%d|rewarid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(rewardid) });
/*    */       
/* 55 */       JingjiManager.logger.error(logstr);
/*    */       
/* 57 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 61 */     JingjiManager.setFivefightrewardid(this.roleid, 0);
/* 62 */     JingjiManager.synRewardChanged(this.roleid);
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\PGetFiveFightReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */