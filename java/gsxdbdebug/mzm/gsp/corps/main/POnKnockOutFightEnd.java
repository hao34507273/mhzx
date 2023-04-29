/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.event.KnockOutFightEndArg;
/*     */ import mzm.gsp.crossbattle.event.KnockOutFightEndProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class POnKnockOutFightEnd
/*     */   extends KnockOutFightEndProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  17 */     String session = CrossBattleConsts.getInstance().cross_battle_session;
/*  18 */     if (((KnockOutFightEndArg)this.arg).rank == 2)
/*     */     {
/*     */ 
/*  21 */       return false;
/*     */     }
/*  23 */     if (((KnockOutFightEndArg)this.arg).rank == 4)
/*     */     {
/*  25 */       if (!((KnockOutFightEndArg)this.arg).isDraw)
/*     */       {
/*     */ 
/*  28 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  32 */     int historyType = getHistoryType();
/*  33 */     if (historyType == -1)
/*     */     {
/*  35 */       GameServer.logger().error(String.format("[corps]POnSelectionFinalFightEnd@ illegal fightType!|session=%s|corpsId=%d|rank=%d|isWin=%s|knockOutType=%d", new Object[] { session, Long.valueOf(((KnockOutFightEndArg)this.arg).corpsId), Integer.valueOf(((KnockOutFightEndArg)this.arg).rank), Boolean.valueOf(((KnockOutFightEndArg)this.arg).isWin), Integer.valueOf(((KnockOutFightEndArg)this.arg).knockOutType) }));
/*     */       
/*     */ 
/*     */ 
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if ((((KnockOutFightEndArg)this.arg).isWin) && (((KnockOutFightEndArg)this.arg).rank != 1) && (((KnockOutFightEndArg)this.arg).rank != 3))
/*     */     {
/*     */ 
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     List<String> params = new ArrayList();
/*  49 */     params.add(session);
/*  50 */     params.add(getRankStr(((KnockOutFightEndArg)this.arg).rank, ((KnockOutFightEndArg)this.arg).isWin));
/*     */     
/*  52 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(((KnockOutFightEndArg)this.arg).corpsId));
/*  53 */     if (xCorps == null)
/*     */     {
/*  55 */       GameServer.logger().error(String.format("[corps]POnSelectionFinalFightEnd@ no corps!|session=%s|corpsId=%d|rank=%d|isWin=%s|knockOutType=%d", new Object[] { session, Long.valueOf(((KnockOutFightEndArg)this.arg).corpsId), Integer.valueOf(((KnockOutFightEndArg)this.arg).rank), Boolean.valueOf(((KnockOutFightEndArg)this.arg).isWin), Integer.valueOf(((KnockOutFightEndArg)this.arg).knockOutType) }));
/*     */       
/*     */ 
/*     */ 
/*  59 */       return false;
/*     */     }
/*  61 */     CorpsManager.addCorpsHistory(xCorps, historyType, params);
/*     */     
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   private String getRankStr(int argRank, boolean isWin)
/*     */   {
/*  68 */     StringBuffer rankSb = new StringBuffer();
/*  69 */     int finalRank = argRank;
/*  70 */     if ((argRank == 3) || (argRank == 1))
/*     */     {
/*  72 */       if (!isWin)
/*     */       {
/*  74 */         finalRank++;
/*     */       }
/*     */     }
/*  77 */     switch (finalRank)
/*     */     {
/*     */     case 1: 
/*  80 */       rankSb.append("冠军");
/*  81 */       break;
/*     */     case 2: 
/*  83 */       rankSb.append("亚军");
/*  84 */       break;
/*     */     case 3: 
/*  86 */       rankSb.append("季军");
/*  87 */       break;
/*     */     case 4: 
/*  89 */       rankSb.append("殿军");
/*  90 */       break;
/*     */     
/*     */     default: 
/*  93 */       rankSb.append(finalRank).append("强");
/*     */     }
/*     */     
/*  96 */     return rankSb.toString();
/*     */   }
/*     */   
/*     */   private int getHistoryType()
/*     */   {
/* 101 */     switch (((KnockOutFightEndArg)this.arg).knockOutType)
/*     */     {
/*     */     case 1: 
/* 104 */       return 8;
/*     */     case 2: 
/* 106 */       return 9;
/*     */     }
/* 108 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnKnockOutFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */