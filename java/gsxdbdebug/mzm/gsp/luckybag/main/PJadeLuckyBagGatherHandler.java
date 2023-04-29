/*    */ package mzm.gsp.luckybag.main;
/*    */ 
/*    */ import mzm.gsp.luckybag.confbean.SLuckyBagCfg;
/*    */ import mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ 
/*    */ public class PJadeLuckyBagGatherHandler
/*    */   extends PLuckyBagGatherHandler
/*    */ {
/* 10 */   private static final PJadeLuckyBagGatherHandler instance = new PJadeLuckyBagGatherHandler();
/*    */   
/*    */   public static PJadeLuckyBagGatherHandler getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/*    */   public PJadeLuckyBagGatherHandler()
/*    */   {
/* 19 */     super(SLuckyBagCfgConsts.getInstance().JADE_MAP_ITEM_HANDLER_TYPE);
/*    */   }
/*    */   
/*    */ 
/*    */   protected LuckyBagContext getContext()
/*    */   {
/* 25 */     LuckyBagContext context = new LuckyBagContext();
/* 26 */     SLuckyBagCfg luckyBagCfg = SLuckyBagCfg.get(2);
/* 27 */     if (luckyBagCfg == null)
/*    */     {
/* 29 */       return context;
/*    */     }
/* 31 */     context.setAddScore(luckyBagCfg.score);
/* 32 */     context.setAwardCfgid(luckyBagCfg.awardCfgid);
/* 33 */     context.setItemCfgid(luckyBagCfg.itemCfgid);
/* 34 */     context.setItemNum(luckyBagCfg.itemNum);
/* 35 */     context.setMutipleItemNum(luckyBagCfg.itemNums);
/* 36 */     context.setUiCfgid(luckyBagCfg.uiCfgid);
/* 37 */     context.setLogReason(LogReason.OPEN_JADE_LUKCY_BAG);
/* 38 */     context.setType(2);
/* 39 */     return context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\PJadeLuckyBagGatherHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */