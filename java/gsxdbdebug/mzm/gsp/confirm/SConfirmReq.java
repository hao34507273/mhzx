/*     */ package mzm.gsp.confirm;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SConfirmReq
/*     */   extends __SConfirmReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617988;
/*     */   public int confirmtype;
/*     */   public long sessionid;
/*     */   public Octets extroinfo;
/*     */   public ArrayList<Long> acceptedmembers;
/*     */   public int endtime;
/*     */   public HashSet<Long> defaultagreeroleids;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617988;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SConfirmReq()
/*     */   {
/*  38 */     this.extroinfo = new Octets();
/*  39 */     this.acceptedmembers = new ArrayList();
/*  40 */     this.defaultagreeroleids = new HashSet();
/*     */   }
/*     */   
/*     */   public SConfirmReq(int _confirmtype_, long _sessionid_, Octets _extroinfo_, ArrayList<Long> _acceptedmembers_, int _endtime_, HashSet<Long> _defaultagreeroleids_) {
/*  44 */     this.confirmtype = _confirmtype_;
/*  45 */     this.sessionid = _sessionid_;
/*  46 */     this.extroinfo = _extroinfo_;
/*  47 */     this.acceptedmembers = _acceptedmembers_;
/*  48 */     this.endtime = _endtime_;
/*  49 */     this.defaultagreeroleids = _defaultagreeroleids_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.confirmtype);
/*  58 */     _os_.marshal(this.sessionid);
/*  59 */     _os_.marshal(this.extroinfo);
/*  60 */     _os_.compact_uint32(this.acceptedmembers.size());
/*  61 */     for (Long _v_ : this.acceptedmembers) {
/*  62 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  64 */     _os_.marshal(this.endtime);
/*  65 */     _os_.compact_uint32(this.defaultagreeroleids.size());
/*  66 */     for (Long _v_ : this.defaultagreeroleids) {
/*  67 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  73 */     this.confirmtype = _os_.unmarshal_int();
/*  74 */     this.sessionid = _os_.unmarshal_long();
/*  75 */     this.extroinfo = _os_.unmarshal_Octets();
/*  76 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  78 */       long _v_ = _os_.unmarshal_long();
/*  79 */       this.acceptedmembers.add(Long.valueOf(_v_));
/*     */     }
/*  81 */     this.endtime = _os_.unmarshal_int();
/*  82 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  84 */       long _v_ = _os_.unmarshal_long();
/*  85 */       this.defaultagreeroleids.add(Long.valueOf(_v_));
/*     */     }
/*  87 */     if (!_validator_()) {
/*  88 */       throw new VerifyError("validator failed");
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  94 */     if (_o1_ == this) return true;
/*  95 */     if ((_o1_ instanceof SConfirmReq)) {
/*  96 */       SConfirmReq _o_ = (SConfirmReq)_o1_;
/*  97 */       if (this.confirmtype != _o_.confirmtype) return false;
/*  98 */       if (this.sessionid != _o_.sessionid) return false;
/*  99 */       if (!this.extroinfo.equals(_o_.extroinfo)) return false;
/* 100 */       if (!this.acceptedmembers.equals(_o_.acceptedmembers)) return false;
/* 101 */       if (this.endtime != _o_.endtime) return false;
/* 102 */       if (!this.defaultagreeroleids.equals(_o_.defaultagreeroleids)) return false;
/* 103 */       return true;
/*     */     }
/* 105 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 109 */     int _h_ = 0;
/* 110 */     _h_ += this.confirmtype;
/* 111 */     _h_ += (int)this.sessionid;
/* 112 */     _h_ += this.extroinfo.hashCode();
/* 113 */     _h_ += this.acceptedmembers.hashCode();
/* 114 */     _h_ += this.endtime;
/* 115 */     _h_ += this.defaultagreeroleids.hashCode();
/* 116 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder _sb_ = new StringBuilder();
/* 121 */     _sb_.append("(");
/* 122 */     _sb_.append(this.confirmtype).append(",");
/* 123 */     _sb_.append(this.sessionid).append(",");
/* 124 */     _sb_.append("B").append(this.extroinfo.size()).append(",");
/* 125 */     _sb_.append(this.acceptedmembers).append(",");
/* 126 */     _sb_.append(this.endtime).append(",");
/* 127 */     _sb_.append(this.defaultagreeroleids).append(",");
/* 128 */     _sb_.append(")");
/* 129 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\SConfirmReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */