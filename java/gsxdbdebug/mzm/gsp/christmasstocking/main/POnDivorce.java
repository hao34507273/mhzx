/*    */ package mzm.gsp.christmasstocking.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*    */ import mzm.gsp.homeland.main.HomelandInterface;
/*    */ import mzm.gsp.marriage.event.DivorceArg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnDivorce extends mzm.gsp.marriage.event.DivorceEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     String userIdA = RoleInterface.getUserId(((DivorceArg)this.arg).roleidA);
/* 16 */     String userIdB = RoleInterface.getUserId(((DivorceArg)this.arg).roleidB);
/* 17 */     lock(User.getTable(), Arrays.asList(new String[] { userIdA, userIdB }));
/* 18 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((DivorceArg)this.arg).roleidA), Long.valueOf(((DivorceArg)this.arg).roleidB) }));
/* 19 */     long homelandWordId1 = HomelandInterface.getHomeWorldIdByRoleId(((DivorceArg)this.arg).roleidA, true);
/* 20 */     long homelandWordId2 = HomelandInterface.getHomeWorldIdByRoleId(((DivorceArg)this.arg).roleidB, true);
/*    */     
/*    */ 
/* 23 */     if (homelandWordId1 != -1L)
/*    */     {
/* 25 */       ChristmasStockingInterface.removeTreeFromCourtyard(((DivorceArg)this.arg).roleidA, ((DivorceArg)this.arg).roleidB, homelandWordId1);
/* 26 */       ChristmasStockingInterface.removeStockingFromCourtyard(homelandWordId1);
/*    */     }
/* 28 */     if (homelandWordId2 != -1L)
/*    */     {
/* 30 */       ChristmasStockingInterface.removeTreeFromCourtyard(((DivorceArg)this.arg).roleidB, ((DivorceArg)this.arg).roleidA, homelandWordId2);
/* 31 */       ChristmasStockingInterface.removeStockingFromCourtyard(homelandWordId2);
/*    */     }
/*    */     
/*    */ 
/* 35 */     if (homelandWordId1 != -1L)
/*    */     {
/* 37 */       SCourtyardCfg sCourtyardCfg = HomelandInterface.getCurrentCourtyardCfg(((DivorceArg)this.arg).roleidA);
/* 38 */       int courtyardMapCfgId = sCourtyardCfg.mapId;
/* 39 */       int courtyardLevel = sCourtyardCfg.level;
/* 40 */       ChristmasStockingInterface.onHomelandWroldCreate(((DivorceArg)this.arg).roleidA, -1L, homelandWordId1, courtyardMapCfgId, courtyardLevel);
/*    */     }
/*    */     
/* 43 */     if (homelandWordId2 != -1L)
/*    */     {
/* 45 */       SCourtyardCfg sCourtyardCfg = HomelandInterface.getCurrentCourtyardCfg(((DivorceArg)this.arg).roleidB);
/* 46 */       int courtyardMapCfgId = sCourtyardCfg.mapId;
/* 47 */       int courtyardLevel = sCourtyardCfg.level;
/* 48 */       ChristmasStockingInterface.onHomelandWroldCreate(((DivorceArg)this.arg).roleidB, -1L, homelandWordId2, courtyardMapCfgId, courtyardLevel);
/*    */     }
/*    */     
/*    */ 
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\POnDivorce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */