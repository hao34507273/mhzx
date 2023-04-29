/*    */ package mzm.gsp.luckybag.main;
/*    */ 
/*    */ import mzm.gsp.luckybag.confbean.SLuckyBagCfg;
/*    */ import mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ 
/*    */ public class PBoxLuckyBagGatherHandler
/*    */   extends PLuckyBagGatherHandler
/*    */ {
/* 10 */   private static final PBoxLuckyBagGatherHandler instance = new PBoxLuckyBagGatherHandler();
/*    */   
/*    */   public static PBoxLuckyBagGatherHandler getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/*    */   public PBoxLuckyBagGatherHandler()
/*    */   {
/* 19 */     super(SLuckyBagCfgConsts.getInstance().BOX_MAP_ITEM_HANDLER_TYPE);
/*    */   }
/*    */   
/*    */ 
/*    */   protected LuckyBagContext getContext()
/*    */   {
/* 25 */     LuckyBagContext context = new LuckyBagContext();
/* 26 */     SLuckyBagCfg luckyBagCfg = SLuckyBagCfg.get(3);
/* 27 */     if (luckyBagCfg == null)
/*    */     {
/* 29 */       return context;
/*    */     }
/* 31 */     context.setAddScore(luckyBagCfg.score);
/* 32 */     context.setItemCfgid(luckyBagCfg.itemCfgid);
/* 33 */     context.setItemNum(luckyBagCfg.itemNum);
/* 34 */     context.setMutipleItemNum(luckyBagCfg.itemNums);
/* 35 */     context.setUiCfgid(luckyBagCfg.uiCfgid);
/* 36 */     context.setLogReason(LogReason.LUKCY_BAG_OPEN_JADE_BOX);
/* 37 */     context.setType(3);
/* 38 */     return context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\PBoxLuckyBagGatherHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */