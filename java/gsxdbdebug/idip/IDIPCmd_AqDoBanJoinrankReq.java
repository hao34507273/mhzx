/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoBanJoinrankReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoBanJoinrankReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoBanJoinrankReq, IDIPPacket_AqDoBanJoinrankRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4151;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoBanJoinrankReq, IDIPPacket_AqDoBanJoinrankRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoBanJoinrankReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoBanJoinrankReq req, IDIPPacket_AqDoBanJoinrankRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoBanJoinrankReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoBanJoinrankReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoBanJoinrankReq req = IDIPPacket_AqDoBanJoinrankReq.create();
/* 34 */     IDIPPacket_AqDoBanJoinrankRsp rsp = IDIPPacket_AqDoBanJoinrankRsp.create();
/* 35 */     return new IDIPCmd_AqDoBanJoinrankReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoBanJoinrankReq create(IDIPPacket_AqDoBanJoinrankReq req, IDIPPacket_AqDoBanJoinrankRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoBanJoinrankReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoBanJoinrankReq(IDIPPacket_AqDoBanJoinrankReq req, IDIPPacket_AqDoBanJoinrankRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4151;
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
/* 62 */     return new PIDIPCmd_AqDoBanJoinrankReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoBanJoinrankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */