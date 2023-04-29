/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class AU2Game extends __AU2Game__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 8038;
/*     */   public Octets userid;
/*     */   public int qtype;
/*     */   public Octets info;
/*     */   public int retcode;
/*     */   public int reserved;
/*     */   
/*     */   protected void process()
/*     */   {
/*  17 */     xdb.Executor.getInstance().execute(new Runnable()
/*     */     {
/*     */       public void run() {}
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  42 */     return 8038;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AU2Game()
/*     */   {
/*  52 */     this.userid = new Octets();
/*  53 */     this.info = new Octets();
/*     */   }
/*     */   
/*     */   public AU2Game(Octets _userid_, int _qtype_, Octets _info_, int _retcode_, int _reserved_) {
/*  57 */     this.userid = _userid_;
/*  58 */     this.qtype = _qtype_;
/*  59 */     this.info = _info_;
/*  60 */     this.retcode = _retcode_;
/*  61 */     this.reserved = _reserved_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  69 */     _os_.marshal(this.userid);
/*  70 */     _os_.marshal(this.qtype);
/*  71 */     _os_.marshal(this.info);
/*  72 */     _os_.marshal(this.retcode);
/*  73 */     _os_.marshal(this.reserved);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  78 */     this.userid = _os_.unmarshal_Octets();
/*  79 */     this.qtype = _os_.unmarshal_int();
/*  80 */     this.info = _os_.unmarshal_Octets();
/*  81 */     this.retcode = _os_.unmarshal_int();
/*  82 */     this.reserved = _os_.unmarshal_int();
/*  83 */     if (!_validator_()) {
/*  84 */       throw new VerifyError("validator failed");
/*     */     }
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  90 */     if (_o1_ == this) return true;
/*  91 */     if ((_o1_ instanceof AU2Game)) {
/*  92 */       AU2Game _o_ = (AU2Game)_o1_;
/*  93 */       if (!this.userid.equals(_o_.userid)) return false;
/*  94 */       if (this.qtype != _o_.qtype) return false;
/*  95 */       if (!this.info.equals(_o_.info)) return false;
/*  96 */       if (this.retcode != _o_.retcode) return false;
/*  97 */       if (this.reserved != _o_.reserved) return false;
/*  98 */       return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 104 */     int _h_ = 0;
/* 105 */     _h_ += this.userid.hashCode();
/* 106 */     _h_ += this.qtype;
/* 107 */     _h_ += this.info.hashCode();
/* 108 */     _h_ += this.retcode;
/* 109 */     _h_ += this.reserved;
/* 110 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder _sb_ = new StringBuilder();
/* 115 */     _sb_.append("(");
/* 116 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 117 */     _sb_.append(this.qtype).append(",");
/* 118 */     _sb_.append("B").append(this.info.size()).append(",");
/* 119 */     _sb_.append(this.retcode).append(",");
/* 120 */     _sb_.append(this.reserved).append(",");
/* 121 */     _sb_.append(")");
/* 122 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\AU2Game.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */