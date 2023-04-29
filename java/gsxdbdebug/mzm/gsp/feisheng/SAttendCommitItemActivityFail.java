/*     */ package mzm.gsp.feisheng;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SAttendCommitItemActivityFail
/*     */   extends __SAttendCommitItemActivityFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12614146;
/*     */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*     */   public static final int ROLE_STATUS_ERROR = -2;
/*     */   public static final int PARAM_ERROR = -3;
/*     */   public static final int CHECK_NPC_SERVICE_ERROR = -4;
/*     */   public static final int SERVER_LEVEL_NOT_ENOUGH = -5;
/*     */   public static final int CAN_NOT_JOIN_ACTIVITY = 1;
/*     */   public static final int ITEM_NOT_ENOUGH = 2;
/*     */   public static final int AWARD_FAIL = 3;
/*     */   public int activity_cfg_id;
/*     */   public int res;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12614146;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAttendCommitItemActivityFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAttendCommitItemActivityFail(int _activity_cfg_id_, int _res_)
/*     */   {
/*  46 */     this.activity_cfg_id = _activity_cfg_id_;
/*  47 */     this.res = _res_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.activity_cfg_id);
/*  56 */     _os_.marshal(this.res);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  62 */     this.res = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof SAttendCommitItemActivityFail)) {
/*  72 */       SAttendCommitItemActivityFail _o_ = (SAttendCommitItemActivityFail)_o1_;
/*  73 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  74 */       if (this.res != _o_.res) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.activity_cfg_id;
/*  83 */     _h_ += this.res;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.activity_cfg_id).append(",");
/*  91 */     _sb_.append(this.res).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAttendCommitItemActivityFail _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.res - _o_.res;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\SAttendCommitItemActivityFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */