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
/*    */ public class SEnterWorldGoalActivityMapFail
/*    */   extends __SEnterWorldGoalActivityMapFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594442;
/*    */   public static final int CAN_NOT_JOIN_ACTIVITY = 1;
/*    */   public static final int CHECK_NPC_SERVICE_ERROR = 2;
/*    */   public static final int NO_TRANSFER_MAP_CFG_ID = 3;
/*    */   public int activity_cfg_id;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594442;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SEnterWorldGoalActivityMapFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SEnterWorldGoalActivityMapFail(int _activity_cfg_id_, int _res_)
/*    */   {
/* 41 */     this.activity_cfg_id = _activity_cfg_id_;
/* 42 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.activity_cfg_id);
/* 51 */     _os_.marshal(this.res);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 57 */     this.res = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SEnterWorldGoalActivityMapFail)) {
/* 67 */       SEnterWorldGoalActivityMapFail _o_ = (SEnterWorldGoalActivityMapFail)_o1_;
/* 68 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 69 */       if (this.res != _o_.res) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.activity_cfg_id;
/* 78 */     _h_ += this.res;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.activity_cfg_id).append(",");
/* 86 */     _sb_.append(this.res).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SEnterWorldGoalActivityMapFail _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.res - _o_.res;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\SEnterWorldGoalActivityMapFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */