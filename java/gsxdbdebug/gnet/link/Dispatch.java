/*     */ package gnet.link;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.gsp.GameServer;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public class Dispatch extends __Dispatch__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 1048581;
/*     */   public int linksid;
/*     */   public Octets userid;
/*     */   public int ptype;
/*     */   public Octets pdata;
/*     */   
/*     */   public void dispatch(xio.Protocol.Stub stub) throws Exception
/*     */   {
/*  18 */     int error = 1;
/*     */     try {
/*  20 */       if (mzm.gsp.GameServerInfoManager.containsDisableProtocol(this.ptype)) {
/*  21 */         GameServer.logger().warn(String.format("skip disabled protocol|linksid=%d|userid=%s|protocolid=%d", new Object[] { Integer.valueOf(this.linksid), this.userid.getString("UTF-8"), Integer.valueOf(this.ptype) }));
/*     */         
/*     */ 
/*  24 */         return;
/*     */       }
/*  26 */       xio.Protocol.Stub stub2 = ((xio.Protocol.Coder)getManager().getCoder()).getStub(this.ptype);
/*  27 */       Protocol p = stub2.newInstance();
/*  28 */       p.unmarshal(OctetsStream.wrap(this.pdata));
/*  29 */       p.setConnection(getConnection());
/*  30 */       p.setContext(this);
/*  31 */       p.dispatch(stub2);
/*  32 */       return;
/*     */     } catch (xio.MarshalError e) {
/*  34 */       if (GameServer.isDebugMode())
/*  35 */         GameServer.logger().error("err", e);
/*  36 */       error = 2;
/*     */     } catch (Throwable e) {
/*  38 */       error = 3;
/*     */     }
/*  40 */     Kick kick = new Kick();
/*  41 */     kick.error = error;
/*  42 */     if (GameServer.isDebugMode()) {
/*  43 */       kick.action = 1;
/*     */     }
/*     */     else {
/*  46 */       kick.action = 2;
/*  47 */       kick.error = 32;
/*     */     }
/*  49 */     kick.send(super.getConnection());
/*     */   }
/*     */   
/*     */   protected void process()
/*     */   {
/*  54 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  62 */     return 1048581;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Dispatch()
/*     */   {
/*  71 */     this.userid = new Octets();
/*  72 */     this.pdata = new Octets();
/*     */   }
/*     */   
/*     */   public Dispatch(int _linksid_, Octets _userid_, int _ptype_, Octets _pdata_) {
/*  76 */     this.linksid = _linksid_;
/*  77 */     this.userid = _userid_;
/*  78 */     this.ptype = _ptype_;
/*  79 */     this.pdata = _pdata_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  83 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  87 */     _os_.marshal(this.linksid);
/*  88 */     _os_.marshal(this.userid);
/*  89 */     _os_.marshal(this.ptype);
/*  90 */     _os_.marshal(this.pdata);
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  95 */     this.linksid = _os_.unmarshal_int();
/*  96 */     this.userid = _os_.unmarshal_Octets();
/*  97 */     this.ptype = _os_.unmarshal_int();
/*  98 */     this.pdata = _os_.unmarshal_Octets();
/*  99 */     if (!_validator_()) {
/* 100 */       throw new VerifyError("validator failed");
/*     */     }
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 106 */     if (_o1_ == this) return true;
/* 107 */     if ((_o1_ instanceof Dispatch)) {
/* 108 */       Dispatch _o_ = (Dispatch)_o1_;
/* 109 */       if (this.linksid != _o_.linksid) return false;
/* 110 */       if (!this.userid.equals(_o_.userid)) return false;
/* 111 */       if (this.ptype != _o_.ptype) return false;
/* 112 */       if (!this.pdata.equals(_o_.pdata)) return false;
/* 113 */       return true;
/*     */     }
/* 115 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 119 */     int _h_ = 0;
/* 120 */     _h_ += this.linksid;
/* 121 */     _h_ += this.userid.hashCode();
/* 122 */     _h_ += this.ptype;
/* 123 */     _h_ += this.pdata.hashCode();
/* 124 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 128 */     StringBuilder _sb_ = new StringBuilder();
/* 129 */     _sb_.append("(");
/* 130 */     _sb_.append(this.linksid).append(",");
/* 131 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 132 */     _sb_.append(this.ptype).append(",");
/* 133 */     _sb_.append("B").append(this.pdata.size()).append(",");
/* 134 */     _sb_.append(")");
/* 135 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\Dispatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */