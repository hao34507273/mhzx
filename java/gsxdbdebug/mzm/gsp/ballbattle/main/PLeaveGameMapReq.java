/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import mzm.gsp.ballbattle.SLeaveGameMapFail;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PLeaveGameMapReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PLeaveGameMapReq(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (!BallBattleActivityManager.isOpen())
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     if (!RoleStatusInterface.containsStatus(this.roleId, 2162))
/*    */     {
/* 27 */       SLeaveGameMapFail fail = new SLeaveGameMapFail();
/* 28 */       fail.reason = 1;
/* 29 */       OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     BallBattleGameInstance.handleLeaveRequest(this.roleId);
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\PLeaveGameMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */