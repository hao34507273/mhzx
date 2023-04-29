/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.paraselene.ParaseleneRankData;
/*    */ import mzm.gsp.paraselene.SParaseleneChartRes;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PParaseleneRankReq extends LogicProcedure
/*    */ {
/*    */   private int startpos;
/*    */   private int num;
/*    */   private long roleid;
/*    */   
/*    */   public PParaseleneRankReq(long roleid, int startpos, int num)
/*    */   {
/* 20 */     this.startpos = startpos;
/* 21 */     this.num = num;
/* 22 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (this.startpos <= 0)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (this.num <= 0)
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     List<ParaseleneRankObj> rankRoles = ParaseleneRankManager.getInstance().getRankObjs(this.startpos - 1, this.startpos + this.num - 2);
/*    */     
/* 38 */     SParaseleneChartRes res = new SParaseleneChartRes();
/* 39 */     res.seconds = ParaseleneManager.getRoleFinishtime(this.roleid);
/* 40 */     res.myrank = (ParaseleneRankManager.getInstance().getRank(Long.valueOf(this.roleid)) + 1);
/* 41 */     int i = this.startpos;
/* 42 */     for (ParaseleneRankObj obj : rankRoles)
/*    */     {
/* 44 */       Role role = RoleInterface.getRole(obj.getKey().longValue(), false);
/* 45 */       ParaseleneRankData rankdata = new ParaseleneRankData();
/* 46 */       rankdata.seconds = obj.getSeconds();
/* 47 */       rankdata.roleid = obj.getKey().longValue();
/* 48 */       rankdata.name = role.getName();
/* 49 */       rankdata.occupationid = role.getOccupationId();
/* 50 */       rankdata.rank = i;
/* 51 */       res.ranklist.add(rankdata);
/* 52 */       i++;
/*    */     }
/*    */     
/* 55 */     OnlineManager.getInstance().send(this.roleid, res);
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\PParaseleneRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */