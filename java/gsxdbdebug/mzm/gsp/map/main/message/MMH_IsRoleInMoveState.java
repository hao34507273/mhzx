/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_IsRoleInMoveState
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/* 10 */   private boolean isMove = false;
/*    */   
/*    */   public MMH_IsRoleInMoveState(long roleid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public boolean isMove()
/*    */   {
/* 19 */     return this.isMove;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 25 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 26 */     if (role == null)
/*    */     {
/* 28 */       return;
/*    */     }
/* 30 */     this.isMove = role.isMoveState();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_IsRoleInMoveState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */