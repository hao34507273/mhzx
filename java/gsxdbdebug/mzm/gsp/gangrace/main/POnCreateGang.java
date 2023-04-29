/*    */ package mzm.gsp.gangrace.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SGangRaceConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ 
/*    */ public class POnCreateGang extends mzm.gsp.gang.event.CreateGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (!ActivityInterface.isActivityOpen(SGangRaceConsts.getInstance().activity)) {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     long worldid = GangInterface.getGangWorldId(((GangArg)this.arg).gangId);
/* 17 */     if (worldid > 0L) {
/* 18 */       mzm.gsp.map.main.ControllerInterface.triggerWorldController(worldid, SGangRaceConsts.getInstance().NpcControlId);
/*    */     }
/*    */     
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\POnCreateGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */