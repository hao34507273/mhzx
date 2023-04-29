/*    */ package mzm.gsp.activitycompensate.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ActivityCompensateGlobal;
/*    */ import xbean.ActivityCompensatesGlobal;
/*    */ import xbean.Pod;
/*    */ import xdb.Table;
/*    */ import xtable.Activitycompensate_global;
/*    */ 
/*    */ public class ActivityCompensateMergeModule implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 23 */     List<Table> tables = new ArrayList();
/* 24 */     tables.add(Activitycompensate_global.getTable());
/* 25 */     tables.add(xtable.Role2activitycompensate.getTable());
/* 26 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 31 */     if (!new PMergeCompensateGlobal().call()) {
/* 32 */       MergeMain.formatLogError("ActivityCompensateMergeModule.handleMerge@merge global failed!!!!", new Object[0]);
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   private static class PMergeCompensateGlobal
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 45 */       long mainKey = MergeMain.getMainZoneid();
/* 46 */       long viceKey = MergeMain.getViceZoneid();
/*    */       
/*    */ 
/* 49 */       lock(Activitycompensate_global.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/* 50 */       ActivityCompensatesGlobal xMainGlobal = Activitycompensate_global.get(Long.valueOf(mainKey));
/* 51 */       ActivityCompensatesGlobal xViceGlobal = Activitycompensate_global.get(Long.valueOf(viceKey));
/*    */       
/* 53 */       if (xMainGlobal == null) {
/* 54 */         xMainGlobal = Pod.newActivityCompensatesGlobal();
/* 55 */         Activitycompensate_global.insert(Long.valueOf(mainKey), xMainGlobal);
/*    */       }
/*    */       
/*    */ 
/* 59 */       if (xViceGlobal == null) {
/* 60 */         MergeMain.formatLogWarn("PMergeCompensateGlobal.processImp@vice record null|vice_key=%d", new Object[] { Long.valueOf(viceKey) });
/* 61 */         return true;
/*    */       }
/*    */       
/* 64 */       Iterator<Map.Entry<Integer, ActivityCompensateGlobal>> xViceIter = xViceGlobal.getActivity2compensateglobal().entrySet().iterator();
/*    */       
/*    */ 
/* 67 */       while (xViceIter.hasNext()) {
/* 68 */         Map.Entry<Integer, ActivityCompensateGlobal> xViceEntry = (Map.Entry)xViceIter.next();
/* 69 */         int activityid = ((Integer)xViceEntry.getKey()).intValue();
/* 70 */         ActivityCompensateGlobal xViceCompensate = (ActivityCompensateGlobal)xViceEntry.getValue();
/*    */         
/* 72 */         xViceIter.remove();
/*    */         
/* 74 */         ActivityCompensateGlobal xMainCompensate = (ActivityCompensateGlobal)xMainGlobal.getActivity2compensateglobal().get(Integer.valueOf(activityid));
/* 75 */         if (xMainCompensate == null) {
/* 76 */           xMainGlobal.getActivity2compensateglobal().put(Integer.valueOf(activityid), xViceCompensate);
/*    */ 
/*    */ 
/*    */         }
/* 80 */         else if (xViceCompensate.getOpen_time() > xMainCompensate.getOpen_time()) {
/* 81 */           xMainCompensate.setOpen_time(xViceCompensate.getOpen_time());
/*    */         }
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 87 */       Activitycompensate_global.remove(Long.valueOf(viceKey));
/*    */       
/* 89 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\ActivityCompensateMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */