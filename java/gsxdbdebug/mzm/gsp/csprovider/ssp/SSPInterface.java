/*    */ package mzm.gsp.csprovider.ssp;
/*    */ 
/*    */ import csprovider.DataBetweenGameAndSocialSpace;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceArg;
/*    */ 
/*    */ public class SSPInterface
/*    */ {
/*    */   public static final void addSSPHandler(int qtype, SSPHandler handler)
/*    */   {
/* 10 */     SSPManager.sspHandlerMgr.addHandler(Integer.valueOf(qtype), handler);
/*    */   }
/*    */   
/*    */ 
/*    */   public static final boolean sendDataBetweenGameAndSocialSpaceRpc(DataBetweenGameAndSocialSpaceArg arg, SSPContext context)
/*    */   {
/* 16 */     DataBetweenGameAndSocialSpace rpc = new DataBetweenGameAndSocialSpace(arg);
/* 17 */     return sendDataBetweenGameAndSocialSpaceRpc(rpc, context);
/*    */   }
/*    */   
/*    */ 
/*    */   public static final boolean sendDataBetweenGameAndSocialSpaceRpc(DataBetweenGameAndSocialSpace rpc, SSPContext context)
/*    */   {
/* 23 */     DataBetweenGameAndSocialSpaceArg arg = (DataBetweenGameAndSocialSpaceArg)rpc.getArgument();
/* 24 */     arg.gameid = mzm.gsp.GameServerInfoManager.getGameid();
/* 25 */     arg.serverid = mzm.gsp.GameServerInfoManager.getZoneId();
/* 26 */     rpc.setSSPContext(context);
/* 27 */     return gnet.GDeliveryManager.getInstance().send(rpc);
/*    */   }
/*    */   
/*    */ 
/*    */   public static final void onServer(DataBetweenGameAndSocialSpaceArg arg, csprovider.DataBetweenGameAndSocialSpaceRes res)
/*    */   {
/* 33 */     SSPManager.onServer(arg, res);
/*    */   }
/*    */   
/*    */ 
/*    */   public static final void onClient(DataBetweenGameAndSocialSpaceArg arg, csprovider.DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 39 */     SSPManager.onClient(arg, res, context);
/*    */   }
/*    */   
/*    */ 
/*    */   public static final void onTimeout(DataBetweenGameAndSocialSpaceArg arg, csprovider.DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 45 */     SSPManager.onTimeout(arg, res, context);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\ssp\SSPInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */