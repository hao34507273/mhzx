/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCExitChatRoomReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCExitChatRoomReq(long roleid)
/*    */   {
/* 11 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     if (!BetacatChatRoomManager.isOpen(this.roleid, "PCExitChatRoomReq.processImp"))
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     return BetacatChatRoomManager.sendExitRoomReq(this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCExitChatRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */