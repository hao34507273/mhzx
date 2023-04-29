/*    */ package mzm.gsp.task.conParamObj;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class KillMonsterParamObj
/*    */ {
/*  8 */   private Map<Integer, Integer> monsterIdToCountMap = new HashMap();
/*    */   private int mapId;
/*    */   
/*    */   public Map<Integer, Integer> getMonsterIdToCountMap()
/*    */   {
/* 13 */     return this.monsterIdToCountMap;
/*    */   }
/*    */   
/*    */   public void setMonsterIdToCountMap(Map<Integer, Integer> monsterIdToCountMap)
/*    */   {
/* 18 */     this.monsterIdToCountMap = monsterIdToCountMap;
/*    */   }
/*    */   
/*    */   public int getMapId()
/*    */   {
/* 23 */     return this.mapId;
/*    */   }
/*    */   
/*    */   public void setMapId(int mapId)
/*    */   {
/* 28 */     this.mapId = mapId;
/*    */   }
/*    */   
/*    */   public void addMonsterCount(int monsterId, int count)
/*    */   {
/* 33 */     if (this.monsterIdToCountMap.containsKey(Integer.valueOf(monsterId)))
/*    */     {
/* 35 */       int monsterCount = ((Integer)this.monsterIdToCountMap.get(Integer.valueOf(monsterId))).intValue() + count;
/* 36 */       this.monsterIdToCountMap.put(Integer.valueOf(monsterId), Integer.valueOf(monsterCount));
/*    */     }
/*    */     else
/*    */     {
/* 40 */       this.monsterIdToCountMap.put(Integer.valueOf(monsterId), Integer.valueOf(count));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\conParamObj\KillMonsterParamObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */