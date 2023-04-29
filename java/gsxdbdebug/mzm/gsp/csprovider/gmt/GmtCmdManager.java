/*    */ package mzm.gsp.csprovider.gmt;
/*    */ 
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GmtCmdManager
/*    */ {
/* 15 */   private static final GmtCmdManager instance = new GmtCmdManager();
/* 16 */   public static String ENCODING = "UTF-8";
/*    */   
/* 18 */   private static final Map<Integer, GmtHandler> handlers = new HashMap();
/*    */   
/*    */   public static GmtCmdManager getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */   static
/*    */   {
/* 27 */     handlers.put(Integer.valueOf(8), new IdipGmtHandler());
/*    */   }
/*    */   
/*    */   public void handle(int type, JSONObject jso, DataBetweenCspAndGame_Re rsp)
/*    */   {
/* 32 */     GmtHandler handler = (GmtHandler)handlers.get(Integer.valueOf(type));
/* 33 */     if (handler == null)
/*    */     {
/* 35 */       rsp.retcode = Retcode.COMMON_ERR.value;
/* 36 */       return;
/*    */     }
/*    */     
/*    */     try
/*    */     {
/* 41 */       handler.handle(jso, rsp);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 45 */       GameServer.logger().error(String.format("[gmt]GmtCmdManager.handle@handle failed|type=%d|req_data=%s", new Object[] { Integer.valueOf(type), jso.toString() }), e);
/*    */       
/* 47 */       rsp.retcode = Retcode.COMMON_ERR.value;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\GmtCmdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */