/*    */ package mzm.gsp.award.gift;
/*    */ 
/*    */ 
/*    */ public class AwardItem
/*    */   extends GiftAwardType
/*    */ {
/*    */   public AwardItem(String userId, long roleId, int usetType)
/*    */   {
/*  9 */     super(userId, roleId, usetType);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   boolean doAward()
/*    */   {
/* 16 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   int getAwardType()
/*    */   {
/* 22 */     return 3;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\AwardItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */