/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import csprovider.DataBetweenCspAndGame;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnDataReqFromCsp extends LogicProcedure
/*    */ {
/*    */   private final DataBetweenCspAndGame dataReq;
/*    */   
/*    */   public POnDataReqFromCsp(DataBetweenCspAndGame dataReq)
/*    */   {
/* 12 */     this.dataReq = dataReq;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     switch (this.dataReq.qtype)
/*    */     {
/*    */ 
/*    */     case 1: 
/* 22 */       new PCspSendBulletin(this.dataReq).execute();
/* 23 */       break;
/*    */     
/*    */ 
/*    */     case 2: 
/*    */       break;
/*    */     
/*    */ 
/*    */     case 3: 
/* 31 */       new PCspSendMailToRole(this.dataReq).execute();
/* 32 */       break;
/*    */     
/*    */ 
/*    */     case 4: 
/* 36 */       new PCspQueryRoleInfoByRoleId(this.dataReq).execute();
/* 37 */       break;
/*    */     
/*    */ 
/*    */     case 5: 
/* 41 */       new PCspForbidRole(this.dataReq).execute();
/* 42 */       break;
/*    */     
/*    */ 
/*    */     case 8: 
/* 46 */       new PCspSendTextCommand(this.dataReq).execute();
/* 47 */       break;
/*    */     
/*    */ 
/*    */     case 9: 
/* 51 */       new PCspQueryRoleInfoByName(this.dataReq).execute();
/* 52 */       break;
/*    */     
/*    */ 
/*    */     case 10: 
/* 56 */       new PCspQueryRoleInfoByUserId(this.dataReq).execute();
/* 57 */       break;
/*    */     
/*    */ 
/*    */     case 11: 
/* 61 */       new PCspForbidUser(this.dataReq).execute();
/* 62 */       break;
/*    */     
/*    */ 
/*    */     case 13: 
/* 66 */       new PCspModifyRoleItemNum(this.dataReq).execute();
/* 67 */       break;
/*    */     
/*    */ 
/*    */     case 14: 
/* 71 */       new PCspSendMailToAll(this.dataReq).execute();
/* 72 */       break;
/*    */     
/*    */ 
/*    */     case 15: 
/*    */       break;
/*    */     
/*    */ 
/*    */     case 16: 
/*    */       break;
/*    */     
/*    */ 
/*    */     case 19: 
/* 84 */       new PCspQueryRoleInfoById(this.dataReq).execute();
/* 85 */       break;
/*    */     }
/*    */     
/*    */     
/*    */ 
/*    */ 
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\POnDataReqFromCsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */