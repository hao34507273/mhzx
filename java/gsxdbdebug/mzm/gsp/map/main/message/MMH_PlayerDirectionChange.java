/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.SRoleDirectionChange;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_PlayerDirectionChange extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleId;
/*    */   private final int dir;
/*    */   
/*    */   public MMH_PlayerDirectionChange(long roleId, int dir)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.dir = dir;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 21 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 22 */     role.setDirection(this.dir);
/*    */     
/* 24 */     SRoleDirectionChange change = new SRoleDirectionChange();
/* 25 */     change.direction = this.dir;
/* 26 */     change.roleid = this.roleId;
/* 27 */     role.broadcastProtocol(change);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PlayerDirectionChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */