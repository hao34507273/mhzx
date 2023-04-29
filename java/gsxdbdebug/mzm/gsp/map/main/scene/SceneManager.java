/*     */ package mzm.gsp.map.main.scene;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.confbean.SMapGlobalConfig;
/*     */ import mzm.gsp.map.main.MapConfiguration;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.message.MMH_SceneManagerUpdate;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class SceneManager
/*     */ {
/*  20 */   private static final Logger logger = Logger.getLogger(SceneManager.class);
/*     */   
/*  22 */   private static final SceneManager instance = new SceneManager();
/*     */   
/*     */   public static SceneManager getInstance()
/*     */   {
/*  26 */     return instance;
/*     */   }
/*     */   
/*  29 */   private Map<Integer, Scene> allGameSceneMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private long lastUpdateTime;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initBigWorldScene()
/*     */   {
/*  41 */     WorldInstance bigWorld = WorldManager.getInstance().getBigWorldInstance();
/*  42 */     for (Integer mapCfgid : SMapGlobalConfig.get(1).worldMapCfgids)
/*     */     {
/*  44 */       Scene scene = new Scene(mapCfgid.intValue(), bigWorld);
/*  45 */       scene.start();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isPosInBigWorld(int sceneid)
/*     */   {
/*  51 */     Scene scene = getScene(sceneid);
/*  52 */     if (scene == null)
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     return scene.getWorld() == WorldManager.getInstance().getBigWorldInstance();
/*     */   }
/*     */   
/*     */   public boolean isPosInBigWorld(Position pos)
/*     */   {
/*  62 */     return isPosInBigWorld(pos.getSceneId());
/*     */   }
/*     */   
/*     */   public Scene getScene(int sceneId)
/*     */   {
/*  67 */     Scene scene = (Scene)this.allGameSceneMap.get(Integer.valueOf(sceneId));
/*  68 */     if ((scene == null) || (scene.isDestroyed()))
/*     */     {
/*  70 */       return null;
/*     */     }
/*     */     
/*  73 */     return scene;
/*     */   }
/*     */   
/*     */   public Scene getScene(Position pos)
/*     */   {
/*  78 */     return getScene(pos.getSceneId());
/*     */   }
/*     */   
/*     */   void addScene(Scene scene)
/*     */   {
/*  83 */     this.allGameSceneMap.put(Integer.valueOf(scene.getId()), scene);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSceneExist(int sceneId)
/*     */   {
/*  95 */     return getScene(sceneId) != null;
/*     */   }
/*     */   
/*     */   public void update()
/*     */   {
/*     */     try
/*     */     {
/* 102 */       Iterator<Map.Entry<Integer, Scene>> iter = this.allGameSceneMap.entrySet().iterator();
/* 103 */       while (iter.hasNext())
/*     */       {
/* 105 */         Scene scene = (Scene)((Map.Entry)iter.next()).getValue();
/* 106 */         if (scene.isDestroyed())
/*     */         {
/* 108 */           iter.remove();
/*     */         }
/*     */         else
/*     */         {
/* 112 */           scene.update();
/*     */         }
/*     */       }
/* 115 */       long time = DateTimeUtils.getCurrTimeInMillis();
/* 116 */       MapObjectInstanceManager.getInstance().update(time);
/*     */       
/* 118 */       if (time - this.lastUpdateTime > MapConfiguration.SCENE_LOG_INTERVAL)
/*     */       {
/* 120 */         StringBuilder sb = new StringBuilder();
/* 121 */         sb.append("\n");
/* 122 */         sb.append("************************ begin scene log **********************************\n");
/* 123 */         sb.append("current runnable scenes : " + this.allGameSceneMap.size()).append("\n");
/* 124 */         sb.append("instanceId mapId mapName roleCount/npcCount/monsterCount/mapItemCount\n");
/* 125 */         for (Scene scene : this.allGameSceneMap.values())
/*     */         {
/* 127 */           sb.append(String.format("%-10d %-10d %-10s %d/%s\n", new Object[] { Integer.valueOf(scene.getId()), Integer.valueOf(scene.getCfgId()), scene.getName(), Integer.valueOf(scene.getRoleCount()), scene.getSceneLog() }));
/*     */         }
/*     */         
/* 130 */         sb.append("************************ end scene log **********************************");
/* 131 */         logger.info(sb.toString());
/*     */         
/* 133 */         this.lastUpdateTime = time;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 138 */       logger.error("[map]SceneManager.update@scene update error!", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void start()
/*     */   {
/* 144 */     new SceneTask();
/*     */   }
/*     */   
/*     */   private class SceneTask extends MilliObserver
/*     */   {
/*     */     SceneTask()
/*     */     {
/* 151 */       super();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 157 */       new MMH_SceneManagerUpdate().execute();
/*     */       
/* 159 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\SceneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */