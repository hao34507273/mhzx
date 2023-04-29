/*     */ package csprovider;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataBetweenCspAndGame_Re
/*     */   extends __DataBetweenCspAndGame_Re__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 10015;
/*     */   public int xid;
/*     */   public int flag;
/*     */   public int retcode;
/*     */   public Octets repdata;
/*     */   public int serverid;
/*     */   public Octets reserved;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 10015;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DataBetweenCspAndGame_Re()
/*     */   {
/*  36 */     this.repdata = new Octets();
/*  37 */     this.reserved = new Octets();
/*     */   }
/*     */   
/*     */   public DataBetweenCspAndGame_Re(int _xid_, int _flag_, int _retcode_, Octets _repdata_, int _serverid_, Octets _reserved_) {
/*  41 */     this.xid = _xid_;
/*  42 */     this.flag = _flag_;
/*  43 */     this.retcode = _retcode_;
/*  44 */     this.repdata = _repdata_;
/*  45 */     this.serverid = _serverid_;
/*  46 */     this.reserved = _reserved_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.xid);
/*  55 */     _os_.marshal(this.flag);
/*  56 */     _os_.marshal(this.retcode);
/*  57 */     _os_.marshal(this.repdata);
/*  58 */     _os_.marshal(this.serverid);
/*  59 */     _os_.marshal(this.reserved);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.xid = _os_.unmarshal_int();
/*  65 */     this.flag = _os_.unmarshal_int();
/*  66 */     this.retcode = _os_.unmarshal_int();
/*  67 */     this.repdata = _os_.unmarshal_Octets();
/*  68 */     this.serverid = _os_.unmarshal_int();
/*  69 */     this.reserved = _os_.unmarshal_Octets();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof DataBetweenCspAndGame_Re)) {
/*  79 */       DataBetweenCspAndGame_Re _o_ = (DataBetweenCspAndGame_Re)_o1_;
/*  80 */       if (this.xid != _o_.xid) return false;
/*  81 */       if (this.flag != _o_.flag) return false;
/*  82 */       if (this.retcode != _o_.retcode) return false;
/*  83 */       if (!this.repdata.equals(_o_.repdata)) return false;
/*  84 */       if (this.serverid != _o_.serverid) return false;
/*  85 */       if (!this.reserved.equals(_o_.reserved)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.xid;
/*  94 */     _h_ += this.flag;
/*  95 */     _h_ += this.retcode;
/*  96 */     _h_ += this.repdata.hashCode();
/*  97 */     _h_ += this.serverid;
/*  98 */     _h_ += this.reserved.hashCode();
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.xid).append(",");
/* 106 */     _sb_.append(this.flag).append(",");
/* 107 */     _sb_.append(this.retcode).append(",");
/* 108 */     _sb_.append("B").append(this.repdata.size()).append(",");
/* 109 */     _sb_.append(this.serverid).append(",");
/* 110 */     _sb_.append("B").append(this.reserved.size()).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\csprovider\DataBetweenCspAndGame_Re.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */