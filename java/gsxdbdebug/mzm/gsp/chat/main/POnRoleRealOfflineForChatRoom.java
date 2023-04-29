/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnRoleRealOfflineForChatRoom extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public POnRoleRealOfflineForChatRoom(long roleid)
/*    */   {
/* 11 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return BetacatChatRoomManager.onRoleRealOffline(this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\POnRoleRealOfflineForChatRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */