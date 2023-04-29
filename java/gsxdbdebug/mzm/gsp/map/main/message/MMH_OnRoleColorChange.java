/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_OnRoleColorChange extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final int hairid;
/*    */   private final int clothid;
/*    */   
/*    */   public MMH_OnRoleColorChange(long roleid, int hairid, int clothid)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.hairid = hairid;
/* 16 */     this.clothid = clothid;
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
/* 27 */     role.onRoleColorChange(this.hairid, this.clothid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnRoleColorChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */