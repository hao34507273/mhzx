/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ public class PetCondition implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int subid;
/*     */   public HashSet<Integer> qualitys;
/*     */   public HashSet<Integer> pettypes;
/*     */   public int skillnum;
/*     */   public HashSet<Integer> skillids;
/*     */   public long custtime;
/*     */   
/*     */   public PetCondition()
/*     */   {
/*  17 */     this.qualitys = new HashSet();
/*  18 */     this.pettypes = new HashSet();
/*  19 */     this.skillids = new HashSet();
/*     */   }
/*     */   
/*     */   public PetCondition(int _subid_, HashSet<Integer> _qualitys_, HashSet<Integer> _pettypes_, int _skillnum_, HashSet<Integer> _skillids_, long _custtime_) {
/*  23 */     this.subid = _subid_;
/*  24 */     this.qualitys = _qualitys_;
/*  25 */     this.pettypes = _pettypes_;
/*  26 */     this.skillnum = _skillnum_;
/*  27 */     this.skillids = _skillids_;
/*  28 */     this.custtime = _custtime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  32 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  36 */     _os_.marshal(this.subid);
/*  37 */     _os_.compact_uint32(this.qualitys.size());
/*  38 */     for (Integer _v_ : this.qualitys) {
/*  39 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  41 */     _os_.compact_uint32(this.pettypes.size());
/*  42 */     for (Integer _v_ : this.pettypes) {
/*  43 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  45 */     _os_.marshal(this.skillnum);
/*  46 */     _os_.compact_uint32(this.skillids.size());
/*  47 */     for (Integer _v_ : this.skillids) {
/*  48 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  50 */     _os_.marshal(this.custtime);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  55 */     this.subid = _os_.unmarshal_int();
/*  56 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  58 */       int _v_ = _os_.unmarshal_int();
/*  59 */       this.qualitys.add(Integer.valueOf(_v_));
/*     */     }
/*  61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  63 */       int _v_ = _os_.unmarshal_int();
/*  64 */       this.pettypes.add(Integer.valueOf(_v_));
/*     */     }
/*  66 */     this.skillnum = _os_.unmarshal_int();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  69 */       int _v_ = _os_.unmarshal_int();
/*  70 */       this.skillids.add(Integer.valueOf(_v_));
/*     */     }
/*  72 */     this.custtime = _os_.unmarshal_long();
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof PetCondition)) {
/*  79 */       PetCondition _o_ = (PetCondition)_o1_;
/*  80 */       if (this.subid != _o_.subid) return false;
/*  81 */       if (!this.qualitys.equals(_o_.qualitys)) return false;
/*  82 */       if (!this.pettypes.equals(_o_.pettypes)) return false;
/*  83 */       if (this.skillnum != _o_.skillnum) return false;
/*  84 */       if (!this.skillids.equals(_o_.skillids)) return false;
/*  85 */       if (this.custtime != _o_.custtime) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.subid;
/*  94 */     _h_ += this.qualitys.hashCode();
/*  95 */     _h_ += this.pettypes.hashCode();
/*  96 */     _h_ += this.skillnum;
/*  97 */     _h_ += this.skillids.hashCode();
/*  98 */     _h_ += (int)this.custtime;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.subid).append(",");
/* 106 */     _sb_.append(this.qualitys).append(",");
/* 107 */     _sb_.append(this.pettypes).append(",");
/* 108 */     _sb_.append(this.skillnum).append(",");
/* 109 */     _sb_.append(this.skillids).append(",");
/* 110 */     _sb_.append(this.custtime).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\PetCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */