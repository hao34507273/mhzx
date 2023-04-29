/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.children.main.PCAgreeOrRefusePregnantBelong;
/*     */ 
/*     */ 
/*     */ public class CAgreeOrRefusePregnantBelong
/*     */   extends __CAgreeOrRefusePregnantBelong__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609331;
/*     */   public static final int REFUSE = 0;
/*     */   public static final int AGREE = 1;
/*     */   public int operator;
/*     */   public long session_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCAgreeOrRefusePregnantBelong(roleId, this.operator, this.session_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12609331;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAgreeOrRefusePregnantBelong() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAgreeOrRefusePregnantBelong(int _operator_, long _session_id_)
/*     */   {
/*  46 */     this.operator = _operator_;
/*  47 */     this.session_id = _session_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.operator);
/*  56 */     _os_.marshal(this.session_id);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.operator = _os_.unmarshal_int();
/*  62 */     this.session_id = _os_.unmarshal_long();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CAgreeOrRefusePregnantBelong)) {
/*  72 */       CAgreeOrRefusePregnantBelong _o_ = (CAgreeOrRefusePregnantBelong)_o1_;
/*  73 */       if (this.operator != _o_.operator) return false;
/*  74 */       if (this.session_id != _o_.session_id) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.operator;
/*  83 */     _h_ += (int)this.session_id;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.operator).append(",");
/*  91 */     _sb_.append(this.session_id).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAgreeOrRefusePregnantBelong _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.operator - _o_.operator;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.session_id - _o_.session_id);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CAgreeOrRefusePregnantBelong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */