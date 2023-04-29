/*     */ package mzm.gsp.factionpve;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.factionpve.main.PSetStartTimeReq;
/*     */ 
/*     */ 
/*     */ public class CSetStartTimeReq
/*     */   extends __CSetStartTimeReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613639;
/*     */   public int date;
/*     */   public int hour;
/*     */   public int minute;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     Role.addRoleProcedure(roleid, new PSetStartTimeReq(roleid, this.date, this.hour, this.minute));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12613639;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CSetStartTimeReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CSetStartTimeReq(int _date_, int _hour_, int _minute_)
/*     */   {
/*  41 */     this.date = _date_;
/*  42 */     this.hour = _hour_;
/*  43 */     this.minute = _minute_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.date);
/*  52 */     _os_.marshal(this.hour);
/*  53 */     _os_.marshal(this.minute);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.date = _os_.unmarshal_int();
/*  59 */     this.hour = _os_.unmarshal_int();
/*  60 */     this.minute = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CSetStartTimeReq)) {
/*  70 */       CSetStartTimeReq _o_ = (CSetStartTimeReq)_o1_;
/*  71 */       if (this.date != _o_.date) return false;
/*  72 */       if (this.hour != _o_.hour) return false;
/*  73 */       if (this.minute != _o_.minute) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.date;
/*  82 */     _h_ += this.hour;
/*  83 */     _h_ += this.minute;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.date).append(",");
/*  91 */     _sb_.append(this.hour).append(",");
/*  92 */     _sb_.append(this.minute).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSetStartTimeReq _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.date - _o_.date;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.hour - _o_.hour;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.minute - _o_.minute;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\CSetStartTimeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */