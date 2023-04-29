/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SConfirmRefreshHunSuccess
/*     */   extends __SConfirmRefreshHunSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584817;
/*     */   public int bagid;
/*     */   public long uuid;
/*     */   public byte isreplace;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584817;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SConfirmRefreshHunSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SConfirmRefreshHunSuccess(int _bagid_, long _uuid_, byte _isreplace_)
/*     */   {
/*  36 */     this.bagid = _bagid_;
/*  37 */     this.uuid = _uuid_;
/*  38 */     this.isreplace = _isreplace_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.bagid);
/*  47 */     _os_.marshal(this.uuid);
/*  48 */     _os_.marshal(this.isreplace);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.bagid = _os_.unmarshal_int();
/*  54 */     this.uuid = _os_.unmarshal_long();
/*  55 */     this.isreplace = _os_.unmarshal_byte();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SConfirmRefreshHunSuccess)) {
/*  65 */       SConfirmRefreshHunSuccess _o_ = (SConfirmRefreshHunSuccess)_o1_;
/*  66 */       if (this.bagid != _o_.bagid) return false;
/*  67 */       if (this.uuid != _o_.uuid) return false;
/*  68 */       if (this.isreplace != _o_.isreplace) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += this.bagid;
/*  77 */     _h_ += (int)this.uuid;
/*  78 */     _h_ += this.isreplace;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.bagid).append(",");
/*  86 */     _sb_.append(this.uuid).append(",");
/*  87 */     _sb_.append(this.isreplace).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SConfirmRefreshHunSuccess _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = this.bagid - _o_.bagid;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.isreplace - _o_.isreplace;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SConfirmRefreshHunSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */