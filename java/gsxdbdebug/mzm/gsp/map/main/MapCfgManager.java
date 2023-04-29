/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.confbean.SMapConfig;
/*    */ import mzm.gsp.map.confbean.SMapPolygonCfg;
/*    */ import mzm.gsp.map.confbean.SMapRegionConfig;
/*    */ import mzm.gsp.map.confbean.SMapVisibleMonster;
/*    */ import mzm.gsp.map.main.proto.MapPolygonPrototype;
/*    */ import mzm.gsp.map.main.proto.MapPrototype;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapCfgManager
/*    */ {
/* 17 */   private static MapCfgManager instance = new MapCfgManager();
/*    */   
/* 19 */   private Map<Integer, MapPrototype> mapProtoMap = new HashMap();
/* 20 */   private Map<Integer, MapPolygonPrototype> mapPolygonProtoMap = new HashMap();
/* 21 */   private int baseRate = 10000;
/*    */   
/*    */   public static MapCfgManager getInstance()
/*    */   {
/* 25 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void init()
/*    */   {
/* 34 */     Map<Integer, SMapConfig> mapConfigs = SMapConfig.getAll();
/* 35 */     for (SMapConfig config : mapConfigs.values())
/*    */     {
/* 37 */       MapPrototype mapPrototype = new MapPrototype(config.id);
/* 38 */       this.mapProtoMap.put(Integer.valueOf(mapPrototype.getTemplateId()), mapPrototype);
/*    */     }
/*    */     
/* 41 */     for (SMapPolygonCfg config : SMapPolygonCfg.getAll().values())
/*    */     {
/* 43 */       MapPolygonPrototype mapPolygonProto = new MapPolygonPrototype(config.id);
/* 44 */       mapPolygonProto.init();
/* 45 */       this.mapPolygonProtoMap.put(Integer.valueOf(mapPolygonProto.getTemplateId()), mapPolygonProto);
/*    */     }
/*    */   }
/*    */   
/*    */   public int getBaseRate()
/*    */   {
/* 51 */     return this.baseRate;
/*    */   }
/*    */   
/*    */   public MapPrototype getMapProtoById(int id)
/*    */   {
/* 56 */     return (MapPrototype)this.mapProtoMap.get(Integer.valueOf(id));
/*    */   }
/*    */   
/*    */   public MapPolygonPrototype getMapPolygonProtoById(int id)
/*    */   {
/* 61 */     return (MapPolygonPrototype)this.mapPolygonProtoMap.get(Integer.valueOf(id));
/*    */   }
/*    */   
/*    */   public int getMonsterCfgNumInMap(int mapCfgid, int monsterCfgid)
/*    */   {
/* 66 */     MapPrototype mapPrototype = getMapProtoById(mapCfgid);
/* 67 */     if (mapPrototype == null)
/*    */     {
/* 69 */       return 0;
/*    */     }
/*    */     
/* 72 */     int totalNum = 0;
/* 73 */     for (SMapVisibleMonster visibleMonster : mapPrototype.getVisibleMonsterList())
/*    */     {
/* 75 */       if (visibleMonster.cfgid == monsterCfgid)
/*    */       {
/*    */ 
/*    */ 
/* 79 */         totalNum += visibleMonster.num; }
/*    */     }
/* 81 */     return totalNum;
/*    */   }
/*    */   
/*    */   public List<Integer> getRandomRegionReachableCellIndices(int regionid)
/*    */   {
/* 86 */     SMapRegionConfig regionCfg = SMapRegionConfig.get(regionid);
/* 87 */     if (regionCfg == null)
/*    */     {
/* 89 */       return null;
/*    */     }
/*    */     
/* 92 */     return regionCfg.randomCells;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */