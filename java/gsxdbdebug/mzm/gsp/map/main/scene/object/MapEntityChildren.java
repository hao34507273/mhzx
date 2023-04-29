/*    */ package mzm.gsp.map.main.scene.object;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ public class MapEntityChildren extends MapEntity
/*    */ {
/*  7 */   private long stayDuration = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */   public MapEntityChildren(MapEntityType entityType, long instanceid, int bornSceneid, int x, int y, int cfgid, Map<Integer, Integer> intExtraInfoEntries, Map<Integer, Long> longExtraInfoEntries, Map<Integer, String> stringExtraInfoEntries)
/*    */   {
/* 13 */     super(entityType, instanceid, bornSceneid, x, y, cfgid, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void update(long time)
/*    */   {
/* 22 */     if (!this.keyPointPath.isEmpty())
/*    */     {
/* 24 */       super.update(time);
/*    */       
/* 26 */       return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapEntityChildren.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */