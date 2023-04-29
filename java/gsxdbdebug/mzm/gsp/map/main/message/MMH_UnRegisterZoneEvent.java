/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ 
/*    */ public class MMH_UnRegisterZoneEvent extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int sceneid;
/*    */   private final int eventid;
/*    */   
/*    */   public MMH_UnRegisterZoneEvent(int sceneid, int eventid)
/*    */   {
/* 13 */     this.sceneid = sceneid;
/* 14 */     this.eventid = eventid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 20 */     Scene scene = SceneManager.getInstance().getScene(this.sceneid);
/* 21 */     if (scene == null)
/*    */     {
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     scene.unregisterZoneEvent(this.eventid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_UnRegisterZoneEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */