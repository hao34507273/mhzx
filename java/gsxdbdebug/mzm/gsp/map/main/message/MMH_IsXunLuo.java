/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_IsXunLuo
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/* 10 */   private boolean xunLuo = false;
/*    */   
/*    */   public MMH_IsXunLuo(long roleid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public boolean isXunLuo()
/*    */   {
/* 19 */     return this.xunLuo;
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
/*    */     
/* 31 */     this.xunLuo = role.isXunLuoState();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_IsXunLuo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */