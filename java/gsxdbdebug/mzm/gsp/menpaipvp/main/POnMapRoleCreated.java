/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.event.MapRoleCreatedArg;
/*    */ import mzm.gsp.map.event.MapRoleCreatedProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xbean.MenpaiPVP;
/*    */ import xbean.MenpaiPVPScore;
/*    */ 
/*    */ public class POnMapRoleCreated
/*    */   extends MapRoleCreatedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long roleid = ((MapRoleCreatedArg)this.arg).roleid;
/*    */     
/*    */ 
/* 19 */     MenpaiPVPScore xScore = MenpaiPVPManager.getXScore(roleid, true);
/*    */     
/* 21 */     if (ActivityInterface.isActivityOpen(MenpaiPVPConfigManager.getInstance().getActivityID()))
/*    */     {
/*    */ 
/*    */ 
/* 25 */       int menpai = RoleInterface.getOccupationId(roleid);
/*    */       
/* 27 */       MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVP(false);
/*    */       
/* 29 */       if (!MenpaiPVPManager.isInMenpaiPVPWorld(roleid, menpai, ((MapRoleCreatedArg)this.arg).worldid, xMenpaiPVP))
/*    */       {
/* 31 */         boolean ret = RoleStatusInterface.unsetStatus(roleid, 5);
/* 32 */         if (ret) {
/* 33 */           MenpaiPVPManager.logError("POnMapRoleCreated.processImp@in activity time, not in map, but has menpaipvp status|roleid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*    */         }
/*    */         
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 40 */         MenpaiPVPManager.leave(roleid, xScore, true);
/* 41 */         MenpaiPVPManager.logError("POnMapRoleCreated.processImp@in activity time and map|roleid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*    */       }
/*    */       
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 48 */       boolean ret = RoleStatusInterface.unsetStatus(roleid, 5);
/* 49 */       if (ret) {
/* 50 */         MenpaiPVPManager.logError("POnMapRoleCreated.processImp@not in activity time, but has menpaipvp status|roleid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\POnMapRoleCreated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */