/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserOneByOneManager
/*    */   extends OneByOneManager<String>
/*    */ {
/* 11 */   private static final UserOneByOneManager instance = new UserOneByOneManager();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static UserOneByOneManager getInstance()
/*    */   {
/* 19 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 25 */     return LoginManager.getInstance().getMaxPlayerNumber() * 2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\UserOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */