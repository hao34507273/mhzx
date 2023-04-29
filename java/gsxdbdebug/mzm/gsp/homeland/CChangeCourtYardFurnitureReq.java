/*     */ package mzm.gsp.homeland;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.homeland.main.PCChangeCourtYardFurnitureReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CChangeCourtYardFurnitureReq
/*     */   extends __CChangeCourtYardFurnitureReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605510;
/*     */   public int furniture_cfg_id;
/*     */   public long furniture_uuid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCChangeCourtYardFurnitureReq(roleId, this.furniture_cfg_id, this.furniture_uuid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12605510;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CChangeCourtYardFurnitureReq() {}
/*     */   
/*     */ 
/*     */   public CChangeCourtYardFurnitureReq(int _furniture_cfg_id_, long _furniture_uuid_)
/*     */   {
/*  43 */     this.furniture_cfg_id = _furniture_cfg_id_;
/*  44 */     this.furniture_uuid = _furniture_uuid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.furniture_cfg_id);
/*  53 */     _os_.marshal(this.furniture_uuid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.furniture_cfg_id = _os_.unmarshal_int();
/*  59 */     this.furniture_uuid = _os_.unmarshal_long();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CChangeCourtYardFurnitureReq)) {
/*  69 */       CChangeCourtYardFurnitureReq _o_ = (CChangeCourtYardFurnitureReq)_o1_;
/*  70 */       if (this.furniture_cfg_id != _o_.furniture_cfg_id) return false;
/*  71 */       if (this.furniture_uuid != _o_.furniture_uuid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.furniture_cfg_id;
/*  80 */     _h_ += (int)this.furniture_uuid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.furniture_cfg_id).append(",");
/*  88 */     _sb_.append(this.furniture_uuid).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CChangeCourtYardFurnitureReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.furniture_cfg_id - _o_.furniture_cfg_id;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = Long.signum(this.furniture_uuid - _o_.furniture_uuid);
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\CChangeCourtYardFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */