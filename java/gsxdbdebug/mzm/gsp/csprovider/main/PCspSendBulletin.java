/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import csprovider.DataBetweenCspAndGame;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ public class PCspSendBulletin
/*    */   extends CspReqBaseProcedure
/*    */ {
/*    */   public PCspSendBulletin(DataBetweenCspAndGame dataReq)
/*    */   {
/* 13 */     super(dataReq);
/*    */   }
/*    */   
/*    */ 
/*    */   protected int doProcess(JSONObject jso, DataBetweenCspAndGame_Re rep)
/*    */     throws Exception
/*    */   {
/* 20 */     return DealMessageFromCsp.sendBulletin(jso);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\PCspSendBulletin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */