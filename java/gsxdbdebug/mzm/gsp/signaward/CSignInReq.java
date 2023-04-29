/*     */ package mzm.gsp.signaward;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.signaward.main.PSignIn;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CSignInReq
/*     */   extends __CSignInReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12593416;
/*     */   public int signday;
/*     */   public long current_yuan_bao_num;
/*     */   public int is_use_yuan_bao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PSignIn(roleid, this.signday, this.current_yuan_bao_num, this.is_use_yuan_bao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12593416;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CSignInReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CSignInReq(int _signday_, long _current_yuan_bao_num_, int _is_use_yuan_bao_)
/*     */   {
/*  41 */     this.signday = _signday_;
/*  42 */     this.current_yuan_bao_num = _current_yuan_bao_num_;
/*  43 */     this.is_use_yuan_bao = _is_use_yuan_bao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.signday);
/*  52 */     _os_.marshal(this.current_yuan_bao_num);
/*  53 */     _os_.marshal(this.is_use_yuan_bao);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.signday = _os_.unmarshal_int();
/*  59 */     this.current_yuan_bao_num = _os_.unmarshal_long();
/*  60 */     this.is_use_yuan_bao = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CSignInReq)) {
/*  70 */       CSignInReq _o_ = (CSignInReq)_o1_;
/*  71 */       if (this.signday != _o_.signday) return false;
/*  72 */       if (this.current_yuan_bao_num != _o_.current_yuan_bao_num) return false;
/*  73 */       if (this.is_use_yuan_bao != _o_.is_use_yuan_bao) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.signday;
/*  82 */     _h_ += (int)this.current_yuan_bao_num;
/*  83 */     _h_ += this.is_use_yuan_bao;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.signday).append(",");
/*  91 */     _sb_.append(this.current_yuan_bao_num).append(",");
/*  92 */     _sb_.append(this.is_use_yuan_bao).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSignInReq _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.signday - _o_.signday;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = Long.signum(this.current_yuan_bao_num - _o_.current_yuan_bao_num);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.is_use_yuan_bao - _o_.is_use_yuan_bao;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\CSignInReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */