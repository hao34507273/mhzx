/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QueryUserid2Rep
/*     */   extends __QueryUserid2Rep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 213;
/*     */   public int xid;
/*     */   public int result;
/*     */   public Octets userid;
/*     */   public long roleid;
/*     */   public int level;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 213;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public QueryUserid2Rep()
/*     */   {
/*  35 */     this.result = 0;
/*  36 */     this.userid = new Octets();
/*  37 */     this.roleid = 0L;
/*  38 */     this.level = 0;
/*     */   }
/*     */   
/*     */   public QueryUserid2Rep(int _xid_, int _result_, Octets _userid_, long _roleid_, int _level_) {
/*  42 */     this.xid = _xid_;
/*  43 */     this.result = _result_;
/*  44 */     this.userid = _userid_;
/*  45 */     this.roleid = _roleid_;
/*  46 */     this.level = _level_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.xid);
/*  55 */     _os_.marshal(this.result);
/*  56 */     _os_.marshal(this.userid);
/*  57 */     _os_.marshal(this.roleid);
/*  58 */     _os_.marshal(this.level);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.xid = _os_.unmarshal_int();
/*  64 */     this.result = _os_.unmarshal_int();
/*  65 */     this.userid = _os_.unmarshal_Octets();
/*  66 */     this.roleid = _os_.unmarshal_long();
/*  67 */     this.level = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof QueryUserid2Rep)) {
/*  77 */       QueryUserid2Rep _o_ = (QueryUserid2Rep)_o1_;
/*  78 */       if (this.xid != _o_.xid) return false;
/*  79 */       if (this.result != _o_.result) return false;
/*  80 */       if (!this.userid.equals(_o_.userid)) return false;
/*  81 */       if (this.roleid != _o_.roleid) return false;
/*  82 */       if (this.level != _o_.level) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.xid;
/*  91 */     _h_ += this.result;
/*  92 */     _h_ += this.userid.hashCode();
/*  93 */     _h_ += (int)this.roleid;
/*  94 */     _h_ += this.level;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.xid).append(",");
/* 102 */     _sb_.append(this.result).append(",");
/* 103 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 104 */     _sb_.append(this.roleid).append(",");
/* 105 */     _sb_.append(this.level).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\QueryUserid2Rep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */