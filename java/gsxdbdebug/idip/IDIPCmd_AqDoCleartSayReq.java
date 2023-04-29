/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoClearSayReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoCleartSayReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoCleartSayReq, IDIPPacket_AqDoCleartSayRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4165;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoCleartSayReq, IDIPPacket_AqDoCleartSayRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoCleartSayReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoCleartSayReq req, IDIPPacket_AqDoCleartSayRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoCleartSayReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoCleartSayReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoCleartSayReq req = IDIPPacket_AqDoCleartSayReq.create();
/* 34 */     IDIPPacket_AqDoCleartSayRsp rsp = IDIPPacket_AqDoCleartSayRsp.create();
/* 35 */     return new IDIPCmd_AqDoCleartSayReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoCleartSayReq create(IDIPPacket_AqDoCleartSayReq req, IDIPPacket_AqDoCleartSayRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoCleartSayReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoCleartSayReq(IDIPPacket_AqDoCleartSayReq req, IDIPPacket_AqDoCleartSayRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4165;
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
/* 62 */     return new PIDIPCmd_AqDoClearSayReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoCleartSayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */