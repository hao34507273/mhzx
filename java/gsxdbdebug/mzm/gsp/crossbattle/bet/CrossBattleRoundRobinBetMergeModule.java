/*     */ package mzm.gsp.crossbattle.bet;
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
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleRoundRobinBet;
/*     */ import xbean.RoundRobinFightBetInfo;
/*     */ import xbean.RoundRobinRoundBetInfo;
/*     */ import xdb.Table;
/*     */ import xtable.Cross_battle_round_robin_bets;
/*     */ 
/*     */ public class CrossBattleRoundRobinBetMergeModule implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  24 */     return Arrays.asList(new Table[] { Cross_battle_round_robin_bets.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  30 */     for (Iterator i$ = SCrossBattleRoundRobinBetCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  32 */       if (!new PMerge(activityCfgid).call())
/*     */       {
/*  34 */         return false;
/*     */       }
/*     */     }
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   private class PMerge extends mzm.gsp.util.LogicProcedure
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
/*  52 */       long mainZoneid = MergeMain.getMainZoneid();
/*  53 */       long viceZoneid = MergeMain.getViceZoneid();
/*  54 */       long mainKey = GameServerInfoManager.toGlobalId(this.activityCfgid, mainZoneid);
/*  55 */       long viceKey = GameServerInfoManager.toGlobalId(this.activityCfgid, viceZoneid);
/*     */       
/*  57 */       HashSet<Long> keys = new HashSet();
/*  58 */       keys.add(Long.valueOf(mainKey));
/*  59 */       keys.add(Long.valueOf(viceKey));
/*  60 */       lock(Cross_battle_round_robin_bets.getTable(), keys);
/*     */       
/*  62 */       CrossBattleRoundRobinBet xMainCrossBattleRoundRobinBet = Cross_battle_round_robin_bets.get(Long.valueOf(mainKey));
/*  63 */       CrossBattleRoundRobinBet xViceCrossBattleRoundRobinBet = Cross_battle_round_robin_bets.get(Long.valueOf(viceKey));
/*     */       
/*     */ 
/*  66 */       if ((xMainCrossBattleRoundRobinBet == null) && (xViceCrossBattleRoundRobinBet == null))
/*     */       {
/*  68 */         MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@main server and vice server have no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*     */ 
/*  72 */         return true;
/*     */       }
/*     */       
/*  75 */       if ((xMainCrossBattleRoundRobinBet != null) && (xViceCrossBattleRoundRobinBet == null))
/*     */       {
/*  77 */         MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@vice server has no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*  80 */         return true;
/*     */       }
/*     */       
/*  83 */       if ((xMainCrossBattleRoundRobinBet == null) && (xViceCrossBattleRoundRobinBet != null))
/*     */       {
/*  85 */         Cross_battle_round_robin_bets.remove(Long.valueOf(viceKey));
/*  86 */         Cross_battle_round_robin_bets.insert(Long.valueOf(mainKey), xViceCrossBattleRoundRobinBet.copy());
/*  87 */         MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@main server has no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*  90 */         return true;
/*     */       }
/*     */       
/*  93 */       Cross_battle_round_robin_bets.remove(Long.valueOf(viceKey));
/*  94 */       for (int i = 0; i < xViceCrossBattleRoundRobinBet.getRound_bet_infos().size(); i++)
/*     */       {
/*  96 */         if (i >= xMainCrossBattleRoundRobinBet.getRound_bet_infos().size())
/*     */         {
/*  98 */           xMainCrossBattleRoundRobinBet.getRound_bet_infos().add(((RoundRobinRoundBetInfo)xViceCrossBattleRoundRobinBet.getRound_bet_infos().get(i)).copy());
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 103 */           for (RoundRobinFightBetInfo xRoundRobinFightBetInfo : ((RoundRobinRoundBetInfo)xViceCrossBattleRoundRobinBet.getRound_bet_infos().get(i)).getFight_bet_infos())
/*     */           {
/*     */ 
/* 106 */             ((RoundRobinRoundBetInfo)xMainCrossBattleRoundRobinBet.getRound_bet_infos().get(i)).getFight_bet_infos().add(xRoundRobinFightBetInfo.copy());
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 111 */       MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@main server and vice server have data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 115 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\CrossBattleRoundRobinBetMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */