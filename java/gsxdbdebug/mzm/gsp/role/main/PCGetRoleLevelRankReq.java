/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.RoleLevelRankData;
/*    */ import mzm.gsp.role.SGetRoleLevelRankRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGetRoleLevelRankReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int fromNo;
/*    */   private int toNO;
/*    */   
/*    */   public PCGetRoleLevelRankReq(long roleid, int fromNo, int toNo)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.fromNo = fromNo;
/* 22 */     this.toNO = toNo;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (this.fromNo <= 0)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (this.fromNo > this.toNO)
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     List<RoleLevelChart> roleLevelCharts = NoneRealTimeRoleLevelRankManager.getInstance().getRankObjs(this.fromNo - 1, this.toNO - 1);
/* 38 */     Map<Long, Integer> rankChangeMap = NoneRealTimeRoleLevelRankManager.getInstance().getCacheRankChangeMap();
/* 39 */     SGetRoleLevelRankRes sGetRoleLevelRankRes = new SGetRoleLevelRankRes();
/* 40 */     for (int i = 0; i < roleLevelCharts.size(); i++)
/*    */     {
/* 42 */       RoleLevelChart roleLevelChart = (RoleLevelChart)roleLevelCharts.get(i);
/* 43 */       RoleLevelRankData roleLevelRankData = new RoleLevelRankData();
/* 44 */       Role role = RoleInterface.getRole(roleLevelChart.getKey().longValue(), false);
/* 45 */       if (role == null)
/*    */       {
/* 47 */         this.fromNo -= 1;
/*    */       }
/*    */       else {
/* 50 */         roleLevelRankData.level = roleLevelChart.getLevel();
/* 51 */         roleLevelRankData.name = role.getName();
/* 52 */         roleLevelRankData.no = (this.fromNo + i);
/* 53 */         roleLevelRankData.occupationid = role.getOccupationId();
/* 54 */         roleLevelRankData.roleid = roleLevelChart.getKey().longValue();
/* 55 */         Integer change = (Integer)rankChangeMap.get(roleLevelChart.getKey());
/* 56 */         if (change != null)
/*    */         {
/* 58 */           roleLevelRankData.step = change.intValue();
/*    */         }
/* 60 */         sGetRoleLevelRankRes.ranklist.add(roleLevelRankData);
/*    */       } }
/* 62 */     sGetRoleLevelRankRes.myno = (NoneRealTimeRoleLevelRankManager.getInstance().getRank(Long.valueOf(this.roleid)) + 1);
/* 63 */     OnlineManager.getInstance().send(this.roleid, sGetRoleLevelRankRes);
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PCGetRoleLevelRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */