/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.RoleFightValueRankData;
/*    */ import mzm.gsp.role.SGetRoleFightValueRankRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGetRoleFightValueRankReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int fromNo;
/*    */   private int toNO;
/*    */   
/*    */   public PCGetRoleFightValueRankReq(long roleid, int fromNo, int toNo)
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
/* 37 */     List<RoleFightValueChart> roleFightValueCharts = NoneRealFightValueRankManager.getInstance().getRankObjs(this.fromNo - 1, this.toNO - 1);
/*    */     
/* 39 */     SGetRoleFightValueRankRes getRoleFightValueRankRes = new SGetRoleFightValueRankRes();
/* 40 */     Map<Long, Integer> rankChangeMap = NoneRealFightValueRankManager.getInstance().getCacheRankChangeMap();
/* 41 */     for (int i = 0; i < roleFightValueCharts.size(); i++)
/*    */     {
/* 43 */       RoleFightValueChart roleFightValueChart = (RoleFightValueChart)roleFightValueCharts.get(i);
/* 44 */       Role role = RoleInterface.getRole(roleFightValueChart.getKey().longValue(), false);
/* 45 */       if (role == null)
/*    */       {
/* 47 */         this.fromNo -= 1;
/*    */       }
/*    */       else {
/* 50 */         RoleFightValueRankData roleFightValueRankData = new RoleFightValueRankData();
/* 51 */         roleFightValueRankData.fightvalue = roleFightValueChart.getFightValue();
/* 52 */         roleFightValueRankData.name = role.getName();
/* 53 */         roleFightValueRankData.no = (this.fromNo + i);
/* 54 */         roleFightValueRankData.occupationid = role.getOccupationId();
/* 55 */         roleFightValueRankData.roleid = roleFightValueChart.getKey().longValue();
/* 56 */         Integer change = (Integer)rankChangeMap.get(roleFightValueChart.getKey());
/* 57 */         if (change != null)
/*    */         {
/* 59 */           roleFightValueRankData.step = change.intValue();
/*    */         }
/* 61 */         getRoleFightValueRankRes.ranklist.add(roleFightValueRankData);
/*    */       } }
/* 63 */     getRoleFightValueRankRes.myno = (NoneRealFightValueRankManager.getInstance().getRank(Long.valueOf(this.roleid)) + 1);
/* 64 */     OnlineManager.getInstance().send(this.roleid, getRoleFightValueRankRes);
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PCGetRoleFightValueRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */