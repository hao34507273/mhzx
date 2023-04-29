/*    */ package mzm.gsp.map.main.team;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapTeamManager
/*    */ {
/* 14 */   private static MapTeamManager instance = new MapTeamManager();
/*    */   
/*    */   public static MapTeamManager getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/* 21 */   private Map<Long, MapTeamData> teamMap = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public MapTeamData createTeam(long teamId, long leader)
/*    */   {
/* 29 */     MapTeamData data = new MapTeamData(teamId, leader);
/* 30 */     this.teamMap.put(Long.valueOf(teamId), data);
/* 31 */     return data;
/*    */   }
/*    */   
/*    */   public MapTeamData getTeamById(long teamId)
/*    */   {
/* 36 */     return (MapTeamData)this.teamMap.get(Long.valueOf(teamId));
/*    */   }
/*    */   
/*    */   public MapTeamData releaseTeam(long teamId)
/*    */   {
/* 41 */     return (MapTeamData)this.teamMap.remove(Long.valueOf(teamId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\team\MapTeamManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */