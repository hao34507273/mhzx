/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class WingData implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int cfgid;
/*     */   public int colorid;
/*     */   public ArrayList<Integer> reproids;
/*     */   public ArrayList<Integer> reskillids;
/*     */   public ArrayList<Integer> proids;
/*     */   public ArrayList<Integer> skills;
/*     */   public HashMap<Integer, Integer> target_skills;
/*     */   
/*     */   public WingData()
/*     */   {
/*  20 */     this.reproids = new ArrayList();
/*  21 */     this.reskillids = new ArrayList();
/*  22 */     this.proids = new ArrayList();
/*  23 */     this.skills = new ArrayList();
/*  24 */     this.target_skills = new HashMap();
/*     */   }
/*     */   
/*     */   public WingData(int _cfgid_, int _colorid_, ArrayList<Integer> _reproids_, ArrayList<Integer> _reskillids_, ArrayList<Integer> _proids_, ArrayList<Integer> _skills_, HashMap<Integer, Integer> _target_skills_) {
/*  28 */     this.cfgid = _cfgid_;
/*  29 */     this.colorid = _colorid_;
/*  30 */     this.reproids = _reproids_;
/*  31 */     this.reskillids = _reskillids_;
/*  32 */     this.proids = _proids_;
/*  33 */     this.skills = _skills_;
/*  34 */     this.target_skills = _target_skills_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  42 */     _os_.marshal(this.cfgid);
/*  43 */     _os_.marshal(this.colorid);
/*  44 */     _os_.compact_uint32(this.reproids.size());
/*  45 */     for (Integer _v_ : this.reproids) {
/*  46 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  48 */     _os_.compact_uint32(this.reskillids.size());
/*  49 */     for (Integer _v_ : this.reskillids) {
/*  50 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  52 */     _os_.compact_uint32(this.proids.size());
/*  53 */     for (Integer _v_ : this.proids) {
/*  54 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  56 */     _os_.compact_uint32(this.skills.size());
/*  57 */     for (Integer _v_ : this.skills) {
/*  58 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  60 */     _os_.compact_uint32(this.target_skills.size());
/*  61 */     for (Map.Entry<Integer, Integer> _e_ : this.target_skills.entrySet()) {
/*  62 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  63 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  69 */     this.cfgid = _os_.unmarshal_int();
/*  70 */     this.colorid = _os_.unmarshal_int();
/*  71 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  73 */       int _v_ = _os_.unmarshal_int();
/*  74 */       this.reproids.add(Integer.valueOf(_v_));
/*     */     }
/*  76 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  78 */       int _v_ = _os_.unmarshal_int();
/*  79 */       this.reskillids.add(Integer.valueOf(_v_));
/*     */     }
/*  81 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  83 */       int _v_ = _os_.unmarshal_int();
/*  84 */       this.proids.add(Integer.valueOf(_v_));
/*     */     }
/*  86 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  88 */       int _v_ = _os_.unmarshal_int();
/*  89 */       this.skills.add(Integer.valueOf(_v_));
/*     */     }
/*  91 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  93 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  95 */       int _v_ = _os_.unmarshal_int();
/*  96 */       this.target_skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 102 */     if (_o1_ == this) return true;
/* 103 */     if ((_o1_ instanceof WingData)) {
/* 104 */       WingData _o_ = (WingData)_o1_;
/* 105 */       if (this.cfgid != _o_.cfgid) return false;
/* 106 */       if (this.colorid != _o_.colorid) return false;
/* 107 */       if (!this.reproids.equals(_o_.reproids)) return false;
/* 108 */       if (!this.reskillids.equals(_o_.reskillids)) return false;
/* 109 */       if (!this.proids.equals(_o_.proids)) return false;
/* 110 */       if (!this.skills.equals(_o_.skills)) return false;
/* 111 */       if (!this.target_skills.equals(_o_.target_skills)) return false;
/* 112 */       return true;
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 118 */     int _h_ = 0;
/* 119 */     _h_ += this.cfgid;
/* 120 */     _h_ += this.colorid;
/* 121 */     _h_ += this.reproids.hashCode();
/* 122 */     _h_ += this.reskillids.hashCode();
/* 123 */     _h_ += this.proids.hashCode();
/* 124 */     _h_ += this.skills.hashCode();
/* 125 */     _h_ += this.target_skills.hashCode();
/* 126 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder _sb_ = new StringBuilder();
/* 131 */     _sb_.append("(");
/* 132 */     _sb_.append(this.cfgid).append(",");
/* 133 */     _sb_.append(this.colorid).append(",");
/* 134 */     _sb_.append(this.reproids).append(",");
/* 135 */     _sb_.append(this.reskillids).append(",");
/* 136 */     _sb_.append(this.proids).append(",");
/* 137 */     _sb_.append(this.skills).append(",");
/* 138 */     _sb_.append(this.target_skills).append(",");
/* 139 */     _sb_.append(")");
/* 140 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\WingData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */