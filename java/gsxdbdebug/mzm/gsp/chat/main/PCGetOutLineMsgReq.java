/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import xbean.RoleChatInfo;
/*    */ 
/*    */ public class PCGetOutLineMsgReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCGetOutLineMsgReq(long roleId)
/*    */   {
/* 11 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     RoleChatInfo roleChatInfo = xtable.Role2chat.get(Long.valueOf(this.roleId));
/* 17 */     if (roleChatInfo == null) {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     ChatStorageManager.sendViaXtable(this.roleId);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCGetOutLineMsgReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */