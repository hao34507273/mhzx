/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class MarqueeInterface
/*    */ {
/*    */   public static boolean forceDeleteMarquee(long marqueeid)
/*    */   {
/*  9 */     return MarqueeManager.forceDeleteMarquee(marqueeid);
/*    */   }
/*    */   
/*    */   public static List<MarqueeDataInfo> queryMarquees(long beginTime, long endTime, int page)
/*    */   {
/* 14 */     return MarqueeManager.queryMarquees(beginTime, endTime, page);
/*    */   }
/*    */   
/*    */   public static void addMarquee(MarqueeDataInfo marquee)
/*    */   {
/* 19 */     if (marquee == null)
/*    */     {
/* 21 */       return;
/*    */     }
/* 23 */     MarqueeManager.addMarquee(marquee);
/*    */   }
/*    */   
/*    */   public static boolean updateMarquee(long marqueeid, MarqueeDataInfo newMarquee)
/*    */   {
/* 28 */     return MarqueeManager.updateMarquee(marqueeid, newMarquee);
/*    */   }
/*    */   
/*    */   public static boolean contains(long indexId)
/*    */   {
/* 33 */     return MarqueeIndexCache.getInstance().contains(indexId);
/*    */   }
/*    */   
/*    */   public static Long getMarqueeid(long indexId)
/*    */   {
/* 38 */     return MarqueeIndexCache.getInstance().get(indexId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\MarqueeInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */