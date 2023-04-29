/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.homeland.HomeRankData;
/*    */ import mzm.gsp.homeland.SHomeChartRes;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.HomeInfo;
/*    */ import xtable.Role2homeinfo;
/*    */ 
/*    */ public class PHomelandChartReq extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int startpos;
/*    */   private int num;
/*    */   
/*    */   public PHomelandChartReq(long roleid, int startpos, int num)
/*    */   {
/* 25 */     this.roleid = roleid;
/* 26 */     this.startpos = startpos;
/* 27 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     SHomeChartRes res = new SHomeChartRes();
/* 34 */     if (OpenInterface.getOpenStatus(161))
/*    */     {
/* 36 */       HomeInfo xHomeInfo = Role2homeinfo.select(Long.valueOf(this.roleid));
/* 37 */       res.point = HomelandManager.getHomelandPoint(xHomeInfo);
/* 38 */       res.myrank = (HomelandRankManager.getInstance().getRank(Long.valueOf(this.roleid)) + 1);
/* 39 */       res.ranklist.addAll(getRankDatasFromstartpos(this.startpos, this.num));
/*    */     }
/*    */     
/*    */ 
/* 43 */     OnlineManager.getInstance().send(this.roleid, res);
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   private List<HomeRankData> getRankDatasFromstartpos(int startpos, int num) throws java.io.UnsupportedEncodingException
/*    */   {
/* 49 */     List<RoleHomelandChart> list = HomelandRankManager.getInstance().getRankObjs(startpos - 1, startpos + num - 2);
/*    */     
/* 51 */     List<HomeRankData> ranklist = new ArrayList();
/* 52 */     int i = startpos;
/* 53 */     for (RoleHomelandChart roleHomelandChart : list)
/*    */     {
/*    */ 
/* 56 */       Role role = RoleInterface.getRole(roleHomelandChart.getKey().longValue(), false);
/* 57 */       HomeRankData rankdata = new HomeRankData();
/* 58 */       rankdata.point = roleHomelandChart.getPoint();
/* 59 */       rankdata.roleid = roleHomelandChart.getKey().longValue();
/* 60 */       rankdata.name.setString(role.getName(), "UTF-8");
/* 61 */       long marriagedRoleId = MarriageInterface.getMarriedRoleid(roleHomelandChart.getKey().longValue());
/* 62 */       if (marriagedRoleId != -1L)
/*    */       {
/* 64 */         String partnerName = RoleInterface.getName(marriagedRoleId);
/* 65 */         if (partnerName != null)
/*    */         {
/* 67 */           rankdata.partnername.setString(partnerName, "UTF-8");
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 72 */       rankdata.rank = i;
/* 73 */       ranklist.add(rankdata);
/* 74 */       i++;
/*    */     }
/* 76 */     return ranklist;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PHomelandChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */