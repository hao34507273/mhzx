/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ 
/*    */ public class DeleteAdvertArg
/*    */ {
/*    */   public final int advertType;
/*    */   
/*    */   public final long roleId;
/*    */   
/*    */   public final long advertId;
/*    */   public final int advertNum;
/*    */   
/*    */   public DeleteAdvertArg(int advertType, long roleId, long advertId, int advertNum)
/*    */   {
/* 15 */     this.advertType = advertType;
/* 16 */     this.roleId = roleId;
/* 17 */     this.advertId = advertId;
/*    */     
/* 19 */     this.advertNum = advertNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\DeleteAdvertArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */