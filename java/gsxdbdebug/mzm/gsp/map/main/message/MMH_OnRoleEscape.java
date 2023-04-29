/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.SRoleEndFight;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_OnRoleEscape extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public MMH_OnRoleEscape(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 19 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 20 */     if (role == null)
/*    */     {
/* 22 */       return;
/*    */     }
/*    */     
/* 25 */     SRoleEndFight core = new SRoleEndFight();
/* 26 */     core.roleid = this.roleid;
/* 27 */     role.broadcastProtocolIncludeSelf(core);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnRoleEscape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */