/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapVisibleMonsterFightContext
/*    */   extends MapFightContext
/*    */ {
/*    */   public final int instanceId;
/*    */   public final int monsterCfgId;
/*    */   
/*    */   public MapVisibleMonsterFightContext(long roleid, int instanceId, int monsterCfgId, int mapId, long worldId)
/*    */   {
/* 18 */     super(roleid, mapId, worldId);
/*    */     
/* 20 */     this.instanceId = instanceId;
/* 21 */     this.monsterCfgId = monsterCfgId;
/*    */   }
/*    */   
/* 24 */   public Map<MapFightContext.EXTRADATA_TYPE, Integer> extra = new HashMap();
/*    */   
/*    */   public void putExtra(MapFightContext.EXTRADATA_TYPE key, int value)
/*    */   {
/* 28 */     this.extra.put(key, Integer.valueOf(value));
/*    */   }
/*    */   
/*    */   public Integer getExtra(MapFightContext.EXTRADATA_TYPE key)
/*    */   {
/* 33 */     return (Integer)this.extra.get(key);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapVisibleMonsterFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */