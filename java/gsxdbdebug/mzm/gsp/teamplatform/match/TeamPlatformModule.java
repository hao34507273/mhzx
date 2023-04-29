/*    */ package mzm.gsp.teamplatform.match;
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
/*    */ public class TeamPlatformModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public void postInit() {}
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 20 */     MatchArgs.init();
/* 21 */     TeamMatchMananger.init();
/* 22 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 43 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\TeamPlatformModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */