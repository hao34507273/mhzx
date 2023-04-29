/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.market.main.PQueryMarketPubPetByPage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CQueryMarketPublicPet
/*     */   extends __CQueryMarketPublicPet__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601389;
/*     */   public int subid;
/*     */   public int pricesort;
/*     */   public int pageindex;
/*     */   
/*     */   protected void process()
/*     */   {
/*  21 */     long roleId = Role.getRoleId(this);
/*  22 */     if (roleId < 0L)
/*     */     {
/*  24 */       return;
/*     */     }
/*  26 */     Role.addRoleProcedure(roleId, new PQueryMarketPubPetByPage(roleId, this.subid, this.pricesort, this.pageindex));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  36 */     return 12601389;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CQueryMarketPublicPet() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CQueryMarketPublicPet(int _subid_, int _pricesort_, int _pageindex_)
/*     */   {
/*  47 */     this.subid = _subid_;
/*  48 */     this.pricesort = _pricesort_;
/*  49 */     this.pageindex = _pageindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.subid);
/*  58 */     _os_.marshal(this.pricesort);
/*  59 */     _os_.marshal(this.pageindex);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.subid = _os_.unmarshal_int();
/*  65 */     this.pricesort = _os_.unmarshal_int();
/*  66 */     this.pageindex = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CQueryMarketPublicPet)) {
/*  76 */       CQueryMarketPublicPet _o_ = (CQueryMarketPublicPet)_o1_;
/*  77 */       if (this.subid != _o_.subid) return false;
/*  78 */       if (this.pricesort != _o_.pricesort) return false;
/*  79 */       if (this.pageindex != _o_.pageindex) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.subid;
/*  88 */     _h_ += this.pricesort;
/*  89 */     _h_ += this.pageindex;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.subid).append(",");
/*  97 */     _sb_.append(this.pricesort).append(",");
/*  98 */     _sb_.append(this.pageindex).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CQueryMarketPublicPet _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.subid - _o_.subid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.pricesort - _o_.pricesort;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.pageindex - _o_.pageindex;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CQueryMarketPublicPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */