/*     */ package mzm.gsp.christmasstocking;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.christmasstocking.main.PCHangStockingReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CHangStockingReq
/*     */   extends __CHangStockingReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12629512;
/*     */   public long target_role_id;
/*     */   public int position;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId <= 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCHangStockingReq(roleId, this.target_role_id, this.position));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12629512;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CHangStockingReq() {}
/*     */   
/*     */ 
/*     */   public CHangStockingReq(long _target_role_id_, int _position_)
/*     */   {
/*  43 */     this.target_role_id = _target_role_id_;
/*  44 */     this.position = _position_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.target_role_id);
/*  53 */     _os_.marshal(this.position);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.target_role_id = _os_.unmarshal_long();
/*  59 */     this.position = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CHangStockingReq)) {
/*  69 */       CHangStockingReq _o_ = (CHangStockingReq)_o1_;
/*  70 */       if (this.target_role_id != _o_.target_role_id) return false;
/*  71 */       if (this.position != _o_.position) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.target_role_id;
/*  80 */     _h_ += this.position;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.target_role_id).append(",");
/*  88 */     _sb_.append(this.position).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CHangStockingReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.target_role_id - _o_.target_role_id);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.position - _o_.position;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\CHangStockingReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */