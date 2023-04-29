/*     */ package mzm.gsp.activitycompensate;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class CGetAwardReq extends __CGetAwardReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627459;
/*     */   public static final int GET_TYPE_FREE = 0;
/*     */   public static final int GET_TYPE_GOLD = 1;
/*     */   public static final int GET_TYPE_YUANBAO = 2;
/*     */   public static final int USE_DOUBLE_POINT_NO = 0;
/*     */   public static final int USE_DOUBLE_POINT_YES = 1;
/*     */   public int activityid;
/*     */   public int get_type;
/*     */   public int left_times;
/*     */   public int use_double_point;
/*     */   
/*     */   protected void process() {
/*  19 */     long roleid = mzm.gsp.Role.getRoleId(this);
/*  20 */     if (roleid > 0L) {
/*  21 */       mzm.gsp.Role.addRoleProcedure(roleid, new mzm.gsp.activitycompensate.main.PGetAwardReq(roleid, this.activityid, this.get_type, this.left_times, this.use_double_point));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12627459;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetAwardReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetAwardReq(int _activityid_, int _get_type_, int _left_times_, int _use_double_point_)
/*     */   {
/*  50 */     this.activityid = _activityid_;
/*  51 */     this.get_type = _get_type_;
/*  52 */     this.left_times = _left_times_;
/*  53 */     this.use_double_point = _use_double_point_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  61 */     _os_.marshal(this.activityid);
/*  62 */     _os_.marshal(this.get_type);
/*  63 */     _os_.marshal(this.left_times);
/*  64 */     _os_.marshal(this.use_double_point);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  69 */     this.activityid = _os_.unmarshal_int();
/*  70 */     this.get_type = _os_.unmarshal_int();
/*  71 */     this.left_times = _os_.unmarshal_int();
/*  72 */     this.use_double_point = _os_.unmarshal_int();
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof CGetAwardReq)) {
/*  82 */       CGetAwardReq _o_ = (CGetAwardReq)_o1_;
/*  83 */       if (this.activityid != _o_.activityid) return false;
/*  84 */       if (this.get_type != _o_.get_type) return false;
/*  85 */       if (this.left_times != _o_.left_times) return false;
/*  86 */       if (this.use_double_point != _o_.use_double_point) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.activityid;
/*  95 */     _h_ += this.get_type;
/*  96 */     _h_ += this.left_times;
/*  97 */     _h_ += this.use_double_point;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.activityid).append(",");
/* 105 */     _sb_.append(this.get_type).append(",");
/* 106 */     _sb_.append(this.left_times).append(",");
/* 107 */     _sb_.append(this.use_double_point).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetAwardReq _o_) {
/* 113 */     if (_o_ == this) return 0;
/* 114 */     int _c_ = 0;
/* 115 */     _c_ = this.activityid - _o_.activityid;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.get_type - _o_.get_type;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.left_times - _o_.left_times;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.use_double_point - _o_.use_double_point;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\CGetAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */