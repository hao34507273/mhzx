/*     */ package mzm.gsp.map.main.controller;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import mzm.gsp.controller.confbean.SController;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.object.MapItem;
/*     */ import mzm.gsp.map.main.scene.object.MapMonster;
/*     */ import mzm.gsp.map.main.scene.object.MapNPC;
/*     */ import mzm.gsp.map.main.scene.object.SceneObject;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Procedure;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class Controller
/*     */ {
/*  29 */   private static final Logger logger = Logger.getLogger(Controller.class);
/*     */   private long worldId;
/*     */   
/*     */   static class MaxSpawnNumSegement
/*     */   {
/*     */     final int beginRefreshCount;
/*     */     final int endRefreshCount;
/*     */     final int maxSpawnNum;
/*     */     
/*     */     MaxSpawnNumSegement(int beginRefreshCount, int size, int maxSpawnNum) {
/*  39 */       this.beginRefreshCount = beginRefreshCount;
/*  40 */       this.endRefreshCount = (beginRefreshCount + size);
/*  41 */       this.maxSpawnNum = maxSpawnNum;
/*     */     }
/*     */     
/*     */     public int getMaxSpawnNum(int refreshCount)
/*     */     {
/*  46 */       if ((this.beginRefreshCount > refreshCount) || (refreshCount >= this.endRefreshCount))
/*     */       {
/*  48 */         return 0;
/*     */       }
/*  50 */       return this.maxSpawnNum;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  59 */   private Map<IControllerObject, Integer> needRefresh = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  64 */   private List<SceneObject> allControllerable = new LinkedList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  69 */   private Map<ExtraType, Object> extraPropData = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  74 */   private int maxCount = -1;
/*     */   
/*     */ 
/*     */ 
/*     */   public static final int ST_TRIGGER_RESPAWN = 0;
/*     */   
/*     */ 
/*  81 */   private int reachMaxStrategy = 0;
/*     */   
/*  83 */   private int refreshCount = 0;
/*  84 */   private final TreeMap<Integer, MaxSpawnNumSegement> refreshCountToSpawnNumMap = new TreeMap();
/*     */   
/*     */   private final int id;
/*     */   
/*     */ 
/*     */   public static enum ExtraType
/*     */   {
/*  91 */     FIGHT_TYPE, 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  96 */     FIGHT_REASON;
/*     */     
/*     */     private ExtraType() {}
/*     */   }
/*     */   
/* 101 */   private ConcurrentLinkedQueue<ControllerListener> listeners = new ConcurrentLinkedQueue();
/*     */   
/* 103 */   private ObjectListener listener = new ObjectListener(null);
/*     */   
/*     */   public Controller(int id)
/*     */   {
/* 107 */     this.id = id;
/*     */   }
/*     */   
/*     */   public void putData(ExtraType type, Object data)
/*     */   {
/* 112 */     if (this.extraPropData == null)
/*     */     {
/* 114 */       this.extraPropData = new HashMap();
/*     */     }
/* 116 */     this.extraPropData.put(type, data);
/*     */   }
/*     */   
/*     */   public Object getData(ExtraType type)
/*     */   {
/* 121 */     if (this.extraPropData == null)
/*     */     {
/* 123 */       return null;
/*     */     }
/* 125 */     return this.extraPropData.get(type);
/*     */   }
/*     */   
/*     */   public void refresh()
/*     */   {
/* 130 */     refresh(0);
/*     */   }
/*     */   
/*     */   public void refresh(int maxSpawnNum)
/*     */   {
/* 135 */     if ((this.maxCount > 0) && (this.refreshCount >= this.maxCount))
/*     */     {
/* 137 */       if (0 == this.reachMaxStrategy)
/*     */       {
/* 139 */         respawnOrRefresh(0);
/*     */       }
/* 141 */       return;
/*     */     }
/*     */     
/* 144 */     this.refreshCount += 1;
/* 145 */     if (maxSpawnNum > 0)
/*     */     {
/* 147 */       this.refreshCountToSpawnNumMap.put(Integer.valueOf(this.refreshCount), new MaxSpawnNumSegement(this.refreshCount, 1, maxSpawnNum));
/*     */     }
/* 149 */     doRefresh();
/*     */   }
/*     */   
/*     */   public void refresh(int count, int maxSpawnNum)
/*     */   {
/* 154 */     if (count < 1)
/*     */     {
/* 156 */       return;
/*     */     }
/*     */     
/* 159 */     if (count == 1)
/*     */     {
/* 161 */       refresh(maxSpawnNum);
/* 162 */       return;
/*     */     }
/*     */     
/* 165 */     if (this.maxCount > 0)
/*     */     {
/* 167 */       int deltaCount = this.maxCount - this.refreshCount;
/*     */       
/* 169 */       if (deltaCount <= 0)
/*     */       {
/* 171 */         if (0 == this.reachMaxStrategy)
/*     */         {
/* 173 */           respawnOrRefresh(0);
/*     */         }
/*     */         
/* 176 */         return;
/*     */       }
/*     */       
/* 179 */       if (deltaCount < count)
/*     */       {
/* 181 */         if (maxSpawnNum > 0)
/*     */         {
/* 183 */           int beginRefreshCount = this.refreshCount + 1;
/* 184 */           this.refreshCountToSpawnNumMap.put(Integer.valueOf(beginRefreshCount), new MaxSpawnNumSegement(beginRefreshCount, deltaCount, maxSpawnNum));
/*     */         }
/*     */         
/* 187 */         this.refreshCount += deltaCount;
/* 188 */         doRefresh();
/*     */         
/* 190 */         if (0 == this.reachMaxStrategy)
/*     */         {
/* 192 */           respawnOrRefresh(0);
/*     */         }
/*     */         
/* 195 */         return;
/*     */       }
/*     */     }
/*     */     
/* 199 */     if (maxSpawnNum > 0)
/*     */     {
/* 201 */       int beginRefreshCount = this.refreshCount + 1;
/* 202 */       this.refreshCountToSpawnNumMap.put(Integer.valueOf(beginRefreshCount), new MaxSpawnNumSegement(beginRefreshCount, count, maxSpawnNum));
/*     */     }
/*     */     
/* 205 */     this.refreshCount += count;
/* 206 */     doRefresh();
/*     */   }
/*     */   
/*     */   public void setMaxCount(int maxCount)
/*     */   {
/* 211 */     this.maxCount = maxCount;
/*     */   }
/*     */   
/*     */   public void addListener(ControllerListener l)
/*     */   {
/* 216 */     this.listeners.add(l);
/*     */   }
/*     */   
/*     */   public void removeListener(ControllerListener l)
/*     */   {
/* 221 */     this.listeners.remove(l);
/*     */   }
/*     */   
/*     */   private void onSceneObjectDead(SceneObject object)
/*     */   {
/* 226 */     if (this.refreshCount <= 0)
/*     */     {
/* 228 */       return;
/*     */     }
/*     */     
/* 231 */     SController controllerCfg = SController.get(this.id);
/* 232 */     if (controllerCfg == null)
/*     */     {
/* 234 */       logger.warn(String.format("[map]Controller.onSceneObjectDead@controller cfg is null|world_instanceid=%d|cfgid=%d", new Object[] { Long.valueOf(this.worldId), Integer.valueOf(this.id) }));
/*     */       
/* 236 */       return;
/*     */     }
/*     */     
/* 239 */     if (controllerCfg.canRespawn)
/*     */     {
/* 241 */       return;
/*     */     }
/*     */     
/* 244 */     this.allControllerable.remove(object);
/*     */   }
/*     */   
/*     */   private class ObjectListener implements mzm.gsp.map.main.scene.object.ISceneObjectListener
/*     */   {
/*     */     private ObjectListener() {}
/*     */     
/*     */     public void onDead(SceneObject object) {
/* 252 */       Controller.this.onSceneObjectDead(object);
/*     */       
/* 254 */       if (Controller.this.listeners.isEmpty())
/*     */       {
/* 256 */         return;
/*     */       }
/*     */       
/* 259 */       final ControllerContext controllerContext = Controller.this.getContext(object);
/* 260 */       if (controllerContext == null)
/*     */       {
/* 262 */         return;
/*     */       }
/*     */       
/* 265 */       for (final ControllerListener listener : Controller.this.listeners)
/*     */       {
/* 267 */         if (listener.isCallInProcedure())
/*     */         {
/* 269 */           Procedure.execute(new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp()
/*     */               throws Exception
/*     */             {
/* 274 */               listener.onDestroy(controllerContext);
/*     */               
/* 276 */               return true;
/*     */             }
/*     */             
/*     */ 
/*     */           });
/*     */         } else {
/* 282 */           Xdb.executor().execute(new LogicRunnable()
/*     */           {
/*     */             public void process()
/*     */               throws Exception
/*     */             {
/* 287 */               listener.onDestroy(controllerContext);
/*     */             }
/*     */           });
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public void onBorn(SceneObject object)
/*     */     {
/* 297 */       if (Controller.this.listeners.isEmpty())
/*     */       {
/* 299 */         return;
/*     */       }
/*     */       
/* 302 */       final ControllerContext controllerContext = Controller.this.getContext(object);
/* 303 */       if (controllerContext == null)
/*     */       {
/* 305 */         return;
/*     */       }
/*     */       
/* 308 */       for (final ControllerListener listener : Controller.this.listeners)
/*     */       {
/* 310 */         if (listener.isCallInProcedure())
/*     */         {
/* 312 */           Procedure.execute(new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp()
/*     */               throws Exception
/*     */             {
/* 317 */               listener.onSpawn(controllerContext);
/*     */               
/* 319 */               return true;
/*     */             }
/*     */             
/*     */ 
/*     */           });
/*     */         } else {
/* 325 */           Xdb.executor().execute(new LogicRunnable()
/*     */           {
/*     */             public void process()
/*     */               throws Exception
/*     */             {
/* 330 */               listener.onSpawn(controllerContext);
/*     */             }
/*     */           });
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void respawn(SceneObject object)
/*     */   {
/* 340 */     if (!this.allControllerable.contains(object))
/*     */     {
/* 342 */       return;
/*     */     }
/*     */     
/* 345 */     if ((object instanceof MapMonster))
/*     */     {
/* 347 */       MapMonster monster = (MapMonster)object;
/* 348 */       monster.spawnMe(TransferType.SOMMON);
/*     */     }
/* 350 */     else if ((object instanceof MapItem))
/*     */     {
/* 352 */       MapItem mapItem = (MapItem)object;
/* 353 */       mapItem.spawnMe(TransferType.SOMMON);
/*     */     }
/*     */   }
/*     */   
/*     */   private ControllerContext getContext(SceneObject object)
/*     */   {
/* 359 */     Scene scene = SceneManager.getInstance().getScene(object.getPosition());
/* 360 */     if (scene == null)
/*     */     {
/* 362 */       return null;
/*     */     }
/*     */     
/* 365 */     ControllerContext context = new ControllerContext(this.worldId, this.id);
/* 366 */     context.setObjectId(object.getObjectId());
/* 367 */     context.putExtra(0, Integer.valueOf(scene.getCfgId()));
/* 368 */     if ((object instanceof MapMonster))
/*     */     {
/* 370 */       MapMonster monster = (MapMonster)object;
/* 371 */       context.putExtra(2, Integer.valueOf(0));
/* 372 */       context.putExtra(1, monster.getCfgId());
/*     */     }
/* 374 */     else if ((object instanceof MapItem))
/*     */     {
/* 376 */       MapItem monster = (MapItem)object;
/* 377 */       context.putExtra(2, Integer.valueOf(1));
/* 378 */       context.putExtra(1, Integer.valueOf(monster.getCfgId()));
/*     */     }
/* 380 */     else if ((object instanceof MapNPC))
/*     */     {
/* 382 */       MapNPC monster = (MapNPC)object;
/* 383 */       context.putExtra(2, Integer.valueOf(2));
/* 384 */       context.putExtra(1, monster.getCfgId());
/*     */     }
/*     */     else
/*     */     {
/* 388 */       return null;
/*     */     }
/* 390 */     return context;
/*     */   }
/*     */   
/*     */   private void _refresh()
/*     */   {
/* 395 */     int refresh = this.refreshCount;
/* 396 */     for (Map.Entry<IControllerObject, Integer> refreshEntry : this.needRefresh.entrySet())
/*     */     {
/* 398 */       int objLife = ((Integer)refreshEntry.getValue()).intValue();
/* 399 */       while (objLife < refresh)
/*     */       {
/* 401 */         objLife++;
/* 402 */         Map.Entry<Integer, MaxSpawnNumSegement> segementEntry = this.refreshCountToSpawnNumMap.floorEntry(Integer.valueOf(objLife));
/* 403 */         int maxSpawnNum = segementEntry == null ? 0 : ((MaxSpawnNumSegement)segementEntry.getValue()).getMaxSpawnNum(objLife);
/* 404 */         List<? extends SceneObject> objects = ((IControllerObject)refreshEntry.getKey()).refresh(this.worldId, maxSpawnNum);
/* 405 */         if (objects != null)
/*     */         {
/* 407 */           for (SceneObject object : objects)
/*     */           {
/* 409 */             object.addListener(this.listener);
/* 410 */             this.allControllerable.add(object);
/* 411 */             object.notifyBorn();
/*     */           }
/*     */         }
/*     */       }
/* 415 */       refreshEntry.setValue(Integer.valueOf(objLife));
/*     */     }
/*     */   }
/*     */   
/*     */   public void doRefresh()
/*     */   {
/* 421 */     _refresh();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void respawnAll()
/*     */   {
/* 429 */     for (SceneObject object : this.allControllerable)
/*     */     {
/* 431 */       if (!object.isAlive())
/*     */       {
/* 433 */         object.spawnMe(TransferType.SOMMON);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void respawnOrRefresh(int count)
/*     */   {
/* 443 */     if (this.refreshCount < count)
/*     */     {
/* 445 */       this.refreshCount += 1;
/* 446 */       _refresh();
/* 447 */       return;
/*     */     }
/*     */     
/* 450 */     for (SceneObject object : this.allControllerable)
/*     */     {
/* 452 */       if (!object.isAlive())
/*     */       {
/* 454 */         object.spawnMe(TransferType.SOMMON);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void setWorldId(long worldId)
/*     */   {
/* 461 */     this.worldId = worldId;
/*     */   }
/*     */   
/*     */   public List<Integer> getAllBornMap()
/*     */   {
/* 466 */     List<Integer> mapSet = new ArrayList();
/* 467 */     for (SceneObject controllerable : this.allControllerable)
/*     */     {
/* 469 */       mapSet.add(Integer.valueOf(controllerable.getSceneId()));
/*     */     }
/* 471 */     return mapSet;
/*     */   }
/*     */   
/*     */   public void collectObject()
/*     */   {
/* 476 */     this.refreshCount = 0;
/* 477 */     this.refreshCountToSpawnNumMap.clear();
/* 478 */     doCollect();
/*     */   }
/*     */   
/*     */   private void doCollect()
/*     */   {
/* 483 */     if (logger.isDebugEnabled())
/*     */     {
/* 485 */       logger.debug(String.format("[map]Controller.doCollect@destroy controllerable object failed|world_instanceid=%d|cfgid=%d", new Object[] { Long.valueOf(this.worldId), Integer.valueOf(this.id) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 490 */     for (Map.Entry<IControllerObject, Integer> entry : this.needRefresh.entrySet())
/*     */     {
/* 492 */       entry.setValue(Integer.valueOf(0));
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 497 */       Iterator<SceneObject> itr = this.allControllerable.iterator();
/* 498 */       while (itr.hasNext())
/*     */       {
/* 500 */         SceneObject sceneObject = (SceneObject)itr.next();
/*     */         try
/*     */         {
/* 503 */           sceneObject.destroy();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 507 */           logger.error(String.format("[map]Controller.doCollect@destroy controllerable object failed|world_instanceid=%d|cfgid=%d|object_type=%s|object_id=%s", new Object[] { Long.valueOf(this.worldId), Integer.valueOf(this.id), sceneObject.getClass().getName(), sceneObject.getObjectId() }), e);
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 512 */         itr.remove();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 517 */       this.allControllerable.clear();
/*     */       
/* 519 */       logger.error(String.format("[map]Controller.doCollect@destroy controllerable object failed|world_instanceid=%d|cfgid=%d", new Object[] { Long.valueOf(this.worldId), Integer.valueOf(this.id) }), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addRefreshObject(IControllerObject object)
/*     */   {
/* 528 */     this.needRefresh.put(object, Integer.valueOf(0));
/* 529 */     if (this.refreshCount > 0)
/*     */     {
/* 531 */       doRefresh();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getId()
/*     */   {
/* 537 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Controller duplicate()
/*     */   {
/* 547 */     Controller controller = new Controller(this.id);
/* 548 */     controller.needRefresh.putAll(this.needRefresh);
/* 549 */     return controller;
/*     */   }
/*     */   
/*     */   public void release()
/*     */   {
/* 554 */     this.needRefresh.clear();
/*     */     
/* 556 */     this.allControllerable.clear();
/*     */     
/* 558 */     if (this.extraPropData != null)
/*     */     {
/* 560 */       this.extraPropData.clear();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\controller\Controller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */