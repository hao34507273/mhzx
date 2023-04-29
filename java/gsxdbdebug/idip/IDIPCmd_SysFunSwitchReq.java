/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_SysFunSwitchReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_SysFunSwitchReq
/*    */   extends IDIPCmd<IDIPPacket_SysFunSwitchReq, IDIPPacket_SysFunSwitchRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4169;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_SysFunSwitchReq, IDIPPacket_SysFunSwitchRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_SysFunSwitchReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_SysFunSwitchReq req, IDIPPacket_SysFunSwitchRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_SysFunSwitchReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_SysFunSwitchReq create()
/*    */   {
/* 33 */     IDIPPacket_SysFunSwitchReq req = IDIPPacket_SysFunSwitchReq.create();
/* 34 */     IDIPPacket_SysFunSwitchRsp rsp = IDIPPacket_SysFunSwitchRsp.create();
/* 35 */     return new IDIPCmd_SysFunSwitchReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_SysFunSwitchReq create(IDIPPacket_SysFunSwitchReq req, IDIPPacket_SysFunSwitchRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_SysFunSwitchReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_SysFunSwitchReq(IDIPPacket_SysFunSwitchReq req, IDIPPacket_SysFunSwitchRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4169;
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
/* 62 */     return new PIDIPCmd_SysFunSwitchReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_SysFunSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */