/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ public class FightOneByOneManager extends OneByOneManager<Long>
/*    */ {
/*  8 */   private static final FightOneByOneManager instance = new FightOneByOneManager();
/*    */   
/*    */ 
/*    */ 
/*    */   public static FightOneByOneManager getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 19 */     return LoginManager.getInstance().getMaxPlayerNumber() * 2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */