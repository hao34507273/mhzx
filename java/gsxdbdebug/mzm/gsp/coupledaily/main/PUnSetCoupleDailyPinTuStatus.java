/*    */ package mzm.gsp.coupledaily.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class PUnSetCoupleDailyPinTuStatus
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final List<Long> roleIdList;
/*    */   
/*    */   public PUnSetCoupleDailyPinTuStatus(List<Long> roleIdList)
/*    */   {
/* 15 */     this.roleIdList = roleIdList;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     lock(Role2properties.getTable(), this.roleIdList);
/* 22 */     RoleStatusInterface.unsetStatus(this.roleIdList, 559);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\PUnSetCoupleDailyPinTuStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */