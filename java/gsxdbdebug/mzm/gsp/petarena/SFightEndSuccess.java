/*     */ package mzm.gsp.petarena;
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
/*     */ public class SFightEndSuccess
/*     */   extends __SFightEndSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628254;
/*     */   public int add_point;
/*     */   public int point;
/*     */   public int today_point;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628254;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SFightEndSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SFightEndSuccess(int _add_point_, int _point_, int _today_point_)
/*     */   {
/*  38 */     this.add_point = _add_point_;
/*  39 */     this.point = _point_;
/*  40 */     this.today_point = _today_point_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.add_point);
/*  49 */     _os_.marshal(this.point);
/*  50 */     _os_.marshal(this.today_point);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.add_point = _os_.unmarshal_int();
/*  56 */     this.point = _os_.unmarshal_int();
/*  57 */     this.today_point = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SFightEndSuccess)) {
/*  67 */       SFightEndSuccess _o_ = (SFightEndSuccess)_o1_;
/*  68 */       if (this.add_point != _o_.add_point) return false;
/*  69 */       if (this.point != _o_.point) return false;
/*  70 */       if (this.today_point != _o_.today_point) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.add_point;
/*  79 */     _h_ += this.point;
/*  80 */     _h_ += this.today_point;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.add_point).append(",");
/*  88 */     _sb_.append(this.point).append(",");
/*  89 */     _sb_.append(this.today_point).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFightEndSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.add_point - _o_.add_point;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.point - _o_.point;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.today_point - _o_.today_point;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\SFightEndSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */