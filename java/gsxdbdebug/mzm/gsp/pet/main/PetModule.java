/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class PetModule
/*    */   implements Module
/*    */ {
/* 11 */   private static final Logger logger = Logger.getLogger(PetModule.class);
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/*    */     try
/*    */     {
/* 17 */       PetManager.getInstance().init(envs);
/* 18 */       PetYaoLiChartRankManager.init();
/*    */       
/* 20 */       NoneRealPetYaoLiRankManager.init();
/*    */       
/* 22 */       int petYaoliRankSec = Integer.parseInt(((String)envs.get("petYaoliRankSec")).trim());
/* 23 */       new PetYaoliRankObserver(petYaoliRankSec);
/*    */     } catch (Exception e) {
/* 25 */       logger.error("初始化宠物配置数据出错！");
/* 26 */       throw new RuntimeException(e);
/*    */     }
/*    */     
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 41 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 47 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */