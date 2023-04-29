/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class WingInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int exp;
/*     */   public int level;
/*     */   public int phase;
/*     */   public ArrayList<WingProperty> propertylist;
/*     */   public ArrayList<WingSkill> skilllist;
/*     */   public ModelId2DyeId modelid2dyeid;
/*     */   
/*     */   public WingInfo()
/*     */   {
/*  17 */     this.propertylist = new ArrayList();
/*  18 */     this.skilllist = new ArrayList();
/*  19 */     this.modelid2dyeid = new ModelId2DyeId();
/*     */   }
/*     */   
/*     */   public WingInfo(int _exp_, int _level_, int _phase_, ArrayList<WingProperty> _propertylist_, ArrayList<WingSkill> _skilllist_, ModelId2DyeId _modelid2dyeid_) {
/*  23 */     this.exp = _exp_;
/*  24 */     this.level = _level_;
/*  25 */     this.phase = _phase_;
/*  26 */     this.propertylist = _propertylist_;
/*  27 */     this.skilllist = _skilllist_;
/*  28 */     this.modelid2dyeid = _modelid2dyeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  32 */     for (WingProperty _v_ : this.propertylist)
/*  33 */       if (!_v_._validator_()) return false;
/*  34 */     for (WingSkill _v_ : this.skilllist)
/*  35 */       if (!_v_._validator_()) return false;
/*  36 */     if (!this.modelid2dyeid._validator_()) return false;
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  41 */     _os_.marshal(this.exp);
/*  42 */     _os_.marshal(this.level);
/*  43 */     _os_.marshal(this.phase);
/*  44 */     _os_.compact_uint32(this.propertylist.size());
/*  45 */     for (WingProperty _v_ : this.propertylist) {
/*  46 */       _os_.marshal(_v_);
/*     */     }
/*  48 */     _os_.compact_uint32(this.skilllist.size());
/*  49 */     for (WingSkill _v_ : this.skilllist) {
/*  50 */       _os_.marshal(_v_);
/*     */     }
/*  52 */     _os_.marshal(this.modelid2dyeid);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  57 */     this.exp = _os_.unmarshal_int();
/*  58 */     this.level = _os_.unmarshal_int();
/*  59 */     this.phase = _os_.unmarshal_int();
/*  60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  61 */       WingProperty _v_ = new WingProperty();
/*  62 */       _v_.unmarshal(_os_);
/*  63 */       this.propertylist.add(_v_);
/*     */     }
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  66 */       WingSkill _v_ = new WingSkill();
/*  67 */       _v_.unmarshal(_os_);
/*  68 */       this.skilllist.add(_v_);
/*     */     }
/*  70 */     this.modelid2dyeid.unmarshal(_os_);
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof WingInfo)) {
/*  77 */       WingInfo _o_ = (WingInfo)_o1_;
/*  78 */       if (this.exp != _o_.exp) return false;
/*  79 */       if (this.level != _o_.level) return false;
/*  80 */       if (this.phase != _o_.phase) return false;
/*  81 */       if (!this.propertylist.equals(_o_.propertylist)) return false;
/*  82 */       if (!this.skilllist.equals(_o_.skilllist)) return false;
/*  83 */       if (!this.modelid2dyeid.equals(_o_.modelid2dyeid)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.exp;
/*  92 */     _h_ += this.level;
/*  93 */     _h_ += this.phase;
/*  94 */     _h_ += this.propertylist.hashCode();
/*  95 */     _h_ += this.skilllist.hashCode();
/*  96 */     _h_ += this.modelid2dyeid.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.exp).append(",");
/* 104 */     _sb_.append(this.level).append(",");
/* 105 */     _sb_.append(this.phase).append(",");
/* 106 */     _sb_.append(this.propertylist).append(",");
/* 107 */     _sb_.append(this.skilllist).append(",");
/* 108 */     _sb_.append(this.modelid2dyeid).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\WingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */