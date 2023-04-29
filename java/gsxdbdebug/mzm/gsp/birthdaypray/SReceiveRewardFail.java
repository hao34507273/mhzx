/*     */ package mzm.gsp.birthdaypray;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SReceiveRewardFail
/*     */   extends __SReceiveRewardFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623107;
/*     */   public static final int ERROR_SYSTEM = 1;
/*     */   public static final int ERROR_USERID = 2;
/*     */   public static final int ERROR_CFG = 3;
/*     */   public static final int ERROR_PARAM = 4;
/*     */   public static final int ERROR_ACTIVITY_CLOSED = 5;
/*     */   public static final int ERROR_TIMES_NOT_ENOUGH = 6;
/*     */   public static final int ERROR_RECEIVED_ALREADY = 7;
/*     */   public static final int ERROR_BAG_FULL = 8;
/*     */   public int activity_cfg_id;
/*     */   public int task_activity_id;
/*     */   public int stage_id;
/*     */   public int error_code;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623107;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SReceiveRewardFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SReceiveRewardFail(int _activity_cfg_id_, int _task_activity_id_, int _stage_id_, int _error_code_)
/*     */   {
/*  48 */     this.activity_cfg_id = _activity_cfg_id_;
/*  49 */     this.task_activity_id = _task_activity_id_;
/*  50 */     this.stage_id = _stage_id_;
/*  51 */     this.error_code = _error_code_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.activity_cfg_id);
/*  60 */     _os_.marshal(this.task_activity_id);
/*  61 */     _os_.marshal(this.stage_id);
/*  62 */     _os_.marshal(this.error_code);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  68 */     this.task_activity_id = _os_.unmarshal_int();
/*  69 */     this.stage_id = _os_.unmarshal_int();
/*  70 */     this.error_code = _os_.unmarshal_int();
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof SReceiveRewardFail)) {
/*  80 */       SReceiveRewardFail _o_ = (SReceiveRewardFail)_o1_;
/*  81 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  82 */       if (this.task_activity_id != _o_.task_activity_id) return false;
/*  83 */       if (this.stage_id != _o_.stage_id) return false;
/*  84 */       if (this.error_code != _o_.error_code) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.activity_cfg_id;
/*  93 */     _h_ += this.task_activity_id;
/*  94 */     _h_ += this.stage_id;
/*  95 */     _h_ += this.error_code;
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.activity_cfg_id).append(",");
/* 103 */     _sb_.append(this.task_activity_id).append(",");
/* 104 */     _sb_.append(this.stage_id).append(",");
/* 105 */     _sb_.append(this.error_code).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SReceiveRewardFail _o_) {
/* 111 */     if (_o_ == this) return 0;
/* 112 */     int _c_ = 0;
/* 113 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.task_activity_id - _o_.task_activity_id;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.stage_id - _o_.stage_id;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.error_code - _o_.error_code;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\SReceiveRewardFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */