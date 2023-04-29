/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.arena.SChartRes;
/*    */ import mzm.gsp.arena.Score;
/*    */ import mzm.gsp.arena.confbean.SArenaConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PChartReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int page;
/*    */   
/*    */   public PChartReq(long roleid, int page)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.page = page;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 29 */     List<ArenaChartObj> objList = ArenaManager.chart.getRanObjsFromPage(this.page, SArenaConsts.getInstance().ChartPageSize);
/*    */     
/*    */ 
/* 32 */     SChartRes res = new SChartRes();
/* 33 */     res.page = this.page;
/*    */     
/*    */ 
/* 36 */     for (ArenaChartObj obj : objList) {
/* 37 */       Score scoreBean = new Score();
/* 38 */       scoreBean.roleid = obj.getRoleid();
/* 39 */       Role role = RoleInterface.getRole(obj.getRoleid(), false);
/* 40 */       scoreBean.name = role.getName();
/* 41 */       scoreBean.level = role.getLevel();
/* 42 */       scoreBean.menpai = role.getOccupationId();
/* 43 */       scoreBean.score = obj.getScore();
/* 44 */       res.data_list.add(scoreBean);
/*    */     }
/*    */     
/* 47 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\PChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */