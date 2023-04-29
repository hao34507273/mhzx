/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.map.main.controller.Controller;
/*     */ import mzm.gsp.map.main.controller.ControllerListener;
/*     */ import mzm.gsp.map.main.message.MMH_CollectController;
/*     */ import mzm.gsp.map.main.message.MMH_CollectControllerByRole;
/*     */ import mzm.gsp.map.main.message.MMH_CollectWorldController;
/*     */ import mzm.gsp.map.main.message.MMH_GetControllerMapList;
/*     */ import mzm.gsp.map.main.message.MMH_RespawnAllDestroy;
/*     */ import mzm.gsp.map.main.message.MMH_SetControllerMaxCount;
/*     */ import mzm.gsp.map.main.message.MMH_TriggerController;
/*     */ import mzm.gsp.map.main.message.MMH_TriggerControllerByRole;
/*     */ import mzm.gsp.map.main.message.MMH_TriggerOrRespawn;
/*     */ import mzm.gsp.map.main.message.MMH_TriggerWorldController;
/*     */ import mzm.gsp.map.main.message.MMH_TriggerWorldControllerCount;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ControllerInterface
/*     */ {
/*     */   public static boolean isControllerExist(int controllerId)
/*     */   {
/*  38 */     return ControllerManager.getInstance().isControllerExist(controllerId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void triggerController(long roleId, int controllerId, int count, int maxSpawnNum)
/*     */   {
/*  56 */     new MMH_TriggerControllerByRole(roleId, controllerId, count, maxSpawnNum).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void triggerController(long roleId, int controllerId)
/*     */   {
/*  70 */     new MMH_TriggerControllerByRole(roleId, controllerId).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerControllerListener(long roleId, int controllerId, ControllerListener listener)
/*     */   {
/*  86 */     WorldInstance instance = WorldManager.getInstance().getRoleWorldInstanceFromStack(roleId);
/*  87 */     if (instance == null)
/*     */     {
/*  89 */       return;
/*     */     }
/*  91 */     Controller controller = instance.getController(controllerId);
/*  92 */     if (controller != null)
/*     */     {
/*  94 */       controller.addListener(listener);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerWorldControllerListener(long worldId, int controllerId, ControllerListener listener)
/*     */   {
/* 112 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(worldId);
/* 113 */     if (instance == null)
/*     */     {
/* 115 */       return;
/*     */     }
/* 117 */     Controller controller = instance.getController(controllerId);
/* 118 */     if (controller != null)
/*     */     {
/* 120 */       controller.addListener(listener);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerControllerListener(int controllerId, ControllerListener listener)
/*     */   {
/* 135 */     WorldInstance instance = WorldManager.getInstance().getBigWorldInstance();
/* 136 */     if (instance == null)
/*     */     {
/* 138 */       return;
/*     */     }
/* 140 */     Controller controller = instance.getController(controllerId);
/* 141 */     if (controller != null)
/*     */     {
/* 143 */       controller.addListener(listener);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void collectController(long roleId, int controllerId)
/*     */   {
/* 157 */     new MMH_CollectControllerByRole(roleId, controllerId).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void triggerController(int controllerId)
/*     */   {
/* 168 */     new MMH_TriggerController(controllerId).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void collectController(int controllerId)
/*     */   {
/* 179 */     new MMH_CollectController(controllerId).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void triggerWorldController(long worldId, int controllerId)
/*     */   {
/* 192 */     new MMH_TriggerWorldController(worldId, controllerId).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void triggerWorldControllerWithMaxSpawnNum(long worldId, int controllerId, int maxSpawnNum)
/*     */   {
/* 207 */     new MMH_TriggerWorldController(worldId, controllerId, maxSpawnNum).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void triggerWorldController(long worldId, int controllerId, int count)
/*     */   {
/* 222 */     new MMH_TriggerWorldControllerCount(worldId, controllerId, count).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void triggerWorldControllerWithMaxSpawnNum(long worldId, int controllerId, int count, int maxSpawnNum)
/*     */   {
/* 240 */     new MMH_TriggerWorldControllerCount(worldId, controllerId, count, maxSpawnNum).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void collectWorldController(long worldId, int controllerId)
/*     */   {
/* 253 */     new MMH_CollectWorldController(worldId, controllerId).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getControllerMapList(int controllerId)
/*     */   {
/* 264 */     MMH_GetControllerMapList handler = new MMH_GetControllerMapList(controllerId);
/* 265 */     handler.call();
/* 266 */     return handler.getMapList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void reSpawnAllDestroy(long worldId, int controllerId)
/*     */   {
/* 279 */     new MMH_RespawnAllDestroy(worldId, controllerId).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void triggerOrReSpawn(long worldId, int controllerId)
/*     */   {
/* 290 */     new MMH_TriggerOrRespawn(worldId, controllerId, 1).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void triggerOrReSpawn(long worldId, int controllerId, int triggerCount)
/*     */   {
/* 303 */     new MMH_TriggerOrRespawn(worldId, controllerId, triggerCount).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setControllerMaxCount(long worldId, int controllerId, int maxCount)
/*     */   {
/* 318 */     new MMH_SetControllerMaxCount(worldId, controllerId, maxCount).execute();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ControllerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */