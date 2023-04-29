/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_GetRoleMfv
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetRoleMfv(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     int roleMFV = MultiRankManager.getRoleMFValue(this.roleId);
/* 26 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("综合战斗力：%d", new Object[] { Integer.valueOf(roleMFV) }));
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\PGM_GetRoleMfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */