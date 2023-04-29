/*     */ package mzm.gsp.qingfu;
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
/*     */ public class SGetGiftInfoError
/*     */   extends __SGetGiftInfoError__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588843;
/*     */   public static final int ACTIVITY_CLOSE = 1;
/*     */   public int code;
/*     */   public int activity_id;
/*     */   public int gift_bag_cfg_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12588843;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetGiftInfoError() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetGiftInfoError(int _code_, int _activity_id_, int _gift_bag_cfg_id_)
/*     */   {
/*  40 */     this.code = _code_;
/*  41 */     this.activity_id = _activity_id_;
/*  42 */     this.gift_bag_cfg_id = _gift_bag_cfg_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.code);
/*  51 */     _os_.marshal(this.activity_id);
/*  52 */     _os_.marshal(this.gift_bag_cfg_id);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.code = _os_.unmarshal_int();
/*  58 */     this.activity_id = _os_.unmarshal_int();
/*  59 */     this.gift_bag_cfg_id = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SGetGiftInfoError)) {
/*  69 */       SGetGiftInfoError _o_ = (SGetGiftInfoError)_o1_;
/*  70 */       if (this.code != _o_.code) return false;
/*  71 */       if (this.activity_id != _o_.activity_id) return false;
/*  72 */       if (this.gift_bag_cfg_id != _o_.gift_bag_cfg_id) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.code;
/*  81 */     _h_ += this.activity_id;
/*  82 */     _h_ += this.gift_bag_cfg_id;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.code).append(",");
/*  90 */     _sb_.append(this.activity_id).append(",");
/*  91 */     _sb_.append(this.gift_bag_cfg_id).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetGiftInfoError _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.code - _o_.code;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.activity_id - _o_.activity_id;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.gift_bag_cfg_id - _o_.gift_bag_cfg_id;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SGetGiftInfoError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */