/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.map.main.message.MapMessageQueue;
/*    */ import mzm.gsp.map.main.message.MapProtocolSendQueue;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Table;
/*    */ import xtable.Clone_role_npc_model;
/*    */ import xtable.Clone_role_npc_models;
/*    */ import xtable.Clone_role_npc_of_gang;
/*    */ 
/*    */ public class MapModule implements mzm.event.Module, PostModuleInitListner, MergeModule
/*    */ {
/* 19 */   private static final Logger logger = Logger.getLogger(MapModule.class);
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 24 */     MapConfiguration.init(envs);
/*    */     
/* 26 */     MapArgs.init();
/*    */     
/* 28 */     MapMessageQueue.init();
/*    */     
/* 30 */     MapProtocolSendQueue.init();
/*    */     
/* 32 */     logger.info("初始化地图数据");
/* 33 */     MapCfgManager.getInstance().init();
/*    */     
/* 35 */     logger.info("初始化地图明雷暗雷信息");
/* 36 */     MapObjectManager.getInstance().init();
/*    */     
/* 38 */     logger.info("初始化地图控制器");
/* 39 */     ControllerManager.getInstance().init();
/*    */     
/* 41 */     logger.info("外部AI初始化完成!");
/* 42 */     WorldScriptManager.getInstance().init();
/*    */     
/* 44 */     SceneManager.getInstance().initBigWorldScene();
/*    */     
/* 46 */     SceneManager.getInstance().start();
/*    */     
/* 48 */     logger.info("地图模块启动成功");
/*    */     
/* 50 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 56 */     MapMessageQueue.exit();
/*    */     
/* 58 */     MapProtocolSendQueue.exit();
/*    */     
/* 60 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 66 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 72 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 78 */     WorldManager.getInstance().postInit();
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 84 */     List<Table> tables = new ArrayList();
/* 85 */     tables.add(Clone_role_npc_model.getTable());
/* 86 */     tables.add(xtable.Clone_role_npc_of_general.getTable());
/* 87 */     tables.add(Clone_role_npc_of_gang.getTable());
/* 88 */     tables.add(Clone_role_npc_models.getTable());
/* 89 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 95 */     return new PMergeMap().call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */