/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
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
/*    */ public class SGetRecallFriendSignAwardInfoSuccess
/*    */   extends __SGetRecallFriendSignAwardInfoSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600357;
/*    */   public HashMap<Integer, Integer> sign_award_state_map;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600357;
/*    */   }
/*    */   
/*    */ 
/*    */   public SGetRecallFriendSignAwardInfoSuccess()
/*    */   {
/* 33 */     this.sign_award_state_map = new HashMap();
/*    */   }
/*    */   
/*    */   public SGetRecallFriendSignAwardInfoSuccess(HashMap<Integer, Integer> _sign_award_state_map_) {
/* 37 */     this.sign_award_state_map = _sign_award_state_map_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.sign_award_state_map.size());
/* 46 */     for (Map.Entry<Integer, Integer> _e_ : this.sign_award_state_map.entrySet()) {
/* 47 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 48 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 56 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 58 */       int _v_ = _os_.unmarshal_int();
/* 59 */       this.sign_award_state_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SGetRecallFriendSignAwardInfoSuccess)) {
/* 70 */       SGetRecallFriendSignAwardInfoSuccess _o_ = (SGetRecallFriendSignAwardInfoSuccess)_o1_;
/* 71 */       if (!this.sign_award_state_map.equals(_o_.sign_award_state_map)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.sign_award_state_map.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.sign_award_state_map).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGetRecallFriendSignAwardInfoSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */