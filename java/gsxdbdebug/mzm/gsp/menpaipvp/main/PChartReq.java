/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.menpaipvp.SChartRes;
/*    */ import mzm.gsp.menpaipvp.Score;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PChartReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int menpai;
/*    */   private final int page;
/*    */   
/*    */   public PChartReq(long roleid, int menpai, int page)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.menpai = menpai;
/* 24 */     this.page = page;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 29 */     MenpaiPVPChart chart = MenpaiPVPManager.getChart(this.menpai);
/* 30 */     if (chart == null) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     List<MenpaiPVPChartObj> objList = chart.getRanObjsFromPage(this.page, MenpaiPVPConfigManager.getInstance().getChartPageSize());
/*    */     
/*    */ 
/* 37 */     SChartRes res = new SChartRes();
/* 38 */     res.menpai = this.menpai;
/* 39 */     res.page = this.page;
/*    */     
/* 41 */     for (MenpaiPVPChartObj obj : objList) {
/* 42 */       Score scoreBean = new Score();
/* 43 */       scoreBean.roleid = obj.getRoleid();
/* 44 */       scoreBean.name = RoleInterface.getName(obj.getRoleid());
/* 45 */       scoreBean.score = obj.getScore();
/* 46 */       scoreBean.win_times = obj.getWinTimes();
/* 47 */       res.data_list.add(scoreBean);
/*    */     }
/*    */     
/* 50 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\PChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */