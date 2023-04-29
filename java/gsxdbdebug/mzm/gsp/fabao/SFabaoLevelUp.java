/*     */ package mzm.gsp.fabao;
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
/*     */ public class SFabaoLevelUp
/*     */   extends __SFabaoLevelUp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595987;
/*     */   public int fabaoid;
/*     */   public int fabaooriginallv;
/*     */   public int fabaolv;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12595987;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SFabaoLevelUp() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SFabaoLevelUp(int _fabaoid_, int _fabaooriginallv_, int _fabaolv_)
/*     */   {
/*  38 */     this.fabaoid = _fabaoid_;
/*  39 */     this.fabaooriginallv = _fabaooriginallv_;
/*  40 */     this.fabaolv = _fabaolv_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.fabaoid);
/*  49 */     _os_.marshal(this.fabaooriginallv);
/*  50 */     _os_.marshal(this.fabaolv);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.fabaoid = _os_.unmarshal_int();
/*  56 */     this.fabaooriginallv = _os_.unmarshal_int();
/*  57 */     this.fabaolv = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SFabaoLevelUp)) {
/*  67 */       SFabaoLevelUp _o_ = (SFabaoLevelUp)_o1_;
/*  68 */       if (this.fabaoid != _o_.fabaoid) return false;
/*  69 */       if (this.fabaooriginallv != _o_.fabaooriginallv) return false;
/*  70 */       if (this.fabaolv != _o_.fabaolv) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.fabaoid;
/*  79 */     _h_ += this.fabaooriginallv;
/*  80 */     _h_ += this.fabaolv;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.fabaoid).append(",");
/*  88 */     _sb_.append(this.fabaooriginallv).append(",");
/*  89 */     _sb_.append(this.fabaolv).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFabaoLevelUp _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.fabaoid - _o_.fabaoid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.fabaooriginallv - _o_.fabaooriginallv;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.fabaolv - _o_.fabaolv;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SFabaoLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */