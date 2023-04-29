/*    */ package mzm.gsp.chivalry.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ChivalryDayInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PChivalryDayInitPro
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PChivalryDayInitPro(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     ChivalryDayInfo cDayInfo = ChivalryManager.getRoleChivalryDayInfo(this.roleId, true);
/* 26 */     if (cDayInfo == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     if (!ChivalryManager.chivalryDayDataInit(cDayInfo))
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\PChivalryDayInitPro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */