/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RankDBManager
/*    */ {
/* 16 */   private static final RankDBManager instance = new RankDBManager();
/*    */   
/*    */ 
/* 19 */   private static final Set<RankManagerNew> saveDBRanks = new HashSet();
/*    */   
/* 21 */   private int originalIntervalSec = 300;
/*    */   public static final int MIN_INTERVAL_SEC = 60;
/*    */   
/*    */   public static RankDBManager getInstance()
/*    */   {
/* 26 */     return instance;
/*    */   }
/*    */   
/*    */   void setSaveDbIntervalSec(int intervalSec) {
/* 30 */     if (intervalSec < 60) {
/* 31 */       GameServer.logger().info("设置的存储排行榜数据库的timer时间过小,至少要大于60");
/* 32 */       return;
/*    */     }
/* 34 */     GameServer.logger().info("排行榜数据库的timer时间更新为" + intervalSec + "秒");
/* 35 */     this.originalIntervalSec = intervalSec;
/*    */   }
/*    */   
/*    */   public int getSaveDbIntervalSec() {
/* 39 */     return this.originalIntervalSec;
/*    */   }
/*    */   
/*    */   void registerDBHandle(RankManagerNew rankDBHandle)
/*    */   {
/* 44 */     synchronized (saveDBRanks) {
/* 45 */       saveDBRanks.add(rankDBHandle);
/*    */     }
/*    */   }
/*    */   
/*    */   void onRankDBObserverUpdate()
/*    */   {
/* 51 */     synchronized (saveDBRanks) {
/* 52 */       for (final RankManagerNew rankDBHandle : saveDBRanks) {
/* 53 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */         {
/*    */           protected boolean processImp() throws Exception
/*    */           {
/* 57 */             rankDBHandle.saveToDB();
/* 58 */             return true;
/*    */           }
/*    */         });
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   void postinit() {
/* 66 */     new RankDBObserver(this.originalIntervalSec);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\RankDBManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */