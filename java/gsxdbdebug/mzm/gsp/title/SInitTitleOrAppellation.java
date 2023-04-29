/*     */ package mzm.gsp.title;
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
/*     */ public class SInitTitleOrAppellation
/*     */   extends __SInitTitleOrAppellation__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12593922;
/*     */   public ArrayList<TitleInfo> owntitle;
/*     */   public ArrayList<AppellationInfo> ownappellation;
/*     */   public int activetitle;
/*     */   public int activeappellation;
/*     */   public int pro2appellationid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12593922;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SInitTitleOrAppellation()
/*     */   {
/*  37 */     this.owntitle = new ArrayList();
/*  38 */     this.ownappellation = new ArrayList();
/*     */   }
/*     */   
/*     */   public SInitTitleOrAppellation(ArrayList<TitleInfo> _owntitle_, ArrayList<AppellationInfo> _ownappellation_, int _activetitle_, int _activeappellation_, int _pro2appellationid_) {
/*  42 */     this.owntitle = _owntitle_;
/*  43 */     this.ownappellation = _ownappellation_;
/*  44 */     this.activetitle = _activetitle_;
/*  45 */     this.activeappellation = _activeappellation_;
/*  46 */     this.pro2appellationid = _pro2appellationid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     for (TitleInfo _v_ : this.owntitle)
/*  51 */       if (!_v_._validator_()) return false;
/*  52 */     for (AppellationInfo _v_ : this.ownappellation)
/*  53 */       if (!_v_._validator_()) return false;
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.compact_uint32(this.owntitle.size());
/*  59 */     for (TitleInfo _v_ : this.owntitle) {
/*  60 */       _os_.marshal(_v_);
/*     */     }
/*  62 */     _os_.compact_uint32(this.ownappellation.size());
/*  63 */     for (AppellationInfo _v_ : this.ownappellation) {
/*  64 */       _os_.marshal(_v_);
/*     */     }
/*  66 */     _os_.marshal(this.activetitle);
/*  67 */     _os_.marshal(this.activeappellation);
/*  68 */     _os_.marshal(this.pro2appellationid);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  74 */       TitleInfo _v_ = new TitleInfo();
/*  75 */       _v_.unmarshal(_os_);
/*  76 */       this.owntitle.add(_v_);
/*     */     }
/*  78 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  79 */       AppellationInfo _v_ = new AppellationInfo();
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.ownappellation.add(_v_);
/*     */     }
/*  83 */     this.activetitle = _os_.unmarshal_int();
/*  84 */     this.activeappellation = _os_.unmarshal_int();
/*  85 */     this.pro2appellationid = _os_.unmarshal_int();
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof SInitTitleOrAppellation)) {
/*  95 */       SInitTitleOrAppellation _o_ = (SInitTitleOrAppellation)_o1_;
/*  96 */       if (!this.owntitle.equals(_o_.owntitle)) return false;
/*  97 */       if (!this.ownappellation.equals(_o_.ownappellation)) return false;
/*  98 */       if (this.activetitle != _o_.activetitle) return false;
/*  99 */       if (this.activeappellation != _o_.activeappellation) return false;
/* 100 */       if (this.pro2appellationid != _o_.pro2appellationid) return false;
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 107 */     int _h_ = 0;
/* 108 */     _h_ += this.owntitle.hashCode();
/* 109 */     _h_ += this.ownappellation.hashCode();
/* 110 */     _h_ += this.activetitle;
/* 111 */     _h_ += this.activeappellation;
/* 112 */     _h_ += this.pro2appellationid;
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append(this.owntitle).append(",");
/* 120 */     _sb_.append(this.ownappellation).append(",");
/* 121 */     _sb_.append(this.activetitle).append(",");
/* 122 */     _sb_.append(this.activeappellation).append(",");
/* 123 */     _sb_.append(this.pro2appellationid).append(",");
/* 124 */     _sb_.append(")");
/* 125 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\SInitTitleOrAppellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */