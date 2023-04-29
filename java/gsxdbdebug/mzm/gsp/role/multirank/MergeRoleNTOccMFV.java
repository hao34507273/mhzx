/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.NoneRealRoleMultiFightValueBean;
/*     */ import xbean.NoneRealTimeMultiFightValueRank;
/*     */ import xbean.NoneRealTimeOccMFVRankData;
/*     */ import xbean.Pod;
/*     */ import xtable.Nonerealtimeoccmfvrank;
/*     */ 
/*     */ 
/*     */ public class MergeRoleNTOccMFV
/*     */   extends LogicProcedure
/*     */ {
/*  22 */   private static final Logger logger = Logger.getLogger(MergeRoleNTOccMFV.class);
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     long mainKey = MergeMain.getMainZoneid();
/*  28 */     long viceKey = MergeMain.getViceZoneid();
/*     */     
/*  30 */     lock(Nonerealtimeoccmfvrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */     
/*  32 */     NoneRealTimeOccMFVRankData xViceMFV = Nonerealtimeoccmfvrank.get(Long.valueOf(viceKey));
/*  33 */     if (xViceMFV == null)
/*     */     {
/*  35 */       logger.warn(String.format("[mfv]MergeRoleNTOccMFV.processImp@ no vice mfv xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  37 */       return true;
/*     */     }
/*  39 */     NoneRealTimeOccMFVRankData xMainMFV = Nonerealtimeoccmfvrank.get(Long.valueOf(mainKey));
/*  40 */     if (xMainMFV == null)
/*     */     {
/*  42 */       xMainMFV = Pod.newNoneRealTimeOccMFVRankData();
/*  43 */       Nonerealtimeoccmfvrank.insert(Long.valueOf(mainKey), xMainMFV);
/*     */     }
/*     */     
/*  46 */     Iterator<Map.Entry<Integer, NoneRealTimeMultiFightValueRank>> it = xMainMFV.getOcc2rankdata().entrySet().iterator();
/*  47 */     while (it.hasNext())
/*     */     {
/*  49 */       Map.Entry<Integer, NoneRealTimeMultiFightValueRank> entry = (Map.Entry)it.next();
/*  50 */       int occId = ((Integer)entry.getKey()).intValue();
/*  51 */       NoneRealTimeMultiFightValueRank xMainMFVRank = (NoneRealTimeMultiFightValueRank)entry.getValue();
/*  52 */       NoneRealTimeMultiFightValueRank xViceMFVRank = (NoneRealTimeMultiFightValueRank)xViceMFV.getOcc2rankdata().get(Integer.valueOf(occId));
/*  53 */       if (xViceMFVRank == null)
/*     */       {
/*  55 */         logger.warn(String.format("[mfv]MergeRoleNTOccMFV.processImp@ no vice NT xOcc mfv xData!|mainKey=%d|viceKey=%d|occId=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey), Integer.valueOf(occId) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  60 */         RoleMFVRankManagerForMerge mergeRank = new RoleMFVRankManagerForMerge(Integer.MAX_VALUE, 0);
/*     */         
/*  62 */         addMFVData(xMainMFVRank.getRankdatas(), mergeRank, occId);
/*     */         
/*  64 */         addMFVData(xViceMFVRank.getRankdatas(), mergeRank, occId);
/*     */         
/*  66 */         xMainMFVRank.getRankdatas().clear();
/*     */         
/*  68 */         for (RoleMultiFightValueChart rankObj : mergeRank.getAllChartObjs())
/*     */         {
/*  70 */           NoneRealRoleMultiFightValueBean xMFV = Pod.newNoneRealRoleMultiFightValueBean();
/*  71 */           xMFV.setRoleid(rankObj.getRoleid());
/*  72 */           xMFV.setMultifightvalue(rankObj.getFightValue());
/*  73 */           xMainMFVRank.getRankdatas().add(xMFV);
/*     */         }
/*  75 */         mergeRank.clear();
/*     */         
/*  77 */         xMainMFVRank.getKeytorankchange().putAll(xViceMFVRank.getKeytorankchange());
/*     */       }
/*     */     }
/*  80 */     Nonerealtimeoccmfvrank.remove(Long.valueOf(viceKey));
/*  81 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addMFVData(List<NoneRealRoleMultiFightValueBean> xMFVDatas, RoleMFVRankManagerForMerge mergeRank, int occId)
/*     */   {
/*  92 */     if ((xMFVDatas == null) || (xMFVDatas.size() == 0))
/*     */     {
/*  94 */       return;
/*     */     }
/*  96 */     for (NoneRealRoleMultiFightValueBean xMFV : xMFVDatas)
/*     */     {
/*  98 */       long roleId = xMFV.getRoleid();
/*  99 */       int mfv = xMFV.getMultifightvalue();
/* 100 */       RoleMultiFightValueChart rankObj = new RoleMultiFightValueChart(roleId, mfv, occId);
/* 101 */       mergeRank.rank(rankObj);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MergeRoleNTOccMFV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */