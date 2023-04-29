/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import mzm.gsp.arena.SSelfRankRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ArenaScore;
/*    */ import xtable.Arenascore;
/*    */ 
/*    */ 
/*    */ public class PSelfRankReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PSelfRankReq(long roleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     int rank = ArenaManager.chart.getRank(Long.valueOf(this.roleid));
/*    */     
/* 24 */     SSelfRankRes res = new SSelfRankRes();
/* 25 */     res.rank = rank;
/*    */     
/* 27 */     ArenaScore xScore = Arenascore.select(Long.valueOf(this.roleid));
/* 28 */     if (xScore != null) {
/* 29 */       res.score = xScore.getScore();
/*    */     }
/*    */     
/* 32 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\PSelfRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */