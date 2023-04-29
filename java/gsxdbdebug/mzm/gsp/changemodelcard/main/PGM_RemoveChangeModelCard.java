/*    */ package mzm.gsp.changemodelcard.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_RemoveChangeModelCard
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long cardId;
/*    */   
/*    */   public PGM_RemoveChangeModelCard(long roleId, long cardId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.cardId = cardId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     ChangeModelCardInterface.RemoveCardForIDIPResult result = ChangeModelCardInterface.removeCardForIDIP(this.roleId, this.cardId);
/* 22 */     if (result == ChangeModelCardInterface.RemoveCardForIDIPResult.SUCCESS)
/*    */     {
/* 24 */       GmManager.getInstance().sendResultToGM(this.roleId, "移除变身卡成功");
/* 25 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 29 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("移除变身卡成功，原因为%d", new Object[] { Integer.valueOf(result.value) }));
/* 30 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PGM_RemoveChangeModelCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */