/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncPetStateChange
/*     */   extends __SSyncPetStateChange__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590610;
/*     */   public static final int STATE_FIGHT = 0;
/*     */   public static final int STATE_SHOW = 1;
/*     */   public static final int STATE_DELETE = 2;
/*     */   public static final int STATE_REST = 3;
/*     */   public static final int STATE_HIDE = 4;
/*     */   public long petid;
/*     */   public int state;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590610;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncPetStateChange() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncPetStateChange(long _petid_, int _state_)
/*     */   {
/*  43 */     this.petid = _petid_;
/*  44 */     this.state = _state_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.petid);
/*  53 */     _os_.marshal(this.state);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.petid = _os_.unmarshal_long();
/*  59 */     this.state = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SSyncPetStateChange)) {
/*  69 */       SSyncPetStateChange _o_ = (SSyncPetStateChange)_o1_;
/*  70 */       if (this.petid != _o_.petid) return false;
/*  71 */       if (this.state != _o_.state) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.petid;
/*  80 */     _h_ += this.state;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.petid).append(",");
/*  88 */     _sb_.append(this.state).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncPetStateChange _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.petid - _o_.petid);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.state - _o_.state;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SSyncPetStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */