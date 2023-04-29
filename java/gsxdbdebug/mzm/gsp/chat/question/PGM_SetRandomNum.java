/*    */ package mzm.gsp.chat.question;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_SetRandomNum
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int num;
/*    */   
/*    */   public PGM_SetRandomNum(long roleId, int num)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (this.num <= 0)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.roleId, "随机奖励人数必须大于0！");
/* 30 */       return false;
/*    */     }
/* 32 */     WorldQuestion.getInstance().setDebugRandomNum(this.num);
/* 33 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("设置随机奖励人数为：%d", new Object[] { Integer.valueOf(this.num) }));
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\PGM_SetRandomNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */