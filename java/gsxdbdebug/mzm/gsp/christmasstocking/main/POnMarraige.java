/*    */ package mzm.gsp.christmasstocking.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*    */ import mzm.gsp.homeland.main.HomelandInterface;
/*    */ import mzm.gsp.marriage.event.MarriageArg;
/*    */ import mzm.gsp.marriage.event.MarriageEventProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnMarraige extends MarriageEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     String userIdA = RoleInterface.getUserId(((MarriageArg)this.arg).roleidA);
/* 16 */     String userIdB = RoleInterface.getUserId(((MarriageArg)this.arg).roleidB);
/* 17 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { userIdA, userIdB }));
/* 18 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((MarriageArg)this.arg).roleidA), Long.valueOf(((MarriageArg)this.arg).roleidB) }));
/*    */     
/*    */ 
/* 21 */     long homelandWordId = HomelandInterface.getHomeWorldIdByRoleId(((MarriageArg)this.arg).roleidA, true);
/* 22 */     if (homelandWordId == -1L)
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 28 */     long ownerRoleId = HomelandInterface.getRoleByHomeWorldId(homelandWordId, false);
/* 29 */     if (ownerRoleId == -1L)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 35 */     Long partnerRoleId = Long.valueOf(ownerRoleId == ((MarriageArg)this.arg).roleidA ? ((MarriageArg)this.arg).roleidB : ((MarriageArg)this.arg).roleidA);
/* 36 */     ChristmasStockingInterface.removeTreeFromCourtyard(ownerRoleId, partnerRoleId.longValue(), homelandWordId);
/* 37 */     ChristmasStockingInterface.removeStockingFromCourtyard(homelandWordId);
/*    */     
/*    */ 
/* 40 */     SCourtyardCfg sCourtyardCfg = HomelandInterface.getCurrentCourtyardCfg(((MarriageArg)this.arg).roleidA);
/* 41 */     int courtyardMapCfgId = sCourtyardCfg.mapId;
/* 42 */     int courtyardLevel = sCourtyardCfg.level;
/* 43 */     ChristmasStockingInterface.onHomelandWroldCreate(ownerRoleId, partnerRoleId.longValue(), homelandWordId, courtyardMapCfgId, courtyardLevel);
/*    */     
/*    */ 
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\POnMarraige.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */