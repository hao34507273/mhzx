/*     */ package mzm.gsp.bounty;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.bounty.main.PCFlushNewReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CFlushNewReq
/*     */   extends __CFlushNewReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584196;
/*     */   public byte useyuanbao;
/*     */   public long curyuanbao;
/*     */   public long needyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCFlushNewReq(roleId, this.useyuanbao > 0, this.curyuanbao, this.needyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12584196;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CFlushNewReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CFlushNewReq(byte _useyuanbao_, long _curyuanbao_, long _needyuanbao_)
/*     */   {
/*  43 */     this.useyuanbao = _useyuanbao_;
/*  44 */     this.curyuanbao = _curyuanbao_;
/*  45 */     this.needyuanbao = _needyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.useyuanbao);
/*  54 */     _os_.marshal(this.curyuanbao);
/*  55 */     _os_.marshal(this.needyuanbao);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.useyuanbao = _os_.unmarshal_byte();
/*  61 */     this.curyuanbao = _os_.unmarshal_long();
/*  62 */     this.needyuanbao = _os_.unmarshal_long();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CFlushNewReq)) {
/*  72 */       CFlushNewReq _o_ = (CFlushNewReq)_o1_;
/*  73 */       if (this.useyuanbao != _o_.useyuanbao) return false;
/*  74 */       if (this.curyuanbao != _o_.curyuanbao) return false;
/*  75 */       if (this.needyuanbao != _o_.needyuanbao) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.useyuanbao;
/*  84 */     _h_ += (int)this.curyuanbao;
/*  85 */     _h_ += (int)this.needyuanbao;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.useyuanbao).append(",");
/*  93 */     _sb_.append(this.curyuanbao).append(",");
/*  94 */     _sb_.append(this.needyuanbao).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CFlushNewReq _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.useyuanbao - _o_.useyuanbao;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = Long.signum(this.curyuanbao - _o_.curyuanbao);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.needyuanbao - _o_.needyuanbao);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\CFlushNewReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */