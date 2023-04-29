/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2fashiondress;
/*    */ 
/*    */ public class FashionDressModule
/*    */   implements Module, MergeModule, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 17 */     FashionDressCfgManager.init();
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
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 42 */     return Arrays.asList(new Table[] { Role2fashiondress.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 54 */     TimeLimitedThemeFashionDressSessionManager.getInstance().postInit();
/* 55 */     FashionDressManager.postInit();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\FashionDressModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */