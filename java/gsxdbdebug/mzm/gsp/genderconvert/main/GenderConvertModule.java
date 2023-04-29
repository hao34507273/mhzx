/*    */ package mzm.gsp.genderconvert.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ 
/*    */ public class GenderConvertModule
/*    */   implements Module
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 11 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 16 */     return 0;
/*    */   }
/*    */   
/*    */   public int init(Map<String, String> paramMap)
/*    */   {
/* 21 */     GenderConvertManager.init();
/* 22 */     GenderConvertHandlerManager.initHandlers();
/*    */     
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> paramMap, int paramInt)
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\main\GenderConvertModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */