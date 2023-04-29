/*     */ package mzm.gsp.breakegg;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBreakEggFail
/*     */   extends __SBreakEggFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623362;
/*     */   public static final int ERROR_SYSTEM = 1;
/*     */   public static final int ERROR_USERID = 2;
/*     */   public static final int ERROR_CFG = 3;
/*     */   public static final int ERROR_PARAM = 4;
/*     */   public static final int ERROR_NO_TIMES = 5;
/*     */   public static final int ERROR_ALREADY_BREAKED = 6;
/*     */   public static final int ERROR_NOT_IN_GAME = 7;
/*     */   public int activity_id;
/*     */   public int index;
/*     */   public int error_code;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623362;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBreakEggFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBreakEggFail(int _activity_id_, int _index_, int _error_code_)
/*     */   {
/*  46 */     this.activity_id = _activity_id_;
/*  47 */     this.index = _index_;
/*  48 */     this.error_code = _error_code_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.activity_id);
/*  57 */     _os_.marshal(this.index);
/*  58 */     _os_.marshal(this.error_code);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.activity_id = _os_.unmarshal_int();
/*  64 */     this.index = _os_.unmarshal_int();
/*  65 */     this.error_code = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SBreakEggFail)) {
/*  75 */       SBreakEggFail _o_ = (SBreakEggFail)_o1_;
/*  76 */       if (this.activity_id != _o_.activity_id) return false;
/*  77 */       if (this.index != _o_.index) return false;
/*  78 */       if (this.error_code != _o_.error_code) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.activity_id;
/*  87 */     _h_ += this.index;
/*  88 */     _h_ += this.error_code;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.activity_id).append(",");
/*  96 */     _sb_.append(this.index).append(",");
/*  97 */     _sb_.append(this.error_code).append(",");
/*  98 */     _sb_.append(")");
/*  99 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBreakEggFail _o_) {
/* 103 */     if (_o_ == this) return 0;
/* 104 */     int _c_ = 0;
/* 105 */     _c_ = this.activity_id - _o_.activity_id;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.index - _o_.index;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.error_code - _o_.error_code;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\SBreakEggFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */