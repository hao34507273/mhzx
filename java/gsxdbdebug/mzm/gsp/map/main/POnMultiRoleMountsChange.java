/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_MultiMountsInfoChanged;
/*    */ import mzm.gsp.mounts.event.MultiRoleMountsChangeArg;
/*    */ import mzm.gsp.mounts.event.MultiRoleMountsChangeProcedure;
/*    */ 
/*    */ public class POnMultiRoleMountsChange extends MultiRoleMountsChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (((MultiRoleMountsChangeArg)this.arg).changeReason == mzm.gsp.mounts.event.MultiRoleMountsChangeArg.ChangeReason.TEAM_INFO_CHANGE)
/*    */     {
/* 13 */       return true;
/*    */     }
/*    */     
/* 16 */     new MMH_MultiMountsInfoChanged(((MultiRoleMountsChangeArg)this.arg).teamId, ((MultiRoleMountsChangeArg)this.arg).mountsCfgId, ((MultiRoleMountsChangeArg)this.arg).roleIds).execute();
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnMultiRoleMountsChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */