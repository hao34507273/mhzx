/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*    */ 
/*    */ public class PGM_SimplifyWedding extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int maxCache;
/*    */   private final int maxCouples;
/*    */   private final int robSub;
/*    */   
/*    */   public PGM_SimplifyWedding(long roleid, int maxCache, int maxCouples, int robSub)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.maxCache = maxCache;
/* 17 */     this.maxCouples = maxCouples;
/* 18 */     this.robSub = robSub;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     SMassWeddingConsts.getInstance().minCouple = 1;
/* 24 */     SMassWeddingConsts.getInstance().maxCacheCouples = this.maxCache;
/* 25 */     SMassWeddingConsts.getInstance().maxCouple = this.maxCouples;
/* 26 */     SMassWeddingConsts.getInstance().supportSub = this.robSub;
/* 27 */     GmManager.getInstance().sendResultToGM(this.roleid, String.format("简化集体婚礼成功,报名人数上限为%d,选中的最大报名人数为%d,抢新娘胜利人数差值为%d", new Object[] { Integer.valueOf(this.maxCache), Integer.valueOf(this.maxCouples), Integer.valueOf(this.robSub) }));
/*    */     
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PGM_SimplifyWedding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */