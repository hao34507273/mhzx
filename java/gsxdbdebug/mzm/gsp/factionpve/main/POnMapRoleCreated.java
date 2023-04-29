/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.event.MapRoleCreatedArg;
/*    */ import mzm.gsp.map.event.MapRoleCreatedProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ 
/*    */ public class POnMapRoleCreated
/*    */   extends MapRoleCreatedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     if (FactionPVEConfigManager.isActivityMap(((MapRoleCreatedArg)this.arg).mapid))
/*    */     {
/*    */ 
/* 19 */       Gang faction = GangInterface.getGangByRoleId(((MapRoleCreatedArg)this.arg).roleid, true);
/*    */       
/*    */ 
/* 22 */       if (!RoleStatusInterface.containsStatus(((MapRoleCreatedArg)this.arg).roleid, 1021))
/*    */       {
/*    */ 
/* 25 */         if (RoleStatusInterface.setStatus(((MapRoleCreatedArg)this.arg).roleid, 1021, false))
/*    */         {
/*    */ 
/* 28 */           FactionPVEManager.broadcastPlayCount(((MapRoleCreatedArg)this.arg).worldid);
/*    */         }
/*    */         else {
/* 31 */           FactionPVEManager.leave(((MapRoleCreatedArg)this.arg).roleid, faction);
/* 32 */           long factionid = -1L;
/* 33 */           if (faction != null) {
/* 34 */             factionid = faction.getGangId();
/*    */           }
/* 36 */           FactionPVEManager.logWarn("POnMapRoleCreated.processImp@cannot set pve status|roleid=%d|factionid=%d|world=%d|mapid=%d|status_set=%s", new Object[] { Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(factionid), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid), RoleStatusInterface.getStatusSet(((MapRoleCreatedArg)this.arg).roleid) });
/*    */ 
/*    */         }
/*    */         
/*    */       }
/*    */       
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 47 */       FactionPVEManager.clearActivityStatus(((MapRoleCreatedArg)this.arg).roleid);
/*    */     }
/*    */     
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\POnMapRoleCreated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */