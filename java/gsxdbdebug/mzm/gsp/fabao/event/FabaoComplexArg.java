/*    */ package mzm.gsp.fabao.event;
/*    */ 
/*    */ public class FabaoComplexArg
/*    */ {
/*    */   private final long roleId;
/*    */   private final int fabaoCfgId;
/*    */   
/*    */   public FabaoComplexArg(long _roleId, int _fabaoCfgId) {
/*  9 */     this.roleId = _roleId;
/* 10 */     this.fabaoCfgId = _fabaoCfgId;
/*    */   }
/*    */   
/*    */   public long getRoleId() {
/* 14 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getFabaoCfgId() {
/* 18 */     return this.fabaoCfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\event\FabaoComplexArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */