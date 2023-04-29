/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleQMHWScore;
/*    */ import xtable.Role2qmhw;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCTaskJionCountAward extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int joinCount;
/*    */   
/*    */   public PCTaskJionCountAward(long roleid, int joincount)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.joinCount = joincount;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 28 */     if (!ActivityInterface.isActivityOpen(SQMHWCfgConsts.getInstance().ACTIVITY_ID)) {
/* 29 */       GameServer.logger().info(String.format("[QMHW]PCTaskJionCOuntAward.processImp@activity is closed", new Object[0]));
/* 30 */       return true;
/*    */     }
/* 32 */     if ((!OpenInterface.getOpenStatus(58)) || (OpenInterface.isBanPlay(this.roleid, 58)))
/*    */     {
/* 34 */       OpenInterface.sendBanPlayMsg(this.roleid, 58);
/* 35 */       return false;
/*    */     }
/* 37 */     if (this.joinCount != SQMHWCfgConsts.getInstance().FIGHT_COUNT) {
/* 38 */       GameServer.logger().info(String.format("[QMHW]PCTaskJionCOuntAward.processImp@join count do not has award|joinCount=%d|awardCount=%d|roleid=%d", new Object[] { Integer.valueOf(this.joinCount), Integer.valueOf(SQMHWCfgConsts.getInstance().FIGHT_COUNT), Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 45 */       return false;
/*    */     }
/* 47 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/* 48 */     lock(User.getTable(), java.util.Arrays.asList(new String[] { userId }));
/*    */     
/* 50 */     RoleQMHWScore xRoleQMHWScore = Role2qmhw.get(Long.valueOf(this.roleid));
/* 51 */     if (xRoleQMHWScore == null) {
/* 52 */       GameServer.logger().info(String.format("[QMHW]PCTaskJionCOuntAward.processImp@role data is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 54 */       return false;
/*    */     }
/* 56 */     if (xRoleQMHWScore.getGetjoinawards().contains(Integer.valueOf(this.joinCount))) {
/* 57 */       GameServer.logger().info(String.format("[QMHW]PCTaskJionCOuntAward.processImp@award is token|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 59 */       return false;
/*    */     }
/* 61 */     int nowJointCount = xRoleQMHWScore.getLosecount() + xRoleQMHWScore.getWincount();
/* 62 */     if (nowJointCount < this.joinCount) {
/* 63 */       GameServer.logger().info(String.format("[QMHW]PCTaskJionCOuntAward.processImp@join count not enough|roleid=%d|nowJoinCount=%d|joinCount=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(nowJointCount), Integer.valueOf(this.joinCount) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 70 */       return false;
/*    */     }
/*    */     
/* 73 */     xRoleQMHWScore.getGetjoinawards().add(Integer.valueOf(this.joinCount));
/*    */     
/* 75 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(SQMHWCfgConsts.getInstance().FIGHT_COUNT_AWARDID, userId, this.roleid, false, true, new mzm.gsp.award.main.AwardReason(LogReason.QMHW_JOIN_COUNT_AWARD, this.joinCount));
/*    */     
/* 77 */     if (awardModel == null) {
/* 78 */       GameServer.logger().error(String.format("[QMHW]PCTaskJionCOuntAward.processImp@qmhw give join count award error|roleid=%d|awardid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SQMHWCfgConsts.getInstance().FIGHT_COUNT_AWARDID) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 85 */       return false;
/*    */     }
/* 87 */     QMHWManager.sendQMHWAwardInfo(this.roleid, xRoleQMHWScore);
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\PCTaskJionCountAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */