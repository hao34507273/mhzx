/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Stack;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.worldai.confbean.SWorldAIParam;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldManager
/*     */ {
/*     */   public static final long BIG_WORLD_ID = 1L;
/*  18 */   private static Logger logger = Logger.getLogger(WorldManager.class);
/*     */   
/*  20 */   private static WorldManager instance = new WorldManager();
/*     */   private WorldInstance bigWorldInstance;
/*     */   private Map<Long, WorldInstance> allWorldInstanceMap;
/*     */   
/*  24 */   public static WorldManager getInstance() { return instance; }
/*     */   
/*     */ 
/*     */ 
/*     */   private Map<Long, Stack<Long>> roleWorldStackMap;
/*     */   
/*     */ 
/*     */   private Map<Integer, Integer> allWorldAiParam;
/*     */   
/*     */   public WorldManager()
/*     */   {
/*  35 */     this.bigWorldInstance = new BigWorldInstance();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  40 */     this.allWorldInstanceMap = new HashMap();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  45 */     this.roleWorldStackMap = new HashMap();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  50 */     this.allWorldAiParam = new HashMap();
/*     */   }
/*     */   
/*     */   public void addWorldInstance(WorldInstance instance) {
/*  54 */     this.allWorldInstanceMap.put(Long.valueOf(instance.getId()), instance);
/*     */   }
/*     */   
/*     */   public void removeWorldInstance(WorldInstance instance)
/*     */   {
/*  59 */     this.allWorldInstanceMap.remove(Long.valueOf(instance.getId()));
/*     */   }
/*     */   
/*     */   public WorldInstance removeWorldInstance(long instanceId)
/*     */   {
/*  64 */     return (WorldInstance)this.allWorldInstanceMap.remove(Long.valueOf(instanceId));
/*     */   }
/*     */   
/*     */   public void stopWorld()
/*     */   {
/*  69 */     logger.info("game world over!");
/*     */   }
/*     */   
/*     */   public void dragTo(long roleId, Position pos, TransferType reason)
/*     */   {
/*  74 */     if (logger.isDebugEnabled())
/*     */     {
/*  76 */       logger.debug("detected world drag role");
/*     */     }
/*     */     
/*  79 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleId);
/*  80 */     if (role == null)
/*     */     {
/*  82 */       logger.error("地图中角色信息不存在");
/*  83 */       return;
/*     */     }
/*  85 */     Position targetPos = pos;
/*  86 */     role.teleportWithProtocol(pos.getX(), pos.getY(), pos.getZ(), targetPos.getX(), targetPos.getY(), pos.getSceneId(), reason);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRoleWorldInstanceIntoStack(long roleId, WorldInstance instance)
/*     */   {
/*  92 */     Stack<Long> worldStack = (Stack)this.roleWorldStackMap.get(Long.valueOf(roleId));
/*  93 */     if (worldStack == null)
/*     */     {
/*  95 */       return;
/*     */     }
/*  97 */     if (worldStack.contains(Long.valueOf(instance.getId())))
/*     */     {
/*  99 */       return;
/*     */     }
/* 101 */     worldStack.push(Long.valueOf(instance.getId()));
/*     */   }
/*     */   
/*     */   public void removeRoleWorldInstanceFromStack(long roleId)
/*     */   {
/* 106 */     Stack<Long> worldStack = (Stack)this.roleWorldStackMap.get(Long.valueOf(roleId));
/* 107 */     if (worldStack == null)
/*     */     {
/* 109 */       return;
/*     */     }
/* 111 */     worldStack.pop();
/*     */   }
/*     */   
/*     */   public void removeRoleWorldInstanceFromStack(long roleId, WorldInstance instance)
/*     */   {
/* 116 */     Stack<Long> worldStack = (Stack)this.roleWorldStackMap.get(Long.valueOf(roleId));
/* 117 */     if (worldStack == null)
/*     */     {
/* 119 */       return;
/*     */     }
/* 121 */     worldStack.remove(Long.valueOf(instance.getId()));
/*     */   }
/*     */   
/*     */   public WorldInstance getRoleWorldInstanceFromStack(long roleId)
/*     */   {
/* 126 */     Stack<Long> worldStack = (Stack)this.roleWorldStackMap.get(Long.valueOf(roleId));
/* 127 */     if (worldStack == null)
/*     */     {
/* 129 */       return null;
/*     */     }
/*     */     
/* 132 */     WorldInstance instance = null;
/* 133 */     while ((instance == null) && (!worldStack.isEmpty()))
/*     */     {
/* 135 */       long worldId = ((Long)worldStack.peek()).longValue();
/* 136 */       instance = getWorldInstance(worldId);
/* 137 */       if (instance == null)
/*     */       {
/* 139 */         worldStack.pop();
/*     */       }
/*     */     }
/* 142 */     return instance;
/*     */   }
/*     */   
/*     */   public void putGlobalAiParam(int id, int value)
/*     */   {
/* 147 */     SWorldAIParam param = SWorldAIParam.get(id);
/* 148 */     if (param == null)
/*     */     {
/* 150 */       throw new RuntimeException("do not exist world ai param id = " + id);
/*     */     }
/* 152 */     if ((param.highLimit < value) || (param.lowLimit > value))
/*     */     {
/* 154 */       throw new RuntimeException(String.format("set global param id = %d %d not in (%d,%d)", new Object[] { Integer.valueOf(id), Integer.valueOf(value), Integer.valueOf(param.lowLimit), Integer.valueOf(param.highLimit) }));
/*     */     }
/*     */     
/* 157 */     this.allWorldAiParam.put(Integer.valueOf(id), Integer.valueOf(value));
/*     */   }
/*     */   
/*     */   public int getGlobalAiParam(int id)
/*     */   {
/* 162 */     Integer value = (Integer)this.allWorldAiParam.get(Integer.valueOf(id));
/* 163 */     if (value == null)
/*     */     {
/* 165 */       return 0;
/*     */     }
/* 167 */     return value.intValue();
/*     */   }
/*     */   
/*     */   public WorldInstance getBigWorldInstance()
/*     */   {
/* 172 */     return this.bigWorldInstance;
/*     */   }
/*     */   
/*     */   class BigWorldInstance extends WorldInstance
/*     */   {
/*     */     BigWorldInstance() {}
/*     */     
/*     */     public void onRoleMove(long roleId, int x, int y, int z, int sceneId) {
/* 180 */       super.onRoleMove(roleId, x, y, z, sceneId);
/*     */     }
/*     */     
/*     */ 
/*     */     public void onRoleJoin(long roleId)
/*     */     {
/* 186 */       Stack<Long> worldStack = (Stack)WorldManager.this.roleWorldStackMap.get(Long.valueOf(roleId));
/* 187 */       if (worldStack == null)
/*     */       {
/* 189 */         worldStack = new Stack();
/* 190 */         WorldManager.this.roleWorldStackMap.put(Long.valueOf(roleId), worldStack);
/*     */       }
/*     */       
/* 193 */       worldStack.clear();
/*     */       
/* 195 */       super.onRoleJoin(roleId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void checkTopStack(long roleId, long instanceId)
/*     */   {
/* 207 */     Stack<Long> worldStack = (Stack)this.roleWorldStackMap.get(Long.valueOf(roleId));
/* 208 */     if (worldStack == null)
/*     */     {
/* 210 */       return;
/*     */     }
/* 212 */     while (!worldStack.isEmpty())
/*     */     {
/* 214 */       if (((Long)worldStack.peek()).longValue() == instanceId) {
/*     */         break;
/*     */       }
/*     */       
/* 218 */       worldStack.pop();
/*     */     }
/*     */   }
/*     */   
/*     */   public WorldInstance getWorldInstance(long id)
/*     */   {
/* 224 */     if (id == 1L)
/*     */     {
/* 226 */       return this.bigWorldInstance;
/*     */     }
/*     */     
/* 229 */     return (WorldInstance)this.allWorldInstanceMap.get(Long.valueOf(id));
/*     */   }
/*     */   
/*     */   public void postInit() {}
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\WorldManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */