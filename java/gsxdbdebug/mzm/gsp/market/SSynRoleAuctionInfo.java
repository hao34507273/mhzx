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
/*     */ 
/*     */ 
/*     */ public class SSynRoleAuctionInfo
/*     */   extends __SSynRoleAuctionInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601424;
/*     */   public ArrayList<AuctionItem> marketitemlist;
/*     */   public ArrayList<AuctionPet> marketpetlist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601424;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynRoleAuctionInfo()
/*     */   {
/*  34 */     this.marketitemlist = new ArrayList();
/*  35 */     this.marketpetlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynRoleAuctionInfo(ArrayList<AuctionItem> _marketitemlist_, ArrayList<AuctionPet> _marketpetlist_) {
/*  39 */     this.marketitemlist = _marketitemlist_;
/*  40 */     this.marketpetlist = _marketpetlist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     for (AuctionItem _v_ : this.marketitemlist)
/*  45 */       if (!_v_._validator_()) return false;
/*  46 */     for (AuctionPet _v_ : this.marketpetlist)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.compact_uint32(this.marketitemlist.size());
/*  53 */     for (AuctionItem _v_ : this.marketitemlist) {
/*  54 */       _os_.marshal(_v_);
/*     */     }
/*  56 */     _os_.compact_uint32(this.marketpetlist.size());
/*  57 */     for (AuctionPet _v_ : this.marketpetlist) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  65 */       AuctionItem _v_ = new AuctionItem();
/*  66 */       _v_.unmarshal(_os_);
/*  67 */       this.marketitemlist.add(_v_);
/*     */     }
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  70 */       AuctionPet _v_ = new AuctionPet();
/*  71 */       _v_.unmarshal(_os_);
/*  72 */       this.marketpetlist.add(_v_);
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SSynRoleAuctionInfo)) {
/*  83 */       SSynRoleAuctionInfo _o_ = (SSynRoleAuctionInfo)_o1_;
/*  84 */       if (!this.marketitemlist.equals(_o_.marketitemlist)) return false;
/*  85 */       if (!this.marketpetlist.equals(_o_.marketpetlist)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.marketitemlist.hashCode();
/*  94 */     _h_ += this.marketpetlist.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.marketitemlist).append(",");
/* 102 */     _sb_.append(this.marketpetlist).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SSynRoleAuctionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */