/*    */ package mzm.gsp.lifeskill;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncCommonInfo
/*    */   extends __SSyncCommonInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589064;
/*    */   public static final int VIGOR_NOT_ENOUGH = 0;
/*    */   public static final int BAG_FULL = 1;
/*    */   public static final int MONEY_NOT_ENOUGH = 2;
/*    */   public static final int BANGGONG_NOT_ENOUGH = 3;
/*    */   public static final int SKILL_REACH_MAX_LEVEL = 4;
/*    */   public static final int NEED_SKILL_LEVELUP = 5;
/*    */   public static final int TREASURE_BAG_FULL = 6;
/*    */   public static final int ITEM_TYPE_MAP_BAG_ERROR = 7;
/*    */   public static final int ITEM_TYPE_CFG_NOT_EXIST = 8;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589064;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncCommonInfo() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncCommonInfo(int _res_)
/*    */   {
/* 46 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.res);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.res = _os_.unmarshal_int();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSyncCommonInfo)) {
/* 69 */       SSyncCommonInfo _o_ = (SSyncCommonInfo)_o1_;
/* 70 */       if (this.res != _o_.res) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.res;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.res).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncCommonInfo _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.res - _o_.res;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\SSyncCommonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */