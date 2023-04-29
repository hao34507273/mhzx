/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryPetInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryPetInfoReq
/*    */   extends IDIPCmd<IDIPPacket_QueryPetInfoReq, IDIPPacket_QueryPetInfoRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4131;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryPetInfoReq, IDIPPacket_QueryPetInfoRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryPetInfoReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryPetInfoReq req, IDIPPacket_QueryPetInfoRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryPetInfoReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryPetInfoReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryPetInfoReq req = IDIPPacket_QueryPetInfoReq.create();
/* 34 */     IDIPPacket_QueryPetInfoRsp rsp = IDIPPacket_QueryPetInfoRsp.create();
/* 35 */     return new IDIPCmd_QueryPetInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryPetInfoReq create(IDIPPacket_QueryPetInfoReq req, IDIPPacket_QueryPetInfoRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryPetInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryPetInfoReq(IDIPPacket_QueryPetInfoReq req, IDIPPacket_QueryPetInfoRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4131;
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
/* 62 */     return new PIDIPCmd_QueryPetInfoReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryPetInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */