/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.jiuxiao.JiuXiaoRankRoleData;
/*    */ import mzm.gsp.jiuxiao.SJiuXiaoRankRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class PCJiuXiaoRankReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int rankType;
/*    */   private int fromNO;
/*    */   private int toNO;
/*    */   private long roleid;
/*    */   
/*    */   public PCJiuXiaoRankReq(int rankType, int fromNo, int toNo, long roleid)
/*    */   {
/* 20 */     this.rankType = rankType;
/* 21 */     this.fromNO = fromNo;
/* 22 */     this.toNO = toNo;
/* 23 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 28 */     if (JiuXiaoManager.checkInCross(this.roleid)) {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     if (this.fromNO <= 0) {
/* 33 */       return false;
/*    */     }
/* 35 */     if (this.fromNO > this.toNO) {
/* 36 */       return false;
/*    */     }
/* 38 */     JiuXiaoChart jiuXiaoChart = JiuXiaoRankManager.getInstance().getJiuXiaoChart(this.rankType);
/* 39 */     if (jiuXiaoChart == null) {
/* 40 */       GameServer.logger().error(String.format("[JiuXiao]PCJiuXiaoRankReq.processImp@jiuxiao rank not exist|rankType=%d", new Object[] { Integer.valueOf(this.rankType) }));
/*    */       
/* 42 */       return false;
/*    */     }
/* 44 */     List<JiuXiaoRankObj> jiuXiaoRankRoles = jiuXiaoChart.getRankObjs(this.fromNO - 1, this.toNO - 1);
/*    */     
/* 46 */     SJiuXiaoRankRes sjiuxiaoRankRes = new SJiuXiaoRankRes();
/* 47 */     sjiuxiaoRankRes.ranktype = this.rankType;
/*    */     
/* 49 */     for (int i = 0; i < jiuXiaoRankRoles.size(); i++) {
/* 50 */       JiuXiaoRankObj jiuXiaoRankRole = (JiuXiaoRankObj)jiuXiaoRankRoles.get(i);
/* 51 */       JiuXiaoRankRoleData jiuXiaoRankRoleData = new JiuXiaoRankRoleData();
/*    */       
/* 53 */       jiuXiaoRankRoleData.rank = (this.fromNO + i);
/* 54 */       long roleid = jiuXiaoRankRole.getKey().longValue();
/* 55 */       boolean exist = RoleInterface.isRoleExit(roleid);
/* 56 */       if (!exist) {
/* 57 */         this.fromNO -= 1;
/*    */       }
/*    */       else {
/* 60 */         jiuXiaoRankRoleData.layer = jiuXiaoRankRole.getLayer();
/* 61 */         jiuXiaoRankRoleData.roleid = roleid;
/* 62 */         jiuXiaoRankRoleData.occupation = RoleInterface.getOccupationId(roleid);
/* 63 */         jiuXiaoRankRoleData.rolename = RoleInterface.getName(roleid);
/* 64 */         jiuXiaoRankRoleData.time = jiuXiaoRankRole.getSec();
/*    */         
/* 66 */         sjiuxiaoRankRes.rankdatas.add(jiuXiaoRankRoleData);
/*    */       }
/*    */     }
/* 69 */     OnlineManager.getInstance().send(this.roleid, sjiuxiaoRankRes);
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\PCJiuXiaoRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */