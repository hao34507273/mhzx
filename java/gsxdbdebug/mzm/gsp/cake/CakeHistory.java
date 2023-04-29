/*     */ package mzm.gsp.cake;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class CakeHistory
/*     */   implements Marshal
/*     */ {
/*     */   public static final int HISTORY_TYPE__COOK = 1;
/*     */   public int historytype;
/*     */   public long recordtime;
/*     */   public Octets makerolename;
/*     */   public Octets mastername;
/*     */   public int itemid;
/*     */   public int orgrank;
/*     */   public int newrank;
/*     */   
/*     */   public CakeHistory()
/*     */   {
/*  22 */     this.makerolename = new Octets();
/*  23 */     this.mastername = new Octets();
/*     */   }
/*     */   
/*     */   public CakeHistory(int _historytype_, long _recordtime_, Octets _makerolename_, Octets _mastername_, int _itemid_, int _orgrank_, int _newrank_) {
/*  27 */     this.historytype = _historytype_;
/*  28 */     this.recordtime = _recordtime_;
/*  29 */     this.makerolename = _makerolename_;
/*  30 */     this.mastername = _mastername_;
/*  31 */     this.itemid = _itemid_;
/*  32 */     this.orgrank = _orgrank_;
/*  33 */     this.newrank = _newrank_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  41 */     _os_.marshal(this.historytype);
/*  42 */     _os_.marshal(this.recordtime);
/*  43 */     _os_.marshal(this.makerolename);
/*  44 */     _os_.marshal(this.mastername);
/*  45 */     _os_.marshal(this.itemid);
/*  46 */     _os_.marshal(this.orgrank);
/*  47 */     _os_.marshal(this.newrank);
/*  48 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  52 */     this.historytype = _os_.unmarshal_int();
/*  53 */     this.recordtime = _os_.unmarshal_long();
/*  54 */     this.makerolename = _os_.unmarshal_Octets();
/*  55 */     this.mastername = _os_.unmarshal_Octets();
/*  56 */     this.itemid = _os_.unmarshal_int();
/*  57 */     this.orgrank = _os_.unmarshal_int();
/*  58 */     this.newrank = _os_.unmarshal_int();
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof CakeHistory)) {
/*  65 */       CakeHistory _o_ = (CakeHistory)_o1_;
/*  66 */       if (this.historytype != _o_.historytype) return false;
/*  67 */       if (this.recordtime != _o_.recordtime) return false;
/*  68 */       if (!this.makerolename.equals(_o_.makerolename)) return false;
/*  69 */       if (!this.mastername.equals(_o_.mastername)) return false;
/*  70 */       if (this.itemid != _o_.itemid) return false;
/*  71 */       if (this.orgrank != _o_.orgrank) return false;
/*  72 */       if (this.newrank != _o_.newrank) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.historytype;
/*  81 */     _h_ += (int)this.recordtime;
/*  82 */     _h_ += this.makerolename.hashCode();
/*  83 */     _h_ += this.mastername.hashCode();
/*  84 */     _h_ += this.itemid;
/*  85 */     _h_ += this.orgrank;
/*  86 */     _h_ += this.newrank;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.historytype).append(",");
/*  94 */     _sb_.append(this.recordtime).append(",");
/*  95 */     _sb_.append("B").append(this.makerolename.size()).append(",");
/*  96 */     _sb_.append("B").append(this.mastername.size()).append(",");
/*  97 */     _sb_.append(this.itemid).append(",");
/*  98 */     _sb_.append(this.orgrank).append(",");
/*  99 */     _sb_.append(this.newrank).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\CakeHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */