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
/*     */ public class SUnLockHunSuccess
/*     */   extends __SUnLockHunSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584816;
/*     */   public int bagid;
/*     */   public long uuid;
/*     */   public byte hunindex;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584816;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SUnLockHunSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUnLockHunSuccess(int _bagid_, long _uuid_, byte _hunindex_)
/*     */   {
/*  36 */     this.bagid = _bagid_;
/*  37 */     this.uuid = _uuid_;
/*  38 */     this.hunindex = _hunindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.bagid);
/*  47 */     _os_.marshal(this.uuid);
/*  48 */     _os_.marshal(this.hunindex);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.bagid = _os_.unmarshal_int();
/*  54 */     this.uuid = _os_.unmarshal_long();
/*  55 */     this.hunindex = _os_.unmarshal_byte();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SUnLockHunSuccess)) {
/*  65 */       SUnLockHunSuccess _o_ = (SUnLockHunSuccess)_o1_;
/*  66 */       if (this.bagid != _o_.bagid) return false;
/*  67 */       if (this.uuid != _o_.uuid) return false;
/*  68 */       if (this.hunindex != _o_.hunindex) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += this.bagid;
/*  77 */     _h_ += (int)this.uuid;
/*  78 */     _h_ += this.hunindex;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.bagid).append(",");
/*  86 */     _sb_.append(this.uuid).append(",");
/*  87 */     _sb_.append(this.hunindex).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUnLockHunSuccess _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = this.bagid - _o_.bagid;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.hunindex - _o_.hunindex;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SUnLockHunSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */