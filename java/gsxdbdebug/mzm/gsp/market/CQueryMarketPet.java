/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.market.main.PQueryMarketPetByPage;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CQueryMarketPet
/*     */   extends __CQueryMarketPet__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601366;
/*     */   public int subid;
/*     */   public int pricesort;
/*     */   public int pageindex;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PQueryMarketPetByPage(roleId, this.subid, this.pricesort, this.pageindex));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12601366;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CQueryMarketPet() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CQueryMarketPet(int _subid_, int _pricesort_, int _pageindex_)
/*     */   {
/*  44 */     this.subid = _subid_;
/*  45 */     this.pricesort = _pricesort_;
/*  46 */     this.pageindex = _pageindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.subid);
/*  55 */     _os_.marshal(this.pricesort);
/*  56 */     _os_.marshal(this.pageindex);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.subid = _os_.unmarshal_int();
/*  62 */     this.pricesort = _os_.unmarshal_int();
/*  63 */     this.pageindex = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CQueryMarketPet)) {
/*  73 */       CQueryMarketPet _o_ = (CQueryMarketPet)_o1_;
/*  74 */       if (this.subid != _o_.subid) return false;
/*  75 */       if (this.pricesort != _o_.pricesort) return false;
/*  76 */       if (this.pageindex != _o_.pageindex) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.subid;
/*  85 */     _h_ += this.pricesort;
/*  86 */     _h_ += this.pageindex;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.subid).append(",");
/*  94 */     _sb_.append(this.pricesort).append(",");
/*  95 */     _sb_.append(this.pageindex).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CQueryMarketPet _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.subid - _o_.subid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.pricesort - _o_.pricesort;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.pageindex - _o_.pageindex;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CQueryMarketPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */