/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.gang.main.PCYuanBao2banggongReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CYuanBao2banggongReq
/*     */   extends __CYuanBao2banggongReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590009;
/*     */   public int yuan_bao;
/*     */   public long client_yuan_bao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCYuanBao2banggongReq(roleId, this.yuan_bao, this.client_yuan_bao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12590009;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CYuanBao2banggongReq() {}
/*     */   
/*     */ 
/*     */   public CYuanBao2banggongReq(int _yuan_bao_, long _client_yuan_bao_)
/*     */   {
/*  43 */     this.yuan_bao = _yuan_bao_;
/*  44 */     this.client_yuan_bao = _client_yuan_bao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.yuan_bao);
/*  53 */     _os_.marshal(this.client_yuan_bao);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.yuan_bao = _os_.unmarshal_int();
/*  59 */     this.client_yuan_bao = _os_.unmarshal_long();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CYuanBao2banggongReq)) {
/*  69 */       CYuanBao2banggongReq _o_ = (CYuanBao2banggongReq)_o1_;
/*  70 */       if (this.yuan_bao != _o_.yuan_bao) return false;
/*  71 */       if (this.client_yuan_bao != _o_.client_yuan_bao) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.yuan_bao;
/*  80 */     _h_ += (int)this.client_yuan_bao;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.yuan_bao).append(",");
/*  88 */     _sb_.append(this.client_yuan_bao).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CYuanBao2banggongReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.yuan_bao - _o_.yuan_bao;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = Long.signum(this.client_yuan_bao - _o_.client_yuan_bao);
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CYuanBao2banggongReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */