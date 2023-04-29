/*     */ package mzm.gsp.activitycompensate;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CGetAllAwardReq extends __CGetAllAwardReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627458;
/*     */   public static final int GET_TYPE_FREE = 0;
/*     */   public static final int GET_TYPE_GOLD = 1;
/*     */   public static final int GET_TYPE_YUANBAO = 2;
/*     */   public static final int USE_DOUBLE_POINT_NO = 0;
/*     */   public static final int USE_DOUBLE_POINT_YES = 1;
/*     */   public int get_type;
/*     */   public int use_double_point;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     if (roleid > 0L) {
/*  21 */       Role.addRoleProcedure(roleid, new mzm.gsp.activitycompensate.main.PGetAllAwardReq(roleid, this.get_type, this.use_double_point));
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
/*  32 */     return 12627458;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetAllAwardReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetAllAwardReq(int _get_type_, int _use_double_point_)
/*     */   {
/*  48 */     this.get_type = _get_type_;
/*  49 */     this.use_double_point = _use_double_point_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.get_type);
/*  58 */     _os_.marshal(this.use_double_point);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  63 */     this.get_type = _os_.unmarshal_int();
/*  64 */     this.use_double_point = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CGetAllAwardReq)) {
/*  74 */       CGetAllAwardReq _o_ = (CGetAllAwardReq)_o1_;
/*  75 */       if (this.get_type != _o_.get_type) return false;
/*  76 */       if (this.use_double_point != _o_.use_double_point) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.get_type;
/*  85 */     _h_ += this.use_double_point;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.get_type).append(",");
/*  93 */     _sb_.append(this.use_double_point).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetAllAwardReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.get_type - _o_.get_type;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.use_double_point - _o_.use_double_point;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\CGetAllAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */