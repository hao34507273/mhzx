/*     */ package mzm.gsp.shitu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.shitu.main.PCReceiveShiTuActiveRewardReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CReceiveShiTuActiveRewardReq
/*     */   extends __CReceiveShiTuActiveRewardReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601657;
/*     */   public long role_id;
/*     */   public int index_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCReceiveShiTuActiveRewardReq(roleId, this.role_id, this.index_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12601657;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CReceiveShiTuActiveRewardReq() {}
/*     */   
/*     */ 
/*     */   public CReceiveShiTuActiveRewardReq(long _role_id_, int _index_id_)
/*     */   {
/*  43 */     this.role_id = _role_id_;
/*  44 */     this.index_id = _index_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.role_id);
/*  53 */     _os_.marshal(this.index_id);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.role_id = _os_.unmarshal_long();
/*  59 */     this.index_id = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CReceiveShiTuActiveRewardReq)) {
/*  69 */       CReceiveShiTuActiveRewardReq _o_ = (CReceiveShiTuActiveRewardReq)_o1_;
/*  70 */       if (this.role_id != _o_.role_id) return false;
/*  71 */       if (this.index_id != _o_.index_id) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.role_id;
/*  80 */     _h_ += this.index_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.role_id).append(",");
/*  88 */     _sb_.append(this.index_id).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReceiveShiTuActiveRewardReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.index_id - _o_.index_id;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\CReceiveShiTuActiveRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */