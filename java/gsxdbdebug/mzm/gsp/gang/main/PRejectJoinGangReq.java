/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.SSyncRejectJoinGang;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRejectJoinGangReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long inventorId;
/*    */   private long roleId;
/*    */   
/*    */   public PRejectJoinGangReq(long inventorId, long roleId)
/*    */   {
/* 18 */     this.inventorId = inventorId;
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     SSyncRejectJoinGang sSyncRejectJoinGang = new SSyncRejectJoinGang();
/* 25 */     sSyncRejectJoinGang.rejectname = RoleInterface.getName(this.roleId);
/* 26 */     OnlineManager.getInstance().send(this.inventorId, sSyncRejectJoinGang);
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PRejectJoinGangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */