/*     */ package mzm.gsp.homeland;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.homeland.main.PCRecycleFurnitureReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CRecycleFurnitureReq
/*     */   extends __CRecycleFurnitureReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605518;
/*     */   public long furnitureuuid;
/*     */   public int furnitureid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCRecycleFurnitureReq(roleId, this.furnitureid, this.furnitureuuid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12605518;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CRecycleFurnitureReq() {}
/*     */   
/*     */ 
/*     */   public CRecycleFurnitureReq(long _furnitureuuid_, int _furnitureid_)
/*     */   {
/*  43 */     this.furnitureuuid = _furnitureuuid_;
/*  44 */     this.furnitureid = _furnitureid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.furnitureuuid);
/*  53 */     _os_.marshal(this.furnitureid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.furnitureuuid = _os_.unmarshal_long();
/*  59 */     this.furnitureid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CRecycleFurnitureReq)) {
/*  69 */       CRecycleFurnitureReq _o_ = (CRecycleFurnitureReq)_o1_;
/*  70 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/*  71 */       if (this.furnitureid != _o_.furnitureid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.furnitureuuid;
/*  80 */     _h_ += this.furnitureid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.furnitureuuid).append(",");
/*  88 */     _sb_.append(this.furnitureid).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CRecycleFurnitureReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.furnitureid - _o_.furnitureid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\CRecycleFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */