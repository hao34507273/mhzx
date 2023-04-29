/*     */ package mzm.gsp.qingyuan;
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
/*     */ 
/*     */ public class SAgreeOrRefuseQingYuan
/*     */   extends __SAgreeOrRefuseQingYuan__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602883;
/*     */   public int operator;
/*     */   public long team_leader_role_id;
/*     */   public long team_member_role_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12602883;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SAgreeOrRefuseQingYuan() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SAgreeOrRefuseQingYuan(int _operator_, long _team_leader_role_id_, long _team_member_role_id_)
/*     */   {
/*  38 */     this.operator = _operator_;
/*  39 */     this.team_leader_role_id = _team_leader_role_id_;
/*  40 */     this.team_member_role_id = _team_member_role_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.operator);
/*  49 */     _os_.marshal(this.team_leader_role_id);
/*  50 */     _os_.marshal(this.team_member_role_id);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.operator = _os_.unmarshal_int();
/*  56 */     this.team_leader_role_id = _os_.unmarshal_long();
/*  57 */     this.team_member_role_id = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SAgreeOrRefuseQingYuan)) {
/*  67 */       SAgreeOrRefuseQingYuan _o_ = (SAgreeOrRefuseQingYuan)_o1_;
/*  68 */       if (this.operator != _o_.operator) return false;
/*  69 */       if (this.team_leader_role_id != _o_.team_leader_role_id) return false;
/*  70 */       if (this.team_member_role_id != _o_.team_member_role_id) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.operator;
/*  79 */     _h_ += (int)this.team_leader_role_id;
/*  80 */     _h_ += (int)this.team_member_role_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.operator).append(",");
/*  88 */     _sb_.append(this.team_leader_role_id).append(",");
/*  89 */     _sb_.append(this.team_member_role_id).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAgreeOrRefuseQingYuan _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.operator - _o_.operator;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.team_leader_role_id - _o_.team_leader_role_id);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.team_member_role_id - _o_.team_member_role_id);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\SAgreeOrRefuseQingYuan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */