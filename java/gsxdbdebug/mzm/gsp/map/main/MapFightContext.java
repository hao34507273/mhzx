/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class MapFightContext implements FightContext
/*    */ {
/*    */   public final long roleid;
/*    */   public final int mapId;
/*    */   public final long worldId;
/*    */   
/*    */   public static enum EXTRADATA_TYPE
/*    */   {
/* 15 */     USE_DOUBPLEPOINT_ROLEID_HIGH, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 20 */     USE_DOUBPLEPOINT_ROLEID_LOW, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 25 */     USE_DOUBLEPOINT, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 30 */     ENTER_FIGHT_LOW_LEVEL_LIMIT, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 35 */     MONSTER_STAR_LEVEL, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 40 */     ACTIVITY_CFG_ID;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     private EXTRADATA_TYPE() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public MapFightContext(long roleid, int mapId, long worldId)
/*    */   {
/* 60 */     this.roleid = roleid;
/* 61 */     this.mapId = mapId;
/* 62 */     this.worldId = worldId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 68 */     return false;
/*    */   }
/*    */   
/* 71 */   public Map<EXTRADATA_TYPE, Integer> extra = new HashMap();
/*    */   
/*    */   public void putExtra(EXTRADATA_TYPE key, int value)
/*    */   {
/* 75 */     this.extra.put(key, Integer.valueOf(value));
/*    */   }
/*    */   
/*    */   public Integer getExtra(EXTRADATA_TYPE key)
/*    */   {
/* 80 */     return (Integer)this.extra.get(key);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */