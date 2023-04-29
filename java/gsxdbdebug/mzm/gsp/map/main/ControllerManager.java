/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.controller.confbean.SController;
/*    */ import mzm.gsp.map.main.controller.Controller;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ControllerManager
/*    */ {
/* 17 */   private Map<Integer, Controller> controllerMap = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 23 */   public static ControllerManager instance = new ControllerManager();
/*    */   
/*    */   public static ControllerManager getInstance()
/*    */   {
/* 27 */     return instance;
/*    */   }
/*    */   
/*    */   void init()
/*    */   {
/* 32 */     Map<Integer, SController> configMap = SController.getAll();
/* 33 */     for (SController conf : configMap.values())
/*    */     {
/* 35 */       Controller controller = new Controller(conf.id);
/* 36 */       this.controllerMap.put(Integer.valueOf(controller.getId()), controller);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isControllerExist(int controllerId)
/*    */   {
/* 42 */     return this.controllerMap.containsKey(Integer.valueOf(controllerId));
/*    */   }
/*    */   
/*    */   public Controller getController(int id)
/*    */   {
/* 47 */     return (Controller)this.controllerMap.get(Integer.valueOf(id));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ControllerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */