/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoBanAssignPlayReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoBanAssignPlayReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoBanAssignPlayReq, IDIPPacket_AqDoBanAssignPlayRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4181;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoBanAssignPlayReq, IDIPPacket_AqDoBanAssignPlayRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoBanAssignPlayReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoBanAssignPlayReq req, IDIPPacket_AqDoBanAssignPlayRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoBanAssignPlayReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoBanAssignPlayReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoBanAssignPlayReq req = IDIPPacket_AqDoBanAssignPlayReq.create();
/* 34 */     IDIPPacket_AqDoBanAssignPlayRsp rsp = IDIPPacket_AqDoBanAssignPlayRsp.create();
/* 35 */     return new IDIPCmd_AqDoBanAssignPlayReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoBanAssignPlayReq create(IDIPPacket_AqDoBanAssignPlayReq req, IDIPPacket_AqDoBanAssignPlayRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoBanAssignPlayReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoBanAssignPlayReq(IDIPPacket_AqDoBanAssignPlayReq req, IDIPPacket_AqDoBanAssignPlayRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4181;
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
/* 62 */     return new PIDIPCmd_AqDoBanAssignPlayReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoBanAssignPlayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */