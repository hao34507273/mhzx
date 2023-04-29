/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.chart.STopModelListRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ import mzm.gsp.role.main.RoleCfgArgs;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class PGetRoleModelListReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private List<Long> topThreeList;
/*    */   private int chartType;
/*    */   
/*    */   public PGetRoleModelListReq(long roleId, int chartType, List<Long> topThreeList)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.chartType = chartType;
/* 27 */     this.topThreeList = topThreeList;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!checkClientParameter())
/*    */     {
/* 35 */       GameServer.logger().error(String.format("[role]PGetRoleModelListReq.processImp@ checkClientParameter failed!|roleId=%d|topThreeList=%s|chartType=%d", new Object[] { Long.valueOf(this.roleId), this.topThreeList, Integer.valueOf(this.chartType) }));
/*    */       
/*    */ 
/*    */ 
/* 39 */       return false;
/*    */     }
/* 41 */     STopModelListRes res = new STopModelListRes();
/* 42 */     for (Iterator i$ = this.topThreeList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 44 */       ModelInfo modelInfo = new ModelInfo();
/* 45 */       RoleInterface.fillModelInfo(roleId, modelInfo);
/* 46 */       res.datalist.add(modelInfo);
/*    */     }
/* 48 */     res.charttype = this.chartType;
/* 49 */     OnlineManager.getInstance().send(this.roleId, res);
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean checkClientParameter()
/*    */   {
/* 63 */     if ((this.topThreeList == null) || (this.topThreeList.size() == 0) || (this.topThreeList.size() > RoleCfgArgs.getInstance().getChartTopNMax()))
/*    */     {
/*    */ 
/* 66 */       return false;
/*    */     }
/*    */     
/* 69 */     for (Iterator i$ = this.topThreeList.iterator(); i$.hasNext();) { long topRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 71 */       if (!RoleInterface.isRoleExist(topRoleId, false))
/*    */       {
/* 73 */         return false;
/*    */       }
/*    */     }
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\PGetRoleModelListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */