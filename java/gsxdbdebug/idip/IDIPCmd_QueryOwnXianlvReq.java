/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryOwnXianlvReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryOwnXianlvReq
/*    */   extends IDIPCmd<IDIPPacket_QueryOwnXianlvReq, IDIPPacket_QueryOwnXianlvRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4207;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryOwnXianlvReq, IDIPPacket_QueryOwnXianlvRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryOwnXianlvReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryOwnXianlvReq req, IDIPPacket_QueryOwnXianlvRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryOwnXianlvReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryOwnXianlvReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryOwnXianlvReq req = IDIPPacket_QueryOwnXianlvReq.create();
/* 34 */     IDIPPacket_QueryOwnXianlvRsp rsp = IDIPPacket_QueryOwnXianlvRsp.create();
/* 35 */     return new IDIPCmd_QueryOwnXianlvReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryOwnXianlvReq create(IDIPPacket_QueryOwnXianlvReq req, IDIPPacket_QueryOwnXianlvRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryOwnXianlvReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryOwnXianlvReq(IDIPPacket_QueryOwnXianlvReq req, IDIPPacket_QueryOwnXianlvRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4207;
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
/* 62 */     return new PIDIPCmd_QueryOwnXianlvReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryOwnXianlvReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */