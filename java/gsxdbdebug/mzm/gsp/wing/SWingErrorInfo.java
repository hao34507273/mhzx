/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SWingErrorInfo
/*     */   extends __SWingErrorInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596497;
/*     */   public static final int WING_SCHEMA_ERROR = 1;
/*     */   public static final int WING_PROPERTY_RESET_ITEM_NOT_ENOUGH = 2;
/*     */   public static final int WING_LEVEL_UP_CFG_ERROR = 3;
/*     */   public static final int WING_LEVEL_UP_ROLE_LEVEL_ERROR = 4;
/*     */   public static final int WING_LEVEL_UP_PHASE_ERROR = 5;
/*     */   public static final int WING_PHASE_UP_CFG_ERROR = 6;
/*     */   public static final int WING_PHASE_UP_LEVEL_ERROR = 7;
/*     */   public static final int WING_PHASE_UP_ITEM_NOT_ENOUGH = 8;
/*     */   public static final int YUANBAO_NOT_ENOUGH = 9;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596497;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int WING_SKILL_RESET_ITEM_NOT_ENOUGH = 10;
/*     */   
/*     */   public static final int WING_DYE_ITEM_NOT_ENOUGH = 11;
/*     */   
/*     */   public static final int WING_MODEL_ERROR = 12;
/*     */   
/*     */   public static final int WING_DYE_ITEM_CFG_ERROR = 13;
/*     */   
/*     */   public static final int NO_PROPERTY_TO_REPLACE = 14;
/*     */   
/*     */   public static final int NO_RIGHT_TO_RESET_PROPERTY = 15;
/*     */   
/*     */   public static final int WING_RESET_SKILL_ITEM_NOT_ENOUGH = 16;
/*     */   
/*     */   public static final int MAIN_SKILL_ERROE = 17;
/*     */   
/*     */   public static final int SUB_SKILL_ERROE = 18;
/*     */   
/*     */   public static final int HAS_SKILL_TO_UNDERSTAND = 19;
/*     */   
/*     */   public int rescode;
/*     */   public SWingErrorInfo() {}
/*     */   
/*     */   public SWingErrorInfo(int _rescode_)
/*     */   {
/*  56 */     this.rescode = _rescode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  64 */     _os_.marshal(this.rescode);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.rescode = _os_.unmarshal_int();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SWingErrorInfo)) {
/*  79 */       SWingErrorInfo _o_ = (SWingErrorInfo)_o1_;
/*  80 */       if (this.rescode != _o_.rescode) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.rescode;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.rescode).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SWingErrorInfo _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.rescode - _o_.rescode;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SWingErrorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */