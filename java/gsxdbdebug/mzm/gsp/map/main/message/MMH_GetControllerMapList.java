/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.controller.Controller;
/*    */ 
/*    */ public class MMH_GetControllerMapList
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int controllerId;
/*    */   private List<Integer> mapList;
/*    */   
/*    */   public MMH_GetControllerMapList(int controllerId)
/*    */   {
/* 17 */     this.controllerId = controllerId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 23 */     Controller controller = WorldManager.getInstance().getBigWorldInstance().getController(this.controllerId);
/* 24 */     if (controller != null)
/*    */     {
/* 26 */       this.mapList = controller.getAllBornMap();
/*    */     }
/*    */     else
/*    */     {
/* 30 */       this.mapList = Collections.emptyList();
/*    */     }
/*    */   }
/*    */   
/*    */   public List<Integer> getMapList()
/*    */   {
/* 36 */     return this.mapList;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetControllerMapList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */