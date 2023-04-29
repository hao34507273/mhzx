/*     */ package mzm.gsp.worldgoal.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*     */ import xbean.Section;
/*     */ import xbean.WorldGoal;
/*     */ import xdb.Table;
/*     */ import xtable.Role2worldgoalinfo;
/*     */ import xtable.Worldgoals;
/*     */ 
/*     */ 
/*     */ public class WorldGoalMergeModule
/*     */   implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  26 */     return Arrays.asList(new Table[] { Role2worldgoalinfo.getTable(), Worldgoals.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  33 */     for (Iterator i$ = SWorldGoalCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  35 */       if (!new PWorldGoalMerge(activityCfgid).call())
/*     */       {
/*  37 */         return false;
/*     */       }
/*     */     }
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   private static class PWorldGoalMerge extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgid;
/*     */     
/*     */     public PWorldGoalMerge(int activityCfgid)
/*     */     {
/*  49 */       this.activityCfgid = activityCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  55 */       long mainZoneid = MergeMain.getMainZoneid();
/*  56 */       long viceZoneid = MergeMain.getViceZoneid();
/*  57 */       long mainActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid, mainZoneid);
/*  58 */       long viceActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid, viceZoneid);
/*  59 */       HashSet<Long> activityCfgids = new HashSet();
/*  60 */       activityCfgids.add(Long.valueOf(mainActivityCfgid));
/*  61 */       activityCfgids.add(Long.valueOf(viceActivityCfgid));
/*  62 */       lock(Worldgoals.getTable(), activityCfgids);
/*     */       
/*  64 */       WorldGoal xMainWorldGoal = Worldgoals.get(Long.valueOf(mainActivityCfgid));
/*  65 */       WorldGoal xViceWorldGoal = Worldgoals.get(Long.valueOf(viceActivityCfgid));
/*     */       
/*  67 */       if ((xMainWorldGoal == null) && (xViceWorldGoal == null))
/*     */       {
/*  69 */         return true;
/*     */       }
/*     */       
/*  72 */       if ((xMainWorldGoal != null) && (xViceWorldGoal == null))
/*     */       {
/*  74 */         return true;
/*     */       }
/*     */       
/*  77 */       if ((xMainWorldGoal == null) && (xViceWorldGoal != null))
/*     */       {
/*  79 */         Worldgoals.remove(Long.valueOf(viceActivityCfgid));
/*  80 */         Worldgoals.insert(Long.valueOf(mainActivityCfgid), xViceWorldGoal.copy());
/*  81 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  85 */       if ((xMainWorldGoal.getCurrent_section_id() < xViceWorldGoal.getCurrent_section_id()) || ((xMainWorldGoal.getCurrent_section_id() == xViceWorldGoal.getCurrent_section_id()) && (((Section)xMainWorldGoal.getSections().get(Integer.valueOf(xMainWorldGoal.getCurrent_section_id()))).getPoint() < ((Section)xViceWorldGoal.getSections().get(Integer.valueOf(xViceWorldGoal.getCurrent_section_id()))).getPoint())))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  90 */         Worldgoals.remove(Long.valueOf(mainActivityCfgid));
/*  91 */         Worldgoals.remove(Long.valueOf(viceActivityCfgid));
/*  92 */         Worldgoals.insert(Long.valueOf(mainActivityCfgid), xViceWorldGoal.copy());
/*  93 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  98 */       Worldgoals.remove(Long.valueOf(viceActivityCfgid));
/*     */       
/* 100 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\WorldGoalMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */