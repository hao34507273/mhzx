/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.controller.Controller;
/*    */ 
/*    */ public class MMH_TriggerControllerByRole extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleId;
/*    */   private final int controllerId;
/*    */   private final int count;
/*    */   private final int maxSpawnNum;
/*    */   
/*    */   public MMH_TriggerControllerByRole(long roleId, int controllerId)
/*    */   {
/* 16 */     this(roleId, controllerId, 1, 0);
/*    */   }
/*    */   
/*    */   public MMH_TriggerControllerByRole(long roleId, int controllerId, int count, int maxSpawnNum)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.controllerId = controllerId;
/* 23 */     this.count = count;
/* 24 */     this.maxSpawnNum = maxSpawnNum;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 30 */     WorldInstance instance = WorldManager.getInstance().getRoleWorldInstanceFromStack(this.roleId);
/* 31 */     if (instance == null)
/*    */     {
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     Controller controller = instance.getController(this.controllerId);
/* 37 */     if (controller == null)
/*    */     {
/* 39 */       return;
/*    */     }
/*    */     
/* 42 */     controller.refresh(this.count, this.maxSpawnNum);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_TriggerControllerByRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */