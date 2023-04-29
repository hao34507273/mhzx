/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PointRaceCorpsFightInfo
/*    */ {
/*    */   public final int wins;
/*    */   public final Map<Long, CorpsCVCInfo> corpsFights;
/*    */   public final long updateTime;
/*    */   
/*    */   public PointRaceCorpsFightInfo()
/*    */   {
/* 19 */     this(0, null);
/*    */   }
/*    */   
/*    */   public PointRaceCorpsFightInfo(int wins, Map<Long, CorpsCVCInfo> corpsFights)
/*    */   {
/* 24 */     this.wins = wins;
/* 25 */     if (corpsFights != null)
/*    */     {
/* 27 */       Map<Long, CorpsCVCInfo> tmp = new HashMap(corpsFights);
/* 28 */       this.corpsFights = Collections.unmodifiableMap(tmp);
/*    */     }
/*    */     else
/*    */     {
/* 32 */       this.corpsFights = Collections.unmodifiableMap(new HashMap());
/*    */     }
/*    */     
/* 35 */     this.updateTime = DateTimeUtils.getCurrTimeInMillis();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceCorpsFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */