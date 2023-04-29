/*    */ package mzm.gsp.worldgoal;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetActivityScheduleFail
/*    */   extends __SGetActivityScheduleFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594435;
/*    */   public static final int CAN_NOT_JOIN_ACTIVITY = 1;
/*    */   public static final int CHECK_NPC_SERVICE_ERROR = 2;
/*    */   public int activity_cfg_id;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594435;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetActivityScheduleFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetActivityScheduleFail(int _activity_cfg_id_, int _res_)
/*    */   {
/* 40 */     this.activity_cfg_id = _activity_cfg_id_;
/* 41 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activity_cfg_id);
/* 50 */     _os_.marshal(this.res);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 56 */     this.res = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SGetActivityScheduleFail)) {
/* 66 */       SGetActivityScheduleFail _o_ = (SGetActivityScheduleFail)_o1_;
/* 67 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 68 */       if (this.res != _o_.res) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.activity_cfg_id;
/* 77 */     _h_ += this.res;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.activity_cfg_id).append(",");
/* 85 */     _sb_.append(this.res).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetActivityScheduleFail _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.res - _o_.res;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\SGetActivityScheduleFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */