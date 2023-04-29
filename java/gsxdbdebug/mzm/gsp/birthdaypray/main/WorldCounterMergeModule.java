/*    */ package mzm.gsp.birthdaypray.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.WorldCounterInfo;
/*    */ import xdb.Table;
/*    */ import xtable.Role2worldcounterreward;
/*    */ import xtable.Worldcounter;
/*    */ 
/*    */ public class WorldCounterMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 25 */     return Arrays.asList(new Table[] { Role2worldcounterreward.getTable(), Worldcounter.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 32 */     for (Iterator i$ = SBirthdayPrayCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 34 */       if (!new PWorldCounterMerge(activityCfgid).call())
/*    */       {
/* 36 */         return false;
/*    */       }
/*    */     }
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   private static class PWorldCounterMerge extends LogicProcedure
/*    */   {
/*    */     private final int activityCfgid;
/*    */     
/*    */     public PWorldCounterMerge(int activityCfgid)
/*    */     {
/* 48 */       this.activityCfgid = activityCfgid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 54 */       long mainZoneid = MergeMain.getMainZoneid();
/* 55 */       long viceZoneid = MergeMain.getViceZoneid();
/* 56 */       long mainActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid, mainZoneid);
/* 57 */       long viceActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid, viceZoneid);
/* 58 */       HashSet<Long> activityCfgids = new HashSet();
/* 59 */       activityCfgids.add(Long.valueOf(mainActivityCfgid));
/* 60 */       activityCfgids.add(Long.valueOf(viceActivityCfgid));
/* 61 */       lock(Worldcounter.getTable(), activityCfgids);
/*    */       
/* 63 */       WorldCounterInfo xMainWorldCounter = Worldcounter.get(Long.valueOf(mainActivityCfgid));
/* 64 */       WorldCounterInfo xViceWorldCounter = Worldcounter.get(Long.valueOf(viceActivityCfgid));
/*    */       
/* 66 */       if ((xMainWorldCounter == null) && (xViceWorldCounter == null))
/*    */       {
/* 68 */         return true;
/*    */       }
/*    */       
/* 71 */       if ((xMainWorldCounter != null) && (xViceWorldCounter == null))
/*    */       {
/* 73 */         return true;
/*    */       }
/*    */       
/* 76 */       if ((xMainWorldCounter == null) && (xViceWorldCounter != null))
/*    */       {
/* 78 */         Worldcounter.remove(Long.valueOf(viceActivityCfgid));
/* 79 */         Worldcounter.insert(Long.valueOf(mainActivityCfgid), xViceWorldCounter.copy());
/* 80 */         return true;
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 85 */       for (Map.Entry<Integer, Long> entry : xViceWorldCounter.getIndex2times().entrySet())
/*    */       {
/* 87 */         Long mainTimes = (Long)xMainWorldCounter.getIndex2times().get(entry.getKey());
/* 88 */         if ((mainTimes == null) || (mainTimes.longValue() < ((Long)entry.getValue()).longValue()))
/*    */         {
/* 90 */           xMainWorldCounter.getIndex2times().put(entry.getKey(), entry.getValue());
/*    */         }
/*    */       }
/*    */       
/* 94 */       Worldcounter.remove(Long.valueOf(viceActivityCfgid));
/* 95 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\main\WorldCounterMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */