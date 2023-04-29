/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import mzm.gsp.menpaipvp.SSelfRankRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSelfRankReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PSelfRankReq(long roleid)
/*    */   {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     int menpai = RoleInterface.getOccupationId(this.roleid);
/* 24 */     MenpaiPVPChart chart = MenpaiPVPManager.getChart(menpai);
/* 25 */     int rank = chart.getRank(Long.valueOf(this.roleid));
/*    */     
/* 27 */     SSelfRankRes res = new SSelfRankRes(rank);
/* 28 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\PSelfRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */