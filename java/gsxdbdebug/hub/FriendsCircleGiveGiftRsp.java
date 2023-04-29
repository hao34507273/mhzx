/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class FriendsCircleGiveGiftRsp
/*    */   implements Marshal
/*    */ {
/*    */   public static final int RESULT_SUCCEED = 0;
/*    */   public static final int RESULT_USER_NOT_FOUND = 1;
/*    */   public static final int RESULT_ALEARDY_DELA = 3;
/*    */   public static final int RESULT_ROLE_LEVEL_NOT_ENOUGH = 4;
/*    */   public byte result;
/*    */   public Octets receive_role_name;
/*    */   public int receive_role_total_popularity;
/*    */   public int receive_role_week_popularity;
/*    */   public int receive_role_gift_num;
/*    */   
/*    */   public FriendsCircleGiveGiftRsp()
/*    */   {
/* 23 */     this.receive_role_name = new Octets();
/*    */   }
/*    */   
/*    */   public FriendsCircleGiveGiftRsp(byte _result_, Octets _receive_role_name_, int _receive_role_total_popularity_, int _receive_role_week_popularity_, int _receive_role_gift_num_) {
/* 27 */     this.result = _result_;
/* 28 */     this.receive_role_name = _receive_role_name_;
/* 29 */     this.receive_role_total_popularity = _receive_role_total_popularity_;
/* 30 */     this.receive_role_week_popularity = _receive_role_week_popularity_;
/* 31 */     this.receive_role_gift_num = _receive_role_gift_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     _os_.marshal(this.result);
/* 40 */     _os_.marshal(this.receive_role_name);
/* 41 */     _os_.marshal(this.receive_role_total_popularity);
/* 42 */     _os_.marshal(this.receive_role_week_popularity);
/* 43 */     _os_.marshal(this.receive_role_gift_num);
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     this.result = _os_.unmarshal_byte();
/* 49 */     this.receive_role_name = _os_.unmarshal_Octets();
/* 50 */     this.receive_role_total_popularity = _os_.unmarshal_int();
/* 51 */     this.receive_role_week_popularity = _os_.unmarshal_int();
/* 52 */     this.receive_role_gift_num = _os_.unmarshal_int();
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof FriendsCircleGiveGiftRsp)) {
/* 59 */       FriendsCircleGiveGiftRsp _o_ = (FriendsCircleGiveGiftRsp)_o1_;
/* 60 */       if (this.result != _o_.result) return false;
/* 61 */       if (!this.receive_role_name.equals(_o_.receive_role_name)) return false;
/* 62 */       if (this.receive_role_total_popularity != _o_.receive_role_total_popularity) return false;
/* 63 */       if (this.receive_role_week_popularity != _o_.receive_role_week_popularity) return false;
/* 64 */       if (this.receive_role_gift_num != _o_.receive_role_gift_num) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.result;
/* 73 */     _h_ += this.receive_role_name.hashCode();
/* 74 */     _h_ += this.receive_role_total_popularity;
/* 75 */     _h_ += this.receive_role_week_popularity;
/* 76 */     _h_ += this.receive_role_gift_num;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.result).append(",");
/* 84 */     _sb_.append("B").append(this.receive_role_name.size()).append(",");
/* 85 */     _sb_.append(this.receive_role_total_popularity).append(",");
/* 86 */     _sb_.append(this.receive_role_week_popularity).append(",");
/* 87 */     _sb_.append(this.receive_role_gift_num).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\FriendsCircleGiveGiftRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */