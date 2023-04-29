/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.market.main.PGetSellPetReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CGetSellPetReq
/*     */   extends __CGetSellPetReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601364;
/*     */   public long marketid;
/*     */   public int petcfgid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PGetSellPetReq(roleId, this.marketid, this.petcfgid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12601364;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetSellPetReq() {}
/*     */   
/*     */ 
/*     */   public CGetSellPetReq(long _marketid_, int _petcfgid_)
/*     */   {
/*  43 */     this.marketid = _marketid_;
/*  44 */     this.petcfgid = _petcfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.marketid);
/*  53 */     _os_.marshal(this.petcfgid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.marketid = _os_.unmarshal_long();
/*  59 */     this.petcfgid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CGetSellPetReq)) {
/*  69 */       CGetSellPetReq _o_ = (CGetSellPetReq)_o1_;
/*  70 */       if (this.marketid != _o_.marketid) return false;
/*  71 */       if (this.petcfgid != _o_.petcfgid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.marketid;
/*  80 */     _h_ += this.petcfgid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.marketid).append(",");
/*  88 */     _sb_.append(this.petcfgid).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetSellPetReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.petcfgid - _o_.petcfgid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CGetSellPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */