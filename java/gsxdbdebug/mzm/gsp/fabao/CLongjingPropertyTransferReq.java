/*     */ package mzm.gsp.fabao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.fabao.main.PLongjingPropertyTransferReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CLongjingPropertyTransferReq
/*     */   extends __CLongjingPropertyTransferReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596034;
/*     */   public long totransferitemuuid;
/*     */   public int targetproperty;
/*     */   public int targetitemid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PLongjingPropertyTransferReq(roleid, this.totransferitemuuid, this.targetproperty, this.targetitemid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12596034;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CLongjingPropertyTransferReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CLongjingPropertyTransferReq(long _totransferitemuuid_, int _targetproperty_, int _targetitemid_)
/*     */   {
/*  40 */     this.totransferitemuuid = _totransferitemuuid_;
/*  41 */     this.targetproperty = _targetproperty_;
/*  42 */     this.targetitemid = _targetitemid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.totransferitemuuid);
/*  51 */     _os_.marshal(this.targetproperty);
/*  52 */     _os_.marshal(this.targetitemid);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.totransferitemuuid = _os_.unmarshal_long();
/*  58 */     this.targetproperty = _os_.unmarshal_int();
/*  59 */     this.targetitemid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CLongjingPropertyTransferReq)) {
/*  69 */       CLongjingPropertyTransferReq _o_ = (CLongjingPropertyTransferReq)_o1_;
/*  70 */       if (this.totransferitemuuid != _o_.totransferitemuuid) return false;
/*  71 */       if (this.targetproperty != _o_.targetproperty) return false;
/*  72 */       if (this.targetitemid != _o_.targetitemid) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += (int)this.totransferitemuuid;
/*  81 */     _h_ += this.targetproperty;
/*  82 */     _h_ += this.targetitemid;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.totransferitemuuid).append(",");
/*  90 */     _sb_.append(this.targetproperty).append(",");
/*  91 */     _sb_.append(this.targetitemid).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CLongjingPropertyTransferReq _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = Long.signum(this.totransferitemuuid - _o_.totransferitemuuid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.targetproperty - _o_.targetproperty;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.targetitemid - _o_.targetitemid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\CLongjingPropertyTransferReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */