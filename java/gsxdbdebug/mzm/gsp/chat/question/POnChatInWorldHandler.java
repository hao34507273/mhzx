/*    */ package mzm.gsp.chat.question;
/*    */ 
/*    */ import mzm.gsp.chat.main.WorldChatHandler;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnChatInWorldHandler
/*    */   implements WorldChatHandler
/*    */ {
/*    */   public void onChatInWorld(long roleId, String str)
/*    */   {
/* 14 */     Procedure.execute(new POnRoleAnswer(roleId, str));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\POnChatInWorldHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */