/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import mzm.gsp.map.main.scene.object.MapRoleInitInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MMH_PlayerSwitchOccupation
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final MapRoleInitInfo mapRoleInitInfo;
/*    */   
/*    */   public MMH_PlayerSwitchOccupation(long roleid, MapRoleInitInfo mapRoleInitInfo)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.mapRoleInitInfo = mapRoleInitInfo;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 25 */     MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 26 */     if (mapRole == null)
/*    */     {
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     mapRole.onRoleSwitchOccupation(this.mapRoleInitInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PlayerSwitchOccupation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */