/*    */ package mzm.gsp.singlebattle.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoinSingleBattleArg
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */ 
/*    */   private final long battleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public JoinSingleBattleArg(long roleId, long battleId)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.battleId = battleId;
/*    */   }
/*    */   
/*    */   long getRoleId()
/*    */   {
/* 22 */     return this.roleId;
/*    */   }
/*    */   
/*    */   long getBattleId()
/*    */   {
/* 27 */     return this.battleId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\event\JoinSingleBattleArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */