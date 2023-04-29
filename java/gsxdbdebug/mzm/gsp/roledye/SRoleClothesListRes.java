/*     */ package mzm.gsp.roledye;
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
/*     */ public class SRoleClothesListRes
/*     */   extends __SRoleClothesListRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12597250;
/*     */   public int curid;
/*     */   public int maxcount;
/*     */   public ArrayList<ColorIds> clotheslist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12597250;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SRoleClothesListRes()
/*     */   {
/*  35 */     this.clotheslist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SRoleClothesListRes(int _curid_, int _maxcount_, ArrayList<ColorIds> _clotheslist_) {
/*  39 */     this.curid = _curid_;
/*  40 */     this.maxcount = _maxcount_;
/*  41 */     this.clotheslist = _clotheslist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (ColorIds _v_ : this.clotheslist)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.curid);
/*  52 */     _os_.marshal(this.maxcount);
/*  53 */     _os_.compact_uint32(this.clotheslist.size());
/*  54 */     for (ColorIds _v_ : this.clotheslist) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.curid = _os_.unmarshal_int();
/*  62 */     this.maxcount = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       ColorIds _v_ = new ColorIds();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.clotheslist.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SRoleClothesListRes)) {
/*  77 */       SRoleClothesListRes _o_ = (SRoleClothesListRes)_o1_;
/*  78 */       if (this.curid != _o_.curid) return false;
/*  79 */       if (this.maxcount != _o_.maxcount) return false;
/*  80 */       if (!this.clotheslist.equals(_o_.clotheslist)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.curid;
/*  89 */     _h_ += this.maxcount;
/*  90 */     _h_ += this.clotheslist.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.curid).append(",");
/*  98 */     _sb_.append(this.maxcount).append(",");
/*  99 */     _sb_.append(this.clotheslist).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\SRoleClothesListRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */