/*     */ package mzm.gsp.drawcarnival.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.drawcarnival.confbean.SOrigDrawCarnivalSpreadWealthCfg;
/*     */ import xbean.DrawCarnivalActivityInfo;
/*     */ import xbean.DrawCarnivalAwardWinnerInfo;
/*     */ import xbean.DrawCarnivalGlobalInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Table;
/*     */ import xtable.Drawcarnivalactivityglobal;
/*     */ 
/*     */ public class DrawCarnivalMergeModule implements mzm.gsp.MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  20 */     List<Table> tables = new java.util.ArrayList();
/*  21 */     tables.add(xtable.Role2drawcarnivalactivity.getTable());
/*  22 */     tables.add(Drawcarnivalactivityglobal.getTable());
/*  23 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  29 */     return new PMerge().call();
/*     */   }
/*     */   
/*     */   static class PMerge
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  37 */       long mainZoneId = MergeMain.getMainZoneid();
/*  38 */       long viceZoneId = MergeMain.getViceZoneid();
/*     */       
/*  40 */       Set<Long> globalIdSet = new java.util.HashSet();
/*  41 */       globalIdSet.add(Long.valueOf(mainZoneId));
/*  42 */       globalIdSet.add(Long.valueOf(viceZoneId));
/*     */       
/*     */ 
/*  45 */       lock(Drawcarnivalactivityglobal.getTable(), globalIdSet);
/*     */       
/*  47 */       DrawCarnivalGlobalInfo xViceGlobalInfo = Drawcarnivalactivityglobal.get(Long.valueOf(viceZoneId));
/*  48 */       if (xViceGlobalInfo == null)
/*     */       {
/*  50 */         return true;
/*     */       }
/*     */       
/*  53 */       DrawCarnivalGlobalInfo xMainGlobalInfo = Drawcarnivalactivityglobal.get(Long.valueOf(mainZoneId));
/*  54 */       if (xMainGlobalInfo == null)
/*     */       {
/*  56 */         xMainGlobalInfo = Pod.newDrawCarnivalGlobalInfo();
/*  57 */         Drawcarnivalactivityglobal.insert(Long.valueOf(mainZoneId), xMainGlobalInfo);
/*     */         
/*     */ 
/*  60 */         xMainGlobalInfo.setAward_pool_yuan_bao_count(xViceGlobalInfo.getAward_pool_yuan_bao_count());
/*     */         
/*     */ 
/*  63 */         for (Map.Entry<Integer, DrawCarnivalActivityInfo> entry : xViceGlobalInfo.getActivity_id2info().entrySet())
/*     */         {
/*  65 */           xMainGlobalInfo.getActivity_id2info().put(entry.getKey(), ((DrawCarnivalActivityInfo)entry.getValue()).copy());
/*     */         }
/*     */         
/*  68 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  73 */       xMainGlobalInfo.setAward_pool_yuan_bao_count(xMainGlobalInfo.getAward_pool_yuan_bao_count() + xViceGlobalInfo.getAward_pool_yuan_bao_count());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */       for (Map.Entry<Integer, DrawCarnivalActivityInfo> entry : xViceGlobalInfo.getActivity_id2info().entrySet())
/*     */       {
/*  86 */         int activityId = ((Integer)entry.getKey()).intValue();
/*  87 */         DrawCarnivalActivityInfo xViceDrawCarnivalActivityInfo = (DrawCarnivalActivityInfo)entry.getValue();
/*     */         
/*  89 */         xMainDrawCarnivalActivityInfo = (DrawCarnivalActivityInfo)xMainGlobalInfo.getActivity_id2info().get(Integer.valueOf(activityId));
/*  90 */         if (xMainDrawCarnivalActivityInfo == null)
/*     */         {
/*  92 */           xMainDrawCarnivalActivityInfo = Pod.newDrawCarnivalActivityInfo();
/*  93 */           xMainGlobalInfo.getActivity_id2info().put(Integer.valueOf(activityId), xMainDrawCarnivalActivityInfo);
/*     */           
/*  95 */           DrawCarnivalMergeModule.copyDrawCarnivalActivityInfo(xMainDrawCarnivalActivityInfo, xViceDrawCarnivalActivityInfo);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 100 */           xMainDrawCarnivalActivityInfo.setBig_award_count(xMainDrawCarnivalActivityInfo.getBig_award_count() + xViceDrawCarnivalActivityInfo.getBig_award_count());
/*     */           
/*     */ 
/*     */ 
/* 104 */           xMainDrawCarnivalActivityInfo.setAccumulate_yuan_bao_cost_count(xMainDrawCarnivalActivityInfo.getAccumulate_yuan_bao_cost_count() + xViceDrawCarnivalActivityInfo.getAccumulate_yuan_bao_cost_count());
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 109 */           DrawCarnivalAwardWinnerInfo xMainDrawCarnivalAwardWinnerInfo = xMainDrawCarnivalActivityInfo.getLast_winner_role_info();
/* 110 */           DrawCarnivalAwardWinnerInfo xViceDrawCarnivalAwardWinnerInfo = xViceDrawCarnivalActivityInfo.getLast_winner_role_info();
/* 111 */           if (xViceDrawCarnivalAwardWinnerInfo.getRole_id() > 0L)
/*     */           {
/* 113 */             if ((xMainDrawCarnivalAwardWinnerInfo.getRole_id() <= 0L) || (xViceDrawCarnivalAwardWinnerInfo.getAward_time_stamp() > xMainDrawCarnivalAwardWinnerInfo.getAward_time_stamp()))
/*     */             {
/*     */ 
/*     */ 
/* 117 */               DrawCarnivalMergeModule.copyLastWinnerRoleInfo(xMainDrawCarnivalActivityInfo, xViceDrawCarnivalActivityInfo);
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 122 */           for (Map.Entry<Integer, Integer> randomTypId2chestCountEntry : xViceDrawCarnivalActivityInfo.getRandom_type_id2chest_count().entrySet())
/*     */           {
/* 124 */             int viceRandomTypeId = ((Integer)randomTypId2chestCountEntry.getKey()).intValue();
/* 125 */             int viceChestCount = ((Integer)randomTypId2chestCountEntry.getValue()).intValue();
/* 126 */             if (xMainDrawCarnivalActivityInfo.getRandom_type_id2chest_count().containsKey(Integer.valueOf(viceRandomTypeId)))
/*     */             {
/* 128 */               int mainChestCount = ((Integer)xMainDrawCarnivalActivityInfo.getRandom_type_id2chest_count().get(Integer.valueOf(viceRandomTypeId))).intValue();
/* 129 */               mainChestCount += viceChestCount;
/* 130 */               SOrigDrawCarnivalSpreadWealthCfg sOrigDrawCarnivalSpreadWealthCfg = SOrigDrawCarnivalSpreadWealthCfg.get(viceRandomTypeId);
/* 131 */               if (sOrigDrawCarnivalSpreadWealthCfg == null)
/*     */               {
/* 133 */                 mzm.gsp.GameServer.logger().error(String.format("[draw_carnival]DrawCarnivalMergeModule.PMerge.processImp@sOrigDrawCarnivalSpreadWealthCfg is null|randomTypeId=%d", new Object[] { Integer.valueOf(viceRandomTypeId) }));
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/* 138 */                 mainChestCount = mainChestCount > sOrigDrawCarnivalSpreadWealthCfg.chestCountMax ? sOrigDrawCarnivalSpreadWealthCfg.chestCountMax : mainChestCount;
/*     */                 
/*     */ 
/* 141 */                 xMainDrawCarnivalActivityInfo.getRandom_type_id2chest_count().put(Integer.valueOf(viceRandomTypeId), Integer.valueOf(mainChestCount));
/*     */               }
/*     */             }
/*     */             else {
/* 145 */               xMainDrawCarnivalActivityInfo.getRandom_type_id2chest_count().put(Integer.valueOf(viceRandomTypeId), Integer.valueOf(viceChestCount));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */       DrawCarnivalActivityInfo xMainDrawCarnivalActivityInfo;
/*     */       
/* 153 */       Drawcarnivalactivityglobal.delete(Long.valueOf(viceZoneId));
/*     */       
/* 155 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void copyDrawCarnivalActivityInfo(DrawCarnivalActivityInfo xTo, DrawCarnivalActivityInfo xFrom)
/*     */   {
/* 163 */     copyLastWinnerRoleInfo(xTo, xFrom);
/*     */     
/*     */ 
/* 166 */     xTo.setAccumulate_yuan_bao_cost_count(xFrom.getAccumulate_yuan_bao_cost_count());
/*     */     
/*     */ 
/* 169 */     for (Map.Entry<Integer, Integer> entry : xFrom.getPass_type_id2extra_rate_per_pass().entrySet())
/*     */     {
/* 171 */       xTo.getPass_type_id2extra_rate_per_pass().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */     
/*     */ 
/* 175 */     xTo.setBig_award_count(xFrom.getBig_award_count());
/*     */     
/*     */ 
/* 178 */     for (Map.Entry<Integer, Integer> entry : xFrom.getRandom_type_id2chest_count().entrySet())
/*     */     {
/* 180 */       xTo.getRandom_type_id2chest_count().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void copyLastWinnerRoleInfo(DrawCarnivalActivityInfo xTo, DrawCarnivalActivityInfo xFrom)
/*     */   {
/* 189 */     xTo.getLast_winner_role_info().setRole_id(xFrom.getLast_winner_role_info().getRole_id());
/*     */     
/* 191 */     xTo.getLast_winner_role_info().setRole_name(xFrom.getLast_winner_role_info().getRole_name());
/*     */     
/* 193 */     xTo.getLast_winner_role_info().setRandom_type_id(xFrom.getLast_winner_role_info().getRandom_type_id());
/*     */     
/* 195 */     xTo.getLast_winner_role_info().setAward_count(xFrom.getLast_winner_role_info().getAward_count());
/*     */     
/* 197 */     xTo.getLast_winner_role_info().setAward_time_stamp(xFrom.getLast_winner_role_info().getAward_time_stamp());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\DrawCarnivalMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */