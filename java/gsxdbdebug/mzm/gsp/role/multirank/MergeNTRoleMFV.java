/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.NoneRealRoleMultiFightValueBean;
/*    */ import xbean.NoneRealTimeMultiFightValueRank;
/*    */ import xbean.Pod;
/*    */ import xtable.Nonerealtimemultifightvaluerank;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MergeNTRoleMFV
/*    */   extends LogicProcedure
/*    */ {
/* 19 */   private static final Logger logger = Logger.getLogger(MergeNTRoleMFV.class);
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     long mainKey = MergeMain.getMainZoneid();
/* 25 */     long viceKey = MergeMain.getViceZoneid();
/*    */     
/* 27 */     lock(Nonerealtimemultifightvaluerank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */     
/* 29 */     NoneRealTimeMultiFightValueRank xViceMFV = Nonerealtimemultifightvaluerank.get(Long.valueOf(viceKey));
/* 30 */     if (xViceMFV == null)
/*    */     {
/* 32 */       logger.warn(String.format("[mfv]MergeNTRoleMFV.processImp@ no vice NT mfv xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 34 */       return true;
/*    */     }
/* 36 */     NoneRealTimeMultiFightValueRank xMainMFV = Nonerealtimemultifightvaluerank.get(Long.valueOf(mainKey));
/* 37 */     if (xMainMFV == null)
/*    */     {
/* 39 */       xMainMFV = Pod.newNoneRealTimeMultiFightValueRank();
/* 40 */       Nonerealtimemultifightvaluerank.insert(Long.valueOf(mainKey), xMainMFV);
/*    */     }
/*    */     
/* 43 */     RoleMFVRankManagerForMerge mergeRank = new RoleMFVRankManagerForMerge(Integer.MAX_VALUE, 0);
/*    */     
/* 45 */     addMFVData(xMainMFV.getRankdatas(), mergeRank);
/*    */     
/* 47 */     addMFVData(xViceMFV.getRankdatas(), mergeRank);
/*    */     
/* 49 */     xMainMFV.getRankdatas().clear();
/*    */     
/* 51 */     for (RoleMultiFightValueChart rankObj : mergeRank.getAllChartObjs())
/*    */     {
/* 53 */       NoneRealRoleMultiFightValueBean xMFV = Pod.newNoneRealRoleMultiFightValueBean();
/* 54 */       xMFV.setRoleid(rankObj.getRoleid());
/* 55 */       xMFV.setMultifightvalue(rankObj.getFightValue());
/* 56 */       xMainMFV.getRankdatas().add(xMFV);
/*    */     }
/*    */     
/* 59 */     xMainMFV.getKeytorankchange().putAll(xViceMFV.getKeytorankchange());
/*    */     
/* 61 */     mergeRank.clear();
/*    */     
/* 63 */     Nonerealtimemultifightvaluerank.remove(Long.valueOf(viceKey));
/* 64 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void addMFVData(List<NoneRealRoleMultiFightValueBean> xMFVDatas, RoleMFVRankManagerForMerge mergeRank)
/*    */   {
/* 75 */     if ((xMFVDatas == null) || (xMFVDatas.size() == 0))
/*    */     {
/* 77 */       return;
/*    */     }
/* 79 */     for (NoneRealRoleMultiFightValueBean xMFV : xMFVDatas)
/*    */     {
/* 81 */       long roleId = xMFV.getRoleid();
/* 82 */       int mfv = xMFV.getMultifightvalue();
/* 83 */       RoleMultiFightValueChart rankObj = new RoleMultiFightValueChart(roleId, mfv);
/* 84 */       mergeRank.rank(rankObj);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MergeNTRoleMFV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */