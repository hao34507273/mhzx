/*    */ package mzm.gsp.award.gift;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GiftInterface
/*    */ {
/*    */   public static ResetGiftRes resetGiftCountForIdip(int useType)
/*    */   {
/* 18 */     PGM_InitXAwardGlobal p = new PGM_InitXAwardGlobal(useType);
/* 19 */     p.call();
/* 20 */     if (p.res == null)
/*    */     {
/* 22 */       return new ResetGiftRes(false, ResetGiftRes.ResetRes.ERROR__OTHER);
/*    */     }
/* 24 */     return p.res;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\GiftInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */