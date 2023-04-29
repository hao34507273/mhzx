/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.guaji.confbean.DoublePointOfferCfgConsts;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuajiModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 20 */     DiGongGuaJIManager.init();
/* 21 */     GuajiManager.initDoubletime();
/*    */     
/* 23 */     ActivityInterface.registerActivityByLogicType(8, new GuajiActivityHandler());
/*    */     
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 43 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 51 */     new OfferDoublePointObserver(DoublePointOfferCfgConsts.getInstance().OFFER_TIME);
/*    */     
/*    */ 
/* 54 */     new DoubleitemClearObserver(DoublePointOfferCfgConsts.getInstance().ITEM_USE_TIMES_RESET_TIME);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\GuajiModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */