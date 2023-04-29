/*     */ package mzm.gsp.gratefuldelivery;
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
/*     */ public class SFetchRewardFail
/*     */   extends __SFetchRewardFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12615687;
/*     */   public static final int UNAVAILABLE = 1;
/*     */   public static final int ALREADY_FETCHED = 2;
/*     */   public int retcode;
/*     */   public int stage;
/*     */   public int activity_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12615687;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFetchRewardFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFetchRewardFail(int _retcode_, int _stage_, int _activity_id_)
/*     */   {
/*  41 */     this.retcode = _retcode_;
/*  42 */     this.stage = _stage_;
/*  43 */     this.activity_id = _activity_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.retcode);
/*  52 */     _os_.marshal(this.stage);
/*  53 */     _os_.marshal(this.activity_id);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.retcode = _os_.unmarshal_int();
/*  59 */     this.stage = _os_.unmarshal_int();
/*  60 */     this.activity_id = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof SFetchRewardFail)) {
/*  70 */       SFetchRewardFail _o_ = (SFetchRewardFail)_o1_;
/*  71 */       if (this.retcode != _o_.retcode) return false;
/*  72 */       if (this.stage != _o_.stage) return false;
/*  73 */       if (this.activity_id != _o_.activity_id) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.retcode;
/*  82 */     _h_ += this.stage;
/*  83 */     _h_ += this.activity_id;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.retcode).append(",");
/*  91 */     _sb_.append(this.stage).append(",");
/*  92 */     _sb_.append(this.activity_id).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFetchRewardFail _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.retcode - _o_.retcode;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.stage - _o_.stage;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.activity_id - _o_.activity_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\SFetchRewardFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */