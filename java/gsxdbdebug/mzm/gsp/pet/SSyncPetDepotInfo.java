/*     */ package mzm.gsp.pet;
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
/*     */ public class SSyncPetDepotInfo
/*     */   extends __SSyncPetDepotInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590623;
/*     */   public int depotsize;
/*     */   public ArrayList<PetInfo> petlist;
/*     */   public int expandcount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590623;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncPetDepotInfo()
/*     */   {
/*  35 */     this.petlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncPetDepotInfo(int _depotsize_, ArrayList<PetInfo> _petlist_, int _expandcount_) {
/*  39 */     this.depotsize = _depotsize_;
/*  40 */     this.petlist = _petlist_;
/*  41 */     this.expandcount = _expandcount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (PetInfo _v_ : this.petlist)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.depotsize);
/*  52 */     _os_.compact_uint32(this.petlist.size());
/*  53 */     for (PetInfo _v_ : this.petlist) {
/*  54 */       _os_.marshal(_v_);
/*     */     }
/*  56 */     _os_.marshal(this.expandcount);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.depotsize = _os_.unmarshal_int();
/*  62 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  63 */       PetInfo _v_ = new PetInfo();
/*  64 */       _v_.unmarshal(_os_);
/*  65 */       this.petlist.add(_v_);
/*     */     }
/*  67 */     this.expandcount = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SSyncPetDepotInfo)) {
/*  77 */       SSyncPetDepotInfo _o_ = (SSyncPetDepotInfo)_o1_;
/*  78 */       if (this.depotsize != _o_.depotsize) return false;
/*  79 */       if (!this.petlist.equals(_o_.petlist)) return false;
/*  80 */       if (this.expandcount != _o_.expandcount) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.depotsize;
/*  89 */     _h_ += this.petlist.hashCode();
/*  90 */     _h_ += this.expandcount;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.depotsize).append(",");
/*  98 */     _sb_.append(this.petlist).append(",");
/*  99 */     _sb_.append(this.expandcount).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SSyncPetDepotInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */