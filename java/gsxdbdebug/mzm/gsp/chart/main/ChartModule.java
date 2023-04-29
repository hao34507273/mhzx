/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChartModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public static final String chartInputDir = "chartdata";
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 16 */     int saveDbIntervalSec = Integer.parseInt(((String)envs.get("rankdbtimer")).trim());
/*    */     
/* 18 */     RankDBManager.getInstance().setSaveDbIntervalSec(saveDbIntervalSec);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 41 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 46 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit()
/*    */   {
/* 51 */     RankDBManager.getInstance().postinit();
/* 52 */     RankCacheManager.postinit();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\ChartModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */