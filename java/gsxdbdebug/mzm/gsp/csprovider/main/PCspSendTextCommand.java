/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import csprovider.DataBetweenCspAndGame;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCspSendTextCommand
/*    */   extends CspReqBaseProcedure
/*    */ {
/*    */   public PCspSendTextCommand(DataBetweenCspAndGame dataReq)
/*    */   {
/* 15 */     super(dataReq);
/*    */   }
/*    */   
/*    */ 
/*    */   protected int doProcess(JSONObject jso, DataBetweenCspAndGame_Re rep)
/*    */     throws Exception
/*    */   {
/* 22 */     GmtCmdManager.getInstance().handle(8, jso, rep);
/* 23 */     return rep.retcode;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\PCspSendTextCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */