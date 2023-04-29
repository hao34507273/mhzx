/*     */ package mzm.gsp.worship;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynRoleWorshipInfo
/*     */   extends __SSynRoleWorshipInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612616;
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
/*  27 */     return 12612616;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynRoleWorshipInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynRoleWorshipInfo(int _worshipid_, int _lastcyclenum_, int _thiscyclenum_, int _cangetsalary_, int _nextcangetsalary_)
/*     */   {
/*  40 */     this.worshipid = _worshipid_;
/*  41 */     this.lastcyclenum = _lastcyclenum_;
/*  42 */     this.thiscyclenum = _thiscyclenum_;
/*  43 */     this.cangetsalary = _cangetsalary_;
/*  44 */     this.nextcangetsalary = _nextcangetsalary_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.worshipid);
/*  53 */     _os_.marshal(this.lastcyclenum);
/*  54 */     _os_.marshal(this.thiscyclenum);
/*  55 */     _os_.marshal(this.cangetsalary);
/*  56 */     _os_.marshal(this.nextcangetsalary);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.worshipid = _os_.unmarshal_int();
/*  62 */     this.lastcyclenum = _os_.unmarshal_int();
/*  63 */     this.thiscyclenum = _os_.unmarshal_int();
/*  64 */     this.cangetsalary = _os_.unmarshal_int();
/*  65 */     this.nextcangetsalary = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SSynRoleWorshipInfo)) {
/*  75 */       SSynRoleWorshipInfo _o_ = (SSynRoleWorshipInfo)_o1_;
/*  76 */       if (this.worshipid != _o_.worshipid) return false;
/*  77 */       if (this.lastcyclenum != _o_.lastcyclenum) return false;
/*  78 */       if (this.thiscyclenum != _o_.thiscyclenum) return false;
/*  79 */       if (this.cangetsalary != _o_.cangetsalary) return false;
/*  80 */       if (this.nextcangetsalary != _o_.nextcangetsalary) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.worshipid;
/*  89 */     _h_ += this.lastcyclenum;
/*  90 */     _h_ += this.thiscyclenum;
/*  91 */     _h_ += this.cangetsalary;
/*  92 */     _h_ += this.nextcangetsalary;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.worshipid).append(",");
/* 100 */     _sb_.append(this.lastcyclenum).append(",");
/* 101 */     _sb_.append(this.thiscyclenum).append(",");
/* 102 */     _sb_.append(this.cangetsalary).append(",");
/* 103 */     _sb_.append(this.nextcangetsalary).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynRoleWorshipInfo _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.worshipid - _o_.worshipid;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.lastcyclenum - _o_.lastcyclenum;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.thiscyclenum - _o_.thiscyclenum;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.cangetsalary - _o_.cangetsalary;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.nextcangetsalary - _o_.nextcangetsalary;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\SSynRoleWorshipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */