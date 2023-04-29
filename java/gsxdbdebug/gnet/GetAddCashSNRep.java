/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GetAddCashSNRep
/*     */   extends __GetAddCashSNRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 201;
/*     */   public int xid;
/*     */   public int retcode;
/*     */   public Octets userid;
/*     */   public int zoneid;
/*     */   public int sn;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 201;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GetAddCashSNRep()
/*     */   {
/*  35 */     this.xid = -1;
/*  36 */     this.retcode = -1;
/*  37 */     this.userid = new Octets();
/*  38 */     this.zoneid = -1;
/*  39 */     this.sn = 0;
/*     */   }
/*     */   
/*     */   public GetAddCashSNRep(int _xid_, int _retcode_, Octets _userid_, int _zoneid_, int _sn_) {
/*  43 */     this.xid = _xid_;
/*  44 */     this.retcode = _retcode_;
/*  45 */     this.userid = _userid_;
/*  46 */     this.zoneid = _zoneid_;
/*  47 */     this.sn = _sn_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.xid);
/*  56 */     _os_.marshal(this.retcode);
/*  57 */     _os_.marshal(this.userid);
/*  58 */     _os_.marshal(this.zoneid);
/*  59 */     _os_.marshal(this.sn);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.xid = _os_.unmarshal_int();
/*  65 */     this.retcode = _os_.unmarshal_int();
/*  66 */     this.userid = _os_.unmarshal_Octets();
/*  67 */     this.zoneid = _os_.unmarshal_int();
/*  68 */     this.sn = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof GetAddCashSNRep)) {
/*  78 */       GetAddCashSNRep _o_ = (GetAddCashSNRep)_o1_;
/*  79 */       if (this.xid != _o_.xid) return false;
/*  80 */       if (this.retcode != _o_.retcode) return false;
/*  81 */       if (!this.userid.equals(_o_.userid)) return false;
/*  82 */       if (this.zoneid != _o_.zoneid) return false;
/*  83 */       if (this.sn != _o_.sn) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.xid;
/*  92 */     _h_ += this.retcode;
/*  93 */     _h_ += this.userid.hashCode();
/*  94 */     _h_ += this.zoneid;
/*  95 */     _h_ += this.sn;
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.xid).append(",");
/* 103 */     _sb_.append(this.retcode).append(",");
/* 104 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 105 */     _sb_.append(this.zoneid).append(",");
/* 106 */     _sb_.append(this.sn).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GetAddCashSNRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */