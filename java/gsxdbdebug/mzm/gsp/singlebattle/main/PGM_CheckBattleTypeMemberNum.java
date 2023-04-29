/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_CheckBattleTypeMemberNum
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int battleType;
/*    */   
/*    */   public PGM_CheckBattleTypeMemberNum(long roleId, int battleType)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.battleType = battleType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     int shouldNum = SingleBattleMemberManager.getInstance().getShouldMemberNum(this.battleType);
/* 27 */     int validNum = SingleBattleMemberManager.getInstance().getValidMemberNum(this.battleType);
/* 28 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("战场类型%d，应到%d人，实到%d人", new Object[] { Integer.valueOf(this.battleType), Integer.valueOf(shouldNum), Integer.valueOf(validNum) }));
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\PGM_CheckBattleTypeMemberNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */