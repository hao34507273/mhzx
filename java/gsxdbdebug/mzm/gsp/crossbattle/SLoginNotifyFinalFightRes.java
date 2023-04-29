/*     */ package mzm.gsp.crossbattle;
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
/*     */ public class SLoginNotifyFinalFightRes
/*     */   extends __SLoginNotifyFinalFightRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617055;
/*     */   public static final int FIGHT = 1;
/*     */   public static final int GIVE_UP = 2;
/*     */   public static final int LIMIT = 3;
/*     */   public int ret;
/*     */   public int is_rank_up;
/*     */   public int reason;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617055;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLoginNotifyFinalFightRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLoginNotifyFinalFightRes(int _ret_, int _is_rank_up_, int _reason_)
/*     */   {
/*  42 */     this.ret = _ret_;
/*  43 */     this.is_rank_up = _is_rank_up_;
/*  44 */     this.reason = _reason_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.ret);
/*  53 */     _os_.marshal(this.is_rank_up);
/*  54 */     _os_.marshal(this.reason);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.ret = _os_.unmarshal_int();
/*  60 */     this.is_rank_up = _os_.unmarshal_int();
/*  61 */     this.reason = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SLoginNotifyFinalFightRes)) {
/*  71 */       SLoginNotifyFinalFightRes _o_ = (SLoginNotifyFinalFightRes)_o1_;
/*  72 */       if (this.ret != _o_.ret) return false;
/*  73 */       if (this.is_rank_up != _o_.is_rank_up) return false;
/*  74 */       if (this.reason != _o_.reason) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.ret;
/*  83 */     _h_ += this.is_rank_up;
/*  84 */     _h_ += this.reason;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.ret).append(",");
/*  92 */     _sb_.append(this.is_rank_up).append(",");
/*  93 */     _sb_.append(this.reason).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SLoginNotifyFinalFightRes _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.ret - _o_.ret;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.is_rank_up - _o_.is_rank_up;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.reason - _o_.reason;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SLoginNotifyFinalFightRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */