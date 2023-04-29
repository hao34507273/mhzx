/*     */ package mzm.gsp.grow;
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
/*     */ 
/*     */ 
/*     */ public class SSynTargetSchedule
/*     */   extends __SSynTargetSchedule__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596993;
/*     */   public int targetid;
/*     */   public int targetstate;
/*     */   public int targetparam;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596993;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynTargetSchedule() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynTargetSchedule(int _targetid_, int _targetstate_, int _targetparam_)
/*     */   {
/*  38 */     this.targetid = _targetid_;
/*  39 */     this.targetstate = _targetstate_;
/*  40 */     this.targetparam = _targetparam_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.targetid);
/*  49 */     _os_.marshal(this.targetstate);
/*  50 */     _os_.marshal(this.targetparam);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.targetid = _os_.unmarshal_int();
/*  56 */     this.targetstate = _os_.unmarshal_int();
/*  57 */     this.targetparam = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSynTargetSchedule)) {
/*  67 */       SSynTargetSchedule _o_ = (SSynTargetSchedule)_o1_;
/*  68 */       if (this.targetid != _o_.targetid) return false;
/*  69 */       if (this.targetstate != _o_.targetstate) return false;
/*  70 */       if (this.targetparam != _o_.targetparam) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.targetid;
/*  79 */     _h_ += this.targetstate;
/*  80 */     _h_ += this.targetparam;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.targetid).append(",");
/*  88 */     _sb_.append(this.targetstate).append(",");
/*  89 */     _sb_.append(this.targetparam).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynTargetSchedule _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.targetid - _o_.targetid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.targetstate - _o_.targetstate;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.targetparam - _o_.targetparam;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\SSynTargetSchedule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */