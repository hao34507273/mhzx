/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ public class MMH_TriggerController extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int controllerid;
/*    */   
/*    */   public MMH_TriggerController(int controllerid)
/*    */   {
/* 11 */     this.controllerid = controllerid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 17 */     WorldManager.getInstance().getBigWorldInstance().triggerController(this.controllerid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_TriggerController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */