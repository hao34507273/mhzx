/*     */ package mzm.gsp.aircraft;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class SAircraftNormalRes
/*     */   extends __SAircraftNormalRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624650;
/*     */   public static final int AIRCRAFT_NOT_OPEN = 1;
/*     */   public static final int AIRCRAFT_CFG_NOT_EXIST = 2;
/*     */   public static final int NOT_OWN_THE_AIRCRAFT = 3;
/*     */   public static final int ALEARDY_OWN_THE_AIRCRAFT = 4;
/*     */   public static final int AIRCRAFT_DYE_CFG_NOT_EXIST = 5;
/*     */   public static final int AIRCRAFT_ITEM_NOT_EXIST = 6;
/*     */   public static final int USER_ID_NOT_EXIST = 7;
/*     */   public static final int ROLE_AIRCRAFT_NOT_EXIST = 8;
/*     */   public static final int CURRENT_NO_AIRCRAFT_ON = 9;
/*     */   public static final int SAME_WITH_AIRCRAFT_ON = 10;
/*     */   public static final int FLY_CAN_NOT_CAKE_OFF_AIRCRAFT = 11;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12624650;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int ITEM_NOT_AIRCRAFT_TYPE = 12;
/*     */   
/*     */   public static final int CUT_ITEM_ERROR = 13;
/*     */   
/*     */   public static final int DYE_SAME_ERROR = 14;
/*     */   
/*     */   public static final int ITEM_NOT_ENOUGH_AND_NOT_YUANBAO_ERROR = 15;
/*     */   
/*     */   public static final int CLIENT_YUANBAO_NOT_SAME_WITH_SERVER_ERROR = 16;
/*     */   
/*     */   public static final int CLIENT_YUANBAO_CAL_NOT_SAME_WITH_SERVER_ERROR = 17;
/*     */   
/*     */   public static final int ITEM_ENOUGH_BUT_USE_YUANBAO_ERROR = 18;
/*     */   
/*     */   public static final int CUT_YUANBAO_ERROR = 19;
/*     */   
/*     */   public static final int CAL_YUANBAO_LESS_ZERO_ERROR = 20;
/*     */   
/*     */   public static final int LEVEL_NOT_ENOUGH_ERROR = 21;
/*     */   
/*     */   public static final int STATUS_ERROR = 22;
/*     */   
/*     */   public int ret;
/*     */   
/*     */   public SAircraftNormalRes() {}
/*     */   
/*     */   public SAircraftNormalRes(int _ret_)
/*     */   {
/*  59 */     this.ret = _ret_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  67 */     _os_.marshal(this.ret);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  72 */     this.ret = _os_.unmarshal_int();
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SAircraftNormalRes)) {
/*  82 */       SAircraftNormalRes _o_ = (SAircraftNormalRes)_o1_;
/*  83 */       if (this.ret != _o_.ret) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.ret;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.ret).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAircraftNormalRes _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.ret - _o_.ret;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\SAircraftNormalRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */