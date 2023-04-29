/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_UseGiftCard extends LogicProcedure
/*    */ {
/*    */   private final long gmId;
/*    */   private final long targetId;
/*    */   private final String cardNum;
/*    */   
/*    */   public PGM_UseGiftCard(long gmid, long targetId, String cardNum)
/*    */   {
/* 15 */     this.gmId = gmid;
/* 16 */     this.targetId = targetId;
/* 17 */     this.cardNum = cardNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if ((this.cardNum == null) || (this.cardNum.length() != 15))
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmId, "gift card not exist.");
/*    */     }
/*    */     
/* 28 */     String userIdentity = RoleInterface.getUserId(this.targetId);
/* 29 */     if (!CSProviderInterface.useGiftCard(this.targetId, userIdentity, this.cardNum, 0))
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.gmId, "use gift card failed.");
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\PGM_UseGiftCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */