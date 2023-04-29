/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import mzm.gsp.map.event.MapRoleDestroyedArg;
/*    */ import mzm.gsp.map.event.MapRoleDestroyedEventProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xbean.MenpaiPVP;
/*    */ import xbean.MenpaiPVPScore;
/*    */ 
/*    */ public class POnMapRoleDestroyed
/*    */   extends MapRoleDestroyedEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long roleid = ((MapRoleDestroyedArg)this.arg).roleid;
/*    */     
/*    */ 
/* 18 */     int menpai = RoleInterface.getOccupationId(roleid);
/*    */     
/* 20 */     MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVP(false);
/*    */     
/*    */ 
/* 23 */     if (!MenpaiPVPManager.isInMenpaiPVPWorld(roleid, menpai, ((MapRoleDestroyedArg)this.arg).worldid, xMenpaiPVP))
/*    */     {
/* 25 */       RoleStatusInterface.unsetStatus(roleid, 5);
/* 26 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 31 */     MenpaiPVPScore xScore = MenpaiPVPManager.getXScoreIfNotExist(roleid);
/* 32 */     MenpaiPVPManager.leave(roleid, xScore, true);
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\POnMapRoleDestroyed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */