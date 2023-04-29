/*     */ package idip.core;
/*     */ 
/*     */ import gnet.GDeliveryManager;
/*     */ import idip.DataBetweenIDIPAndGameRep;
/*     */ import jsonio.JsonStream;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public abstract class IDIPCmd<REQ extends IDIPPacket<?>, RSP extends IDIPPacket<?>> implements Runnable
/*     */ {
/*     */   protected int reqType;
/*     */   protected int xid;
/*     */   protected int proxyid;
/*     */   protected int zoneid;
/*     */   public final REQ req;
/*     */   public final RSP rsp;
/*     */   
/*     */   public static final IDIPCmd<?, ?> parseIdipCmd(int reqtype, int xid, int proxyid, int zoneid, String reqdata) throws Exception
/*     */   {
/*  19 */     JsonStream js = new JsonStream(reqdata);
/*  20 */     int cmdid = js.getJSONObject().getJSONObject("head").getInt("Cmdid");
/*  21 */     IDIPCmd<?, ?> cmd = idip.IDIPCmdManager.getInstance().createCmd(cmdid);
/*  22 */     if (cmd == null)
/*     */     {
/*  24 */       sendBadResponse(reqtype, xid, proxyid, zoneid, -1, "system error:idip command unsupported.");
/*     */       
/*  26 */       mzm.gsp.GameServer.logger().error(String.format("[idip]IDIPCmd.run@idip command unsupported|xid=%d|proxyid=%d|req_type=%d|req_data=%s", new Object[] { Integer.valueOf(xid), Integer.valueOf(proxyid), Integer.valueOf(reqtype), reqdata }));
/*     */       
/*     */ 
/*     */ 
/*  30 */       return null;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  35 */       cmd.req.unmarshal(js);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  39 */       sendBadResponse(reqtype, xid, proxyid, zoneid, -2, String.format("command format invalid:%s.", new Object[] { e.getMessage() }), cmdid);
/*     */       
/*     */ 
/*  42 */       mzm.gsp.GameServer.logger().error(String.format("[idip]IDIPCmd.run@command format invalid|xid=%d|proxyid=%d|req_type=%d|req_data=%s", new Object[] { Integer.valueOf(xid), Integer.valueOf(proxyid), Integer.valueOf(reqtype), reqdata }), e);
/*     */       
/*     */ 
/*     */ 
/*  46 */       return null;
/*     */     }
/*     */     
/*  49 */     assert (cmd.req.head.Cmdid == cmdid);
/*     */     
/*  51 */     cmd.setReqType(reqtype);
/*  52 */     cmd.setXid(xid);
/*  53 */     cmd.setProxyId(proxyid);
/*  54 */     cmd.setZoneid(zoneid);
/*     */     
/*  56 */     return cmd;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final boolean sendBadResponse(int reqtype, int xid, int proxyid, int zoneid, int result, String retMsg)
/*     */   {
/*  62 */     return sendBadResponse(reqtype, xid, proxyid, zoneid, result, retMsg, 0);
/*     */   }
/*     */   
/*     */ 
/*     */   public static final boolean sendBadResponse(int reqtype, int xid, int proxyid, int zoneid, int result, String retMsg, int cmdid)
/*     */   {
/*  68 */     DataBetweenIDIPAndGameRep rep = new DataBetweenIDIPAndGameRep();
/*  69 */     rep.direction = 1;
/*  70 */     rep.xid = xid;
/*  71 */     rep.proxyid = proxyid;
/*  72 */     rep.zoneid = zoneid;
/*  73 */     rep.retcode = 0;
/*     */     
/*  75 */     JSONObject packet = new JSONObject();
/*  76 */     IdipHeader head = new IdipHeader();
/*  77 */     head.Cmdid = cmdid;
/*  78 */     head.Result = result;
/*  79 */     head.RetErrMsg = retMsg;
/*  80 */     JsonStream js = head.marshal(new JsonStream());
/*  81 */     packet.put("head", js.getJSONObject());
/*     */     
/*  83 */     rep.repdata = com.goldhuman.Common.Octets.wrap(packet.toString(), "UTF-8");
/*     */     
/*  85 */     return GDeliveryManager.getInstance().send(rep);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public IDIPCmd(REQ req, RSP rsp)
/*     */   {
/*  98 */     this.req = req;
/*  99 */     this.rsp = rsp;
/*     */   }
/*     */   
/*     */   public void process()
/*     */   {
/* 104 */     xdb.Executor.getInstance().execute(this);
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/*     */     try
/*     */     {
/* 111 */       processImp();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 115 */       this.rsp.head.Result = -1;
/* 116 */       this.rsp.head.RetErrMsg = String.format("system error:%s.", new Object[] { e.getMessage() });
/* 117 */       sendResponse();
/*     */       
/* 119 */       mzm.gsp.GameServer.logger().error(String.format("[idip]IDIPCmd.run@system error|xid=%d|proxyid=%d|req_type=%d|req_data=%s", new Object[] { Integer.valueOf(this.xid), Integer.valueOf(this.proxyid), Integer.valueOf(this.reqType), this.req.toString() }), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReqType(int reqType)
/*     */   {
/* 127 */     this.reqType = reqType;
/*     */   }
/*     */   
/*     */   public void setXid(int xid)
/*     */   {
/* 132 */     this.xid = xid;
/*     */   }
/*     */   
/*     */   public void setProxyId(int proxyid)
/*     */   {
/* 137 */     this.proxyid = proxyid;
/*     */   }
/*     */   
/*     */   public void setZoneid(int zoneid)
/*     */   {
/* 142 */     this.zoneid = zoneid;
/*     */   }
/*     */   
/*     */   public int getZoneid()
/*     */   {
/* 147 */     return this.zoneid;
/*     */   }
/*     */   
/*     */   public boolean sendResponse()
/*     */   {
/* 152 */     return sendResponse(0);
/*     */   }
/*     */   
/*     */   public boolean sendResponse(int retcode)
/*     */   {
/* 157 */     DataBetweenIDIPAndGameRep rep = new DataBetweenIDIPAndGameRep();
/* 158 */     rep.direction = 1;
/* 159 */     rep.xid = this.xid;
/* 160 */     rep.proxyid = this.proxyid;
/* 161 */     rep.zoneid = this.zoneid;
/* 162 */     rep.retcode = retcode;
/*     */     
/* 164 */     this.rsp.head.Seqid = this.req.head.Seqid;
/* 165 */     this.rsp.head.ServiceName = this.req.head.ServiceName;
/* 166 */     this.rsp.head.SendTime = this.req.head.SendTime;
/* 167 */     this.rsp.head.Version = this.req.head.Version;
/* 168 */     this.rsp.head.Authenticate = this.req.head.Authenticate;
/* 169 */     JsonStream js = new JsonStream();
/* 170 */     this.rsp.marshal(js);
/* 171 */     rep.repdata = com.goldhuman.Common.Octets.wrap(js.toString(), "UTF-8");
/*     */     
/* 173 */     return GDeliveryManager.getInstance().send(rep);
/*     */   }
/*     */   
/*     */   protected abstract int getCmdID();
/*     */   
/*     */   protected abstract boolean processImp()
/*     */     throws Exception;
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\core\IDIPCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */