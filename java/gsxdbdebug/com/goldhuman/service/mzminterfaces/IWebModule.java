/*    */ package com.goldhuman.service.mzminterfaces;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public final class IWebModule
/*    */   implements Module
/*    */ {
/* 10 */   private static Logger logger = Logger.getLogger(IWebModule.class);
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 14 */     new GameControl().registerMBean();
/* 15 */     logger.info("iweb妯″潡鍒濆鍖栧畬姣曪紒");
/* 16 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 21 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\com\goldhuman\service\mzminterfaces\IWebModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */