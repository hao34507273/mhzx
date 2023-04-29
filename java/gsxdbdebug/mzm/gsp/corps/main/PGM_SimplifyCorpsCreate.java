/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SimplifyCorpsCreate extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int createGuysNum;
/*    */   
/*    */   public PGM_SimplifyCorpsCreate(long roleId, int createGuysNum)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.createGuysNum = createGuysNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (this.createGuysNum <= 0)
/*    */     {
/* 22 */       GmManager.getInstance().sendResultToGM(this.roleId, "最小人数不能小于0！");
/* 23 */       return false;
/*    */     }
/* 25 */     GMDataManager.getInstance().setCreateMinPeopleNum(this.createGuysNum);
/* 26 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("设置最小创建人数为：%d", new Object[] { Integer.valueOf(this.createGuysNum) }));
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PGM_SimplifyCorpsCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */