/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_OnRoleExteriorChange extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final boolean isRoleOnline;
/*    */   private final int exteriorId;
/*    */   
/*    */   public MMH_OnRoleExteriorChange(long roleid, boolean isRoleOnline, int exteriorId)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.isRoleOnline = isRoleOnline;
/* 16 */     this.exteriorId = exteriorId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 22 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 23 */     if (role == null)
/*    */     {
/* 25 */       return;
/*    */     }
/*    */     
/* 28 */     role.onRoleExteriorChange(this.isRoleOnline, this.exteriorId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnRoleExteriorChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */