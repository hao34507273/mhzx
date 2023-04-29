/*     */ package mzm.gsp.shitu;
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
/*     */ public class SGetClassMateApprenticeInfo
/*     */   extends __SGetClassMateApprenticeInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601625;
/*     */   public ArrayList<ShiTuRoleInfo> chushiclassmatelistinfo;
/*     */   public ArrayList<ShiTuRoleInfo> nowclassmatelistinfo;
/*     */   public int classmatesize;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601625;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetClassMateApprenticeInfo()
/*     */   {
/*  35 */     this.chushiclassmatelistinfo = new ArrayList();
/*  36 */     this.nowclassmatelistinfo = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetClassMateApprenticeInfo(ArrayList<ShiTuRoleInfo> _chushiclassmatelistinfo_, ArrayList<ShiTuRoleInfo> _nowclassmatelistinfo_, int _classmatesize_) {
/*  40 */     this.chushiclassmatelistinfo = _chushiclassmatelistinfo_;
/*  41 */     this.nowclassmatelistinfo = _nowclassmatelistinfo_;
/*  42 */     this.classmatesize = _classmatesize_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (ShiTuRoleInfo _v_ : this.chushiclassmatelistinfo)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     for (ShiTuRoleInfo _v_ : this.nowclassmatelistinfo)
/*  49 */       if (!_v_._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.compact_uint32(this.chushiclassmatelistinfo.size());
/*  55 */     for (ShiTuRoleInfo _v_ : this.chushiclassmatelistinfo) {
/*  56 */       _os_.marshal(_v_);
/*     */     }
/*  58 */     _os_.compact_uint32(this.nowclassmatelistinfo.size());
/*  59 */     for (ShiTuRoleInfo _v_ : this.nowclassmatelistinfo) {
/*  60 */       _os_.marshal(_v_);
/*     */     }
/*  62 */     _os_.marshal(this.classmatesize);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  68 */       ShiTuRoleInfo _v_ = new ShiTuRoleInfo();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.chushiclassmatelistinfo.add(_v_);
/*     */     }
/*  72 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  73 */       ShiTuRoleInfo _v_ = new ShiTuRoleInfo();
/*  74 */       _v_.unmarshal(_os_);
/*  75 */       this.nowclassmatelistinfo.add(_v_);
/*     */     }
/*  77 */     this.classmatesize = _os_.unmarshal_int();
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SGetClassMateApprenticeInfo)) {
/*  87 */       SGetClassMateApprenticeInfo _o_ = (SGetClassMateApprenticeInfo)_o1_;
/*  88 */       if (!this.chushiclassmatelistinfo.equals(_o_.chushiclassmatelistinfo)) return false;
/*  89 */       if (!this.nowclassmatelistinfo.equals(_o_.nowclassmatelistinfo)) return false;
/*  90 */       if (this.classmatesize != _o_.classmatesize) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.chushiclassmatelistinfo.hashCode();
/*  99 */     _h_ += this.nowclassmatelistinfo.hashCode();
/* 100 */     _h_ += this.classmatesize;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.chushiclassmatelistinfo).append(",");
/* 108 */     _sb_.append(this.nowclassmatelistinfo).append(",");
/* 109 */     _sb_.append(this.classmatesize).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SGetClassMateApprenticeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */