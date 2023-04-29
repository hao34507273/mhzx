/*    */ package mzm.gsp.changemodelcard.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GetClassLevel
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetClassLevel(long roleId)
/*    */   {
/* 13 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     ChangeModelCardInterface.ClassLevelEntry result = ChangeModelCardInterface.getRoleClassTypeAndLevel(this.roleId, true);
/*    */     
/* 21 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("系别为：%d，等级为：%d", new Object[] { Integer.valueOf(result.classType), Integer.valueOf(result.level) }));
/*    */     
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PGM_GetClassLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */