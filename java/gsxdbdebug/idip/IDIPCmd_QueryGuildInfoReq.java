/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryGuildInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryGuildInfoReq
/*    */   extends IDIPCmd<IDIPPacket_QueryGuildInfoReq, IDIPPacket_QueryGuildInfoRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4209;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryGuildInfoReq, IDIPPacket_QueryGuildInfoRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryGuildInfoReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryGuildInfoReq req, IDIPPacket_QueryGuildInfoRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryGuildInfoReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryGuildInfoReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryGuildInfoReq req = IDIPPacket_QueryGuildInfoReq.create();
/* 34 */     IDIPPacket_QueryGuildInfoRsp rsp = IDIPPacket_QueryGuildInfoRsp.create();
/* 35 */     return new IDIPCmd_QueryGuildInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryGuildInfoReq create(IDIPPacket_QueryGuildInfoReq req, IDIPPacket_QueryGuildInfoRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryGuildInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryGuildInfoReq(IDIPPacket_QueryGuildInfoReq req, IDIPPacket_QueryGuildInfoRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4209;
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
/* 62 */     return new PIDIPCmd_QueryGuildInfoReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryGuildInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */