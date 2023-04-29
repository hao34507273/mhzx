/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_SetWorldAppMsgHandler extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleId;
/*    */   private final int colorId;
/*    */   private final String appText;
/*    */   
/*    */   public MMH_SetWorldAppMsgHandler(long roleId, int colorId, String appText)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.colorId = colorId;
/* 16 */     this.appText = appText;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 22 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 23 */     if (role == null)
/*    */     {
/* 25 */       return;
/*    */     }
/*    */     
/* 28 */     if (this.colorId == 0)
/*    */     {
/* 30 */       role.unSetWorldApp();
/* 31 */       return;
/*    */     }
/* 33 */     role.setWorldApp(this.colorId, this.appText);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_SetWorldAppMsgHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */