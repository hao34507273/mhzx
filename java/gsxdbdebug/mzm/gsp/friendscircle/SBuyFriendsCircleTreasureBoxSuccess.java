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
/*    */ public class SBuyFriendsCircleTreasureBoxSuccess
/*    */   extends __SBuyFriendsCircleTreasureBoxSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625417;
/*    */   public int now_treasure_box_num;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625417;
/*    */   }
/*    */   
/*    */ 
/*    */   public SBuyFriendsCircleTreasureBoxSuccess() {}
/*    */   
/*    */ 
/*    */   public SBuyFriendsCircleTreasureBoxSuccess(int _now_treasure_box_num_)
/*    */   {
/* 36 */     this.now_treasure_box_num = _now_treasure_box_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.now_treasure_box_num);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.now_treasure_box_num = _os_.unmarshal_int();
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SBuyFriendsCircleTreasureBoxSuccess)) {
/* 59 */       SBuyFriendsCircleTreasureBoxSuccess _o_ = (SBuyFriendsCircleTreasureBoxSuccess)_o1_;
/* 60 */       if (this.now_treasure_box_num != _o_.now_treasure_box_num) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.now_treasure_box_num;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.now_treasure_box_num).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBuyFriendsCircleTreasureBoxSuccess _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = this.now_treasure_box_num - _o_.now_treasure_box_num;
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\SBuyFriendsCircleTreasureBoxSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */