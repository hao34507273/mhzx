/*    */ package mzm.gsp.auction.main;
/*    */ 
/*    */ import mzm.gsp.auction.confbean.SAuctionActivityCfg;
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ public class AuctionOneByOneManager extends OneByOneManager<Integer>
/*    */ {
/*  8 */   private static AuctionOneByOneManager instance = new AuctionOneByOneManager();
/*    */   
/*    */   public static AuctionOneByOneManager getInstance()
/*    */   {
/* 12 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 22 */     return SAuctionActivityCfg.getAll().size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\AuctionOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */