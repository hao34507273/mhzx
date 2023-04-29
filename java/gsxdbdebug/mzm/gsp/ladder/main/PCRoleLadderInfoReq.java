/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.ladder.SRoleLadderInfoRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Ladder;
/*    */ 
/*    */ public class PCRoleLadderInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCRoleLadderInfoReq(long roleid)
/*    */   {
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     if (!OpenInterface.getOpenStatus(188)) {
/* 22 */       GameServer.logger().info(String.format("[Ladder]PCRoleLadderInfoReq.processImp@idip is closed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 24 */       return false;
/*    */     }
/* 26 */     if (OpenInterface.isBanPlay(this.roleid, 188)) {
/* 27 */       OpenInterface.sendBanPlayMsg(this.roleid, this.roleid, mzm.gsp.role.main.RoleInterface.getName(this.roleid), 188);
/*    */       
/* 29 */       return false;
/*    */     }
/* 31 */     Ladder xLadder = LadderManager.getAndCreateXLadder(this.roleid);
/* 32 */     SRoleLadderInfoRes roleLadderInfoRes = new SRoleLadderInfoRes();
/* 33 */     if (xLadder != null) {
/* 34 */       roleLadderInfoRes.losecount = xLadder.getLosecount();
/* 35 */       roleLadderInfoRes.matchscore = LadderManager.getScore(this.roleid, xLadder);
/* 36 */       roleLadderInfoRes.stage = xLadder.getStage();
/* 37 */       roleLadderInfoRes.stageawards.addAll(xLadder.getAwardstages());
/* 38 */       roleLadderInfoRes.wincount = xLadder.getWincount();
/*    */     }
/* 40 */     OnlineManager.getInstance().send(this.roleid, roleLadderInfoRes);
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PCRoleLadderInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */