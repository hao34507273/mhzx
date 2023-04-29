/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*    */ 
/*    */ public class RoleCfgArgs
/*    */ {
/*    */   int intervalMin;
/*    */   double checkRet;
/*    */   int chartTopNMax;
/*    */   int extroLevel;
/*    */   private static RoleCfgArgs instance;
/*    */   
/*    */   public static RoleCfgArgs getInstance()
/*    */   {
/* 16 */     return instance;
/*    */   }
/*    */   
/*    */   static void init()
/*    */   {
/* 21 */     instance = (RoleCfgArgs)ConfManager.getInstance().getconf("mzm.gsp.role.main.RoleCfgArgs");
/* 22 */     if (instance == null)
/*    */     {
/* 24 */       throw new RuntimeException("RoleCfgArgs文件不存在！");
/*    */     }
/*    */   }
/*    */   
/*    */   public int getChartTopNMax()
/*    */   {
/* 30 */     return this.chartTopNMax;
/*    */   }
/*    */   
/*    */   public int getExtroLevel()
/*    */   {
/* 35 */     return this.extroLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleCfgArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */