/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ public class DrawCarnivalOneByOneManager extends OneByOneManager<Integer>
/*    */ {
/*  7 */   private static final DrawCarnivalOneByOneManager INSTANCE = new DrawCarnivalOneByOneManager();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static DrawCarnivalOneByOneManager getInstance()
/*    */   {
/* 15 */     return INSTANCE;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 21 */     return 2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\DrawCarnivalOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */