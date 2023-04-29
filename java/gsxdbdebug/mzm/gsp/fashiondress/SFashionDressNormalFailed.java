/*     */ package mzm.gsp.fashiondress;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SFashionDressNormalFailed
/*     */   extends __SFashionDressNormalFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603152;
/*     */   public static final int CHANGE_OLD_PROPERTY_NOT_EXIST = 1;
/*     */   public static final int CHANGE_NEW_PROPERTY_NOT_EXIST = 2;
/*     */   public static final int CHANGE_NEW_PROPERTY_PROPERTY_EMPTY = 3;
/*     */   public static final int CHANGE_PROPERTY_FULL = 4;
/*     */   public static final int FASHION_DRESS_ROLE_INFO_NULL = 5;
/*     */   public static final int FASHION_DRESS_CFG_NOT_EXIST = 6;
/*     */   public static final int CHANGE_OLD_PROPERTY_NOT_IN = 7;
/*     */   public static final int CHANGE_NEW_PROPERTY_ALREADY_IN = 8;
/*     */   public static final int FASHION_DRESS_CFG_ID_REPEAT = 9;
/*     */   public static final int NORMAL_FASHION_DRESS_CHECK_FAIL = 10;
/*     */   public static final int REPLACE_FASHION_DRESS_GENDER_CHECK_FAIL = 11;
/*     */   public static final int REPLACE_FASHION_DRESS_OCCUPATION_CHECK_FAIL = 12;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12603152;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int MULTI_OCCUPATION_CFG_NOT_FOUND = 13;
/*     */   
/*     */   public static final int MULTI_OCCUPATION_CFG_EFFECT_TIME_WRONG = 14;
/*     */   
/*     */   public static final int MULTI_OCCUPATION_CFG_REPEAT = 15;
/*     */   
/*     */   public static final int CHANGE_PROPERTY_MULTI_OCCUPATION_WRONG = 16;
/*     */   
/*     */   public static final int MULTI_OCCUPATION_NOT_HAS_THE_CFG = 17;
/*     */   
/*     */   public static final int FASHION_REPLACE_NOT_OPEN = 18;
/*     */   
/*     */   public static final int THEME_FASHION_NOT_OPEN = 19;
/*     */   
/*     */   public static final int THEME_FASHION_AWARD_ALEARDY = 20;
/*     */   
/*     */   public static final int THEME_FASHION_CFG_NOT_EXIST = 21;
/*     */   
/*     */   public static final int THEME_FASHION_AWARD_CFG_NOT_EXIST = 22;
/*     */   
/*     */   public static final int THEME_FASHION_AWARD_UNLOCK_NUM_NOT_ENOUGH = 23;
/*     */   
/*     */   public static final int THEME_FASHION_AWARD_FAIL = 24;
/*     */   
/*     */   public int result;
/*     */   
/*     */   public SFashionDressNormalFailed() {}
/*     */   
/*     */   public SFashionDressNormalFailed(int _result_)
/*     */   {
/*  61 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  69 */     _os_.marshal(this.result);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  74 */     this.result = _os_.unmarshal_int();
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof SFashionDressNormalFailed)) {
/*  84 */       SFashionDressNormalFailed _o_ = (SFashionDressNormalFailed)_o1_;
/*  85 */       if (this.result != _o_.result) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.result;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.result).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFashionDressNormalFailed _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.result - _o_.result;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\SFashionDressNormalFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */