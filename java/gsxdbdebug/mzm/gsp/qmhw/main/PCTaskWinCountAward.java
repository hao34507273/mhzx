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
/*    */ public class PCTaskWinCountAward extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int wincount;
/*    */   
/*    */   public PCTaskWinCountAward(long roleid, int wincount)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.wincount = wincount;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 28 */     if (!ActivityInterface.isActivityOpen(SQMHWCfgConsts.getInstance().ACTIVITY_ID)) {
/* 29 */       GameServer.logger().info(String.format("[QMHW]PCTaskWinCountAward.processImp@activity is closed", new Object[0]));
/* 30 */       return true;
/*    */     }
/* 32 */     if ((!OpenInterface.getOpenStatus(58)) || (OpenInterface.isBanPlay(this.roleid, 58)))
/*    */     {
/* 34 */       OpenInterface.sendBanPlayMsg(this.roleid, 58);
/* 35 */       return false;
/*    */     }
/* 37 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/* 38 */     lock(User.getTable(), java.util.Arrays.asList(new String[] { userId }));
/*    */     
/* 40 */     RoleQMHWScore xRoleQMHWScore = Role2qmhw.get(Long.valueOf(this.roleid));
/* 41 */     if (xRoleQMHWScore == null) {
/* 42 */       GameServer.logger().info(String.format("[QMHW]PCTaskWinCountAward.processImp@role data is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 44 */       return false;
/*    */     }
/* 46 */     if (xRoleQMHWScore.getGetawards().contains(Integer.valueOf(this.wincount))) {
/* 47 */       GameServer.logger().info(String.format("[QMHW]PCTaskWinCountAward.processImp@award is token|roleid=%d|wincount=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.wincount) }));
/*    */       
/*    */ 
/* 50 */       return false;
/*    */     }
/* 52 */     if (xRoleQMHWScore.getGetawards().size() > 0) {
/* 53 */       GameServer.logger().info(String.format("[QMHW]PCTaskWinCountAward.processImp@award is token|roleid=%d|wincount=%d|info=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.wincount), xRoleQMHWScore.toString() }));
/*    */       
/*    */ 
/* 56 */       return false;
/*    */     }
/* 58 */     int nowWinCount = xRoleQMHWScore.getWincount();
/* 59 */     if (nowWinCount < this.wincount) {
/* 60 */       GameServer.logger().info(String.format("[QMHW]PCTaskWinCountAward.processImp@win count not enough|roleid=%d|nowWinCount=%d|wincount=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(nowWinCount), Integer.valueOf(this.wincount) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 67 */       return false;
/*    */     }
/*    */     
/* 70 */     xRoleQMHWScore.getGetawards().add(Integer.valueOf(this.wincount));
/*    */     
/* 72 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(SQMHWCfgConsts.getInstance().FIRST_WIN_AWARDID, userId, this.roleid, false, true, new mzm.gsp.award.main.AwardReason(LogReason.QMHW_WIN_COUNT_AWARD, this.wincount));
/*    */     
/* 74 */     if (awardModel == null) {
/* 75 */       GameServer.logger().error(String.format("[QMHW]PCTaskWinCountAward.processImp@qmhw give win count award error|roleid=%d|awardid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SQMHWCfgConsts.getInstance().FIRST_WIN_AWARDID) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 82 */       return false;
/*    */     }
/* 84 */     QMHWManager.sendQMHWAwardInfo(this.roleid, xRoleQMHWScore);
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\PCTaskWinCountAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */