/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WingModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public void postInit() {}
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 21 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 42 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\WingModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */