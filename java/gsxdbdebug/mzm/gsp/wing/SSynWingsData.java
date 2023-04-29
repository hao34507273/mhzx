/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public class SSynWingsData extends __SSynWingsData__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596528;
/*     */   public static final int TYPE__OPEN_WING = 1;
/*     */   public static final int TYPE__LOGIN = 2;
/*     */   public static final int TYPE__CHANGE_OCCUPATION_PLAN = 3;
/*     */   public int syntype;
/*     */   public int curlv;
/*     */   public int currank;
/*     */   public int curexp;
/*     */   public int curwing;
/*     */   public int effectoccupationid;
/*     */   public HashMap<Integer, WingData> wings;
/*     */   public LinkedList<OccWingPlanInfo> occpalns;
/*     */   public LinkedList<Integer> newoccplans;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596528;
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
/*     */ 
/*     */ 
/*     */   public SSynWingsData()
/*     */   {
/*  45 */     this.wings = new HashMap();
/*  46 */     this.occpalns = new LinkedList();
/*  47 */     this.newoccplans = new LinkedList();
/*     */   }
/*     */   
/*     */   public SSynWingsData(int _syntype_, int _curlv_, int _currank_, int _curexp_, int _curwing_, int _effectoccupationid_, HashMap<Integer, WingData> _wings_, LinkedList<OccWingPlanInfo> _occpalns_, LinkedList<Integer> _newoccplans_) {
/*  51 */     this.syntype = _syntype_;
/*  52 */     this.curlv = _curlv_;
/*  53 */     this.currank = _currank_;
/*  54 */     this.curexp = _curexp_;
/*  55 */     this.curwing = _curwing_;
/*  56 */     this.effectoccupationid = _effectoccupationid_;
/*  57 */     this.wings = _wings_;
/*  58 */     this.occpalns = _occpalns_;
/*  59 */     this.newoccplans = _newoccplans_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  63 */     for (java.util.Map.Entry<Integer, WingData> _e_ : this.wings.entrySet()) {
/*  64 */       if (!((WingData)_e_.getValue())._validator_()) return false;
/*     */     }
/*  66 */     for (OccWingPlanInfo _v_ : this.occpalns)
/*  67 */       if (!_v_._validator_()) return false;
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  72 */     _os_.marshal(this.syntype);
/*  73 */     _os_.marshal(this.curlv);
/*  74 */     _os_.marshal(this.currank);
/*  75 */     _os_.marshal(this.curexp);
/*  76 */     _os_.marshal(this.curwing);
/*  77 */     _os_.marshal(this.effectoccupationid);
/*  78 */     _os_.compact_uint32(this.wings.size());
/*  79 */     for (java.util.Map.Entry<Integer, WingData> _e_ : this.wings.entrySet()) {
/*  80 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  81 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  83 */     _os_.compact_uint32(this.occpalns.size());
/*  84 */     for (OccWingPlanInfo _v_ : this.occpalns) {
/*  85 */       _os_.marshal(_v_);
/*     */     }
/*  87 */     _os_.compact_uint32(this.newoccplans.size());
/*  88 */     for (Integer _v_ : this.newoccplans) {
/*  89 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  95 */     this.syntype = _os_.unmarshal_int();
/*  96 */     this.curlv = _os_.unmarshal_int();
/*  97 */     this.currank = _os_.unmarshal_int();
/*  98 */     this.curexp = _os_.unmarshal_int();
/*  99 */     this.curwing = _os_.unmarshal_int();
/* 100 */     this.effectoccupationid = _os_.unmarshal_int();
/* 101 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 103 */       int _k_ = _os_.unmarshal_int();
/* 104 */       WingData _v_ = new WingData();
/* 105 */       _v_.unmarshal(_os_);
/* 106 */       this.wings.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 108 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 109 */       OccWingPlanInfo _v_ = new OccWingPlanInfo();
/* 110 */       _v_.unmarshal(_os_);
/* 111 */       this.occpalns.add(_v_);
/*     */     }
/* 113 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 115 */       int _v_ = _os_.unmarshal_int();
/* 116 */       this.newoccplans.add(Integer.valueOf(_v_));
/*     */     }
/* 118 */     if (!_validator_()) {
/* 119 */       throw new VerifyError("validator failed");
/*     */     }
/* 121 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 125 */     if (_o1_ == this) return true;
/* 126 */     if ((_o1_ instanceof SSynWingsData)) {
/* 127 */       SSynWingsData _o_ = (SSynWingsData)_o1_;
/* 128 */       if (this.syntype != _o_.syntype) return false;
/* 129 */       if (this.curlv != _o_.curlv) return false;
/* 130 */       if (this.currank != _o_.currank) return false;
/* 131 */       if (this.curexp != _o_.curexp) return false;
/* 132 */       if (this.curwing != _o_.curwing) return false;
/* 133 */       if (this.effectoccupationid != _o_.effectoccupationid) return false;
/* 134 */       if (!this.wings.equals(_o_.wings)) return false;
/* 135 */       if (!this.occpalns.equals(_o_.occpalns)) return false;
/* 136 */       if (!this.newoccplans.equals(_o_.newoccplans)) return false;
/* 137 */       return true;
/*     */     }
/* 139 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 143 */     int _h_ = 0;
/* 144 */     _h_ += this.syntype;
/* 145 */     _h_ += this.curlv;
/* 146 */     _h_ += this.currank;
/* 147 */     _h_ += this.curexp;
/* 148 */     _h_ += this.curwing;
/* 149 */     _h_ += this.effectoccupationid;
/* 150 */     _h_ += this.wings.hashCode();
/* 151 */     _h_ += this.occpalns.hashCode();
/* 152 */     _h_ += this.newoccplans.hashCode();
/* 153 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 157 */     StringBuilder _sb_ = new StringBuilder();
/* 158 */     _sb_.append("(");
/* 159 */     _sb_.append(this.syntype).append(",");
/* 160 */     _sb_.append(this.curlv).append(",");
/* 161 */     _sb_.append(this.currank).append(",");
/* 162 */     _sb_.append(this.curexp).append(",");
/* 163 */     _sb_.append(this.curwing).append(",");
/* 164 */     _sb_.append(this.effectoccupationid).append(",");
/* 165 */     _sb_.append(this.wings).append(",");
/* 166 */     _sb_.append(this.occpalns).append(",");
/* 167 */     _sb_.append(this.newoccplans).append(",");
/* 168 */     _sb_.append(")");
/* 169 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SSynWingsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */