/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ public class MMH_WorldHasRole
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldid;
/* 10 */   private boolean result = false;
/*    */   
/*    */   public MMH_WorldHasRole(long worldid)
/*    */   {
/* 14 */     this.worldid = worldid;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 19 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 25 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldid);
/* 26 */     if (instance == null)
/*    */     {
/* 28 */       return;
/*    */     }
/* 30 */     this.result = instance.hasRole();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_WorldHasRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */