/*     */ package mzm.gsp.corps;
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
/*     */ 
/*     */ 
/*     */ public class SGetCorpsHistoryRep
/*     */   extends __SGetCorpsHistoryRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617519;
/*     */   public long corpsid;
/*     */   public int start;
/*     */   public ArrayList<CorpsHistoryInfo> historylist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617519;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetCorpsHistoryRep()
/*     */   {
/*  35 */     this.historylist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetCorpsHistoryRep(long _corpsid_, int _start_, ArrayList<CorpsHistoryInfo> _historylist_) {
/*  39 */     this.corpsid = _corpsid_;
/*  40 */     this.start = _start_;
/*  41 */     this.historylist = _historylist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (CorpsHistoryInfo _v_ : this.historylist)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.corpsid);
/*  52 */     _os_.marshal(this.start);
/*  53 */     _os_.compact_uint32(this.historylist.size());
/*  54 */     for (CorpsHistoryInfo _v_ : this.historylist) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.corpsid = _os_.unmarshal_long();
/*  62 */     this.start = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       CorpsHistoryInfo _v_ = new CorpsHistoryInfo();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.historylist.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SGetCorpsHistoryRep)) {
/*  77 */       SGetCorpsHistoryRep _o_ = (SGetCorpsHistoryRep)_o1_;
/*  78 */       if (this.corpsid != _o_.corpsid) return false;
/*  79 */       if (this.start != _o_.start) return false;
/*  80 */       if (!this.historylist.equals(_o_.historylist)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.corpsid;
/*  89 */     _h_ += this.start;
/*  90 */     _h_ += this.historylist.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.corpsid).append(",");
/*  98 */     _sb_.append(this.start).append(",");
/*  99 */     _sb_.append(this.historylist).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SGetCorpsHistoryRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */