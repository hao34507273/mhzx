/*     */ package mzm.gsp.alllotto.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllLottoInfo;
/*     */ import xbean.AllLottoTurnInfo;
/*     */ import xdb.Table;
/*     */ import xtable.All_lotto_infos;
/*     */ import xtable.Role_all_lotto_infos;
/*     */ 
/*     */ public class AllLottoMergeModule implements MergeModule
/*     */ {
/*     */   public java.util.List<Table> getHandleTables()
/*     */   {
/*  24 */     return Arrays.asList(new Table[] { All_lotto_infos.getTable(), Role_all_lotto_infos.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  30 */     for (Iterator i$ = SAllLottoCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  32 */       if (!new PMerge(activityCfgid).call())
/*     */       {
/*  34 */         return false;
/*     */       }
/*     */     }
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   class PMerge extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final int activityCfgid;
/*     */     
/*     */     public PMerge(int activityCfgid)
/*     */     {
/*  46 */       this.activityCfgid = activityCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  52 */       SAllLottoCfg cfg = SAllLottoCfg.get(this.activityCfgid);
/*  53 */       if (cfg == null)
/*     */       {
/*  55 */         MergeMain.logger().error(String.format("[alllotto]AllLottoMergeModule.PMerge.processImp@param error|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*  58 */         return false;
/*     */       }
/*     */       
/*  61 */       long mainZoneid = MergeMain.getMainZoneid();
/*  62 */       long viceZoneid = MergeMain.getViceZoneid();
/*  63 */       long mainKey = GameServerInfoManager.toGlobalId(this.activityCfgid, mainZoneid);
/*  64 */       long viceKey = GameServerInfoManager.toGlobalId(this.activityCfgid, viceZoneid);
/*     */       
/*  66 */       HashSet<Long> keys = new HashSet();
/*  67 */       keys.add(Long.valueOf(mainKey));
/*  68 */       keys.add(Long.valueOf(viceKey));
/*  69 */       lock(All_lotto_infos.getTable(), keys);
/*     */       
/*  71 */       AllLottoInfo xMainAllLottoInfo = All_lotto_infos.get(Long.valueOf(mainKey));
/*  72 */       AllLottoInfo xViceAllLottoInfo = All_lotto_infos.get(Long.valueOf(viceKey));
/*     */       
/*     */ 
/*  75 */       if ((xMainAllLottoInfo == null) && (xViceAllLottoInfo == null))
/*     */       {
/*  77 */         MergeMain.logger().info(String.format("[alllotto]AllLottoMergeModule.PMerge.processImp@main server and vice server have no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*     */ 
/*  81 */         return true;
/*     */       }
/*     */       
/*  84 */       if ((xMainAllLottoInfo != null) && (xViceAllLottoInfo == null))
/*     */       {
/*  86 */         MergeMain.logger().info(String.format("[alllotto]AllLottoMergeModule.PMerge.processImp@vice server has no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*     */ 
/*  90 */         return true;
/*     */       }
/*     */       
/*  93 */       if ((xMainAllLottoInfo == null) && (xViceAllLottoInfo != null))
/*     */       {
/*  95 */         All_lotto_infos.insert(Long.valueOf(mainKey), xViceAllLottoInfo.copy());
/*  96 */         All_lotto_infos.remove(Long.valueOf(viceKey));
/*  97 */         MergeMain.logger().info(String.format("[alllotto]AllLottoMergeModule.PMerge.processImp@main server has no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*     */ 
/* 101 */         return true;
/*     */       }
/*     */       
/* 104 */       All_lotto_infos.remove(Long.valueOf(viceKey));
/* 105 */       for (int turn = 1; turn <= cfg.turn_infos.size(); turn++)
/*     */       {
/* 107 */         AllLottoTurnInfo xMainAllLottoTurnInfo = (AllLottoTurnInfo)xMainAllLottoInfo.getTurn_infos().get(Integer.valueOf(turn));
/* 108 */         AllLottoTurnInfo xViceAllLottoTurnInfo = (AllLottoTurnInfo)xViceAllLottoInfo.getTurn_infos().get(Integer.valueOf(turn));
/*     */         
/*     */ 
/* 111 */         if ((xMainAllLottoTurnInfo == null) && (xViceAllLottoTurnInfo == null))
/*     */         {
/* 113 */           MergeMain.logger().info(String.format("[alllotto]AllLottoMergeModule.PMerge.processImp@main server and vice server have no turn data|activity_cfg_id=%d|turn=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 120 */         else if ((xMainAllLottoTurnInfo != null) && (xViceAllLottoTurnInfo == null))
/*     */         {
/* 122 */           MergeMain.logger().info(String.format("[alllotto]AllLottoMergeModule.PMerge.processImp@vice server has no turn data|activity_cfg_id=%d|turn=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 129 */         else if ((xMainAllLottoTurnInfo == null) && (xViceAllLottoTurnInfo != null))
/*     */         {
/* 131 */           xMainAllLottoInfo.getTurn_infos().put(Integer.valueOf(turn), xViceAllLottoTurnInfo.copy());
/* 132 */           MergeMain.logger().info(String.format("[alllotto]AllLottoMergeModule.PMerge.processImp@main server has no turn data|activity_cfg_id=%d|turn=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn) }));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 139 */           MergeMain.logger().info(String.format("[alllotto]AllLottoMergeModule.PMerge.processImp@main server and vice server have turn data|activity_cfg_id=%d|turn=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn) }));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 144 */       MergeMain.logger().info(String.format("[alllotto]AllLottoMergeModule.PMerge.processImp@main server and vice server have data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 148 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\AllLottoMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */