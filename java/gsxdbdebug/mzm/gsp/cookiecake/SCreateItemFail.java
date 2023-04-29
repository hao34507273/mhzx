/*     */ package mzm.gsp.cookiecake;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class SCreateItemFail
/*     */   extends __SCreateItemFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623873;
/*     */   public static final int ERROR_SYSTEM = 1;
/*     */   public static final int ERROR_USERID = 2;
/*     */   public static final int ERROR_CFG = 3;
/*     */   public static final int ERROR_PARAM = 4;
/*     */   public static final int ERROR_CAN_NOT_JOIN_ACTIVITY = 5;
/*     */   public static final int ERROR_BAG_FULL = 6;
/*     */   public static final int ERROR_COST_ITEM_LESS = 7;
/*     */   public int activity_id;
/*     */   public int create_item_id;
/*     */   public int action_type;
/*     */   public int error_code;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623873;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCreateItemFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCreateItemFail(int _activity_id_, int _create_item_id_, int _action_type_, int _error_code_)
/*     */   {
/*  47 */     this.activity_id = _activity_id_;
/*  48 */     this.create_item_id = _create_item_id_;
/*  49 */     this.action_type = _action_type_;
/*  50 */     this.error_code = _error_code_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.activity_id);
/*  59 */     _os_.marshal(this.create_item_id);
/*  60 */     _os_.marshal(this.action_type);
/*  61 */     _os_.marshal(this.error_code);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.activity_id = _os_.unmarshal_int();
/*  67 */     this.create_item_id = _os_.unmarshal_int();
/*  68 */     this.action_type = _os_.unmarshal_int();
/*  69 */     this.error_code = _os_.unmarshal_int();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SCreateItemFail)) {
/*  79 */       SCreateItemFail _o_ = (SCreateItemFail)_o1_;
/*  80 */       if (this.activity_id != _o_.activity_id) return false;
/*  81 */       if (this.create_item_id != _o_.create_item_id) return false;
/*  82 */       if (this.action_type != _o_.action_type) return false;
/*  83 */       if (this.error_code != _o_.error_code) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.activity_id;
/*  92 */     _h_ += this.create_item_id;
/*  93 */     _h_ += this.action_type;
/*  94 */     _h_ += this.error_code;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.activity_id).append(",");
/* 102 */     _sb_.append(this.create_item_id).append(",");
/* 103 */     _sb_.append(this.action_type).append(",");
/* 104 */     _sb_.append(this.error_code).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCreateItemFail _o_) {
/* 110 */     if (_o_ == this) return 0;
/* 111 */     int _c_ = 0;
/* 112 */     _c_ = this.activity_id - _o_.activity_id;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.create_item_id - _o_.create_item_id;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.action_type - _o_.action_type;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.error_code - _o_.error_code;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cookiecake\SCreateItemFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */