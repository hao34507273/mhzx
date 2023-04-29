/*    */ package mzm.gsp.award;
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
/*    */ public class SSynAllLostExpInfo
/*    */   extends __SSynAllLostExpInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583450;
/*    */   public HashMap<Integer, LostExpInfo> activityid2lostexpinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12583450;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynAllLostExpInfo()
/*    */   {
/* 33 */     this.activityid2lostexpinfo = new HashMap();
/*    */   }
/*    */   
/*    */   public SSynAllLostExpInfo(HashMap<Integer, LostExpInfo> _activityid2lostexpinfo_) {
/* 37 */     this.activityid2lostexpinfo = _activityid2lostexpinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (Map.Entry<Integer, LostExpInfo> _e_ : this.activityid2lostexpinfo.entrySet()) {
/* 42 */       if (!((LostExpInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.compact_uint32(this.activityid2lostexpinfo.size());
/* 49 */     for (Map.Entry<Integer, LostExpInfo> _e_ : this.activityid2lostexpinfo.entrySet()) {
/* 50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 51 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 59 */       int _k_ = _os_.unmarshal_int();
/* 60 */       LostExpInfo _v_ = new LostExpInfo();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.activityid2lostexpinfo.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SSynAllLostExpInfo)) {
/* 73 */       SSynAllLostExpInfo _o_ = (SSynAllLostExpInfo)_o1_;
/* 74 */       if (!this.activityid2lostexpinfo.equals(_o_.activityid2lostexpinfo)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.activityid2lostexpinfo.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.activityid2lostexpinfo).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\SSynAllLostExpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */