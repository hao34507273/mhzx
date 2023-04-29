/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ 
/*    */ public class MMH_SceneManagerUpdate
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   public void doProcess()
/*    */   {
/* 10 */     SceneManager.getInstance().update();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_SceneManagerUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */