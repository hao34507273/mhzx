/*    */ package mzm.gsp.friendscircle;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SUseFriendsCircleOrnamentItemSuccess
/*    */   extends __SUseFriendsCircleOrnamentItemSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625412;
/*    */   public int add_item_cfg_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625412;
/*    */   }
/*    */   
/*    */ 
/*    */   public SUseFriendsCircleOrnamentItemSuccess() {}
/*    */   
/*    */ 
/*    */   public SUseFriendsCircleOrnamentItemSuccess(int _add_item_cfg_id_)
/*    */   {
/* 36 */     this.add_item_cfg_id = _add_item_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.add_item_cfg_id);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.add_item_cfg_id = _os_.unmarshal_int();
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SUseFriendsCircleOrnamentItemSuccess)) {
/* 59 */       SUseFriendsCircleOrnamentItemSuccess _o_ = (SUseFriendsCircleOrnamentItemSuccess)_o1_;
/* 60 */       if (this.add_item_cfg_id != _o_.add_item_cfg_id) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.add_item_cfg_id;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.add_item_cfg_id).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUseFriendsCircleOrnamentItemSuccess _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = this.add_item_cfg_id - _o_.add_item_cfg_id;
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\SUseFriendsCircleOrnamentItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */