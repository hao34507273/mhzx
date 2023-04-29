/*    */ package mzm.gsp.countdown.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.countdown.confbean.SCountDownCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CountDown;
/*    */ import xdb.Table;
/*    */ import xtable.Countdowns;
/*    */ import xtable.Role2countdowninfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CountDownMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 26 */     return Arrays.asList(new Table[] { Role2countdowninfo.getTable(), Countdowns.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 33 */     for (Iterator i$ = SCountDownCfg.getAll().keySet().iterator(); i$.hasNext();) { int cfg = ((Integer)i$.next()).intValue();
/*    */       
/* 35 */       if (!new PCountDownMerge(cfg).call())
/*    */       {
/* 37 */         return false;
/*    */       }
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   private static class PCountDownMerge extends LogicProcedure
/*    */   {
/*    */     private final int cfgid;
/*    */     
/*    */     public PCountDownMerge(int cfgid)
/*    */     {
/* 49 */       this.cfgid = cfgid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 55 */       long mainZoneid = MergeMain.getMainZoneid();
/* 56 */       long viceZoneid = MergeMain.getViceZoneid();
/* 57 */       long mainCfgid = GameServerInfoManager.toGlobalId(this.cfgid, mainZoneid);
/* 58 */       long viceCfgid = GameServerInfoManager.toGlobalId(this.cfgid, viceZoneid);
/* 59 */       HashSet<Long> Cfgids = new HashSet();
/* 60 */       Cfgids.add(Long.valueOf(mainCfgid));
/* 61 */       Cfgids.add(Long.valueOf(viceCfgid));
/* 62 */       lock(Countdowns.getTable(), Cfgids);
/*    */       
/* 64 */       CountDown xMainCountDown = Countdowns.get(Long.valueOf(mainCfgid));
/* 65 */       CountDown xViceCountDown = Countdowns.get(Long.valueOf(mainCfgid));
/*    */       
/* 67 */       if ((xMainCountDown == null) && (xViceCountDown == null))
/*    */       {
/* 69 */         return true;
/*    */       }
/*    */       
/* 72 */       if ((xMainCountDown != null) && (xViceCountDown == null))
/*    */       {
/* 74 */         return true;
/*    */       }
/*    */       
/* 77 */       if ((xMainCountDown == null) && (xViceCountDown != null))
/*    */       {
/* 79 */         Countdowns.remove(Long.valueOf(viceCfgid));
/* 80 */         Countdowns.insert(Long.valueOf(mainCfgid), xViceCountDown.copy());
/* 81 */         return true;
/*    */       }
/*    */       
/*    */ 
/* 85 */       Countdowns.remove(Long.valueOf(viceCfgid));
/* 86 */       xMainCountDown.getCan_get_red_packet_roleids().addAll(xViceCountDown.getCan_get_red_packet_roleids());
/*    */       
/* 88 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\main\CountDownMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */