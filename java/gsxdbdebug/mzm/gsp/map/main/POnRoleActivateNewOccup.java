/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_PlayerSwitchOccupation;
/*    */ import mzm.gsp.map.main.scene.object.MapRoleInitInfo;
/*    */ import mzm.gsp.multioccupation.event.ActivateNewOccupArg;
/*    */ 
/*    */ public class POnRoleActivateNewOccup extends mzm.gsp.multioccupation.event.ActivateNewOccupProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleid = ((ActivateNewOccupArg)this.arg).roleid;
/*    */     
/* 13 */     MapRoleInitInfo mapRoleInitInfo = new MapRoleInitInfo(roleid);
/*    */     
/* 15 */     new MMH_PlayerSwitchOccupation(roleid, mapRoleInitInfo).execute();
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleActivateNewOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */