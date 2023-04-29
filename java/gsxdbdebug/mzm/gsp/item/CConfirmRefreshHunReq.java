/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PConfirmRefreshHunReq;
/*     */ 
/*     */ public class CConfirmRefreshHunReq extends __CConfirmRefreshHunReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584819;
/*     */   public int bagid;
/*     */   public long uuid;
/*     */   public byte isreplace;
/*     */   
/*     */   protected void process()
/*     */   {
/*  17 */     long roleid = Role.getRoleId(this);
/*  18 */     Role.addRoleProcedure(roleid, new PConfirmRefreshHunReq(roleid, this.bagid, this.uuid, this.isreplace == 1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  26 */     return 12584819;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CConfirmRefreshHunReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CConfirmRefreshHunReq(int _bagid_, long _uuid_, byte _isreplace_)
/*     */   {
/*  37 */     this.bagid = _bagid_;
/*  38 */     this.uuid = _uuid_;
/*  39 */     this.isreplace = _isreplace_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  43 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  47 */     _os_.marshal(this.bagid);
/*  48 */     _os_.marshal(this.uuid);
/*  49 */     _os_.marshal(this.isreplace);
/*  50 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  54 */     this.bagid = _os_.unmarshal_int();
/*  55 */     this.uuid = _os_.unmarshal_long();
/*  56 */     this.isreplace = _os_.unmarshal_byte();
/*  57 */     if (!_validator_()) {
/*  58 */       throw new VerifyError("validator failed");
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  64 */     if (_o1_ == this) return true;
/*  65 */     if ((_o1_ instanceof CConfirmRefreshHunReq)) {
/*  66 */       CConfirmRefreshHunReq _o_ = (CConfirmRefreshHunReq)_o1_;
/*  67 */       if (this.bagid != _o_.bagid) return false;
/*  68 */       if (this.uuid != _o_.uuid) return false;
/*  69 */       if (this.isreplace != _o_.isreplace) return false;
/*  70 */       return true;
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  76 */     int _h_ = 0;
/*  77 */     _h_ += this.bagid;
/*  78 */     _h_ += (int)this.uuid;
/*  79 */     _h_ += this.isreplace;
/*  80 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  84 */     StringBuilder _sb_ = new StringBuilder();
/*  85 */     _sb_.append("(");
/*  86 */     _sb_.append(this.bagid).append(",");
/*  87 */     _sb_.append(this.uuid).append(",");
/*  88 */     _sb_.append(this.isreplace).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CConfirmRefreshHunReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.bagid - _o_.bagid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.isreplace - _o_.isreplace;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CConfirmRefreshHunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */