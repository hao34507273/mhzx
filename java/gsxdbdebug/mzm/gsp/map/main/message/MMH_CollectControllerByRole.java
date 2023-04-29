/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ public class MMH_CollectControllerByRole extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleId;
/*    */   private final int controllerId;
/*    */   
/*    */   public MMH_CollectControllerByRole(long roleId, int controllerId)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.controllerId = controllerId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 20 */     WorldInstance instance = WorldManager.getInstance().getRoleWorldInstanceFromStack(this.roleId);
/* 21 */     if (instance == null)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     instance.collectController(this.controllerId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_CollectControllerByRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */