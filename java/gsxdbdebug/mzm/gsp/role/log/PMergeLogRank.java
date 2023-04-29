/*    */ package mzm.gsp.role.log;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LogRankData;
/*    */ import xbean.Pod;
/*    */ import xbean.RecordData;
/*    */ import xbean.RoleRankData;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Logrolerank;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PMergeLogRank
/*    */   extends LogicProcedure
/*    */ {
/* 24 */   private static final Logger logger = Logger.getLogger(PMergeLogRank.class);
/*    */   private long curTime;
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     long mainKey = MergeMain.getMainZoneid();
/* 31 */     long viceKey = MergeMain.getViceZoneid();
/* 32 */     this.curTime = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 34 */     Lockeys.lock(Logrolerank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */     
/* 36 */     LogRankData xViceData = Logrolerank.get(Long.valueOf(viceKey));
/* 37 */     if (xViceData == null)
/*    */     {
/* 39 */       logger.warn(String.format("[logrank]PMergeLogRank.processImp@ no vice xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 41 */       return true;
/*    */     }
/* 43 */     LogRankData xMainData = Logrolerank.get(Long.valueOf(mainKey));
/* 44 */     if (xMainData == null)
/*    */     {
/* 46 */       xMainData = Pod.newLogRankData();
/* 47 */       Logrolerank.insert(Long.valueOf(mainKey), xMainData);
/*    */     }
/*    */     
/* 50 */     mergeAllViceToMain(xViceData, xMainData);
/*    */     
/* 52 */     Logrolerank.remove(Long.valueOf(viceKey));
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   private void mergeAllViceToMain(LogRankData xViceData, LogRankData xMainData)
/*    */   {
/* 58 */     Map<Integer, RecordData> xViceRecordDatas = xViceData.getType2rankdata();
/* 59 */     Iterator<Map.Entry<Integer, RecordData>> it = xViceRecordDatas.entrySet().iterator();
/* 60 */     while (it.hasNext())
/*    */     {
/* 62 */       Map.Entry<Integer, RecordData> entry = (Map.Entry)it.next();
/* 63 */       int type = ((Integer)entry.getKey()).intValue();
/* 64 */       RecordData xViceRecordData = (RecordData)entry.getValue();
/* 65 */       RecordData xMainRecordData = (RecordData)xMainData.getType2rankdata().get(Integer.valueOf(type));
/* 66 */       if (xMainRecordData == null)
/*    */       {
/* 68 */         xMainRecordData = Pod.newRecordData();
/* 69 */         xMainRecordData.setLastlogtime(this.curTime);
/* 70 */         xMainData.getType2rankdata().put(Integer.valueOf(type), xMainRecordData);
/*    */       }
/* 72 */       mergeTypeDataToMain(xMainRecordData, xViceRecordData.getRankdatas());
/*    */     }
/*    */   }
/*    */   
/*    */   private void mergeTypeDataToMain(RecordData xMainRecordData, Map<Long, RoleRankData> xViceRoleRankDatas)
/*    */   {
/* 78 */     if ((xViceRoleRankDatas == null) || (xViceRoleRankDatas.size() == 0))
/*    */     {
/* 80 */       return;
/*    */     }
/* 82 */     Iterator<Map.Entry<Long, RoleRankData>> it = xViceRoleRankDatas.entrySet().iterator();
/* 83 */     while (it.hasNext())
/*    */     {
/* 85 */       Map.Entry<Long, RoleRankData> entry = (Map.Entry)it.next();
/* 86 */       long roleId = ((Long)entry.getKey()).longValue();
/* 87 */       RoleRankData xViceRoleRankData = (RoleRankData)entry.getValue();
/*    */       
/* 89 */       insertNewLogData(xMainRecordData, roleId, xViceRoleRankData);
/*    */     }
/*    */   }
/*    */   
/*    */   private void insertNewLogData(RecordData xMainRecordData, long roleId, RoleRankData xViceRoleRankData)
/*    */   {
/* 95 */     RoleRankData xNewRoleRankData = Pod.newRoleRankData();
/* 96 */     xNewRoleRankData.setLogtime(xViceRoleRankData.getLogtime());
/* 97 */     xNewRoleRankData.setMaxvalue(xViceRoleRankData.getMaxvalue());
/*    */     
/* 99 */     xMainRecordData.getRankdatas().put(Long.valueOf(roleId), xNewRoleRankData);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\log\PMergeLogRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */