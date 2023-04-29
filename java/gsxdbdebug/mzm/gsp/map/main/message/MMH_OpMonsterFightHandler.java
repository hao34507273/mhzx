/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.IMonsterFightHandler;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ public class MMH_OpMonsterFightHandler extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldid;
/*    */   private final IMonsterFightHandler handler;
/*    */   private final boolean regis;
/*    */   
/*    */   public MMH_OpMonsterFightHandler(long worldid, IMonsterFightHandler handler, boolean regis)
/*    */   {
/* 15 */     this.worldid = worldid;
/* 16 */     this.handler = handler;
/* 17 */     this.regis = regis;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 23 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldid);
/* 24 */     if (instance == null)
/*    */     {
/* 26 */       return;
/*    */     }
/*    */     
/* 29 */     if (this.regis)
/*    */     {
/* 31 */       instance.addFightHandler(this.handler);
/*    */     }
/*    */     else
/*    */     {
/* 35 */       instance.removeFightHandler(this.handler);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OpMonsterFightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */