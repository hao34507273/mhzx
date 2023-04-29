/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMAddGold
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int number;
/*    */   
/*    */   public PGMAddGold(long roleId, int number)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.number = number;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     RoleInterface.addGold(this.roleId, this.number, new TLogArg(LogReason.GM_ADD));
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGMAddGold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */