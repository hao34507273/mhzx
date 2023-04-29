/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shitu.MasterRankData;
/*    */ import mzm.gsp.shitu.SMasterChartRes;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCMasterChartReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int fromOrder;
/*    */   private final int toOrder;
/*    */   private final long roleId;
/*    */   
/*    */   public PCMasterChartReq(int fromOrder, int toOrder, long roleId)
/*    */   {
/* 23 */     this.fromOrder = fromOrder;
/* 24 */     this.toOrder = toOrder;
/* 25 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if ((this.fromOrder <= 0) || (this.toOrder <= 0) || (this.toOrder < this.fromOrder))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 37 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1719, true))
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (!ShiTuManager.isShiTuSwitchOpen(this.roleId, "PCMasterChartReq.processImp"))
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     SMasterChartRes sMasterChatRes = new SMasterChartRes();
/* 48 */     sMasterChatRes.apprenticesize = ShiTuManager.selectApprenticeSize(this.roleId);
/* 49 */     sMasterChatRes.myrank = (MasterRankManager.getInstance().getRank(Long.valueOf(this.roleId)) + 1);
/*    */     
/* 51 */     sMasterChatRes.ranklist.addAll(getRankData(this.fromOrder - 1, this.toOrder - 1));
/*    */     
/* 53 */     OnlineManager.getInstance().send(this.roleId, sMasterChatRes);
/*    */     
/* 55 */     GameServer.logger().info(String.format("[shitu]PCMasterChartReq.processImp@handle master chart req success|role_id=%d|start_pos=%d|end_pos=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fromOrder), Integer.valueOf(this.toOrder) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 60 */     return true;
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
/*    */ 
/*    */ 
/*    */   private List<MasterRankData> getRankData(int fromOrder, int toOrder)
/*    */   {
/* 75 */     List<MasterRankData> masterRankDataList = new ArrayList();
/* 76 */     if ((fromOrder < 0) || (toOrder < 0) || (toOrder < fromOrder))
/*    */     {
/* 78 */       GameServer.logger().error(String.format("[shitu]PCMasterChartReq.getRankData@from order or to order error|role_id=%d|from_order=%d|to_order=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(fromOrder), Integer.valueOf(toOrder) }));
/*    */       
/*    */ 
/*    */ 
/* 82 */       return masterRankDataList;
/*    */     }
/* 84 */     List<RoleMasterChart> roleMasterChartList = MasterRankManager.getInstance().getRankObjs(fromOrder, toOrder);
/* 85 */     int startRank = fromOrder;
/* 86 */     for (RoleMasterChart roleMasterChart : roleMasterChartList)
/*    */     {
/* 88 */       long roleId = roleMasterChart.getRoleid();
/* 89 */       MasterRankData masterRankData = new MasterRankData();
/* 90 */       masterRankData.roleid = roleId;
/* 91 */       masterRankData.apprenticesize = roleMasterChart.getApprenticeSize();
/* 92 */       masterRankData.name = RoleInterface.getName(roleId);
/* 93 */       masterRankData.rank = (++startRank);
/* 94 */       masterRankData.occupationid = RoleInterface.getOccupationId(roleId);
/*    */       
/* 96 */       masterRankDataList.add(masterRankData);
/*    */     }
/* 98 */     return masterRankDataList;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCMasterChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */