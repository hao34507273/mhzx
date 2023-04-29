/*    */ package mzm.gsp.visiblemonsterfight.main.robber;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GangMonsterRobber;
/*    */ import xbean.GangRobber;
/*    */ import xdb.Table;
/*    */ import xtable.Gangrobber;
/*    */ 
/*    */ public class GangRobberMergeModule implements MergeModule
/*    */ {
/* 18 */   private static final Logger logger = Logger.getLogger(GangRobberMergeModule.class);
/*    */   
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 22 */     List<Table> tables = new ArrayList();
/*    */     
/* 24 */     tables.add(Gangrobber.getTable());
/* 25 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 30 */     new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 34 */         GangRobberMergeModule.logger.info(String.format("[Merge]GangRobberMergeModule.handleMerge@begin merge gangrobber", new Object[0]));
/* 35 */         long viceZoneid = MergeMain.getViceZoneid();
/* 36 */         long mainZoneid = MergeMain.getMainZoneid();
/* 37 */         lock(Gangrobber.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(mainZoneid) }));
/* 38 */         GangRobber xViceGangRobber = Gangrobber.get(Long.valueOf(viceZoneid));
/* 39 */         GangRobber xMainGangRobber = Gangrobber.get(Long.valueOf(mainZoneid));
/* 40 */         if (xViceGangRobber == null) {
/* 41 */           GangRobberMergeModule.logger.info(String.format("[Merge]GangRobberMergeModule.handleMerge@vice server donot has data", new Object[0]));
/* 42 */           return true;
/*    */         }
/* 44 */         if (xMainGangRobber == null) {
/* 45 */           Gangrobber.insert(Long.valueOf(mainZoneid), xViceGangRobber.toBean());
/* 46 */           GangRobberMergeModule.logger.info(String.format("[Merge]GangRobberMergeModule.handleMerge@do using vice server data", new Object[0]));
/*    */         } else {
/* 48 */           Iterator<Map.Entry<Long, GangMonsterRobber>> iterator = xViceGangRobber.getGangrobberdatas().entrySet().iterator();
/*    */           
/* 50 */           while (iterator.hasNext()) {
/* 51 */             Map.Entry<Long, GangMonsterRobber> entry = (Map.Entry)iterator.next();
/* 52 */             iterator.remove();
/* 53 */             long gangid = ((Long)entry.getKey()).longValue();
/* 54 */             xMainGangRobber.getGangrobberdatas().put(Long.valueOf(gangid), entry.getValue());
/* 55 */             GangRobberMergeModule.logger.info(String.format("[Merge]GangRobberMergeModule.handleMerge@do add vice server data|gangid=%d", new Object[] { Long.valueOf(gangid) }));
/*    */           }
/*    */           
/* 58 */           GangRobberMergeModule.logger.info(String.format("[Merge]GangRobberMergeModule.handleMerge@do add vice server data", new Object[0]));
/*    */         }
/*    */         
/*    */ 
/* 62 */         Gangrobber.remove(Long.valueOf(viceZoneid));
/*    */         
/* 64 */         return true;
/*    */       }
/* 66 */     }.call();
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\robber\GangRobberMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */