/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import mzm.gsp.map.event.MapRoleDestroyedArg;
/*    */ import mzm.gsp.map.event.MapRoleDestroyedEventProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnMapRoleDestroyed
/*    */   extends MapRoleDestroyedEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     if (!FactionPVEConfigManager.isActivityMap(((MapRoleDestroyedArg)this.arg).mapid)) {
/* 16 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 21 */     RoleStatusInterface.unsetStatus(((MapRoleDestroyedArg)this.arg).roleid, 1021);
/*    */     
/*    */ 
/* 24 */     FactionPVEManager.broadcastPlayCount(((MapRoleDestroyedArg)this.arg).worldid);
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\POnMapRoleDestroyed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */