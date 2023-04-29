/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.market.search.PSearchPetReq;
/*     */ 
/*     */ 
/*     */ public class CSearchPetReq
/*     */   extends __CSearchPetReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601413;
/*     */   public PetCondition condition;
/*     */   public int puborsell;
/*     */   public int pricesort;
/*     */   public int pageindex;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PSearchPetReq(roleId, this.condition, this.puborsell, this.pricesort, this.pageindex));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12601413;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSearchPetReq()
/*     */   {
/*  41 */     this.condition = new PetCondition();
/*     */   }
/*     */   
/*     */   public CSearchPetReq(PetCondition _condition_, int _puborsell_, int _pricesort_, int _pageindex_) {
/*  45 */     this.condition = _condition_;
/*  46 */     this.puborsell = _puborsell_;
/*  47 */     this.pricesort = _pricesort_;
/*  48 */     this.pageindex = _pageindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     if (!this.condition._validator_()) return false;
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.condition);
/*  58 */     _os_.marshal(this.puborsell);
/*  59 */     _os_.marshal(this.pricesort);
/*  60 */     _os_.marshal(this.pageindex);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.condition.unmarshal(_os_);
/*  66 */     this.puborsell = _os_.unmarshal_int();
/*  67 */     this.pricesort = _os_.unmarshal_int();
/*  68 */     this.pageindex = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof CSearchPetReq)) {
/*  78 */       CSearchPetReq _o_ = (CSearchPetReq)_o1_;
/*  79 */       if (!this.condition.equals(_o_.condition)) return false;
/*  80 */       if (this.puborsell != _o_.puborsell) return false;
/*  81 */       if (this.pricesort != _o_.pricesort) return false;
/*  82 */       if (this.pageindex != _o_.pageindex) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.condition.hashCode();
/*  91 */     _h_ += this.puborsell;
/*  92 */     _h_ += this.pricesort;
/*  93 */     _h_ += this.pageindex;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.condition).append(",");
/* 101 */     _sb_.append(this.puborsell).append(",");
/* 102 */     _sb_.append(this.pricesort).append(",");
/* 103 */     _sb_.append(this.pageindex).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CSearchPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */