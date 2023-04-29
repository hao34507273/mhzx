/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import mzm.gsp.bulletin.main.BulletinInterface;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.util.DelayTimeObserver;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VisibleMonsterDelayObserver
/*    */   extends DelayTimeObserver
/*    */ {
/*    */   private final int controllerId;
/*    */   final String notice;
/*    */   
/*    */   public VisibleMonsterDelayObserver(int controllerId, long interval, boolean repeatable, String notice)
/*    */   {
/* 18 */     super(interval, repeatable);
/* 19 */     this.controllerId = controllerId;
/* 20 */     this.notice = notice;
/*    */   }
/*    */   
/*    */   protected void onTimeOut(long time) {
/* 24 */     ControllerInterface.triggerOrReSpawn(MapInterface.getCenterWorldid(), this.controllerId, 1);
/* 25 */     if (this.notice != "")
/*    */     {
/* 27 */       String deadNotice = this.notice.replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>");
/* 28 */       BulletinInterface.sendNotice(deadNotice);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\VisibleMonsterDelayObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */