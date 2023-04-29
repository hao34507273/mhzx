/*    */ package mzm.gsp.paynewyear.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PayNewYearModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 15 */     PayNewYearActivityHandler handler = new PayNewYearActivityHandler();
/* 16 */     ActivityInterface.registerActivityByLogicType(65, handler);
/*    */     
/* 18 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 30 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paynewyear\main\PayNewYearModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */