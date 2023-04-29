/*     */ package mzm.gsp.chart;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class PetYaoLiRankData
/*     */   implements Marshal
/*     */ {
/*     */   public int no;
/*     */   public long petid;
/*     */   public long roleid;
/*     */   public String petname;
/*     */   public String rolename;
/*     */   public int yaoli;
/*     */   public int step;
/*     */   public int templateid;
/*     */   
/*     */   public PetYaoLiRankData()
/*     */   {
/*  21 */     this.petname = "";
/*  22 */     this.rolename = "";
/*     */   }
/*     */   
/*     */   public PetYaoLiRankData(int _no_, long _petid_, long _roleid_, String _petname_, String _rolename_, int _yaoli_, int _step_, int _templateid_) {
/*  26 */     this.no = _no_;
/*  27 */     this.petid = _petid_;
/*  28 */     this.roleid = _roleid_;
/*  29 */     this.petname = _petname_;
/*  30 */     this.rolename = _rolename_;
/*  31 */     this.yaoli = _yaoli_;
/*  32 */     this.step = _step_;
/*  33 */     this.templateid = _templateid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  41 */     _os_.marshal(this.no);
/*  42 */     _os_.marshal(this.petid);
/*  43 */     _os_.marshal(this.roleid);
/*  44 */     _os_.marshal(this.petname, "UTF-16LE");
/*  45 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  46 */     _os_.marshal(this.yaoli);
/*  47 */     _os_.marshal(this.step);
/*  48 */     _os_.marshal(this.templateid);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.no = _os_.unmarshal_int();
/*  54 */     this.petid = _os_.unmarshal_long();
/*  55 */     this.roleid = _os_.unmarshal_long();
/*  56 */     this.petname = _os_.unmarshal_String("UTF-16LE");
/*  57 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  58 */     this.yaoli = _os_.unmarshal_int();
/*  59 */     this.step = _os_.unmarshal_int();
/*  60 */     this.templateid = _os_.unmarshal_int();
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof PetYaoLiRankData)) {
/*  67 */       PetYaoLiRankData _o_ = (PetYaoLiRankData)_o1_;
/*  68 */       if (this.no != _o_.no) return false;
/*  69 */       if (this.petid != _o_.petid) return false;
/*  70 */       if (this.roleid != _o_.roleid) return false;
/*  71 */       if (!this.petname.equals(_o_.petname)) return false;
/*  72 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  73 */       if (this.yaoli != _o_.yaoli) return false;
/*  74 */       if (this.step != _o_.step) return false;
/*  75 */       if (this.templateid != _o_.templateid) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.no;
/*  84 */     _h_ += (int)this.petid;
/*  85 */     _h_ += (int)this.roleid;
/*  86 */     _h_ += this.petname.hashCode();
/*  87 */     _h_ += this.rolename.hashCode();
/*  88 */     _h_ += this.yaoli;
/*  89 */     _h_ += this.step;
/*  90 */     _h_ += this.templateid;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.no).append(",");
/*  98 */     _sb_.append(this.petid).append(",");
/*  99 */     _sb_.append(this.roleid).append(",");
/* 100 */     _sb_.append("T").append(this.petname.length()).append(",");
/* 101 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 102 */     _sb_.append(this.yaoli).append(",");
/* 103 */     _sb_.append(this.step).append(",");
/* 104 */     _sb_.append(this.templateid).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\PetYaoLiRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */