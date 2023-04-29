/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RegisterGameServerRsp
/*     */   extends __RegisterGameServerRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 14005;
/*     */   public int retcode;
/*     */   public int hubid;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     GHubHelper.onRegisGameServerRsp(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 14005;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public RegisterGameServerRsp()
/*     */   {
/*  36 */     this.retcode = 2;
/*  37 */     this.hubid = 0;
/*  38 */     this.reserved1 = 0;
/*  39 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public RegisterGameServerRsp(int _retcode_, int _hubid_, int _reserved1_, int _reserved2_) {
/*  43 */     this.retcode = _retcode_;
/*  44 */     this.hubid = _hubid_;
/*  45 */     this.reserved1 = _reserved1_;
/*  46 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.retcode);
/*  55 */     _os_.marshal(this.hubid);
/*  56 */     _os_.marshal(this.reserved1);
/*  57 */     _os_.marshal(this.reserved2);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.retcode = _os_.unmarshal_int();
/*  63 */     this.hubid = _os_.unmarshal_int();
/*  64 */     this.reserved1 = _os_.unmarshal_int();
/*  65 */     this.reserved2 = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof RegisterGameServerRsp)) {
/*  75 */       RegisterGameServerRsp _o_ = (RegisterGameServerRsp)_o1_;
/*  76 */       if (this.retcode != _o_.retcode) return false;
/*  77 */       if (this.hubid != _o_.hubid) return false;
/*  78 */       if (this.reserved1 != _o_.reserved1) return false;
/*  79 */       if (this.reserved2 != _o_.reserved2) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.retcode;
/*  88 */     _h_ += this.hubid;
/*  89 */     _h_ += this.reserved1;
/*  90 */     _h_ += this.reserved2;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.retcode).append(",");
/*  98 */     _sb_.append(this.hubid).append(",");
/*  99 */     _sb_.append(this.reserved1).append(",");
/* 100 */     _sb_.append(this.reserved2).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(RegisterGameServerRsp _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.retcode - _o_.retcode;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.hubid - _o_.hubid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.reserved1 - _o_.reserved1;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.reserved2 - _o_.reserved2;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RegisterGameServerRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */