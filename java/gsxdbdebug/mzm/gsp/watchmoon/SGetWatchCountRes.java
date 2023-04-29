/*    */ package mzm.gsp.watchmoon;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
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
/*    */ public class SGetWatchCountRes
/*    */   extends __SGetWatchCountRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600836;
/*    */   public HashMap<Long, WatchmoonState> roleid2state;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600836;
/*    */   }
/*    */   
/*    */ 
/*    */   public SGetWatchCountRes()
/*    */   {
/* 33 */     this.roleid2state = new HashMap();
/*    */   }
/*    */   
/*    */   public SGetWatchCountRes(HashMap<Long, WatchmoonState> _roleid2state_) {
/* 37 */     this.roleid2state = _roleid2state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (Map.Entry<Long, WatchmoonState> _e_ : this.roleid2state.entrySet()) {
/* 42 */       if (!((WatchmoonState)_e_.getValue())._validator_()) return false;
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.compact_uint32(this.roleid2state.size());
/* 49 */     for (Map.Entry<Long, WatchmoonState> _e_ : this.roleid2state.entrySet()) {
/* 50 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 51 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 59 */       long _k_ = _os_.unmarshal_long();
/* 60 */       WatchmoonState _v_ = new WatchmoonState();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.roleid2state.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SGetWatchCountRes)) {
/* 73 */       SGetWatchCountRes _o_ = (SGetWatchCountRes)_o1_;
/* 74 */       if (!this.roleid2state.equals(_o_.roleid2state)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.roleid2state.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.roleid2state).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\SGetWatchCountRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */