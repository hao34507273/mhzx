/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ public class MMH_RoleLogoffForClearing extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public MMH_RoleLogoffForClearing(long roleid)
/*    */   {
/*  9 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 15 */     PendingMessageManager.getRolePendingMessageManager().clearPendingMessage(Long.valueOf(this.roleid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_RoleLogoffForClearing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */