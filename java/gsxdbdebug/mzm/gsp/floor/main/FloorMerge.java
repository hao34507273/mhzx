/*     */ package mzm.gsp.floor.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FloorFightRes;
/*     */ import xbean.GlobalFloorActivityInfo;
/*     */ import xbean.GlobalFloorInfo;
/*     */ import xbean.GlobalSingleFloorInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Globalfloor;
/*     */ 
/*     */ public class FloorMerge implements mzm.gsp.MergeModule
/*     */ {
/*     */   private final Logger logger;
/*     */   
/*     */   public FloorMerge()
/*     */   {
/*  21 */     this.logger = Logger.getLogger(FloorMerge.class);
/*     */   }
/*     */   
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  26 */     List<xdb.Table> tables = new java.util.ArrayList();
/*  27 */     tables.add(xtable.Role2flooractivity.getTable());
/*  28 */     tables.add(Globalfloor.getTable());
/*  29 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  35 */     boolean res = new MergeGlobalfloor().call();
/*  36 */     if (!res)
/*     */     {
/*  38 */       this.logger.error("[floor]MergeGlobalfloor.processImp@ MergeGlobalfloor err!");
/*     */     }
/*  40 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public class MergeGlobalfloor
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*  51 */     private final Logger logger = Logger.getLogger(MergeGlobalfloor.class);
/*     */     
/*     */     public MergeGlobalfloor() {}
/*     */     
/*     */     protected boolean processImp() throws Exception {
/*  56 */       long mainKey = mzm.gsp.MergeMain.getMainZoneid();
/*  57 */       long viceKey = mzm.gsp.MergeMain.getViceZoneid();
/*     */       
/*  59 */       lock(Globalfloor.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  61 */       GlobalFloorActivityInfo xViceActivitysData = Globalfloor.get(Long.valueOf(viceKey));
/*  62 */       if (xViceActivitysData == null)
/*     */       {
/*  64 */         this.logger.warn(String.format("[floor]MergeGlobalfloor.processImp@ no vice level xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */         
/*  66 */         return true;
/*     */       }
/*  68 */       GlobalFloorActivityInfo xMainActivitysData = Globalfloor.get(Long.valueOf(mainKey));
/*  69 */       if (xMainActivitysData == null)
/*     */       {
/*  71 */         xMainActivitysData = Pod.newGlobalFloorActivityInfo();
/*  72 */         Globalfloor.insert(Long.valueOf(mainKey), xMainActivitysData);
/*     */       }
/*     */       
/*  75 */       Set<Integer> allActivityIds = new java.util.HashSet();
/*  76 */       allActivityIds.addAll(xMainActivitysData.getActivityinfo().keySet());
/*  77 */       allActivityIds.addAll(xViceActivitysData.getActivityinfo().keySet());
/*     */       
/*  79 */       Map<Integer, GlobalFloorInfo> xTmpGlobalData = new java.util.HashMap();
/*     */       
/*  81 */       for (Iterator i$ = allActivityIds.iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */         
/*  83 */         GlobalFloorInfo xMainFloorInfo = (GlobalFloorInfo)xMainActivitysData.getActivityinfo().get(Integer.valueOf(activityId));
/*  84 */         GlobalFloorInfo xViceFloorInfo = (GlobalFloorInfo)xViceActivitysData.getActivityinfo().get(Integer.valueOf(activityId));
/*  85 */         if ((xMainFloorInfo != null) || (xViceFloorInfo != null))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  90 */           GlobalFloorInfo xTmpFloorInfo = Pod.newGlobalFloorInfo();
/*  91 */           if ((xMainFloorInfo == null) && (xViceFloorInfo != null))
/*     */           {
/*  93 */             copyXFloorData(xTmpFloorInfo, xViceFloorInfo.getFloor2info());
/*     */           }
/*  95 */           if ((xMainFloorInfo != null) && (xViceFloorInfo == null))
/*     */           {
/*  97 */             copyXFloorData(xTmpFloorInfo, xMainFloorInfo.getFloor2info());
/*     */           }
/*  99 */           if ((xMainFloorInfo != null) && (xViceFloorInfo != null))
/*     */           {
/* 101 */             compareAndCopyXFloorData(xMainFloorInfo, xViceFloorInfo, xTmpFloorInfo);
/*     */           }
/* 103 */           if (xTmpFloorInfo.getFloor2info().size() != 0)
/*     */           {
/*     */ 
/*     */ 
/* 107 */             xTmpGlobalData.put(Integer.valueOf(activityId), xTmpFloorInfo); }
/*     */         }
/*     */       }
/* 110 */       xMainActivitysData.getActivityinfo().clear();
/*     */       
/* 112 */       xMainActivitysData.getActivityinfo().putAll(xTmpGlobalData);
/*     */       
/* 114 */       Globalfloor.remove(Long.valueOf(viceKey));
/* 115 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     private void compareAndCopyXFloorData(GlobalFloorInfo xMainFloorInfo, GlobalFloorInfo xViceFloorInfo, GlobalFloorInfo xTmpFloorInfo)
/*     */     {
/* 121 */       Set<Integer> allFloors = new java.util.HashSet();
/* 122 */       allFloors.addAll(xMainFloorInfo.getFloor2info().keySet());
/* 123 */       allFloors.addAll(xViceFloorInfo.getFloor2info().keySet());
/*     */       
/* 125 */       for (Iterator i$ = allFloors.iterator(); i$.hasNext();) { int floor = ((Integer)i$.next()).intValue();
/*     */         
/* 127 */         GlobalSingleFloorInfo xMainSingleData = (GlobalSingleFloorInfo)xMainFloorInfo.getFloor2info().get(Integer.valueOf(floor));
/* 128 */         GlobalSingleFloorInfo xViceSingleData = (GlobalSingleFloorInfo)xViceFloorInfo.getFloor2info().get(Integer.valueOf(floor));
/* 129 */         if ((xMainSingleData != null) || (xViceSingleData != null))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 134 */           GlobalSingleFloorInfo xTmpSingleFloorInfo = Pod.newGlobalSingleFloorInfo();
/* 135 */           fillXSingleFloorInfo(xMainSingleData, xViceSingleData, xTmpSingleFloorInfo);
/* 136 */           if ((xTmpSingleFloorInfo.getFastkill().getKilltime() > 0) || (xTmpSingleFloorInfo.getFirstblood().getKilltime() > 0))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 141 */             xTmpFloorInfo.getFloor2info().put(Integer.valueOf(floor), xTmpSingleFloorInfo);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     private void fillXSingleFloorInfo(GlobalSingleFloorInfo xMainSingleData, GlobalSingleFloorInfo xViceSingleData, GlobalSingleFloorInfo xTmpSingleFloorInfo) {
/* 148 */       if ((xMainSingleData != null) && (xViceSingleData != null))
/*     */       {
/*     */ 
/* 151 */         fillXFastKill(xTmpSingleFloorInfo, xMainSingleData.getFastkill(), xViceSingleData.getFastkill());
/*     */         
/* 153 */         fillXFirstBlood(xTmpSingleFloorInfo, xMainSingleData.getFirstblood(), xViceSingleData.getFirstblood());
/*     */       }
/* 155 */       if ((xMainSingleData == null) && (xViceSingleData != null))
/*     */       {
/*     */ 
/* 158 */         fillXFightRes(xTmpSingleFloorInfo.getFastkill(), xViceSingleData.getFastkill());
/*     */         
/* 160 */         fillXFightRes(xTmpSingleFloorInfo.getFirstblood(), xViceSingleData.getFirstblood());
/*     */       }
/* 162 */       if ((xMainSingleData != null) && (xViceSingleData == null))
/*     */       {
/*     */ 
/* 165 */         fillXFightRes(xTmpSingleFloorInfo.getFastkill(), xMainSingleData.getFastkill());
/*     */         
/* 167 */         fillXFightRes(xTmpSingleFloorInfo.getFirstblood(), xMainSingleData.getFirstblood());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     private void fillXFirstBlood(GlobalSingleFloorInfo xTmpSingleFloorInfo, FloorFightRes xMainFirstBlood, FloorFightRes xViceFirstBlood)
/*     */     {
/* 174 */       if ((xMainFirstBlood.getKilltime() > 0) && (xViceFirstBlood.getKilltime() > 0))
/*     */       {
/* 176 */         if (xMainFirstBlood.getKilltime() <= xViceFirstBlood.getKilltime())
/*     */         {
/* 178 */           fillXFightRes(xTmpSingleFloorInfo.getFirstblood(), xMainFirstBlood);
/*     */         }
/*     */         else
/*     */         {
/* 182 */           fillXFightRes(xTmpSingleFloorInfo.getFirstblood(), xViceFirstBlood);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 187 */       else if (xMainFirstBlood.getKilltime() > 0)
/*     */       {
/* 189 */         fillXFightRes(xTmpSingleFloorInfo.getFirstblood(), xMainFirstBlood);
/*     */ 
/*     */ 
/*     */       }
/* 193 */       else if (xViceFirstBlood.getKilltime() > 0)
/*     */       {
/* 195 */         fillXFightRes(xTmpSingleFloorInfo.getFirstblood(), xViceFirstBlood);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private void fillXFastKill(GlobalSingleFloorInfo xTmpSingleFloorInfo, FloorFightRes xMainFastKill, FloorFightRes xViceFastKill)
/*     */     {
/* 204 */       if ((xMainFastKill.getUsedtime() > 0) && (xViceFastKill.getUsedtime() > 0))
/*     */       {
/* 206 */         if (xMainFastKill.getUsedtime() <= xViceFastKill.getUsedtime())
/*     */         {
/* 208 */           fillXFightRes(xTmpSingleFloorInfo.getFastkill(), xMainFastKill);
/*     */         }
/*     */         else
/*     */         {
/* 212 */           fillXFightRes(xTmpSingleFloorInfo.getFastkill(), xViceFastKill);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 217 */       else if (xMainFastKill.getUsedtime() > 0)
/*     */       {
/* 219 */         fillXFightRes(xTmpSingleFloorInfo.getFastkill(), xMainFastKill);
/*     */ 
/*     */ 
/*     */       }
/* 223 */       else if (xViceFastKill.getUsedtime() > 0)
/*     */       {
/* 225 */         fillXFightRes(xTmpSingleFloorInfo.getFastkill(), xMainFastKill);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     private void fillXFightRes(FloorFightRes xFillFightRes, FloorFightRes xBaseFightRes)
/*     */     {
/* 233 */       if (xBaseFightRes.getKilltime() <= 0)
/*     */       {
/* 235 */         return;
/*     */       }
/* 237 */       xFillFightRes.setKilltime(xBaseFightRes.getKilltime());
/* 238 */       xFillFightRes.setRadioid(xBaseFightRes.getRadioid());
/* 239 */       xFillFightRes.setUsedtime(xBaseFightRes.getUsedtime());
/* 240 */       xFillFightRes.getNames().addAll(xBaseFightRes.getNames());
/*     */     }
/*     */     
/*     */     private void copyXFloorData(GlobalFloorInfo xTmpFloorInfo, Map<Integer, GlobalSingleFloorInfo> xFloorsInfo)
/*     */     {
/* 245 */       for (java.util.Map.Entry<Integer, GlobalSingleFloorInfo> entry : xFloorsInfo.entrySet())
/*     */       {
/* 247 */         int floor = ((Integer)entry.getKey()).intValue();
/* 248 */         GlobalSingleFloorInfo xSingleFloorInfo = (GlobalSingleFloorInfo)entry.getValue();
/*     */         
/* 250 */         GlobalSingleFloorInfo xTmpSingleFloorInfo = Pod.newGlobalSingleFloorInfo();
/* 251 */         xTmpSingleFloorInfo.getFastkill().setKilltime(xSingleFloorInfo.getFastkill().getKilltime());
/* 252 */         xTmpSingleFloorInfo.getFastkill().setRadioid(xSingleFloorInfo.getFastkill().getRadioid());
/* 253 */         xTmpSingleFloorInfo.getFastkill().setUsedtime(xSingleFloorInfo.getFastkill().getUsedtime());
/* 254 */         xTmpSingleFloorInfo.getFastkill().getNames().addAll(xSingleFloorInfo.getFastkill().getNames());
/*     */         
/* 256 */         xTmpSingleFloorInfo.getFirstblood().setKilltime(xSingleFloorInfo.getFirstblood().getKilltime());
/* 257 */         xTmpSingleFloorInfo.getFirstblood().setRadioid(xSingleFloorInfo.getFirstblood().getRadioid());
/* 258 */         xTmpSingleFloorInfo.getFirstblood().setUsedtime(xSingleFloorInfo.getFirstblood().getUsedtime());
/* 259 */         xTmpSingleFloorInfo.getFirstblood().getNames().addAll(xSingleFloorInfo.getFirstblood().getNames());
/*     */         
/* 261 */         xTmpFloorInfo.getFloor2info().put(Integer.valueOf(floor), xTmpSingleFloorInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\FloorMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */