/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleFinalBuffCfg;
/*     */ import xbean.HideItemInfo;
/*     */ import xbean.IdipConfigInfo;
/*     */ import xbean.IdipForbidInfo;
/*     */ import xbean.IdipNTimesAwardInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleInfoForbid;
/*     */ import xbean.RolePlayForbid;
/*     */ import xbean.RoleRankForbid;
/*     */ import xtable.Idipconfig;
/*     */ import xtable.Idipmarquee;
/*     */ 
/*     */ public class PIdipMerge extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     long mainKey = MergeMain.getMainZoneid();
/*  25 */     long viceKey = MergeMain.getViceZoneid();
/*  26 */     lock(xdb.Lockeys.get(Idipconfig.getTable(), new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */     
/*  28 */     IdipConfigInfo xMainConfigInfo = Idipconfig.get(Long.valueOf(mainKey));
/*  29 */     IdipConfigInfo xViceConfigInfo = Idipconfig.get(Long.valueOf(viceKey));
/*  30 */     if (xViceConfigInfo != null)
/*     */     {
/*  32 */       if (xMainConfigInfo == null)
/*     */       {
/*  34 */         xMainConfigInfo = Pod.newIdipConfigInfo();
/*  35 */         Idipconfig.insert(Long.valueOf(mainKey), xMainConfigInfo);
/*     */       }
/*     */       
/*  38 */       handleRankForbids(xMainConfigInfo.getRank_forbids(), xViceConfigInfo.getRank_forbids());
/*  39 */       handlePlayForbids(xMainConfigInfo.getPlay_forbids(), xViceConfigInfo.getPlay_forbids());
/*  40 */       handleInfoForbids(xMainConfigInfo.getInfo_forbids(), xViceConfigInfo.getInfo_forbids());
/*  41 */       handleZeroProfit(xMainConfigInfo.getZero_profits(), xViceConfigInfo.getZero_profits());
/*     */       
/*  43 */       handleNotice(xMainConfigInfo.getNotices(), xViceConfigInfo.getNotices());
/*     */       
/*  45 */       handleMarquee(xMainConfigInfo.getMarquees(), xViceConfigInfo.getMarquees());
/*     */       
/*     */ 
/*  48 */       handleIdipNTimesAward(xMainConfigInfo.getN_times_award(), xViceConfigInfo.getN_times_award());
/*     */       
/*     */ 
/*  51 */       handleItemHide(xMainConfigInfo.getHide_items(), xViceConfigInfo.getHide_items());
/*     */     }
/*  53 */     Idipconfig.remove(Long.valueOf(viceKey));
/*     */     
/*     */ 
/*  56 */     handDuplicateMarquee(xMainConfigInfo);
/*     */     
/*     */ 
/*     */ 
/*  60 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIdipMerge.processImp@merge success|main_key=%d|vice_key=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */     
/*     */ 
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   private void handDuplicateMarquee(IdipConfigInfo xMainConfigInfo)
/*     */   {
/*  68 */     if (xMainConfigInfo == null)
/*     */     {
/*  70 */       return;
/*     */     }
/*  72 */     Set<Long> xMarquees = xMainConfigInfo.getMarquees();
/*  73 */     if (xMarquees.isEmpty())
/*     */     {
/*  75 */       return;
/*     */     }
/*     */     
/*  78 */     lock(xdb.Lockeys.get(Idipmarquee.getTable(), xMarquees));
/*  79 */     Iterator<Long> xIt = xMarquees.iterator();
/*  80 */     Set<Long> indexIds = new java.util.HashSet();
/*  81 */     while (xIt.hasNext())
/*     */     {
/*  83 */       long marqueeid = ((Long)xIt.next()).longValue();
/*  84 */       xbean.IdipMarqueeInfo xIdipMarqueeInfo = Idipmarquee.get(Long.valueOf(marqueeid));
/*  85 */       if (xIdipMarqueeInfo == null)
/*     */       {
/*  87 */         xIt.remove();
/*  88 */         Idipmarquee.remove(Long.valueOf(marqueeid));
/*     */       }
/*     */       else
/*     */       {
/*  92 */         long indexId = xIdipMarqueeInfo.getIndexid();
/*  93 */         if (indexId != 0L)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  98 */           if (indexIds.contains(Long.valueOf(indexId)))
/*     */           {
/* 100 */             xIt.remove();
/* 101 */             Idipmarquee.remove(Long.valueOf(marqueeid));
/*     */           }
/*     */           else
/*     */           {
/* 105 */             indexIds.add(Long.valueOf(indexId));
/*     */           } }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/* 111 */   private void handleNotice(Set<Long> xMainNotices, Set<Long> xViceNotices) { xMainNotices.addAll(xViceNotices); }
/*     */   
/*     */ 
/*     */   private void handleMarquee(Set<Long> xMainMarquees, Set<Long> xViceMarquees)
/*     */   {
/* 116 */     xMainMarquees.addAll(xViceMarquees);
/*     */   }
/*     */   
/*     */ 
/*     */   private void handleZeroProfit(Map<Long, IdipForbidInfo> xMainZeroProfits, Map<Long, IdipForbidInfo> xViceZeroProfits)
/*     */   {
/* 122 */     if (xViceZeroProfits.isEmpty())
/*     */     {
/* 124 */       return;
/*     */     }
/*     */     
/* 127 */     for (Map.Entry<Long, IdipForbidInfo> xViceZeroProfit : xViceZeroProfits.entrySet())
/*     */     {
/* 129 */       IdipForbidInfo xViceIdipForbidInfo = (IdipForbidInfo)xViceZeroProfit.getValue();
/* 130 */       IdipForbidInfo xMainIdipForbidInfo = Pod.newIdipForbidInfo();
/*     */       
/* 132 */       xMainIdipForbidInfo.setExpiretime(xViceIdipForbidInfo.getExpiretime());
/* 133 */       xMainIdipForbidInfo.setReason(xViceIdipForbidInfo.getReason());
/* 134 */       xMainIdipForbidInfo.setStarttime(xViceIdipForbidInfo.getStarttime());
/*     */       
/* 136 */       xMainZeroProfits.put(xViceZeroProfit.getKey(), xMainIdipForbidInfo);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void handleRankForbids(Map<Long, RoleRankForbid> xMainRankForbids, Map<Long, RoleRankForbid> xViceRankForbids)
/*     */   {
/* 143 */     if (xViceRankForbids.isEmpty())
/*     */     {
/* 145 */       return;
/*     */     }
/*     */     
/* 148 */     for (Map.Entry<Long, RoleRankForbid> xViceRoleRankForbid : xViceRankForbids.entrySet())
/*     */     {
/* 150 */       RoleRankForbid xViceForbids = (RoleRankForbid)xViceRoleRankForbid.getValue();
/* 151 */       if (!xViceForbids.getForbids().isEmpty())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 156 */         xMainRoleRankForbid = Pod.newRoleRankForbid();
/* 157 */         xMainRankForbids.put(xViceRoleRankForbid.getKey(), xMainRoleRankForbid);
/* 158 */         for (Map.Entry<Integer, IdipForbidInfo> xViceForbid : xViceForbids.getForbids().entrySet())
/*     */         {
/* 160 */           IdipForbidInfo xViceIdipForbidInfo = (IdipForbidInfo)xViceForbid.getValue();
/* 161 */           IdipForbidInfo xMainIdipForbidInfo = Pod.newIdipForbidInfo();
/*     */           
/* 163 */           xMainIdipForbidInfo.setExpiretime(xViceIdipForbidInfo.getExpiretime());
/* 164 */           xMainIdipForbidInfo.setReason(xViceIdipForbidInfo.getReason());
/* 165 */           xMainIdipForbidInfo.setStarttime(xViceIdipForbidInfo.getStarttime());
/*     */           
/* 167 */           xMainRoleRankForbid.getForbids().put(xViceForbid.getKey(), xMainIdipForbidInfo);
/*     */         }
/*     */       }
/*     */     }
/*     */     RoleRankForbid xMainRoleRankForbid;
/*     */   }
/*     */   
/*     */   private void handlePlayForbids(Map<Long, RolePlayForbid> xMainPlayForbids, Map<Long, RolePlayForbid> xVicePlayForbids) {
/* 175 */     if (xVicePlayForbids.isEmpty())
/*     */     {
/* 177 */       return;
/*     */     }
/*     */     
/* 180 */     for (Map.Entry<Long, RolePlayForbid> xViceRolePlayForbid : xVicePlayForbids.entrySet())
/*     */     {
/* 182 */       RolePlayForbid xViceForbids = (RolePlayForbid)xViceRolePlayForbid.getValue();
/* 183 */       if (!xViceForbids.getForbids().isEmpty())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 188 */         xMainRolePlayForbid = Pod.newRolePlayForbid();
/* 189 */         xMainPlayForbids.put(xViceRolePlayForbid.getKey(), xMainRolePlayForbid);
/* 190 */         for (Map.Entry<Integer, IdipForbidInfo> xViceForbid : xViceForbids.getForbids().entrySet())
/*     */         {
/* 192 */           IdipForbidInfo xViceIdipForbidInfo = (IdipForbidInfo)xViceForbid.getValue();
/* 193 */           IdipForbidInfo xMainIdipForbidInfo = Pod.newIdipForbidInfo();
/*     */           
/* 195 */           xMainIdipForbidInfo.setExpiretime(xViceIdipForbidInfo.getExpiretime());
/* 196 */           xMainIdipForbidInfo.setReason(xViceIdipForbidInfo.getReason());
/* 197 */           xMainIdipForbidInfo.setStarttime(xViceIdipForbidInfo.getStarttime());
/*     */           
/* 199 */           xMainRolePlayForbid.getForbids().put(xViceForbid.getKey(), xMainIdipForbidInfo);
/*     */         }
/*     */       }
/*     */     }
/*     */     RolePlayForbid xMainRolePlayForbid;
/*     */   }
/*     */   
/*     */   private void handleInfoForbids(Map<Long, RoleInfoForbid> xMainInfoForbids, Map<Long, RoleInfoForbid> xViceInfoForbids) {
/* 207 */     if (xViceInfoForbids.isEmpty())
/*     */     {
/* 209 */       return;
/*     */     }
/* 211 */     for (Map.Entry<Long, RoleInfoForbid> xViceRoleInfoForbid : xViceInfoForbids.entrySet())
/*     */     {
/* 213 */       RoleInfoForbid xViceForbids = (RoleInfoForbid)xViceRoleInfoForbid.getValue();
/* 214 */       if (!xViceForbids.getForbids().isEmpty())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 219 */         xMainRoleInfoForbid = Pod.newRoleInfoForbid();
/* 220 */         xMainInfoForbids.put(xViceRoleInfoForbid.getKey(), xMainRoleInfoForbid);
/* 221 */         for (Map.Entry<Integer, IdipForbidInfo> xViceForbid : xViceForbids.getForbids().entrySet())
/*     */         {
/* 223 */           IdipForbidInfo xViceIdipForbidInfo = (IdipForbidInfo)xViceForbid.getValue();
/* 224 */           IdipForbidInfo xMainIdipForbidInfo = Pod.newIdipForbidInfo();
/*     */           
/* 226 */           xMainIdipForbidInfo.setExpiretime(xViceIdipForbidInfo.getExpiretime());
/* 227 */           xMainIdipForbidInfo.setReason(xViceIdipForbidInfo.getReason());
/* 228 */           xMainIdipForbidInfo.setStarttime(xViceIdipForbidInfo.getStarttime());
/*     */           
/* 230 */           xMainRoleInfoForbid.getForbids().put(xViceForbid.getKey(), xMainIdipForbidInfo);
/*     */         }
/*     */       }
/*     */     }
/*     */     RoleInfoForbid xMainRoleInfoForbid;
/*     */   }
/*     */   
/*     */   private void handleItemHide(Map<Integer, HideItemInfo> xMainHideItemInfos, Map<Integer, HideItemInfo> xViceHideItemInfos) {
/* 238 */     if (xViceHideItemInfos.isEmpty())
/*     */     {
/* 240 */       return;
/*     */     }
/*     */     
/* 243 */     for (Map.Entry<Integer, HideItemInfo> xEntry : xViceHideItemInfos.entrySet())
/*     */     {
/* 245 */       HideItemInfo xViceHideItemInfo = (HideItemInfo)xEntry.getValue();
/* 246 */       if (!xViceHideItemInfo.getItems().isEmpty())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 251 */         Integer key = (Integer)xEntry.getKey();
/* 252 */         HideItemInfo xMainHideItemInfo = (HideItemInfo)xMainHideItemInfos.get(key);
/* 253 */         if (xMainHideItemInfo == null)
/*     */         {
/* 255 */           xMainHideItemInfos.put(key, xViceHideItemInfo.copy());
/*     */         }
/*     */         else
/*     */         {
/* 259 */           xMainHideItemInfo.getItems().addAll(xViceHideItemInfo.getItems());
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void handleIdipNTimesAward(Map<Integer, IdipNTimesAwardInfo> xMainIdipNTimesAwardInfoMap, Map<Integer, IdipNTimesAwardInfo> xViceIdipNTimesAwardInfoMap) {
/* 266 */     SCrossBattleFinalBuffCfg sCrossBattleFinalBuffCfg = (SCrossBattleFinalBuffCfg)((Map.Entry)SCrossBattleFinalBuffCfg.getAll().entrySet().iterator().next()).getValue();
/*     */     
/* 268 */     for (Map.Entry<Integer, IdipNTimesAwardInfo> entry : xViceIdipNTimesAwardInfoMap.entrySet())
/*     */     {
/* 270 */       int buffId = ((Integer)entry.getKey()).intValue();
/* 271 */       if (sCrossBattleFinalBuffCfg.buff_id_set.contains(Integer.valueOf(buffId)))
/*     */       {
/* 273 */         IdipNTimesAwardInfo xMainIdipNTimesAwardInfo = (IdipNTimesAwardInfo)xMainIdipNTimesAwardInfoMap.get(Integer.valueOf(buffId));
/* 274 */         if (null == xMainIdipNTimesAwardInfo)
/*     */         {
/* 276 */           xMainIdipNTimesAwardInfoMap.put(Integer.valueOf(buffId), ((IdipNTimesAwardInfo)entry.getValue()).copy());
/*     */         }
/*     */         else
/*     */         {
/* 280 */           xMainIdipNTimesAwardInfo.getValid_zone_id_set().addAll(((IdipNTimesAwardInfo)entry.getValue()).getValid_zone_id_set());
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIdipMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */