/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.chart.STopModelListRes;
/*    */ import mzm.gsp.children.main.ChildrenInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ import mzm.gsp.role.main.RoleCfgArgs;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCGetChildrenModelList extends LogicProcedure
/*    */ {
/*    */   private final List<Long> idList;
/*    */   private final int chartType;
/*    */   private final long roleId;
/*    */   
/*    */   public PCGetChildrenModelList(List<Long> idList, int chartType, long roleId)
/*    */   {
/* 25 */     this.idList = idList;
/* 26 */     this.chartType = chartType;
/* 27 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */   {
/* 33 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1392, true))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (!isFunOpen(this.roleId))
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     if (this.idList.size() > RoleCfgArgs.getInstance().getChartTopNMax())
/*    */     {
/* 45 */       GameServer.logger().info(String.format("[chart]PCGetChildrenModelList.processImp@id list too large|role_id=%d|chartType=%d|idList=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.chartType), this.idList }));
/*    */       
/*    */ 
/*    */ 
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     STopModelListRes res = new STopModelListRes();
/* 54 */     for (Iterator i$ = this.idList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*    */       
/* 56 */       ModelInfo modelInfo = new ModelInfo();
/* 57 */       ChildrenInterface.fillChildModelInfo(modelInfo, childId, false);
/* 58 */       res.datalist.add(modelInfo);
/*    */     }
/* 60 */     res.charttype = this.chartType;
/*    */     
/*    */ 
/* 63 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 65 */     GameServer.logger().info(String.format("[chart]PCGetChildrenModelList.processImp@handle get children chart model req success|role_id=%d|chartType=%d|idList=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.chartType), this.idList }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 70 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean isFunOpen(long roleid)
/*    */   {
/* 81 */     if (!OpenInterface.getOpenStatus(354))
/*    */     {
/* 83 */       return false;
/*    */     }
/* 85 */     if (OpenInterface.isBanPlay(roleid, 354))
/*    */     {
/* 87 */       OpenInterface.sendBanPlayMsg(roleid, 354);
/* 88 */       return false;
/*    */     }
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\PCGetChildrenModelList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */