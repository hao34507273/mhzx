/*     */ package mzm.gsp.map.main.scene;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.worldai.script.IAIContext;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.worldai.confbean.SWorldAiConfig;
/*     */ 
/*     */ public final class SceneAiContext implements IAIContext
/*     */ {
/*     */   private long lastUpdateTime;
/*     */   private Scene scene;
/*  20 */   private Map<Integer, ScriptTimerCounter> counterMap = new HashMap();
/*     */   
/*  22 */   private static final ThreadLocal<Integer> threadScriptId = new ThreadLocal();
/*     */   
/*  24 */   private ConcurrentLinkedQueue<Integer> needRemoveQueue = new ConcurrentLinkedQueue();
/*     */   
/*     */   public SceneAiContext(Scene scene)
/*     */   {
/*  28 */     this.scene = scene;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getMapParam(int id)
/*     */   {
/*  34 */     return this.scene.getMapAiParam(id);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getWorldParam(int id)
/*     */   {
/*  40 */     return this.scene.getWorldInstance().getWorldAiParam(id);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getGlobalParam(int id)
/*     */   {
/*  46 */     return WorldManager.getInstance().getGlobalAiParam(id);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getControllerState(int id)
/*     */   {
/*  52 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isNpcExist(int id)
/*     */   {
/*  58 */     return this.scene.isNpcExistByCfgId(id);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isMonsterExist(int id)
/*     */   {
/*  64 */     return this.scene.isMonsterExistByCfgId(id);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getMonsterNumber(int id)
/*     */   {
/*  70 */     return this.scene.getMonsterNumberCfgId(id);
/*     */   }
/*     */   
/*     */   private boolean checkParam(int id, int value)
/*     */   {
/*  75 */     int scriptId = ((Integer)threadScriptId.get()).intValue();
/*  76 */     SWorldAiConfig config = SWorldAiConfig.get(scriptId);
/*  77 */     if (!config.paramList.contains(Integer.valueOf(id)))
/*     */     {
/*  79 */       return false;
/*     */     }
/*  81 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public void addMapParam(int id, int value)
/*     */   {
/*  87 */     setMapParam(id, this.scene.getMapAiParam(id) + value);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addWorldParam(int id, int value)
/*     */   {
/*  93 */     setWorldParam(id, this.scene.getWorldInstance().getWorldAiParam(id) + value);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addGlobalParam(int id, int value)
/*     */   {
/*  99 */     setGlobalParam(id, WorldManager.getInstance().getGlobalAiParam(id) + value);
/*     */   }
/*     */   
/*     */ 
/*     */   public void setMapParam(int id, int value)
/*     */   {
/* 105 */     if (!checkParam(id, value))
/*     */     {
/* 107 */       return;
/*     */     }
/* 109 */     this.scene.putMapAiParam(id, value);
/*     */   }
/*     */   
/*     */ 
/*     */   public void setWorldParam(int id, int value)
/*     */   {
/* 115 */     if (!checkParam(id, value))
/*     */     {
/* 117 */       return;
/*     */     }
/* 119 */     this.scene.getWorldInstance().putWorldAiParam(id, value);
/*     */   }
/*     */   
/*     */ 
/*     */   public void setGlobalParam(int id, int value)
/*     */   {
/* 125 */     if (!checkParam(id, value))
/*     */     {
/* 127 */       return;
/*     */     }
/* 129 */     WorldManager.getInstance().putGlobalAiParam(id, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void speek(String text, int scope) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void setControllerState(int id, boolean state)
/*     */   {
/* 140 */     if (state)
/*     */     {
/* 142 */       this.scene.getWorldInstance().triggerController(id);
/*     */     }
/*     */     else
/*     */     {
/* 146 */       this.scene.getWorldInstance().collectController(id);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean createTimer(int id, int interval, int count)
/*     */   {
/* 153 */     if (this.counterMap.containsKey(Integer.valueOf(id)))
/*     */     {
/* 155 */       return false;
/*     */     }
/* 157 */     ScriptTimerCounter counter = new ScriptTimerCounter(id, interval, count);
/* 158 */     this.counterMap.put(Integer.valueOf(id), counter);
/* 159 */     return true;
/*     */   }
/*     */   
/*     */   void update()
/*     */   {
/* 164 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 165 */     if (now - this.lastUpdateTime < 1000L)
/*     */     {
/* 167 */       return;
/*     */     }
/* 169 */     this.lastUpdateTime = now;
/* 170 */     Iterator<Integer> it = this.counterMap.keySet().iterator();
/* 171 */     while (it.hasNext())
/*     */     {
/* 173 */       int id = ((Integer)it.next()).intValue();
/* 174 */       ScriptTimerCounter counter = (ScriptTimerCounter)this.counterMap.get(Integer.valueOf(id));
/* 175 */       if (!counter.update())
/*     */       {
/* 177 */         it.remove();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isTimerTrigger(int id)
/*     */   {
/* 185 */     ScriptTimerCounter counter = (ScriptTimerCounter)this.counterMap.get(Integer.valueOf(id));
/* 186 */     if (counter == null)
/*     */     {
/* 188 */       return false;
/*     */     }
/* 190 */     return counter.isTrigger();
/*     */   }
/*     */   
/*     */   void beforeScriptExecute(int scriptId)
/*     */   {
/* 195 */     threadScriptId.set(Integer.valueOf(scriptId));
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean hasTimer(int id)
/*     */   {
/* 201 */     return this.counterMap.containsKey(Integer.valueOf(id));
/*     */   }
/*     */   
/*     */ 
/*     */   public void finishScript()
/*     */   {
/* 207 */     this.needRemoveQueue.add(threadScriptId.get());
/*     */   }
/*     */   
/*     */   public List<Integer> getRemoveScriptList()
/*     */   {
/* 212 */     List<Integer> returnList = new ArrayList(this.needRemoveQueue);
/* 213 */     this.needRemoveQueue.clear();
/* 214 */     return returnList;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\SceneAiContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */