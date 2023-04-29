/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_ChannelSignLimitFunReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_ChannelSignLimitFunReq
/*    */   extends IDIPCmd<IDIPPacket_ChannelSignLimitFunReq, IDIPPacket_ChannelSignLimitFunRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4171;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_ChannelSignLimitFunReq, IDIPPacket_ChannelSignLimitFunRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_ChannelSignLimitFunReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_ChannelSignLimitFunReq req, IDIPPacket_ChannelSignLimitFunRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_ChannelSignLimitFunReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_ChannelSignLimitFunReq create()
/*    */   {
/* 33 */     IDIPPacket_ChannelSignLimitFunReq req = IDIPPacket_ChannelSignLimitFunReq.create();
/* 34 */     IDIPPacket_ChannelSignLimitFunRsp rsp = IDIPPacket_ChannelSignLimitFunRsp.create();
/* 35 */     return new IDIPCmd_ChannelSignLimitFunReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_ChannelSignLimitFunReq create(IDIPPacket_ChannelSignLimitFunReq req, IDIPPacket_ChannelSignLimitFunRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_ChannelSignLimitFunReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_ChannelSignLimitFunReq(IDIPPacket_ChannelSignLimitFunReq req, IDIPPacket_ChannelSignLimitFunRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4171;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 62 */     return new PIDIPCmd_ChannelSignLimitFunReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_ChannelSignLimitFunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */