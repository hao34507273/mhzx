/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.map.main.PTransformMapReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CTransferMapReq
/*     */   extends __CTransferMapReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590854;
/*     */   public int mapid;
/*     */   public Location targetpos;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     new PTransformMapReq(roleId, this.mapid, this.targetpos.x, this.targetpos.y).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12590854;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CTransferMapReq()
/*     */   {
/*  38 */     this.targetpos = new Location();
/*     */   }
/*     */   
/*     */   public CTransferMapReq(int _mapid_, Location _targetpos_) {
/*  42 */     this.mapid = _mapid_;
/*  43 */     this.targetpos = _targetpos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.targetpos._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.mapid);
/*  53 */     _os_.marshal(this.targetpos);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.mapid = _os_.unmarshal_int();
/*  59 */     this.targetpos.unmarshal(_os_);
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CTransferMapReq)) {
/*  69 */       CTransferMapReq _o_ = (CTransferMapReq)_o1_;
/*  70 */       if (this.mapid != _o_.mapid) return false;
/*  71 */       if (!this.targetpos.equals(_o_.targetpos)) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.mapid;
/*  80 */     _h_ += this.targetpos.hashCode();
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.mapid).append(",");
/*  88 */     _sb_.append(this.targetpos).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CTransferMapReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.mapid - _o_.mapid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.targetpos.compareTo(_o_.targetpos);
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\CTransferMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */