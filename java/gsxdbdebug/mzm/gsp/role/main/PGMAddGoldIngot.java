/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGMAddGoldIngot
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int addValue;
/*    */   
/*    */   public PGMAddGoldIngot(long roleId, int addValue)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.addValue = addValue;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     RoleInterface.addGoldIngotInAll(this.roleId, this.addValue, new TLogArg(LogReason.GM_ADD), false);
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGMAddGoldIngot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */