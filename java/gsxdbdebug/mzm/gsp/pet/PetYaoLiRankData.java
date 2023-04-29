/*     */ package mzm.gsp.pet;
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
/*     */   public int isexit;
/*     */   
/*     */   public PetYaoLiRankData()
/*     */   {
/*  22 */     this.petname = "";
/*  23 */     this.rolename = "";
/*     */   }
/*     */   
/*     */   public PetYaoLiRankData(int _no_, long _petid_, long _roleid_, String _petname_, String _rolename_, int _yaoli_, int _step_, int _templateid_, int _isexit_) {
/*  27 */     this.no = _no_;
/*  28 */     this.petid = _petid_;
/*  29 */     this.roleid = _roleid_;
/*  30 */     this.petname = _petname_;
/*  31 */     this.rolename = _rolename_;
/*  32 */     this.yaoli = _yaoli_;
/*  33 */     this.step = _step_;
/*  34 */     this.templateid = _templateid_;
/*  35 */     this.isexit = _isexit_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  43 */     _os_.marshal(this.no);
/*  44 */     _os_.marshal(this.petid);
/*  45 */     _os_.marshal(this.roleid);
/*  46 */     _os_.marshal(this.petname, "UTF-16LE");
/*  47 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  48 */     _os_.marshal(this.yaoli);
/*  49 */     _os_.marshal(this.step);
/*  50 */     _os_.marshal(this.templateid);
/*  51 */     _os_.marshal(this.isexit);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.no = _os_.unmarshal_int();
/*  57 */     this.petid = _os_.unmarshal_long();
/*  58 */     this.roleid = _os_.unmarshal_long();
/*  59 */     this.petname = _os_.unmarshal_String("UTF-16LE");
/*  60 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  61 */     this.yaoli = _os_.unmarshal_int();
/*  62 */     this.step = _os_.unmarshal_int();
/*  63 */     this.templateid = _os_.unmarshal_int();
/*  64 */     this.isexit = _os_.unmarshal_int();
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof PetYaoLiRankData)) {
/*  71 */       PetYaoLiRankData _o_ = (PetYaoLiRankData)_o1_;
/*  72 */       if (this.no != _o_.no) return false;
/*  73 */       if (this.petid != _o_.petid) return false;
/*  74 */       if (this.roleid != _o_.roleid) return false;
/*  75 */       if (!this.petname.equals(_o_.petname)) return false;
/*  76 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  77 */       if (this.yaoli != _o_.yaoli) return false;
/*  78 */       if (this.step != _o_.step) return false;
/*  79 */       if (this.templateid != _o_.templateid) return false;
/*  80 */       if (this.isexit != _o_.isexit) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.no;
/*  89 */     _h_ += (int)this.petid;
/*  90 */     _h_ += (int)this.roleid;
/*  91 */     _h_ += this.petname.hashCode();
/*  92 */     _h_ += this.rolename.hashCode();
/*  93 */     _h_ += this.yaoli;
/*  94 */     _h_ += this.step;
/*  95 */     _h_ += this.templateid;
/*  96 */     _h_ += this.isexit;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.no).append(",");
/* 104 */     _sb_.append(this.petid).append(",");
/* 105 */     _sb_.append(this.roleid).append(",");
/* 106 */     _sb_.append("T").append(this.petname.length()).append(",");
/* 107 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 108 */     _sb_.append(this.yaoli).append(",");
/* 109 */     _sb_.append(this.step).append(",");
/* 110 */     _sb_.append(this.templateid).append(",");
/* 111 */     _sb_.append(this.isexit).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\PetYaoLiRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */