/*     */ package mzm.gsp.role;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.role.main.PResetRolePropReq;
/*     */ 
/*     */ public class CResetRolePropReq extends __CResetRolePropReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585996;
/*     */   public static final int PROP_SYS_1 = 0;
/*     */   public static final int PROP_SYS_2 = 1;
/*     */   public static final int PROP_SYS_3 = 2;
/*     */   public int isuseyuanbao;
/*     */   public int propsys;
/*     */   public long yuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PResetRolePropReq(roleId, this.yuanbao, this.propsys, this.isuseyuanbao == 1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12585996;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CResetRolePropReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CResetRolePropReq(int _isuseyuanbao_, int _propsys_, long _yuanbao_)
/*     */   {
/*  46 */     this.isuseyuanbao = _isuseyuanbao_;
/*  47 */     this.propsys = _propsys_;
/*  48 */     this.yuanbao = _yuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.isuseyuanbao);
/*  57 */     _os_.marshal(this.propsys);
/*  58 */     _os_.marshal(this.yuanbao);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  63 */     this.isuseyuanbao = _os_.unmarshal_int();
/*  64 */     this.propsys = _os_.unmarshal_int();
/*  65 */     this.yuanbao = _os_.unmarshal_long();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CResetRolePropReq)) {
/*  75 */       CResetRolePropReq _o_ = (CResetRolePropReq)_o1_;
/*  76 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  77 */       if (this.propsys != _o_.propsys) return false;
/*  78 */       if (this.yuanbao != _o_.yuanbao) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.isuseyuanbao;
/*  87 */     _h_ += this.propsys;
/*  88 */     _h_ += (int)this.yuanbao;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.isuseyuanbao).append(",");
/*  96 */     _sb_.append(this.propsys).append(",");
/*  97 */     _sb_.append(this.yuanbao).append(",");
/*  98 */     _sb_.append(")");
/*  99 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CResetRolePropReq _o_) {
/* 103 */     if (_o_ == this) return 0;
/* 104 */     int _c_ = 0;
/* 105 */     _c_ = this.isuseyuanbao - _o_.isuseyuanbao;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.propsys - _o_.propsys;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = Long.signum(this.yuanbao - _o_.yuanbao);
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\CResetRolePropReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */