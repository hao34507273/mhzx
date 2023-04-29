/*     */ package mzm.gsp.worship;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynWorshipInfo
/*     */   extends __SSynWorshipInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612613;
/*     */   public HashMap<Integer, Integer> worshipid2num;
/*     */   public ArrayList<SingleWorshipInfo> worshiprecord;
/*     */   public int worshipid;
/*     */   public int lastcyclenum;
/*     */   public int thiscyclenum;
/*     */   public int cangetsalary;
/*     */   public int nextcangetsalary;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12612613;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynWorshipInfo()
/*     */   {
/*  39 */     this.worshipid2num = new HashMap();
/*  40 */     this.worshiprecord = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynWorshipInfo(HashMap<Integer, Integer> _worshipid2num_, ArrayList<SingleWorshipInfo> _worshiprecord_, int _worshipid_, int _lastcyclenum_, int _thiscyclenum_, int _cangetsalary_, int _nextcangetsalary_) {
/*  44 */     this.worshipid2num = _worshipid2num_;
/*  45 */     this.worshiprecord = _worshiprecord_;
/*  46 */     this.worshipid = _worshipid_;
/*  47 */     this.lastcyclenum = _lastcyclenum_;
/*  48 */     this.thiscyclenum = _thiscyclenum_;
/*  49 */     this.cangetsalary = _cangetsalary_;
/*  50 */     this.nextcangetsalary = _nextcangetsalary_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     for (SingleWorshipInfo _v_ : this.worshiprecord)
/*  55 */       if (!_v_._validator_()) return false;
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.compact_uint32(this.worshipid2num.size());
/*  61 */     for (Map.Entry<Integer, Integer> _e_ : this.worshipid2num.entrySet()) {
/*  62 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  63 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  65 */     _os_.compact_uint32(this.worshiprecord.size());
/*  66 */     for (SingleWorshipInfo _v_ : this.worshiprecord) {
/*  67 */       _os_.marshal(_v_);
/*     */     }
/*  69 */     _os_.marshal(this.worshipid);
/*  70 */     _os_.marshal(this.lastcyclenum);
/*  71 */     _os_.marshal(this.thiscyclenum);
/*  72 */     _os_.marshal(this.cangetsalary);
/*  73 */     _os_.marshal(this.nextcangetsalary);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  78 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  80 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  82 */       int _v_ = _os_.unmarshal_int();
/*  83 */       this.worshipid2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  85 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  86 */       SingleWorshipInfo _v_ = new SingleWorshipInfo();
/*  87 */       _v_.unmarshal(_os_);
/*  88 */       this.worshiprecord.add(_v_);
/*     */     }
/*  90 */     this.worshipid = _os_.unmarshal_int();
/*  91 */     this.lastcyclenum = _os_.unmarshal_int();
/*  92 */     this.thiscyclenum = _os_.unmarshal_int();
/*  93 */     this.cangetsalary = _os_.unmarshal_int();
/*  94 */     this.nextcangetsalary = _os_.unmarshal_int();
/*  95 */     if (!_validator_()) {
/*  96 */       throw new VerifyError("validator failed");
/*     */     }
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 102 */     if (_o1_ == this) return true;
/* 103 */     if ((_o1_ instanceof SSynWorshipInfo)) {
/* 104 */       SSynWorshipInfo _o_ = (SSynWorshipInfo)_o1_;
/* 105 */       if (!this.worshipid2num.equals(_o_.worshipid2num)) return false;
/* 106 */       if (!this.worshiprecord.equals(_o_.worshiprecord)) return false;
/* 107 */       if (this.worshipid != _o_.worshipid) return false;
/* 108 */       if (this.lastcyclenum != _o_.lastcyclenum) return false;
/* 109 */       if (this.thiscyclenum != _o_.thiscyclenum) return false;
/* 110 */       if (this.cangetsalary != _o_.cangetsalary) return false;
/* 111 */       if (this.nextcangetsalary != _o_.nextcangetsalary) return false;
/* 112 */       return true;
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 118 */     int _h_ = 0;
/* 119 */     _h_ += this.worshipid2num.hashCode();
/* 120 */     _h_ += this.worshiprecord.hashCode();
/* 121 */     _h_ += this.worshipid;
/* 122 */     _h_ += this.lastcyclenum;
/* 123 */     _h_ += this.thiscyclenum;
/* 124 */     _h_ += this.cangetsalary;
/* 125 */     _h_ += this.nextcangetsalary;
/* 126 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder _sb_ = new StringBuilder();
/* 131 */     _sb_.append("(");
/* 132 */     _sb_.append(this.worshipid2num).append(",");
/* 133 */     _sb_.append(this.worshiprecord).append(",");
/* 134 */     _sb_.append(this.worshipid).append(",");
/* 135 */     _sb_.append(this.lastcyclenum).append(",");
/* 136 */     _sb_.append(this.thiscyclenum).append(",");
/* 137 */     _sb_.append(this.cangetsalary).append(",");
/* 138 */     _sb_.append(this.nextcangetsalary).append(",");
/* 139 */     _sb_.append(")");
/* 140 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\SSynWorshipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */