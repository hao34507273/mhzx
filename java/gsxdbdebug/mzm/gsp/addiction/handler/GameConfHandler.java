/*    */ package mzm.gsp.addiction.handler;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import jsonio.JsonStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.addiction.main.AddictionCfgInfo;
/*    */ import mzm.gsp.addiction.main.AddictionManager;
/*    */ import mzm.gsp.addiction.pro.GameConfInfoRsp;
/*    */ import mzm.gsp.addiction.pro.core.CommRsp;
/*    */ import mzm.gsp.grc.main.GrcInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class GameConfHandler
/*    */   implements Handler
/*    */ {
/*    */   public void handle(String data)
/*    */   {
/* 20 */     CommRsp commRsp = new CommRsp();
/* 21 */     JsonStream js = new JsonStream(data);
/* 22 */     js.unmarshal("comm_rsp", commRsp);
/*    */     
/* 24 */     if (commRsp.ret != 0)
/*    */     {
/* 26 */       GameServer.logger().error(String.format("[addiction]GameConfHandler.handle@game conf handler error|ret=%d|error_msg=%s", new Object[] { Integer.valueOf(commRsp.ret), commRsp.err_msg }));
/*    */       
/*    */ 
/* 29 */       return;
/*    */     }
/*    */     
/* 32 */     GameConfInfoRsp gameConfInfoRsp = new GameConfInfoRsp();
/* 33 */     js.unmarshal("game_conf_info", gameConfInfoRsp);
/* 34 */     AddictionCfgInfo config = new AddictionCfgInfo(gameConfInfoRsp);
/* 35 */     AddictionManager.setConfig(config);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onFailed(int retCode, String queryInfo, Octets context)
/*    */   {
/* 41 */     OctetsStream stream = new OctetsStream(context);
/* 42 */     int count = 0;
/*    */     try
/*    */     {
/* 45 */       count = stream.unmarshal_int();
/*    */     }
/*    */     catch (MarshalException e) {}
/*    */     
/*    */ 
/*    */ 
/* 51 */     if (count == 0)
/*    */     {
/* 53 */       stream.clear();
/* 54 */       stream.marshal(1);
/* 55 */       GrcInterface.antiAddictProxy(queryInfo, stream);
/*    */     }
/*    */     
/* 58 */     if (count > 0)
/*    */     {
/* 60 */       AddictionManager.setConfig(new AddictionCfgInfo());
/*    */     }
/*    */     
/* 63 */     GameServer.logger().error(String.format("[addiction]GameConfHandler.onFailed@handle failed|count=%d|retcode=%d|query_info=%s", new Object[] { Integer.valueOf(count), Integer.valueOf(retCode), queryInfo }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\handler\GameConfHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */