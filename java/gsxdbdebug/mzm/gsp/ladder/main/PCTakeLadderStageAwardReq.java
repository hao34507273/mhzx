/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.ladder.STakeLadderStageAwardErrorRes;
/*    */ import mzm.gsp.ladder.STakeLadderStageAwardRes;
/*    */ import mzm.gsp.ladder.confbean.SLadderGradeInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Ladder;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCTakeLadderStageAwardReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int stage;
/*    */   
/*    */   public PCTakeLadderStageAwardReq(long roleid, int stage)
/*    */   {
/* 25 */     this.roleid = roleid;
/* 26 */     this.stage = stage;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 31 */     if (!OpenInterface.getOpenStatus(188)) {
/* 32 */       GameServer.logger().info(String.format("[Ladder]PCTakeLadderStageAwardReq.processImp@idip is closed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 34 */       return false;
/*    */     }
/* 36 */     if (OpenInterface.isBanPlay(this.roleid, 188)) {
/* 37 */       OpenInterface.sendBanPlayMsg(this.roleid, this.roleid, RoleInterface.getName(this.roleid), 188);
/*    */       
/* 39 */       return false;
/*    */     }
/* 41 */     String userid = RoleInterface.getUserId(this.roleid);
/* 42 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 43 */     Ladder xLadder = LadderManager.getAndInitXLadder(this.roleid, true);
/* 44 */     if (xLadder == null) {
/* 45 */       sendErrorRes(1);
/* 46 */       return false;
/*    */     }
/* 48 */     if (xLadder.getAwardstages().contains(Integer.valueOf(this.stage))) {
/* 49 */       sendErrorRes(0);
/* 50 */       return false;
/*    */     }
/* 52 */     if (this.stage > xLadder.getStage()) {
/* 53 */       sendErrorRes(3);
/* 54 */       return false;
/*    */     }
/* 56 */     SLadderGradeInfo gradeInfo = LadderManager.getGradeInfo(RoleInterface.getLevel(this.roleid), this.stage);
/* 57 */     if (gradeInfo == null) {
/* 58 */       sendErrorRes(2);
/* 59 */       return false;
/*    */     }
/* 61 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.awardFixAward(gradeInfo.awardid, userid, this.roleid, true, true, new mzm.gsp.award.main.AwardReason(LogReason.LADDER_MATCH_STAGE_AWARD));
/*    */     
/* 63 */     if (awardModel == null) {
/* 64 */       sendErrorRes(4);
/* 65 */       return false;
/*    */     }
/* 67 */     xLadder.getAwardstages().add(Integer.valueOf(this.stage));
/* 68 */     STakeLadderStageAwardRes takeLadderStageAwardRes = new STakeLadderStageAwardRes();
/* 69 */     takeLadderStageAwardRes.stage = this.stage;
/* 70 */     OnlineManager.getInstance().send(this.roleid, takeLadderStageAwardRes);
/* 71 */     return true;
/*    */   }
/*    */   
/*    */   private void sendErrorRes(int errorCode) {
/* 75 */     STakeLadderStageAwardErrorRes res = new STakeLadderStageAwardErrorRes();
/* 76 */     res.ret = errorCode;
/* 77 */     OnlineManager.getInstance().sendAtOnce(this.roleid, res);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PCTakeLadderStageAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */