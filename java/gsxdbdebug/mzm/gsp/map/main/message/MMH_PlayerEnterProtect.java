/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_PlayerEnterProtect extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public MMH_PlayerEnterProtect(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 18 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 19 */     if (role == null)
/*    */     {
/* 21 */       return;
/*    */     }
/*    */     
/* 24 */     role.savePosition();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PlayerEnterProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */