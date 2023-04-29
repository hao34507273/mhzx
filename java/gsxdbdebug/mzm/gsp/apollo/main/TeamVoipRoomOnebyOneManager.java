/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TeamVoipRoomOnebyOneManager
/*    */   extends OneByOneManager<Long>
/*    */ {
/* 12 */   private static final TeamVoipRoomOnebyOneManager instance = new TeamVoipRoomOnebyOneManager();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static TeamVoipRoomOnebyOneManager getInstance()
/*    */   {
/* 20 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 26 */     return 20480;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\TeamVoipRoomOnebyOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */