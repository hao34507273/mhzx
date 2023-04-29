/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PointRaceCorpsPreInfo
/*    */ {
/*    */   public final int zoneid;
/*    */   public final String name;
/*    */   public final int icon;
/*    */   public final int win;
/*    */   public final int lose;
/*    */   public final int point;
/*    */   public final long updateTime;
/*    */   public final Map<Long, CorpsCVCInfo> corpsFights;
/*    */   
/*    */   public PointRaceCorpsPreInfo(int zoneid, String name, int icon, int win, int lose, int point, long updateTime, Map<Long, CorpsCVCInfo> corpsFights)
/*    */   {
/* 23 */     this.zoneid = zoneid;
/* 24 */     this.name = name;
/* 25 */     this.icon = icon;
/* 26 */     this.win = win;
/* 27 */     this.lose = lose;
/* 28 */     this.point = point;
/* 29 */     this.updateTime = updateTime;
/*    */     
/* 31 */     if (corpsFights != null)
/*    */     {
/* 33 */       Map<Long, CorpsCVCInfo> tmp = new HashMap(corpsFights);
/* 34 */       this.corpsFights = Collections.unmodifiableMap(tmp);
/*    */     }
/*    */     else
/*    */     {
/* 38 */       this.corpsFights = Collections.unmodifiableMap(new HashMap());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceCorpsPreInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */