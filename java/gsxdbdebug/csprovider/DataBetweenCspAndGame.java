/*     */ package csprovider;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class DataBetweenCspAndGame extends __DataBetweenCspAndGame__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 10014;
/*     */   public int xid;
/*     */   public int flag;
/*     */   public int qtype;
/*     */   public Octets reqdata;
/*     */   public int serverid;
/*     */   public Octets reserved;
/*     */   
/*     */   protected void process()
/*     */   {
/*  18 */     new mzm.gsp.csprovider.main.POnDataReqFromCsp(this).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 10014;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DataBetweenCspAndGame()
/*     */   {
/*  38 */     this.reqdata = new Octets();
/*  39 */     this.reserved = new Octets();
/*     */   }
/*     */   
/*     */   public DataBetweenCspAndGame(int _xid_, int _flag_, int _qtype_, Octets _reqdata_, int _serverid_, Octets _reserved_) {
/*  43 */     this.xid = _xid_;
/*  44 */     this.flag = _flag_;
/*  45 */     this.qtype = _qtype_;
/*  46 */     this.reqdata = _reqdata_;
/*  47 */     this.serverid = _serverid_;
/*  48 */     this.reserved = _reserved_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.xid);
/*  57 */     _os_.marshal(this.flag);
/*  58 */     _os_.marshal(this.qtype);
/*  59 */     _os_.marshal(this.reqdata);
/*  60 */     _os_.marshal(this.serverid);
/*  61 */     _os_.marshal(this.reserved);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  66 */     this.xid = _os_.unmarshal_int();
/*  67 */     this.flag = _os_.unmarshal_int();
/*  68 */     this.qtype = _os_.unmarshal_int();
/*  69 */     this.reqdata = _os_.unmarshal_Octets();
/*  70 */     this.serverid = _os_.unmarshal_int();
/*  71 */     this.reserved = _os_.unmarshal_Octets();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof DataBetweenCspAndGame)) {
/*  81 */       DataBetweenCspAndGame _o_ = (DataBetweenCspAndGame)_o1_;
/*  82 */       if (this.xid != _o_.xid) return false;
/*  83 */       if (this.flag != _o_.flag) return false;
/*  84 */       if (this.qtype != _o_.qtype) return false;
/*  85 */       if (!this.reqdata.equals(_o_.reqdata)) return false;
/*  86 */       if (this.serverid != _o_.serverid) return false;
/*  87 */       if (!this.reserved.equals(_o_.reserved)) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.xid;
/*  96 */     _h_ += this.flag;
/*  97 */     _h_ += this.qtype;
/*  98 */     _h_ += this.reqdata.hashCode();
/*  99 */     _h_ += this.serverid;
/* 100 */     _h_ += this.reserved.hashCode();
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.xid).append(",");
/* 108 */     _sb_.append(this.flag).append(",");
/* 109 */     _sb_.append(this.qtype).append(",");
/* 110 */     _sb_.append("B").append(this.reqdata.size()).append(",");
/* 111 */     _sb_.append(this.serverid).append(",");
/* 112 */     _sb_.append("B").append(this.reserved.size()).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\csprovider\DataBetweenCspAndGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */