/*     */ package mzm.gsp.grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetRecallRebateFailed
/*     */   extends __SGetRecallRebateFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600385;
/*     */   public static final int ERROR_REDIS_LOCK = -1;
/*     */   public static final int ERROR_RECALL_REBATE_NOT_ENOUGH = -2;
/*     */   public static final int ERROR_RECALL_REBATE_MAX = -3;
/*     */   public static final int ERROR_RECALL_LEVEL = -4;
/*     */   public static final int ERROR_RECALL_NET = -5;
/*     */   public int num;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600385;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetRecallRebateFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetRecallRebateFailed(int _num_, int _retcode_)
/*     */   {
/*  43 */     this.num = _num_;
/*  44 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.num);
/*  53 */     _os_.marshal(this.retcode);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.num = _os_.unmarshal_int();
/*  59 */     this.retcode = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SGetRecallRebateFailed)) {
/*  69 */       SGetRecallRebateFailed _o_ = (SGetRecallRebateFailed)_o1_;
/*  70 */       if (this.num != _o_.num) return false;
/*  71 */       if (this.retcode != _o_.retcode) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.num;
/*  80 */     _h_ += this.retcode;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.num).append(",");
/*  88 */     _sb_.append(this.retcode).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetRecallRebateFailed _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.num - _o_.num;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.retcode - _o_.retcode;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGetRecallRebateFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */