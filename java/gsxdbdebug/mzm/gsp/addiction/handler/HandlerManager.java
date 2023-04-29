/*    */ package mzm.gsp.addiction.handler;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HandlerManager
/*    */ {
/* 14 */   private static final Map<Integer, Handler> handlers = new HashMap();
/*    */   
/*    */   public static void init()
/*    */   {
/* 18 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return;
/*    */     }
/*    */     
/* 23 */     handlers.put(Integer.valueOf(1), new GameConfHandler());
/* 24 */     handlers.put(Integer.valueOf(2), new GetUserInfoHandler());
/* 25 */     handlers.put(Integer.valueOf(3), new UpdateUserInfoHandler());
/* 26 */     handlers.put(Integer.valueOf(6), new EndGameHandler());
/* 27 */     handlers.put(Integer.valueOf(8), new ReportRemindedBatchHandler());
/*    */   }
/*    */   
/*    */   public static void handle(int type, String data)
/*    */   {
/* 32 */     Handler handler = (Handler)handlers.get(Integer.valueOf(type));
/* 33 */     if (handler == null)
/*    */     {
/* 35 */       GameServer.logger().error(String.format("[addiction]HandlerManager.handle@handler is null|type=%d|data=%s", new Object[] { Integer.valueOf(type), data }));
/*    */       
/* 37 */       return;
/*    */     }
/* 39 */     handler.handle(data);
/*    */   }
/*    */   
/*    */   public static void onFailed(int type, int retCode, String queryInfo, Octets context)
/*    */   {
/* 44 */     Handler handler = (Handler)handlers.get(Integer.valueOf(type));
/* 45 */     if (handler == null)
/*    */     {
/* 47 */       GameServer.logger().error(String.format("[addiction]HandlerManager.onFailed@handler is null|retcode=%d|type=%d|query_info=%s", new Object[] { Integer.valueOf(retCode), Integer.valueOf(type), queryInfo }));
/*    */       
/* 49 */       return;
/*    */     }
/* 51 */     handler.onFailed(retCode, queryInfo, context);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\handler\HandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */