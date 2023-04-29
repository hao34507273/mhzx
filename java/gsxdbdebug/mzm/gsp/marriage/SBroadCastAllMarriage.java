/*     */ package mzm.gsp.marriage;
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
/*     */ public class SBroadCastAllMarriage
/*     */   extends __SBroadCastAllMarriage__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12599818;
/*     */   public long roleida;
/*     */   public String roleidaname;
/*     */   public long roleidb;
/*     */   public String roleidbname;
/*     */   public int level;
/*     */   public int marriagecounter;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12599818;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBroadCastAllMarriage()
/*     */   {
/*  38 */     this.roleidaname = "";
/*  39 */     this.roleidbname = "";
/*     */   }
/*     */   
/*     */   public SBroadCastAllMarriage(long _roleida_, String _roleidaname_, long _roleidb_, String _roleidbname_, int _level_, int _marriagecounter_) {
/*  43 */     this.roleida = _roleida_;
/*  44 */     this.roleidaname = _roleidaname_;
/*  45 */     this.roleidb = _roleidb_;
/*  46 */     this.roleidbname = _roleidbname_;
/*  47 */     this.level = _level_;
/*  48 */     this.marriagecounter = _marriagecounter_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.roleida);
/*  57 */     _os_.marshal(this.roleidaname, "UTF-16LE");
/*  58 */     _os_.marshal(this.roleidb);
/*  59 */     _os_.marshal(this.roleidbname, "UTF-16LE");
/*  60 */     _os_.marshal(this.level);
/*  61 */     _os_.marshal(this.marriagecounter);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.roleida = _os_.unmarshal_long();
/*  67 */     this.roleidaname = _os_.unmarshal_String("UTF-16LE");
/*  68 */     this.roleidb = _os_.unmarshal_long();
/*  69 */     this.roleidbname = _os_.unmarshal_String("UTF-16LE");
/*  70 */     this.level = _os_.unmarshal_int();
/*  71 */     this.marriagecounter = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SBroadCastAllMarriage)) {
/*  81 */       SBroadCastAllMarriage _o_ = (SBroadCastAllMarriage)_o1_;
/*  82 */       if (this.roleida != _o_.roleida) return false;
/*  83 */       if (!this.roleidaname.equals(_o_.roleidaname)) return false;
/*  84 */       if (this.roleidb != _o_.roleidb) return false;
/*  85 */       if (!this.roleidbname.equals(_o_.roleidbname)) return false;
/*  86 */       if (this.level != _o_.level) return false;
/*  87 */       if (this.marriagecounter != _o_.marriagecounter) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += (int)this.roleida;
/*  96 */     _h_ += this.roleidaname.hashCode();
/*  97 */     _h_ += (int)this.roleidb;
/*  98 */     _h_ += this.roleidbname.hashCode();
/*  99 */     _h_ += this.level;
/* 100 */     _h_ += this.marriagecounter;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.roleida).append(",");
/* 108 */     _sb_.append("T").append(this.roleidaname.length()).append(",");
/* 109 */     _sb_.append(this.roleidb).append(",");
/* 110 */     _sb_.append("T").append(this.roleidbname.length()).append(",");
/* 111 */     _sb_.append(this.level).append(",");
/* 112 */     _sb_.append(this.marriagecounter).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SBroadCastAllMarriage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */