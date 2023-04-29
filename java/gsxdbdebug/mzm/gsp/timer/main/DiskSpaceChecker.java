/*    */ package mzm.gsp.timer.main;
/*    */ 
/*    */ import java.io.File;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class DiskSpaceChecker
/*    */ {
/*    */   private static final int PERCENT = 100;
/*    */   int checkInterval;
/*    */   int alarmSpacePercent;
/*    */   int stopGsDelay;
/*    */   private static DiskSpaceChecker instance;
/*    */   
/*    */   public DiskSpaceChecker()
/*    */   {
/* 20 */     this.checkInterval = 60;
/* 21 */     this.alarmSpacePercent = 5;
/* 22 */     this.stopGsDelay = 10;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static void init()
/*    */   {
/* 29 */     instance = (DiskSpaceChecker)ConfManager.getInstance().getconf("mzm.gsp.timer.main.DiskSpaceChecker");
/* 30 */     if (instance == null) {
/* 31 */       throw new RuntimeException("初始化DiskSpaceChecker失败，可能是配置不存在！");
/*    */     }
/* 33 */     instance.start();
/*    */   }
/*    */   
/*    */   public void start()
/*    */   {
/* 38 */     new CheckObserver();
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {}
/*    */   
/*    */   private class CheckObserver extends Observer {
/* 44 */     private final boolean[] ret = new boolean[1];
/*    */     
/*    */     public CheckObserver() {
/* 47 */       super();
/* 48 */       this.ret[0] = true;
/*    */     }
/*    */     
/*    */     public boolean update()
/*    */     {
/* 53 */       Executor.getInstance().execute(new mzm.gsp.util.LogicRunnable()
/*    */       {
/*    */         public void process() throws Exception
/*    */         {
/* 57 */           File dbHome = Xdb.getInstance().getConf().getDbHome();
/* 58 */           long freeSpace = dbHome.getFreeSpace();
/* 59 */           long totalSpace = dbHome.getTotalSpace();
/* 60 */           if (freeSpace / totalSpace < DiskSpaceChecker.this.alarmSpacePercent / 100.0D) {
/* 61 */             GameServer.logger().fatal("磁盘空间不足，剩余空间=" + freeSpace + "，总空间=" + totalSpace + "，即将关闭服务器！");
/* 62 */             GameServer.stop(DiskSpaceChecker.this.stopGsDelay);
/* 63 */             DiskSpaceChecker.CheckObserver.this.ret[0] = 0;
/*    */           }
/*    */           
/*    */         }
/*    */         
/* 68 */       });
/* 69 */       return this.ret[0];
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\DiskSpaceChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */