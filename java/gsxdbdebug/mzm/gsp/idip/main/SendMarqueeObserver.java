/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class SendMarqueeObserver extends Observer
/*    */ {
/*    */   private final long marqueeId;
/*    */   private final int rollFre;
/*    */   private final int version;
/*    */   
/*    */   public SendMarqueeObserver(long marqueeId, long delay, int rollFre, int version)
/*    */   {
/* 13 */     super(delay);
/* 14 */     this.marqueeId = marqueeId;
/* 15 */     this.rollFre = rollFre;
/* 16 */     this.version = version;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 22 */     MarqueeManager.sendMarquee(this.marqueeId, this.version);
/* 23 */     setIntervalSeconds(this.rollFre);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\SendMarqueeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */