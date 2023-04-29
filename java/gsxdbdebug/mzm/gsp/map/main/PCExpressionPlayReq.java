/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_ExpressionPlay;
/*    */ 
/*    */ public class PCExpressionPlayReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int actionEnum;
/*    */   
/*    */   public PCExpressionPlayReq(long roleid, int actionEnum)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.actionEnum = actionEnum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (!MapManager.canDoAction(this.roleid, 170))
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     new MMH_ExpressionPlay(this.roleid, this.actionEnum).execute();
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PCExpressionPlayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */