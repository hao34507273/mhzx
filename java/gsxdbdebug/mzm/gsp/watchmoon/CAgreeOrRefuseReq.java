/*     */ package mzm.gsp.watchmoon;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.watchmoon.main.PHandleWatchmoonInvite;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CAgreeOrRefuseReq
/*     */   extends __CAgreeOrRefuseReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600839;
/*     */   public long roleid1;
/*     */   public int result;
/*     */   public long invitetime;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long inviteeRoleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(inviteeRoleid, new PHandleWatchmoonInvite(this.roleid1, inviteeRoleid, this.result, this.invitetime));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12600839;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CAgreeOrRefuseReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CAgreeOrRefuseReq(long _roleid1_, int _result_, long _invitetime_)
/*     */   {
/*  41 */     this.roleid1 = _roleid1_;
/*  42 */     this.result = _result_;
/*  43 */     this.invitetime = _invitetime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.roleid1);
/*  52 */     _os_.marshal(this.result);
/*  53 */     _os_.marshal(this.invitetime);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.roleid1 = _os_.unmarshal_long();
/*  59 */     this.result = _os_.unmarshal_int();
/*  60 */     this.invitetime = _os_.unmarshal_long();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CAgreeOrRefuseReq)) {
/*  70 */       CAgreeOrRefuseReq _o_ = (CAgreeOrRefuseReq)_o1_;
/*  71 */       if (this.roleid1 != _o_.roleid1) return false;
/*  72 */       if (this.result != _o_.result) return false;
/*  73 */       if (this.invitetime != _o_.invitetime) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.roleid1;
/*  82 */     _h_ += this.result;
/*  83 */     _h_ += (int)this.invitetime;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.roleid1).append(",");
/*  91 */     _sb_.append(this.result).append(",");
/*  92 */     _sb_.append(this.invitetime).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAgreeOrRefuseReq _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = Long.signum(this.roleid1 - _o_.roleid1);
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.result - _o_.result;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = Long.signum(this.invitetime - _o_.invitetime);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\CAgreeOrRefuseReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */