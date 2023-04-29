/*    */ package mzm.gsp.common;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ 
/*    */ public class CommonModule implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/*    */     try
/*    */     {
/*    */       
/*    */     }
/*    */     catch (IllegalAccessException e)
/*    */     {
/* 16 */       throw new RuntimeException("init property list error !", e);
/*    */     }
/* 18 */     PropertyRandomUtil.init();
/* 19 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 34 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\common\CommonModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */