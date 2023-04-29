/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ 
/*    */ public class MMH_GetSceneName
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int sceneId;
/* 10 */   private String result = "";
/*    */   
/*    */   public MMH_GetSceneName(int sceneId)
/*    */   {
/* 14 */     this.sceneId = sceneId;
/*    */   }
/*    */   
/*    */   public String getResult()
/*    */   {
/* 19 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 25 */     Scene scene = SceneManager.getInstance().getScene(this.sceneId);
/* 26 */     if (scene == null)
/*    */     {
/* 28 */       return;
/*    */     }
/* 30 */     this.result = scene.getName();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetSceneName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */