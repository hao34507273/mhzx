/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class SRoleEnterView extends __SRoleEnterView__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590855;
/*     */   public static final int KEY_PET = 1;
/*     */   public static final int KEY_CHILDREN = 2;
/*     */   public Octets modelinfo;
/*     */   public ArrayList<Location> keypointpath;
/*     */   public int direction;
/*     */   public Location curpos;
/*     */   public HashMap<Integer, Octets> models;
/*     */   public int level;
/*     */   public int menpai;
/*     */   public int gender;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590855;
/*     */   }
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
/*     */ 
/*     */ 
/*     */   public SRoleEnterView()
/*     */   {
/*  43 */     this.modelinfo = new Octets();
/*  44 */     this.keypointpath = new ArrayList();
/*  45 */     this.curpos = new Location();
/*  46 */     this.models = new HashMap();
/*     */   }
/*     */   
/*     */   public SRoleEnterView(Octets _modelinfo_, ArrayList<Location> _keypointpath_, int _direction_, Location _curpos_, HashMap<Integer, Octets> _models_, int _level_, int _menpai_, int _gender_) {
/*  50 */     this.modelinfo = _modelinfo_;
/*  51 */     this.keypointpath = _keypointpath_;
/*  52 */     this.direction = _direction_;
/*  53 */     this.curpos = _curpos_;
/*  54 */     this.models = _models_;
/*  55 */     this.level = _level_;
/*  56 */     this.menpai = _menpai_;
/*  57 */     this.gender = _gender_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  61 */     for (Location _v_ : this.keypointpath)
/*  62 */       if (!_v_._validator_()) return false;
/*  63 */     if (!this.curpos._validator_()) return false;
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  68 */     _os_.marshal(this.modelinfo);
/*  69 */     _os_.compact_uint32(this.keypointpath.size());
/*  70 */     for (Location _v_ : this.keypointpath) {
/*  71 */       _os_.marshal(_v_);
/*     */     }
/*  73 */     _os_.marshal(this.direction);
/*  74 */     _os_.marshal(this.curpos);
/*  75 */     _os_.compact_uint32(this.models.size());
/*  76 */     for (Map.Entry<Integer, Octets> _e_ : this.models.entrySet()) {
/*  77 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  78 */       _os_.marshal((Octets)_e_.getValue());
/*     */     }
/*  80 */     _os_.marshal(this.level);
/*  81 */     _os_.marshal(this.menpai);
/*  82 */     _os_.marshal(this.gender);
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  87 */     this.modelinfo = _os_.unmarshal_Octets();
/*  88 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  89 */       Location _v_ = new Location();
/*  90 */       _v_.unmarshal(_os_);
/*  91 */       this.keypointpath.add(_v_);
/*     */     }
/*  93 */     this.direction = _os_.unmarshal_int();
/*  94 */     this.curpos.unmarshal(_os_);
/*  95 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  97 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  99 */       Octets _v_ = _os_.unmarshal_Octets();
/* 100 */       this.models.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 102 */     this.level = _os_.unmarshal_int();
/* 103 */     this.menpai = _os_.unmarshal_int();
/* 104 */     this.gender = _os_.unmarshal_int();
/* 105 */     if (!_validator_()) {
/* 106 */       throw new VerifyError("validator failed");
/*     */     }
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 112 */     if (_o1_ == this) return true;
/* 113 */     if ((_o1_ instanceof SRoleEnterView)) {
/* 114 */       SRoleEnterView _o_ = (SRoleEnterView)_o1_;
/* 115 */       if (!this.modelinfo.equals(_o_.modelinfo)) return false;
/* 116 */       if (!this.keypointpath.equals(_o_.keypointpath)) return false;
/* 117 */       if (this.direction != _o_.direction) return false;
/* 118 */       if (!this.curpos.equals(_o_.curpos)) return false;
/* 119 */       if (!this.models.equals(_o_.models)) return false;
/* 120 */       if (this.level != _o_.level) return false;
/* 121 */       if (this.menpai != _o_.menpai) return false;
/* 122 */       if (this.gender != _o_.gender) return false;
/* 123 */       return true;
/*     */     }
/* 125 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 129 */     int _h_ = 0;
/* 130 */     _h_ += this.modelinfo.hashCode();
/* 131 */     _h_ += this.keypointpath.hashCode();
/* 132 */     _h_ += this.direction;
/* 133 */     _h_ += this.curpos.hashCode();
/* 134 */     _h_ += this.models.hashCode();
/* 135 */     _h_ += this.level;
/* 136 */     _h_ += this.menpai;
/* 137 */     _h_ += this.gender;
/* 138 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 142 */     StringBuilder _sb_ = new StringBuilder();
/* 143 */     _sb_.append("(");
/* 144 */     _sb_.append("B").append(this.modelinfo.size()).append(",");
/* 145 */     _sb_.append(this.keypointpath).append(",");
/* 146 */     _sb_.append(this.direction).append(",");
/* 147 */     _sb_.append(this.curpos).append(",");
/* 148 */     _sb_.append(this.models).append(",");
/* 149 */     _sb_.append(this.level).append(",");
/* 150 */     _sb_.append(this.menpai).append(",");
/* 151 */     _sb_.append(this.gender).append(",");
/* 152 */     _sb_.append(")");
/* 153 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SRoleEnterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */