/*     */ package mzm.gsp.sworn;
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
/*     */ public class SGetChangeNameVoteInfoRes
/*     */   extends __SGetChangeNameVoteInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12597813;
/*     */   public String name1;
/*     */   public String name2;
/*     */   public String rolename;
/*     */   public long verifytime;
/*     */   public int curvotecount;
/*     */   public int needvotecount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12597813;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetChangeNameVoteInfoRes()
/*     */   {
/*  38 */     this.name1 = "";
/*  39 */     this.name2 = "";
/*  40 */     this.rolename = "";
/*     */   }
/*     */   
/*     */   public SGetChangeNameVoteInfoRes(String _name1_, String _name2_, String _rolename_, long _verifytime_, int _curvotecount_, int _needvotecount_) {
/*  44 */     this.name1 = _name1_;
/*  45 */     this.name2 = _name2_;
/*  46 */     this.rolename = _rolename_;
/*  47 */     this.verifytime = _verifytime_;
/*  48 */     this.curvotecount = _curvotecount_;
/*  49 */     this.needvotecount = _needvotecount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.name1, "UTF-16LE");
/*  58 */     _os_.marshal(this.name2, "UTF-16LE");
/*  59 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  60 */     _os_.marshal(this.verifytime);
/*  61 */     _os_.marshal(this.curvotecount);
/*  62 */     _os_.marshal(this.needvotecount);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/*  68 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/*  69 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  70 */     this.verifytime = _os_.unmarshal_long();
/*  71 */     this.curvotecount = _os_.unmarshal_int();
/*  72 */     this.needvotecount = _os_.unmarshal_int();
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SGetChangeNameVoteInfoRes)) {
/*  82 */       SGetChangeNameVoteInfoRes _o_ = (SGetChangeNameVoteInfoRes)_o1_;
/*  83 */       if (!this.name1.equals(_o_.name1)) return false;
/*  84 */       if (!this.name2.equals(_o_.name2)) return false;
/*  85 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  86 */       if (this.verifytime != _o_.verifytime) return false;
/*  87 */       if (this.curvotecount != _o_.curvotecount) return false;
/*  88 */       if (this.needvotecount != _o_.needvotecount) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.name1.hashCode();
/*  97 */     _h_ += this.name2.hashCode();
/*  98 */     _h_ += this.rolename.hashCode();
/*  99 */     _h_ += (int)this.verifytime;
/* 100 */     _h_ += this.curvotecount;
/* 101 */     _h_ += this.needvotecount;
/* 102 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 106 */     StringBuilder _sb_ = new StringBuilder();
/* 107 */     _sb_.append("(");
/* 108 */     _sb_.append("T").append(this.name1.length()).append(",");
/* 109 */     _sb_.append("T").append(this.name2.length()).append(",");
/* 110 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 111 */     _sb_.append(this.verifytime).append(",");
/* 112 */     _sb_.append(this.curvotecount).append(",");
/* 113 */     _sb_.append(this.needvotecount).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SGetChangeNameVoteInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */