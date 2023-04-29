/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceArg;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.ssp.SSPContext;
/*    */ import mzm.gsp.csprovider.ssp.SSPInterface;
/*    */ 
/*    */ public class RRepeatSendSspRpc extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private final DataBetweenGameAndSocialSpaceArg arg;
/*    */   private final SSPContext sspContext;
/*    */   
/*    */   public RRepeatSendSspRpc(DataBetweenGameAndSocialSpaceArg arg)
/*    */   {
/* 16 */     this.arg = arg;
/* 17 */     this.sspContext = null;
/*    */   }
/*    */   
/*    */   public RRepeatSendSspRpc(DataBetweenGameAndSocialSpaceArg arg, SSPContext sspContext)
/*    */   {
/* 22 */     this.arg = arg;
/* 23 */     this.sspContext = sspContext;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 29 */     boolean isSendSuccess = SSPInterface.sendDataBetweenGameAndSocialSpaceRpc(this.arg, this.sspContext);
/* 30 */     if (!isSendSuccess)
/*    */     {
/* 32 */       StringBuilder sBuilder = new StringBuilder();
/* 33 */       sBuilder.append("[friendscircle]RRepeatSendSspRpc@send ssp info fail");
/* 34 */       sBuilder.append("|q_type=").append(this.arg.qtype);
/* 35 */       sBuilder.append("|arg=").append(this.arg.data.getString("UTF-8"));
/*    */       
/* 37 */       GameServer.logger().error(sBuilder.toString());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\RRepeatSendSspRpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */