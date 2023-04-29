/*     */ package mzm.gsp.flowerparade;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SFlowerParadeDanceFailedRep
/*     */   extends __SFlowerParadeDanceFailedRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625666;
/*     */   public static final int MAX_COUNT = 1;
/*     */   public static final int ACTION_WRONG = 2;
/*     */   public static final int FAR_AWARY = 3;
/*     */   public static final int POS_ALREADY_TAKEN = 4;
/*     */   public static final int ROLE_LEVEL_ERROR = 5;
/*     */   public int activityid;
/*     */   public int code;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12625666;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFlowerParadeDanceFailedRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFlowerParadeDanceFailedRep(int _activityid_, int _code_)
/*     */   {
/*  43 */     this.activityid = _activityid_;
/*  44 */     this.code = _code_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activityid);
/*  53 */     _os_.marshal(this.code);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activityid = _os_.unmarshal_int();
/*  59 */     this.code = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SFlowerParadeDanceFailedRep)) {
/*  69 */       SFlowerParadeDanceFailedRep _o_ = (SFlowerParadeDanceFailedRep)_o1_;
/*  70 */       if (this.activityid != _o_.activityid) return false;
/*  71 */       if (this.code != _o_.code) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.activityid;
/*  80 */     _h_ += this.code;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activityid).append(",");
/*  88 */     _sb_.append(this.code).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFlowerParadeDanceFailedRep _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.activityid - _o_.activityid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.code - _o_.code;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\SFlowerParadeDanceFailedRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */