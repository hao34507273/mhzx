/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import mzm.gsp.task.main.TaskInterface.TaskState;
/*    */ 
/*    */ public class MMH_RoleOnTaskStateChange
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final Map<Integer, TaskInterface.TaskState> taskStatues;
/*    */   
/*    */   public MMH_RoleOnTaskStateChange(long roleid, Map<Integer, TaskInterface.TaskState> taskStatues)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.taskStatues = taskStatues;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 23 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 24 */     if (role == null)
/*    */     {
/* 26 */       return;
/*    */     }
/* 28 */     role.setRoleTaskStateMap(this.taskStatues);
/* 29 */     role.updateView();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_RoleOnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */