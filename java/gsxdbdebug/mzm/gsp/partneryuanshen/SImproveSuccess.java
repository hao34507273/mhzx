/*     */ package mzm.gsp.partneryuanshen;
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
/*     */ public class SImproveSuccess
/*     */   extends __SImproveSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12621061;
/*     */   public int position;
/*     */   public int level;
/*     */   public int property;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12621061;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SImproveSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SImproveSuccess(int _position_, int _level_, int _property_)
/*     */   {
/*  38 */     this.position = _position_;
/*  39 */     this.level = _level_;
/*  40 */     this.property = _property_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.position);
/*  49 */     _os_.marshal(this.level);
/*  50 */     _os_.marshal(this.property);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.position = _os_.unmarshal_int();
/*  56 */     this.level = _os_.unmarshal_int();
/*  57 */     this.property = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SImproveSuccess)) {
/*  67 */       SImproveSuccess _o_ = (SImproveSuccess)_o1_;
/*  68 */       if (this.position != _o_.position) return false;
/*  69 */       if (this.level != _o_.level) return false;
/*  70 */       if (this.property != _o_.property) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.position;
/*  79 */     _h_ += this.level;
/*  80 */     _h_ += this.property;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.position).append(",");
/*  88 */     _sb_.append(this.level).append(",");
/*  89 */     _sb_.append(this.property).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SImproveSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.position - _o_.position;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.level - _o_.level;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.property - _o_.property;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\SImproveSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */