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
/*     */ public class SWorshipSucBro
/*     */   extends __SWorshipSucBro__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612618;
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int worshipid;
/*     */   public int goldnum;
/*     */   public int contentindex;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12612618;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SWorshipSucBro()
/*     */   {
/*  37 */     this.rolename = "";
/*     */   }
/*     */   
/*     */   public SWorshipSucBro(long _roleid_, String _rolename_, int _worshipid_, int _goldnum_, int _contentindex_) {
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.rolename = _rolename_;
/*  43 */     this.worshipid = _worshipid_;
/*  44 */     this.goldnum = _goldnum_;
/*  45 */     this.contentindex = _contentindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.roleid);
/*  54 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  55 */     _os_.marshal(this.worshipid);
/*  56 */     _os_.marshal(this.goldnum);
/*  57 */     _os_.marshal(this.contentindex);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.roleid = _os_.unmarshal_long();
/*  63 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  64 */     this.worshipid = _os_.unmarshal_int();
/*  65 */     this.goldnum = _os_.unmarshal_int();
/*  66 */     this.contentindex = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SWorshipSucBro)) {
/*  76 */       SWorshipSucBro _o_ = (SWorshipSucBro)_o1_;
/*  77 */       if (this.roleid != _o_.roleid) return false;
/*  78 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  79 */       if (this.worshipid != _o_.worshipid) return false;
/*  80 */       if (this.goldnum != _o_.goldnum) return false;
/*  81 */       if (this.contentindex != _o_.contentindex) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.roleid;
/*  90 */     _h_ += this.rolename.hashCode();
/*  91 */     _h_ += this.worshipid;
/*  92 */     _h_ += this.goldnum;
/*  93 */     _h_ += this.contentindex;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.roleid).append(",");
/* 101 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 102 */     _sb_.append(this.worshipid).append(",");
/* 103 */     _sb_.append(this.goldnum).append(",");
/* 104 */     _sb_.append(this.contentindex).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\SWorshipSucBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */