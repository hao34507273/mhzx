/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.market.search.PSearchPetEquipReq;
/*     */ 
/*     */ 
/*     */ public class CSearchPetEquipReq
/*     */   extends __CSearchPetEquipReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601407;
/*     */   public PetEquipCondition condition;
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
/*  24 */     Role.addRoleProcedure(roleId, new PSearchPetEquipReq(roleId, this.condition, this.puborsell, this.pricesort, this.pageindex));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12601407;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSearchPetEquipReq()
/*     */   {
/*  42 */     this.condition = new PetEquipCondition();
/*     */   }
/*     */   
/*     */   public CSearchPetEquipReq(PetEquipCondition _condition_, int _puborsell_, int _pricesort_, int _pageindex_) {
/*  46 */     this.condition = _condition_;
/*  47 */     this.puborsell = _puborsell_;
/*  48 */     this.pricesort = _pricesort_;
/*  49 */     this.pageindex = _pageindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     if (!this.condition._validator_()) return false;
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.condition);
/*  59 */     _os_.marshal(this.puborsell);
/*  60 */     _os_.marshal(this.pricesort);
/*  61 */     _os_.marshal(this.pageindex);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.condition.unmarshal(_os_);
/*  67 */     this.puborsell = _os_.unmarshal_int();
/*  68 */     this.pricesort = _os_.unmarshal_int();
/*  69 */     this.pageindex = _os_.unmarshal_int();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof CSearchPetEquipReq)) {
/*  79 */       CSearchPetEquipReq _o_ = (CSearchPetEquipReq)_o1_;
/*  80 */       if (!this.condition.equals(_o_.condition)) return false;
/*  81 */       if (this.puborsell != _o_.puborsell) return false;
/*  82 */       if (this.pricesort != _o_.pricesort) return false;
/*  83 */       if (this.pageindex != _o_.pageindex) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.condition.hashCode();
/*  92 */     _h_ += this.puborsell;
/*  93 */     _h_ += this.pricesort;
/*  94 */     _h_ += this.pageindex;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.condition).append(",");
/* 102 */     _sb_.append(this.puborsell).append(",");
/* 103 */     _sb_.append(this.pricesort).append(",");
/* 104 */     _sb_.append(this.pageindex).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CSearchPetEquipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */