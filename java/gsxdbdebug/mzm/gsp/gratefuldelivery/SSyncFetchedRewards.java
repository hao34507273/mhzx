/*    */ package mzm.gsp.gratefuldelivery;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
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
/*    */ public class SSyncFetchedRewards
/*    */   extends __SSyncFetchedRewards__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615689;
/*    */   public HashSet<Integer> fetched_rewards;
/*    */   public int activity_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615689;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncFetchedRewards()
/*    */   {
/* 34 */     this.fetched_rewards = new HashSet();
/*    */   }
/*    */   
/*    */   public SSyncFetchedRewards(HashSet<Integer> _fetched_rewards_, int _activity_id_) {
/* 38 */     this.fetched_rewards = _fetched_rewards_;
/* 39 */     this.activity_id = _activity_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.fetched_rewards.size());
/* 48 */     for (Integer _v_ : this.fetched_rewards) {
/* 49 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 51 */     _os_.marshal(this.activity_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 58 */       int _v_ = _os_.unmarshal_int();
/* 59 */       this.fetched_rewards.add(Integer.valueOf(_v_));
/*    */     }
/* 61 */     this.activity_id = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SSyncFetchedRewards)) {
/* 71 */       SSyncFetchedRewards _o_ = (SSyncFetchedRewards)_o1_;
/* 72 */       if (!this.fetched_rewards.equals(_o_.fetched_rewards)) return false;
/* 73 */       if (this.activity_id != _o_.activity_id) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.fetched_rewards.hashCode();
/* 82 */     _h_ += this.activity_id;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.fetched_rewards).append(",");
/* 90 */     _sb_.append(this.activity_id).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\SSyncFetchedRewards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */