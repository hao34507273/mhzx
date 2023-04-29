/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.activity.main.PCTakeRecommendAward;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CTakeRecommendReq
/*    */   extends __CTakeRecommendReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587530;
/*    */   public int activityid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     Role.addRoleProcedure(roleId, new PCTakeRecommendAward(this.activityid, roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587530;
/*    */   }
/*    */   
/*    */ 
/*    */   public CTakeRecommendReq() {}
/*    */   
/*    */ 
/*    */   public CTakeRecommendReq(int _activityid_)
/*    */   {
/* 36 */     this.activityid = _activityid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.activityid);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.activityid = _os_.unmarshal_int();
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof CTakeRecommendReq)) {
/* 59 */       CTakeRecommendReq _o_ = (CTakeRecommendReq)_o1_;
/* 60 */       if (this.activityid != _o_.activityid) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.activityid;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.activityid).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CTakeRecommendReq _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = this.activityid - _o_.activityid;
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\CTakeRecommendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */