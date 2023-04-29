/*     */ package mzm.gsp.activity;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.activity.main.PCTakeCareActivityReq;
/*     */ 
/*     */ 
/*     */ public class CTakeCareActivityReq
/*     */   extends __CTakeCareActivityReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587568;
/*     */   public static final int CANCEL = 0;
/*     */   public static final int TAKE_CARE = 1;
/*     */   public int activitycfgid;
/*     */   public int careflag;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCTakeCareActivityReq(roleId, this.activitycfgid, this.careflag));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12587568;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CTakeCareActivityReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CTakeCareActivityReq(int _activitycfgid_, int _careflag_)
/*     */   {
/*  45 */     this.activitycfgid = _activitycfgid_;
/*  46 */     this.careflag = _careflag_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activitycfgid);
/*  55 */     _os_.marshal(this.careflag);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activitycfgid = _os_.unmarshal_int();
/*  61 */     this.careflag = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CTakeCareActivityReq)) {
/*  71 */       CTakeCareActivityReq _o_ = (CTakeCareActivityReq)_o1_;
/*  72 */       if (this.activitycfgid != _o_.activitycfgid) return false;
/*  73 */       if (this.careflag != _o_.careflag) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.activitycfgid;
/*  82 */     _h_ += this.careflag;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.activitycfgid).append(",");
/*  90 */     _sb_.append(this.careflag).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CTakeCareActivityReq _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.activitycfgid - _o_.activitycfgid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.careflag - _o_.careflag;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\CTakeCareActivityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */