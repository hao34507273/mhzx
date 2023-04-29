/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.market.main.PQueryPetInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CQueryPetInfoReq
/*     */   extends __CQueryPetInfoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601357;
/*     */   public long marketid;
/*     */   public int petcfgid;
/*     */   public int price;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PQueryPetInfo(roleId, this.marketid, this.petcfgid, this.price));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12601357;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CQueryPetInfoReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CQueryPetInfoReq(long _marketid_, int _petcfgid_, int _price_)
/*     */   {
/*  44 */     this.marketid = _marketid_;
/*  45 */     this.petcfgid = _petcfgid_;
/*  46 */     this.price = _price_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.marketid);
/*  55 */     _os_.marshal(this.petcfgid);
/*  56 */     _os_.marshal(this.price);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.marketid = _os_.unmarshal_long();
/*  62 */     this.petcfgid = _os_.unmarshal_int();
/*  63 */     this.price = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CQueryPetInfoReq)) {
/*  73 */       CQueryPetInfoReq _o_ = (CQueryPetInfoReq)_o1_;
/*  74 */       if (this.marketid != _o_.marketid) return false;
/*  75 */       if (this.petcfgid != _o_.petcfgid) return false;
/*  76 */       if (this.price != _o_.price) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += (int)this.marketid;
/*  85 */     _h_ += this.petcfgid;
/*  86 */     _h_ += this.price;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.marketid).append(",");
/*  94 */     _sb_.append(this.petcfgid).append(",");
/*  95 */     _sb_.append(this.price).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CQueryPetInfoReq _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.petcfgid - _o_.petcfgid;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.price - _o_.price;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CQueryPetInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */