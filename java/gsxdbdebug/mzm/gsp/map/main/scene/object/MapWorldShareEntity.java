/*    */ package mzm.gsp.map.main.scene.object;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.scene.TransferType;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ public class MapWorldShareEntity
/*    */   extends MapEntity
/*    */ {
/*    */   private WorldInstance worldInstance;
/*    */   
/*    */   public MapWorldShareEntity(MapEntityType entityType, long instanceid, int bornSceneid, int x, int y, int cfgid, Map<Integer, Integer> intExtraInfoEntries, Map<Integer, Long> longExtraInfoEntries, Map<Integer, String> stringExtraInfoEntries)
/*    */   {
/* 17 */     super(entityType, instanceid, bornSceneid, x, y, cfgid, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void addListener(ISceneObjectListener listener)
/*    */   {
/* 24 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void removeListener(ISceneObjectListener listener)
/*    */   {
/* 30 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void spawnMe(int x, int y, int z, int sceneid, int channelid, TransferType type)
/*    */   {
/* 36 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public void worldShare(WorldInstance worldInstance)
/*    */   {
/* 41 */     if (worldInstance == null)
/*    */     {
/* 43 */       return;
/*    */     }
/*    */     
/* 46 */     if (!worldInstance.addMapEntity(this))
/*    */     {
/* 48 */       return;
/*    */     }
/*    */     
/* 51 */     MapObjectInstanceManager.getInstance().addMapEntity(this);
/*    */     
/* 53 */     this.worldInstance = worldInstance;
/*    */   }
/*    */   
/*    */   public WorldInstance getWorldInstance()
/*    */   {
/* 58 */     return this.worldInstance;
/*    */   }
/*    */   
/*    */ 
/*    */   public void destroy()
/*    */   {
/* 64 */     if (this.worldInstance == null)
/*    */     {
/* 66 */       return;
/*    */     }
/*    */     
/* 69 */     this.worldInstance.removeMapEntity(this);
/*    */     
/* 71 */     MapObjectInstanceManager.getInstance().removeMapEntity(getEntityType().ordinal(), getInstanceid().longValue());
/*    */     
/* 73 */     this.worldInstance = null;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void broadcast(Protocol protocol)
/*    */   {
/* 79 */     if (this.worldInstance == null)
/*    */     {
/* 81 */       return;
/*    */     }
/*    */     
/* 84 */     this.worldInstance.broadcast(protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapWorldShareEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */