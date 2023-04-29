/*     */ package mzm.gsp.friend;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynFriendStatus
/*     */   extends __SSynFriendStatus__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587025;
/*     */   public static final int NORMAL = 1;
/*     */   public static final int CROSS_SERVER = 2;
/*     */   public long friendid;
/*     */   public int status;
/*     */   public int reason;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12587025;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynFriendStatus() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynFriendStatus(long _friendid_, int _status_, int _reason_)
/*     */   {
/*  39 */     this.friendid = _friendid_;
/*  40 */     this.status = _status_;
/*  41 */     this.reason = _reason_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.friendid);
/*  50 */     _os_.marshal(this.status);
/*  51 */     _os_.marshal(this.reason);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.friendid = _os_.unmarshal_long();
/*  57 */     this.status = _os_.unmarshal_int();
/*  58 */     this.reason = _os_.unmarshal_int();
/*  59 */     if (!_validator_()) {
/*  60 */       throw new VerifyError("validator failed");
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  66 */     if (_o1_ == this) return true;
/*  67 */     if ((_o1_ instanceof SSynFriendStatus)) {
/*  68 */       SSynFriendStatus _o_ = (SSynFriendStatus)_o1_;
/*  69 */       if (this.friendid != _o_.friendid) return false;
/*  70 */       if (this.status != _o_.status) return false;
/*  71 */       if (this.reason != _o_.reason) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.friendid;
/*  80 */     _h_ += this.status;
/*  81 */     _h_ += this.reason;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.friendid).append(",");
/*  89 */     _sb_.append(this.status).append(",");
/*  90 */     _sb_.append(this.reason).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynFriendStatus _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = Long.signum(this.friendid - _o_.friendid);
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.status - _o_.status;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.reason - _o_.reason;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SSynFriendStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */