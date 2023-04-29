/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.personal.event.DeleteAdvertArg;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class POnDeleteAdvertRemoveCache extends mzm.gsp.personal.event.DeleteAdvertRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     UpdateCacheOneByOne.getInstance().add(new RRemoveCache(((DeleteAdvertArg)this.arg).roleId, ((DeleteAdvertArg)this.arg).advertId, ((DeleteAdvertArg)this.arg).advertType, ((DeleteAdvertArg)this.arg).advertNum == 0));
/*    */   }
/*    */   
/*    */   private static class RRemoveCache extends LogicRunnable
/*    */   {
/*    */     private final long roleId;
/*    */     private final long advertId;
/*    */     private final int advertType;
/*    */     private final boolean empty;
/*    */     
/*    */     public RRemoveCache(long roleId, long advertId, int advertType, boolean empty)
/*    */     {
/* 22 */       this.roleId = roleId;
/* 23 */       this.advertId = advertId;
/* 24 */       this.advertType = advertType;
/* 25 */       this.empty = empty;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 31 */       FilterInfo filterInfo = SNSIndexManager.getInstance().getFilteInfo(this.advertId, this.advertType);
/*    */       
/* 33 */       SNSIndexManager.getInstance().delAdvert(this.advertId, this.advertType);
/*    */       
/*    */ 
/* 36 */       AdvertChartCache.getInstance().remove(this.advertId);
/*    */       
/*    */ 
/* 39 */       SNSRankManager.getInstance().delete(this.advertId, filterInfo);
/*    */       
/*    */ 
/* 42 */       if (this.empty)
/*    */       {
/* 44 */         AdvertDataCache.getInstance().remove(this.advertId, this.roleId);
/*    */       }
/*    */       else
/*    */       {
/* 48 */         AdvertDataCache.getInstance().remove(this.advertId);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\POnDeleteAdvertRemoveCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */