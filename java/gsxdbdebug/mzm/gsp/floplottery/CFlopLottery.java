/*     */ package mzm.gsp.floplottery;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.floplottery.main.PCFlopLottery;
/*     */ 
/*     */ 
/*     */ public class CFlopLottery
/*     */   extends __CFlopLottery__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618498;
/*     */   public long uid;
/*     */   public int index;
/*     */   public int flopcount;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCFlopLottery(this.uid, this.index, this.flopcount, roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12618498;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CFlopLottery() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CFlopLottery(long _uid_, int _index_, int _flopcount_)
/*     */   {
/*  43 */     this.uid = _uid_;
/*  44 */     this.index = _index_;
/*  45 */     this.flopcount = _flopcount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.uid);
/*  54 */     _os_.marshal(this.index);
/*  55 */     _os_.marshal(this.flopcount);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.uid = _os_.unmarshal_long();
/*  61 */     this.index = _os_.unmarshal_int();
/*  62 */     this.flopcount = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CFlopLottery)) {
/*  72 */       CFlopLottery _o_ = (CFlopLottery)_o1_;
/*  73 */       if (this.uid != _o_.uid) return false;
/*  74 */       if (this.index != _o_.index) return false;
/*  75 */       if (this.flopcount != _o_.flopcount) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.uid;
/*  84 */     _h_ += this.index;
/*  85 */     _h_ += this.flopcount;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.uid).append(",");
/*  93 */     _sb_.append(this.index).append(",");
/*  94 */     _sb_.append(this.flopcount).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CFlopLottery _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.uid - _o_.uid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.index - _o_.index;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.flopcount - _o_.flopcount;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floplottery\CFlopLottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */