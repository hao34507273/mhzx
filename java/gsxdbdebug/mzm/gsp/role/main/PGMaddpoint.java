/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMaddpoint extends LogicProcedure {
/*    */   private final long roleId;
/*    */   private final int newLevel;
/*    */   
/*    */   public PGMaddpoint(long roleId, int newLevel) {
/* 10 */     this.roleId = roleId;
/* 11 */     this.newLevel = newLevel;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 15 */     RoleOutFightObj roleout = RoleInterface.getRoleOutFightObject(this.roleId);
/* 16 */     roleout.addPortentialPoint(0, this.newLevel);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGMaddpoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */