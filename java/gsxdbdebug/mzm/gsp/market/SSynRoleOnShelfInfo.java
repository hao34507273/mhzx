/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynRoleOnShelfInfo
/*     */   extends __SSynRoleOnShelfInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601354;
/*     */   public ArrayList<MarketItem> marketitemlist;
/*     */   public ArrayList<MarketPet> marketpetlist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12601354;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynRoleOnShelfInfo()
/*     */   {
/*  32 */     this.marketitemlist = new ArrayList();
/*  33 */     this.marketpetlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynRoleOnShelfInfo(ArrayList<MarketItem> _marketitemlist_, ArrayList<MarketPet> _marketpetlist_) {
/*  37 */     this.marketitemlist = _marketitemlist_;
/*  38 */     this.marketpetlist = _marketpetlist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     for (MarketItem _v_ : this.marketitemlist)
/*  43 */       if (!_v_._validator_()) return false;
/*  44 */     for (MarketPet _v_ : this.marketpetlist)
/*  45 */       if (!_v_._validator_()) return false;
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.compact_uint32(this.marketitemlist.size());
/*  51 */     for (MarketItem _v_ : this.marketitemlist) {
/*  52 */       _os_.marshal(_v_);
/*     */     }
/*  54 */     _os_.compact_uint32(this.marketpetlist.size());
/*  55 */     for (MarketPet _v_ : this.marketpetlist) {
/*  56 */       _os_.marshal(_v_);
/*     */     }
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  63 */       MarketItem _v_ = new MarketItem();
/*  64 */       _v_.unmarshal(_os_);
/*  65 */       this.marketitemlist.add(_v_);
/*     */     }
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  68 */       MarketPet _v_ = new MarketPet();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.marketpetlist.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SSynRoleOnShelfInfo)) {
/*  81 */       SSynRoleOnShelfInfo _o_ = (SSynRoleOnShelfInfo)_o1_;
/*  82 */       if (!this.marketitemlist.equals(_o_.marketitemlist)) return false;
/*  83 */       if (!this.marketpetlist.equals(_o_.marketpetlist)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.marketitemlist.hashCode();
/*  92 */     _h_ += this.marketpetlist.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.marketitemlist).append(",");
/* 100 */     _sb_.append(this.marketpetlist).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SSynRoleOnShelfInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */