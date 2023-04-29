/*    */ package mzm.gsp.chinesevalentine.main;
/*    */ 
/*    */ import mzm.gsp.chinesevalentine.SChineseValentineActivityConfirmDesc;
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ import mzm.gsp.confirm.main.TeamConfirmHandler;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ public class ChineseValentineConfirmHandler
/*    */   implements TeamConfirmHandler
/*    */ {
/*    */   public Protocol getConfirmProtocol(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 14 */     if (!(context instanceof ChineseValentineConfirmContext))
/*    */     {
/* 16 */       return null;
/*    */     }
/* 18 */     ChineseValentineConfirmContext chineseValentineContext = (ChineseValentineConfirmContext)context;
/* 19 */     return new SChineseValentineActivityConfirmDesc(chineseValentineContext.getActivityId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean afterAllAccepted(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 25 */     if (!(context instanceof ChineseValentineConfirmContext))
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     ChineseValentineConfirmContext chineseValentineContext = (ChineseValentineConfirmContext)context;
/* 30 */     ChineseValentineManager.startGame(chineseValentineContext.getRoleIdList(), chineseValentineContext.getActivityId());
/* 31 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\ChineseValentineConfirmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */