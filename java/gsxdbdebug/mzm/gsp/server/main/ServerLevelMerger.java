/*     */ package mzm.gsp.server.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LevelTimeBean;
/*     */ import xdb.Table;
/*     */ import xtable.Level2time;
/*     */ 
/*     */ public class ServerLevelMerger implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  19 */     List<Table> tables = new ArrayList();
/*  20 */     tables.add(Level2time.getTable());
/*     */     
/*  22 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  28 */     return new Merge_Level2time_Pro(null).call();
/*     */   }
/*     */   
/*     */   private static class Merge_Level2time_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  37 */       long mainKey = MergeMain.getMainZoneid();
/*  38 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*  40 */       lock(Level2time.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*  41 */       LevelTimeBean xMain = Level2time.get(Long.valueOf(mainKey));
/*  42 */       LevelTimeBean xVice = Level2time.get(Long.valueOf(viceKey));
/*     */       
/*  44 */       if (xVice == null)
/*     */       {
/*  46 */         GameServer.logger().warn("Merge_Level2time_Pro.processImp@no server level in vice xdb");
/*  47 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  51 */       if (xMain != null)
/*     */       {
/*     */ 
/*  54 */         if (xMain.getServerlevel() < xVice.getServerlevel())
/*     */         {
/*  56 */           int oldlevel = xMain.getServerlevel();
/*  57 */           xMain.setServerlevel(xVice.getServerlevel());
/*  58 */           xMain.setStarttime(xVice.getStarttime());
/*  59 */           xMain.setUpgradetime(xVice.getUpgradetime());
/*     */           
/*  61 */           GameServer.logger().info(String.format("Merge_Level2time_Pro.processImp@set server level from vice xdb|newserverlevel=%d|oldmainserverlevel=%d", new Object[] { Integer.valueOf(xMain.getServerlevel()), Integer.valueOf(oldlevel) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*  67 */         else if (xMain.getServerlevel() == xVice.getServerlevel())
/*     */         {
/*  69 */           if (xMain.getStarttime() > xVice.getStarttime())
/*     */           {
/*  71 */             xMain.setStarttime(xVice.getStarttime());
/*  72 */             xMain.setUpgradetime(xVice.getUpgradetime());
/*     */             
/*  74 */             GameServer.logger().info(String.format("Merge_Level2time_Pro.processImp@set server level starttime from vice xdb|serverlevel=%d|start_time=%d|upgrade_time=%d", new Object[] { Integer.valueOf(xMain.getServerlevel()), Long.valueOf(xVice.getStarttime()), Long.valueOf(xVice.getUpgradetime()) }));
/*     */ 
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/*  86 */           GameServer.logger().info(String.format("Merge_Level2time_Pro.processImp@set server level from main xdb|serverlevel=%d", new Object[] { Integer.valueOf(xMain.getServerlevel()) }));
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  94 */         GameServer.logger().error("Merge_Level2time_Pro.processImp@no server level in main xdb and vice xdb");
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  99 */       Level2time.remove(Long.valueOf(viceKey));
/* 100 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\ServerLevelMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */