/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MultiFightValueRank;
/*     */ import xbean.OccMFVRankData;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleMultiFightValueBean;
/*     */ import xtable.Occmfvrank;
/*     */ 
/*     */ 
/*     */ public class MergeRoleOccMFV
/*     */   extends LogicProcedure
/*     */ {
/*  23 */   private static final Logger logger = Logger.getLogger(MergeRoleOccMFV.class);
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     long mainKey = MergeMain.getMainZoneid();
/*  29 */     long viceKey = MergeMain.getViceZoneid();
/*     */     
/*  31 */     lock(Occmfvrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */     
/*  33 */     OccMFVRankData xViceMFV = Occmfvrank.get(Long.valueOf(viceKey));
/*  34 */     if (xViceMFV == null)
/*     */     {
/*  36 */       logger.warn(String.format("[mfv]MergeRoleOccMFV.processImp@ no vice occ mfv xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  38 */       return true;
/*     */     }
/*  40 */     OccMFVRankData xMainMFV = Occmfvrank.get(Long.valueOf(mainKey));
/*  41 */     if (xMainMFV == null)
/*     */     {
/*  43 */       xMainMFV = Pod.newOccMFVRankData();
/*  44 */       Occmfvrank.insert(Long.valueOf(mainKey), xMainMFV);
/*     */     }
/*     */     
/*  47 */     Iterator<Map.Entry<Integer, MultiFightValueRank>> it = xMainMFV.getOcc2rankdata().entrySet().iterator();
/*  48 */     while (it.hasNext())
/*     */     {
/*  50 */       Map.Entry<Integer, MultiFightValueRank> entry = (Map.Entry)it.next();
/*  51 */       int occId = ((Integer)entry.getKey()).intValue();
/*  52 */       MultiFightValueRank xMainMFVRank = (MultiFightValueRank)entry.getValue();
/*     */       
/*  54 */       MultiFightValueRank xViceMFVRank = (MultiFightValueRank)xViceMFV.getOcc2rankdata().get(Integer.valueOf(occId));
/*  55 */       if (xViceMFVRank == null)
/*     */       {
/*  57 */         logger.warn(String.format("[mfv]MergeRoleOccMFV.processImp@ no vice xOcc mfv xData!|mainKey=%d|viceKey=%d|occId=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey), Integer.valueOf(occId) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  62 */         RoleMFVRankManagerForMerge mergeRank = new RoleMFVRankManagerForMerge(Integer.MAX_VALUE, 0);
/*     */         
/*  64 */         addMFVData(xMainMFVRank.getRolerankdatas(), mergeRank, occId);
/*     */         
/*  66 */         addMFVData(xViceMFVRank.getRolerankdatas(), mergeRank, occId);
/*     */         
/*  68 */         xMainMFVRank.getRolerankdatas().clear();
/*     */         
/*  70 */         for (RoleMultiFightValueChart rankObj : mergeRank.getAllChartObjs())
/*     */         {
/*  72 */           RoleMultiFightValueBean xMFV = Pod.newRoleMultiFightValueBean();
/*  73 */           xMFV.setRoleid(rankObj.getRoleid());
/*  74 */           xMainMFVRank.getRolerankdatas().add(xMFV);
/*     */         }
/*     */         
/*  77 */         mergeRank.clear();
/*     */       }
/*     */     }
/*  80 */     Occmfvrank.remove(Long.valueOf(viceKey));
/*     */     
/*  82 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addMFVData(List<RoleMultiFightValueBean> xMFVDatas, RoleMFVRankManagerForMerge mergeRank, int occId)
/*     */   {
/*  93 */     if ((xMFVDatas == null) || (xMFVDatas.size() == 0))
/*     */     {
/*  95 */       return;
/*     */     }
/*  97 */     for (RoleMultiFightValueBean xMFV : xMFVDatas)
/*     */     {
/*  99 */       long roleId = xMFV.getRoleid();
/* 100 */       int mfv = RoleInterface.getRoleMFValue(roleId);
/* 101 */       RoleMultiFightValueChart rankObj = new RoleMultiFightValueChart(roleId, mfv, occId);
/* 102 */       mergeRank.rank(rankObj);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MergeRoleOccMFV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */