/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MultiFightValueRank;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleMultiFightValueBean;
/*    */ import xtable.Multifightvaluerank;
/*    */ 
/*    */ public class MergeRoleMFV extends mzm.gsp.util.LogicProcedure
/*    */ {
/* 15 */   private static final Logger logger = Logger.getLogger(MergeRoleMFV.class);
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     long mainKey = MergeMain.getMainZoneid();
/* 21 */     long viceKey = MergeMain.getViceZoneid();
/*    */     
/* 23 */     lock(Multifightvaluerank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */     
/* 25 */     MultiFightValueRank xViceMFV = Multifightvaluerank.get(Long.valueOf(viceKey));
/* 26 */     if (xViceMFV == null)
/*    */     {
/* 28 */       logger.warn(String.format("[mfv]MergeRoleMFV.processImp@ no vice mfv xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 30 */       return true;
/*    */     }
/* 32 */     MultiFightValueRank xMainMFV = Multifightvaluerank.get(Long.valueOf(mainKey));
/* 33 */     if (xMainMFV == null)
/*    */     {
/* 35 */       xMainMFV = Pod.newMultiFightValueRank();
/* 36 */       Multifightvaluerank.insert(Long.valueOf(mainKey), xMainMFV);
/*    */     }
/*    */     
/* 39 */     RoleMFVRankManagerForMerge mergeRank = new RoleMFVRankManagerForMerge(Integer.MAX_VALUE, 0);
/*    */     
/* 41 */     addMFVData(xMainMFV.getRolerankdatas(), mergeRank);
/*    */     
/* 43 */     addMFVData(xViceMFV.getRolerankdatas(), mergeRank);
/*    */     
/* 45 */     xMainMFV.getRolerankdatas().clear();
/*    */     
/* 47 */     for (RoleMultiFightValueChart rankObj : mergeRank.getAllChartObjs())
/*    */     {
/* 49 */       RoleMultiFightValueBean xMFV = Pod.newRoleMultiFightValueBean();
/* 50 */       xMFV.setRoleid(rankObj.getRoleid());
/* 51 */       xMainMFV.getRolerankdatas().add(xMFV);
/*    */     }
/*    */     
/* 54 */     mergeRank.clear();
/*    */     
/* 56 */     Multifightvaluerank.remove(Long.valueOf(viceKey));
/* 57 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void addMFVData(List<RoleMultiFightValueBean> xMFVDatas, RoleMFVRankManagerForMerge mergeRank)
/*    */   {
/* 68 */     if ((xMFVDatas == null) || (xMFVDatas.size() == 0))
/*    */     {
/* 70 */       return;
/*    */     }
/* 72 */     for (RoleMultiFightValueBean xMFV : xMFVDatas)
/*    */     {
/* 74 */       long roleId = xMFV.getRoleid();
/* 75 */       int mfv = RoleInterface.getRoleMFValue(roleId);
/* 76 */       RoleMultiFightValueChart rankObj = new RoleMultiFightValueChart(roleId, mfv);
/* 77 */       mergeRank.rank(rankObj);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MergeRoleMFV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */