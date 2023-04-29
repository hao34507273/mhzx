/*     */ package mzm.gsp.crosscompete;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SStageBrd extends __SStageBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616705;
/*     */   public static final int STG_SIGN_UP = 0;
/*     */   public static final int STG_MATCH = 1;
/*     */   public static final int STG_WAIT_REMIND = 2;
/*     */   public static final int STG_WAIT_COMPETE = 3;
/*     */   public static final int STG_EARLY_CREATE_FACTION_1 = 4;
/*     */   public static final int STG_PREPARE_1 = 5;
/*     */   public static final int STG_FIGHT_1 = 6;
/*     */   public static final int STG_FORCE_END_1 = 7;
/*     */   public static final int STG_REST = 8;
/*     */   public static final int STG_EARLY_CREATE_FACTION_2 = 9;
/*     */   public static final int STG_PREPARE_2 = 10;
/*     */   public static final int STG_FIGHT_2 = 11;
/*     */   public static final int STG_FORCE_END_2 = 12;
/*     */   public static final int STG_END = 13;
/*     */   public int stage;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12616705;
/*     */   }
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
/*     */   public SStageBrd() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStageBrd(int _stage_)
/*     */   {
/*  51 */     this.stage = _stage_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.stage);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  64 */     this.stage = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof SStageBrd)) {
/*  74 */       SStageBrd _o_ = (SStageBrd)_o1_;
/*  75 */       if (this.stage != _o_.stage) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.stage;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.stage).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SStageBrd _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.stage - _o_.stage;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SStageBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */