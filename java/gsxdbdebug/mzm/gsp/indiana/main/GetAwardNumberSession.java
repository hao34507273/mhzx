/*    */ package mzm.gsp.indiana.main;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.grc.main.GrcInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class GetAwardNumberSession
/*    */   extends Session
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int turn;
/*    */   private final int sortid;
/*    */   
/*    */   public GetAwardNumberSession(long interval, int activityCfgid, int turn, int sortid)
/*    */   {
/* 20 */     super(interval, 0L);
/* 21 */     this.activityCfgid = activityCfgid;
/* 22 */     this.turn = turn;
/* 23 */     this.sortid = sortid;
/* 24 */     GameServer.logger().info(String.format("[indiana]GetAwardNumberSession@start get award number session|interval=%d|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Long.valueOf(interval), Integer.valueOf(activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 33 */     new RGetAwardNumber(this.activityCfgid, this.turn, this.sortid).execute();
/*    */   }
/*    */   
/*    */   class RGetAwardNumber extends LogicRunnable
/*    */   {
/*    */     private final int activityCfgid;
/*    */     private final int turn;
/*    */     private final int sortid;
/*    */     
/*    */     public RGetAwardNumber(int activityCfgid, int turn, int sortid)
/*    */     {
/* 44 */       this.activityCfgid = activityCfgid;
/* 45 */       this.turn = turn;
/* 46 */       this.sortid = sortid;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 52 */       if (!GrcInterface.getIndianaAwardNumber(this.activityCfgid, this.turn, this.sortid))
/*    */       {
/*    */ 
/* 55 */         GameServer.logger().error(String.format("[indiana]GetAwardNumberSession.RGetAwardNumber.process@communication error|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(this.sortid) }));
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 60 */         new GetAwardNumberSession(IndianaManager.GRC_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(IndianaManager.GRC_MAX_DELAY_IN_SECOND - IndianaManager.GRC_MIN_DELAY_IN_SECOND), this.activityCfgid, this.turn, this.sortid);
/*    */         
/*    */ 
/*    */ 
/* 64 */         return;
/*    */       }
/* 66 */       GameServer.logger().info(String.format("[indiana]GetAwardNumberSession.RGetAwardNumber.process@get award number from grc|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(this.sortid) }));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\GetAwardNumberSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */