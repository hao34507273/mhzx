/*     */ package mzm.gsp.map.main.scene.object;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.SMapItemEnterView;
/*     */ import mzm.gsp.map.SMapItemLeaveView;
/*     */ import mzm.gsp.map.confbean.SMapItemCfg;
/*     */ import mzm.gsp.map.confbean.SMapItemConfig;
/*     */ import mzm.gsp.map.confbean.StateSet;
/*     */ import mzm.gsp.map.main.IdGenerator;
/*     */ import mzm.gsp.map.main.MapConfiguration;
/*     */ import mzm.gsp.map.main.MapItemGatherContext;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.PMapItemGatherReq;
/*     */ import mzm.gsp.map.main.message.MMH_DestroyItem;
/*     */ import mzm.gsp.map.main.message.MMH_OnMapItemGatherReqProcedureDone;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.view.CircleView;
/*     */ import mzm.gsp.task.main.TaskInterface.TaskState;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xdb.Procedure;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public class MapItem extends SceneObject
/*     */ {
/*     */   private final MapItemId objid;
/*     */   private final int cfgid;
/*  33 */   private final LinkedHashMap<Long, MapItemGatherContext> gatherRoleList = new LinkedHashMap();
/*  34 */   private final Done procedureDone = new Done();
/*  35 */   private int counter = 0;
/*  36 */   private long bornTime = 0L;
/*  37 */   private boolean destroyed = false;
/*     */   
/*     */   public MapItem(int cfgid)
/*     */   {
/*  41 */     this.objid = new MapItemId(sceneObjIdGenerator.nextId());
/*  42 */     this.cfgid = cfgid;
/*     */     
/*  44 */     SMapItemConfig itemConfig = SMapItemConfig.get(this.cfgid);
/*  45 */     if (!itemConfig.visibleByTaskState.isEmpty())
/*     */     {
/*  47 */       this.isVisible = false;
/*     */     }
/*     */     
/*  50 */     this.view = new CircleView(this, MapConfiguration.VIEW_WIDTH);
/*     */   }
/*     */   
/*     */ 
/*     */   public MapItemId getObjectId()
/*     */   {
/*  56 */     return this.objid;
/*     */   }
/*     */   
/*     */   public int getItemId()
/*     */   {
/*  61 */     return this.objid.getId().intValue();
/*     */   }
/*     */   
/*     */   public int getCfgId()
/*     */   {
/*  66 */     return this.cfgid;
/*     */   }
/*     */   
/*     */ 
/*     */   public void spawnMe(int x, int y, int z, int sceneId, TransferType type)
/*     */   {
/*  72 */     MapObjectInstanceManager.getInstance().addMapItem(this);
/*     */     
/*  74 */     this.destroyed = false;
/*  75 */     this.counter = 0;
/*  76 */     this.bornTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  78 */     super.spawnMe(x, y, z, sceneId, type);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCanSee(MapRole role)
/*     */   {
/*  84 */     if (isDestroyed())
/*     */     {
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     if (this.isVisible)
/*     */     {
/*  91 */       return true;
/*     */     }
/*     */     
/*  94 */     SMapItemCfg itemCfg = SMapItemCfg.get(this.cfgid);
/*  95 */     SMapItemConfig itemConfig = SMapItemConfig.get(this.cfgid);
/*  96 */     if ((itemCfg == null) || (itemConfig == null))
/*     */     {
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     Map<Integer, TaskInterface.TaskState> roleTaskState = role.getRoleTaskMap();
/* 102 */     Map<Integer, StateSet> needTaskState = itemConfig.visibleByTaskState;
/* 103 */     Iterator<Integer> needTaskIdit = needTaskState.keySet().iterator();
/* 104 */     StateSet needState; while (needTaskIdit.hasNext())
/*     */     {
/* 106 */       int needTaskId = ((Integer)needTaskIdit.next()).intValue();
/* 107 */       TaskInterface.TaskState state = (TaskInterface.TaskState)roleTaskState.get(Integer.valueOf(needTaskId));
/* 108 */       if (state != null)
/*     */       {
/*     */ 
/*     */ 
/* 112 */         needState = (StateSet)needTaskState.get(Integer.valueOf(needTaskId));
/* 113 */         for (Integer ts : state.getStateSet())
/*     */         {
/* 115 */           if (needState.stateSet.contains(ts))
/*     */           {
/* 117 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 122 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createEnterView()
/*     */   {
/* 128 */     SMapItemEnterView mapItemEnterView = new SMapItemEnterView();
/* 129 */     mapItemEnterView.instanceid = getItemId();
/* 130 */     mapItemEnterView.mapitemcfgid = getCfgId();
/* 131 */     mapItemEnterView.loc.x = this.position.getX();
/* 132 */     mapItemEnterView.loc.y = this.position.getY();
/*     */     
/* 134 */     return mapItemEnterView;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onGathered()
/*     */   {
/* 142 */     SMapItemCfg itemCfg = SMapItemCfg.get(this.cfgid);
/* 143 */     SMapItemConfig itemConfig = SMapItemConfig.get(this.cfgid);
/* 144 */     if ((itemCfg == null) || (itemConfig == null))
/*     */     {
/* 146 */       return;
/*     */     }
/*     */     
/* 149 */     if (!itemConfig.visibleByTaskState.isEmpty())
/*     */     {
/* 151 */       return;
/*     */     }
/*     */     
/* 154 */     if ((itemCfg.maxCount > 0) && (++this.counter >= itemCfg.maxCount))
/*     */     {
/* 156 */       destroy();
/*     */     }
/*     */   }
/*     */   
/*     */   boolean isDestroyed()
/*     */   {
/* 162 */     return this.destroyed;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isAlive()
/*     */   {
/* 168 */     if (isDestroyed())
/*     */     {
/* 170 */       return false;
/*     */     }
/*     */     
/* 173 */     return super.isAlive();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isVisible()
/*     */   {
/* 179 */     if (isDestroyed())
/*     */     {
/* 181 */       return false;
/*     */     }
/*     */     
/* 184 */     return super.isVisible();
/*     */   }
/*     */   
/*     */ 
/*     */   public void update(long time)
/*     */   {
/* 190 */     if ((isDestroyed()) || (!isAlive()))
/*     */     {
/* 192 */       return;
/*     */     }
/*     */     
/* 195 */     SMapItemCfg cfg = getMapItemCfg();
/* 196 */     if ((cfg != null) && (cfg.survivalTime > 0) && ((time - this.bornTime) / 1000L > cfg.survivalTime))
/*     */     {
/* 198 */       this.destroyed = true;
/*     */       
/* 200 */       new MMH_DestroyItem(getItemId()).execute();
/*     */       
/* 202 */       return;
/*     */     }
/*     */     
/* 205 */     super.update(time);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDestroy()
/*     */   {
/* 211 */     MapObjectInstanceManager.getInstance().removeMapItem(getItemId());
/*     */   }
/*     */   
/*     */   public SMapItemCfg getMapItemCfg()
/*     */   {
/* 216 */     return SMapItemCfg.get(this.cfgid);
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createLeaveView()
/*     */   {
/* 222 */     SMapItemLeaveView mapItemLeaveView = new SMapItemLeaveView();
/* 223 */     mapItemLeaveView.instanceid = getItemId();
/* 224 */     return mapItemLeaveView;
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createMoveProtocol()
/*     */   {
/* 230 */     return null;
/*     */   }
/*     */   
/*     */   public void spawnMe(TransferType type)
/*     */   {
/* 235 */     spawnMe(this.position.getX(), this.position.getY(), this.position.getZ(), this.position.getSceneId(), type);
/*     */   }
/*     */   
/*     */ 
/*     */   public void destroy()
/*     */   {
/* 241 */     super.destroy();
/*     */     
/* 243 */     this.gatherRoleList.clear();
/*     */   }
/*     */   
/*     */   public void addGatherTask(long roleId, MapItemGatherContext context)
/*     */   {
/* 248 */     if (isDestroyed())
/*     */     {
/* 250 */       return;
/*     */     }
/*     */     
/* 253 */     if (this.gatherRoleList.containsKey(Long.valueOf(roleId)))
/*     */     {
/* 255 */       return;
/*     */     }
/*     */     
/* 258 */     this.gatherRoleList.put(Long.valueOf(roleId), context);
/* 259 */     if (this.gatherRoleList.size() == 1)
/*     */     {
/* 261 */       Map.Entry<Long, MapItemGatherContext> entry = peekFirst();
/* 262 */       if (entry == null)
/*     */       {
/* 264 */         return;
/*     */       }
/* 266 */       Procedure.execute(new PMapItemGatherReq(((Long)entry.getKey()).longValue(), getItemId(), (MapItemGatherContext)entry.getValue()), this.procedureDone);
/*     */     }
/*     */   }
/*     */   
/*     */   public Map.Entry<Long, MapItemGatherContext> peekFirst()
/*     */   {
/* 272 */     Iterator<Map.Entry<Long, MapItemGatherContext>> itr = this.gatherRoleList.entrySet().iterator();
/* 273 */     if (itr.hasNext())
/*     */     {
/* 275 */       return (Map.Entry)itr.next();
/*     */     }
/*     */     
/* 278 */     return null;
/*     */   }
/*     */   
/*     */   public Map.Entry<Long, MapItemGatherContext> pollFirst()
/*     */   {
/* 283 */     Iterator<Map.Entry<Long, MapItemGatherContext>> itr = this.gatherRoleList.entrySet().iterator();
/* 284 */     if (itr.hasNext())
/*     */     {
/* 286 */       Map.Entry<Long, MapItemGatherContext> entry = (Map.Entry)itr.next();
/* 287 */       itr.remove();
/* 288 */       return entry;
/*     */     }
/*     */     
/* 291 */     return null;
/*     */   }
/*     */   
/*     */   public void onMapItemGatherReqProdureDone()
/*     */   {
/* 296 */     if (this.gatherRoleList.isEmpty())
/*     */     {
/* 298 */       return;
/*     */     }
/*     */     
/* 301 */     pollFirst();
/*     */     
/* 303 */     if (this.gatherRoleList.isEmpty())
/*     */     {
/* 305 */       return;
/*     */     }
/*     */     
/* 308 */     if (!isAlive())
/*     */     {
/* 310 */       return;
/*     */     }
/*     */     
/* 313 */     Map.Entry<Long, MapItemGatherContext> entry = peekFirst();
/* 314 */     if (entry == null)
/*     */     {
/* 316 */       return;
/*     */     }
/* 318 */     Procedure.execute(new PMapItemGatherReq(((Long)entry.getKey()).longValue(), getItemId(), (MapItemGatherContext)entry.getValue()), this.procedureDone);
/*     */   }
/*     */   
/*     */   static class Done
/*     */     implements xdb.Procedure.Done<PMapItemGatherReq>
/*     */   {
/*     */     public void doDone(PMapItemGatherReq proc)
/*     */     {
/* 326 */       new MMH_OnMapItemGatherReqProcedureDone(proc.getMapItemInstanceId()).execute();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */