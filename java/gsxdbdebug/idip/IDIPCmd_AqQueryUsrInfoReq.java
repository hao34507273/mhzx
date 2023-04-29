/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqQueryUsrInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqQueryUsrInfoReq
/*    */   extends IDIPCmd<IDIPPacket_AqQueryUsrInfoReq, IDIPPacket_AqQueryUsrInfoRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4135;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqQueryUsrInfoReq, IDIPPacket_AqQueryUsrInfoRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqQueryUsrInfoReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqQueryUsrInfoReq req, IDIPPacket_AqQueryUsrInfoRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqQueryUsrInfoReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqQueryUsrInfoReq create()
/*    */   {
/* 33 */     IDIPPacket_AqQueryUsrInfoReq req = IDIPPacket_AqQueryUsrInfoReq.create();
/* 34 */     IDIPPacket_AqQueryUsrInfoRsp rsp = IDIPPacket_AqQueryUsrInfoRsp.create();
/* 35 */     return new IDIPCmd_AqQueryUsrInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqQueryUsrInfoReq create(IDIPPacket_AqQueryUsrInfoReq req, IDIPPacket_AqQueryUsrInfoRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqQueryUsrInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqQueryUsrInfoReq(IDIPPacket_AqQueryUsrInfoReq req, IDIPPacket_AqQueryUsrInfoRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4135;
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
/* 62 */     return new PIDIPCmd_AqQueryUsrInfoReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqQueryUsrInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */