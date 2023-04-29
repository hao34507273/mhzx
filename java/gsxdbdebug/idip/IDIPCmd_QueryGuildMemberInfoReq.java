/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryGuildMemberInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryGuildMemberInfoReq
/*    */   extends IDIPCmd<IDIPPacket_QueryGuildMemberInfoReq, IDIPPacket_QueryGuildMemberInfoRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4211;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryGuildMemberInfoReq, IDIPPacket_QueryGuildMemberInfoRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryGuildMemberInfoReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryGuildMemberInfoReq req, IDIPPacket_QueryGuildMemberInfoRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryGuildMemberInfoReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryGuildMemberInfoReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryGuildMemberInfoReq req = IDIPPacket_QueryGuildMemberInfoReq.create();
/* 34 */     IDIPPacket_QueryGuildMemberInfoRsp rsp = IDIPPacket_QueryGuildMemberInfoRsp.create();
/* 35 */     return new IDIPCmd_QueryGuildMemberInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryGuildMemberInfoReq create(IDIPPacket_QueryGuildMemberInfoReq req, IDIPPacket_QueryGuildMemberInfoRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryGuildMemberInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryGuildMemberInfoReq(IDIPPacket_QueryGuildMemberInfoReq req, IDIPPacket_QueryGuildMemberInfoRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4211;
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
/* 62 */     return new PIDIPCmd_QueryGuildMemberInfoReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryGuildMemberInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */