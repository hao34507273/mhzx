/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleOneByOneManager
/*    */   extends OneByOneManager<Long>
/*    */ {
/* 14 */   private static final RoleOneByOneManager instance = new RoleOneByOneManager();
/*    */   
/*    */ 
/*    */ 
/*    */   public static RoleOneByOneManager getInstance()
/*    */   {
/* 20 */     return instance;
/*    */   }
/*    */   
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 25 */     return LoginManager.getInstance().getMaxPlayerNumber() * 2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */